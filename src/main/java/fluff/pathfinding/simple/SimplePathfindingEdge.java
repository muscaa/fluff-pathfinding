package fluff.pathfinding.simple;

import fluff.pathfinding.IPathfindingEdge;
import fluff.pathfinding.IPathfindingNode;

public class SimplePathfindingEdge implements IPathfindingEdge {
	
	private final IPathfindingNode target;
	private final double weight;
	
	public SimplePathfindingEdge(IPathfindingNode target, double weight) {
		this.target = target;
		this.weight = weight;
	}
	
	@Override
	public IPathfindingNode getTarget() {
		return target;
	}
	
	@Override
	public double getWeight() {
		return weight;
	}
}
