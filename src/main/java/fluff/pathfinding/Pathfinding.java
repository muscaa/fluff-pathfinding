package fluff.pathfinding;

import java.util.HashMap;
import java.util.Map;

import fluff.pathfinding.algorithms.DijkstraPathfindingAlgorithm;

public class Pathfinding {
	
    private static final Map<String, PathfindingFunctions> REG = new HashMap<>();
    
    public static final PathfindingFunctions DIJKSTRA = register("dijkstra", new DijkstraPathfindingAlgorithm());
    //public static final PathfindingFunctions A_STAR = register("a_star", new AStarPathfindingAlgorithm());
    
    public static PathfindingFunctions get(String name) {
        return REG.get(name);
    }
    
    public static boolean has(String name) {
        return REG.containsKey(name);
    }
    
    public static PathfindingFunctions register(String name, IPathfindingAlgorithm algorithm) {
        PathfindingFunctions funcs = new PathfindingFunctions(algorithm);
        REG.put(name, funcs);
        return funcs;
    }
    
    public static boolean unregister(String name) {
        return REG.remove(name) != null;
    }
}
