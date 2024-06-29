package fluff.pathfinding.result;

import java.util.List;

import fluff.pathfinding.IPathfindingNode;

public class PathResult {
	
	private final List<IPathfindingNode> path;
	private final double totalWeight;
	
	public PathResult(List<IPathfindingNode> path, double totalWeight) {
		this.path = List.copyOf(path);
		this.totalWeight = totalWeight;
	}
	
	public List<IPathfindingNode> getPath() {
		return path;
	}
	
	public double getTotalWeight() {
		return totalWeight;
	}
}
