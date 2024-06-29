package fluff.pathfinding.simple;

import java.util.List;

import fluff.pathfinding.IPathfindingEdge;
import fluff.pathfinding.IPathfindingNode;

public class SimplePathfindingNode implements IPathfindingNode {
	
	private final List<IPathfindingEdge> edges;
	private final boolean explorable;
	
	public SimplePathfindingNode(List<IPathfindingEdge> edges, boolean explorable) {
		this.edges = edges;
		this.explorable = explorable;
	}
	
	@Override
	public List<IPathfindingEdge> getEdges() {
		return edges;
	}
	
	@Override
	public boolean isExplorable() {
		return explorable;
	}
}
