package k21;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class DepthFirstSearchAlgo implements ISearchAlgo{

	@Override
	public Node execute(Node root, String goal) {
		Stack<Node> frontier = new Stack<Node>();
		Set<Node> visited = new HashSet<Node>();
		frontier.add(root);
		while(frontier != null) {
			Node current = frontier.pop();
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
		Stack<Node> frontier = new Stack<Node>();
		Set<Node> visited = new HashSet<Node>();
		frontier.add(root);
		while(frontier != null) {
			Node current = frontier.pop();
			if(current.getLabel().equalsIgnoreCase(start)) {
				frontier.clear();
			}
			if(current.getLabel().equalsIgnoreCase(goal)) {
				return current;
			}
			visited.add(current);
			frontier.addAll(current.getChildrenNodes());
		}
		return null;
	}
	
}
