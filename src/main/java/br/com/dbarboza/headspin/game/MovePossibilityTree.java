package br.com.dbarboza.headspin.game;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import br.com.dbarboza.headspin.game.Game.Move;
import br.com.dbarboza.headspin.game.exception.UnsovableGameException;

public class MovePossibilityTree {

	/**
	 * @author danilo
	 * 
	 */
	public class SolutionFoundException extends RuntimeException {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

	}

	private Node root;
	private SolutionTester solutionTester;
	private PossibleSolution solution;

	public MovePossibilityTree(int possibleMoves) {
		root = new Node();
		for (int i = 0; i < possibleMoves; i++) {
			root.addLevel();
		}
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

		public void scan() {

			if (isLeaf()) {
				PossibleSolution possibleSolution = new PossibleSolution(this);
				if (solutionTester
						.testPossibleSolution(possibleSolution.solution)) {
					solution = possibleSolution;
					throw new SolutionFoundException();
				}

			} else {
				for (Node child : children) {
					try {
						child.scan();
					} catch (SolutionFoundException e) {
						break;
					}
				}
			}

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

	/**
	 * @param solutionTester
	 * @return
	 */
	public List<Move> scan(SolutionTester solutionTester) {
		this.solutionTester = solutionTester;

		root.scan();

		if (solution == null)
			throw new UnsovableGameException();

		return solution.solution;
	}

}
