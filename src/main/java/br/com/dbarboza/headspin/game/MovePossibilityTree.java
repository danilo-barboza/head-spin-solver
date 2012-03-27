package br.com.dbarboza.headspin.game;

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
	private List<Move> solution;
	private int possibleMoves;

	public MovePossibilityTree(int possibleMoves) {
		root = new Node();
		this.possibleMoves = possibleMoves;
	}

	public int numberOfPossibleSolutions() {
		return (int) Math.pow(Move.values().length, possibleMoves);
	}

	private class Node {

		private Move value;

		private Node parent;

		private int level;

		public Node() {
			level = 0;
		}

		public Node(Node parent, Move value) {
			this();
			this.parent = parent;
			this.value = value;

			Node node = this;

			while (node.parent != null) {
				level += 1;
				node = node.parent;
			}
		}

		public void scan() {

			if (isLeaf()) {
				List<Move> possibleSolution = possibleSolution();
				if (solutionTester.testPossibleSolution(possibleSolution)) {
					solution = possibleSolution;
					throw new SolutionFoundException();
				}

			} else {

				for (Move move : Move.values()) {
					if (move.cancels(value))
						continue;

					Node child = new Node(this, move);
					try {
						child.scan();
					} catch (SolutionFoundException e) {
						break;
					}
				}

			}

		}

		/**
		 * Navigates up the tree storing the possible solution of this leaf
		 * 
		 * @return
		 */
		private List<Move> possibleSolution() {
			LinkedList<Move> moves = new LinkedList<Move>();
			Node leaf = this;

			while (leaf.parent != null) {
				moves.push(leaf.value);
				leaf = leaf.parent;
			}

			return moves;
		}

		private boolean isLeaf() {
			return level == possibleMoves;
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

		return solution;
	}

}
