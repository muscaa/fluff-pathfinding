package fluff.pathfinding.callback;

import fluff.pathfinding.result.PathResult;

public interface IPathfindingCallback {
	
	PathfindingOperation onPathFound(int total, PathResult last);
}
