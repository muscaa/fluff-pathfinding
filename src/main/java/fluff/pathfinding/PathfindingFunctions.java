package fluff.pathfinding;

import java.util.List;

import fluff.pathfinding.callback.IPathfindingCallback;
import fluff.pathfinding.callback.PathfindingOperation;
import fluff.pathfinding.result.ExploreResult;
import fluff.pathfinding.result.PathResult;

public class PathfindingFunctions {
    
    private final IPathfindingAlgorithm algorithm;
    
    public PathfindingFunctions(IPathfindingAlgorithm algorithm) {
        this.algorithm = algorithm;
    }
    
    public ExploreResult explore(IPathfindingNode start) {
    	return algorithm.explore(start);
    }
    
    public List<PathResult> findPaths(IPathfindingCallback callback, IPathfindingNode start, IPathfindingNode finish) {
    	return algorithm.findPaths(callback, start, finish);
    }
    
    public PathResult findPath(IPathfindingNode start, IPathfindingNode finish) {
    	return findPaths((total, last) -> PathfindingOperation.STOP, start, finish).get(0);
    }
}
