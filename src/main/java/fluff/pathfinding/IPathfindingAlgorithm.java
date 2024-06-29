package fluff.pathfinding;

import java.util.List;

import fluff.pathfinding.callback.IPathfindingCallback;
import fluff.pathfinding.result.ExploreResult;
import fluff.pathfinding.result.PathResult;

public interface IPathfindingAlgorithm {
    
	ExploreResult explore(IPathfindingNode start);
	
    List<PathResult> findPaths(IPathfindingCallback callback, IPathfindingNode start, IPathfindingNode finish);
}
