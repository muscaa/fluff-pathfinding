package fluff.pathfinding;

import java.util.LinkedList;
import java.util.List;

public class PathfindingSegment {
	
	private final PathfindingSegment parent;
	private final IPathfindingNode node;
	private final double totalWeight;
	
	public PathfindingSegment(PathfindingSegment parent, IPathfindingNode node, double weight) {
		this.parent = parent;
		this.node = node;
		this.totalWeight = (parent != null ? parent.getTotalWeight() : 0.0) + weight;
	}
	
	public boolean isCycle(IPathfindingNode node) {
		return this.node.equals(node) || (parent != null && parent.isCycle(node));
	}
	
	public List<IPathfindingNode> getPath() {
		List<IPathfindingNode> path = new LinkedList<>();
		path.add(node);
		
		PathfindingSegment epn = this;
		while ((epn = epn.parent) != null) {
			path.add(0, epn.node);
		}
		
		return path;
	}
	
	public PathfindingSegment getParent() {
		return parent;
	}
	
	public IPathfindingNode getNode() {
		return node;
	}
	
	public double getTotalWeight() {
		return totalWeight;
	}
}
