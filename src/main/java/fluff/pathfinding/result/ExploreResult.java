package fluff.pathfinding.result;

import java.util.Set;

import fluff.pathfinding.IPathfindingNode;

public class ExploreResult {
	
	private final Set<IPathfindingNode> explored;
	
	public ExploreResult(Set<IPathfindingNode> explored) {
		this.explored = Set.copyOf(explored);
	}
	
	public Set<IPathfindingNode> getExplored() {
		return explored;
	}
}
