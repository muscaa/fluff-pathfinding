package fluff.pathfinding;

import java.util.List;

public interface IPathfindingNode {
	
	List<IPathfindingEdge> getEdges();
	
	boolean isExplorable();
}
