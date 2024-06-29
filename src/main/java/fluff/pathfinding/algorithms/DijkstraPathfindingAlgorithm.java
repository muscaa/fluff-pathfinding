package fluff.pathfinding.algorithms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

import fluff.pathfinding.PathfindingSegment;
import fluff.pathfinding.IPathfindingAlgorithm;
import fluff.pathfinding.IPathfindingEdge;
import fluff.pathfinding.IPathfindingNode;
import fluff.pathfinding.callback.IPathfindingCallback;
import fluff.pathfinding.callback.PathfindingOperation;
import fluff.pathfinding.result.ExploreResult;
import fluff.pathfinding.result.PathResult;

public class DijkstraPathfindingAlgorithm implements IPathfindingAlgorithm {
	
	@Override
	public ExploreResult explore(IPathfindingNode start) {
		Set<IPathfindingNode> explored = new HashSet<>();
		
		Queue<PathfindingSegment> queue = new LinkedList<>();
		queue.add(new PathfindingSegment(null, start, 0.0));
		
		while (!queue.isEmpty()) {
			for (PathfindingSegment seg : queue) {
				explored.add(seg.getNode());
			}
			
			queue = next(queue, new LinkedList<>(), explored);
		}
		
		return new ExploreResult(explored);
	}
	
	@Override
	public List<PathResult> findPaths(IPathfindingCallback callback, IPathfindingNode start, IPathfindingNode finish) {
		List<PathResult> results = new ArrayList<>();
		
		ExploreResult er = explore(start);
		if (finish == null || !er.getExplored().contains(finish)) {
			results.add(new PathResult(List.of(), 0.0));
			return results;
		}
		
		Queue<PathfindingSegment> queue = new LinkedList<>();
		queue.add(new PathfindingSegment(null, start, 0.0));
		
		while (!queue.isEmpty()) {
			if (find(callback, finish, queue, results) == PathfindingOperation.STOP) break;
			
			queue = next(queue, new PriorityQueue<>(getComparator(finish)), Set.of());
		}
		
		return results;
	}
	
	protected PathfindingOperation find(IPathfindingCallback callback, IPathfindingNode finish, Queue<PathfindingSegment> queue, List<PathResult> results) {
		for (PathfindingSegment seg : queue) {
			if (!seg.getNode().equals(finish)) continue;
			
			PathResult result = new PathResult(seg.getPath(), seg.getTotalWeight());
			results.add(result);
			
			if (callback.onPathFound(results.size(), result) == PathfindingOperation.STOP) {
				return PathfindingOperation.STOP;
			}
		}
		
		return PathfindingOperation.CONTINUE;
	}
	
	protected Queue<PathfindingSegment> next(Queue<PathfindingSegment> from, Queue<PathfindingSegment> to, Set<IPathfindingNode> explored) {
		for (PathfindingSegment parent : from) {
			for (IPathfindingEdge edge : parent.getNode().getEdges()) {
				IPathfindingNode target = edge.getTarget();
				
				if (!target.isExplorable()) continue;
				if (explored.contains(target)) continue;
				if (parent.isCycle(target)) continue;
				
				to.add(new PathfindingSegment(parent, target, edge.getWeight()));
			}
		}
		
		return to;
	}
	
	protected Comparator<PathfindingSegment> getComparator(IPathfindingNode finish) {
		return Comparator.comparingDouble(PathfindingSegment::getTotalWeight);
	}
}
