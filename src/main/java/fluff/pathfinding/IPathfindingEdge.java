package fluff.pathfinding;

public interface IPathfindingEdge {
	
	IPathfindingNode getTarget();
	
	double getWeight();
}
