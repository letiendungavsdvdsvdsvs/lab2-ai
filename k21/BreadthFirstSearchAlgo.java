package k21;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BreadthFirstSearchAlgo implements ISearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		Queue<Node> frontier = new LinkedList<Node>();
		Set<Node> visited = new HashSet<Node>();
		frontier.add(root);
		while(frontier != null) {
			Node current = frontier.poll();
			frontier.addAll(current.getChildrenNodes());
			for (Node child : current.getChildrenNodes()) child.setParent(current);
			if(current.getLabel().equalsIgnoreCase(goal)) {
				return current;
			}
			visited.add(current);
			
		}
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
