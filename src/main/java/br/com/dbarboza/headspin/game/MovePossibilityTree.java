package br.com.dbarboza.headspin.game;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import br.com.dbarboza.headspin.game.Game.Move;

public class MovePossibilityTree {

	private Node root;

	private List<PossibleSolution> possibleSolutions;

	public MovePossibilityTree(int possibleMoves) {
		possibleSolutions = new ArrayList<PossibleSolution>();
		root = new Node();
		for (int i = 0; i < possibleMoves; i++) 
			root.addLevel();
	}

	public List<List<Move>> possibleSolutions() {
		root.possibleSolutions();
		List<List<Move>> result = new ArrayList<List<Move>>(
				possibleSolutions.size());

		for (PossibleSolution possibleSolution : possibleSolutions)
			result.add(possibleSolution.solution);

		return result;
	}

	public int numberOfPossibleSolutions() {
		return root.totalChildren();
	}

	private class Node {

		private List<Node> children;

		private Move value;

		private Node parent;

		public Node() {
			children = new ArrayList<Node>();
		}

		public Node(Node parent, Move value) {
			this();
			this.parent = parent;
			this.value = value;
		}

		public void addLevel() {
			if (isLeaf())
				for (Move move : Move.values()) 
					children.add(new Node(this, move));
			else
				for (Node child : children)
					child.addLevel();
		}

		public int totalChildren() {
			int result = 0;
			if (isLeaf())
				return 1;
			else {
				for (Node child : children)
					result += child.totalChildren();
				return result;
			}

		}

		public void possibleSolutions() {

			if (isLeaf())
				possibleSolutions.add(new PossibleSolution(this));
			else
				for (Node child : children)
					child.possibleSolutions();

		}

		private boolean isLeaf() {
			return children.isEmpty();
		}
	}

	private class PossibleSolution {

		private List<Move> solution;

		protected PossibleSolution(Node leaf) {
			LinkedList<Move> moves = new LinkedList<Move>();

			while (leaf.parent != null) {
				moves.push(leaf.value);
				leaf = leaf.parent;
			}

			solution = moves;
		}

		@Override
		public String toString() {
			return solution.toString();
		}

	}

}
