package br.com.dbarboza.headspin.game;

import java.util.ArrayList;
import java.util.List;

import br.com.dbarboza.headspin.game.exception.UnsovableGameException;
import br.com.dbarboza.headspin.model.DeadRabbitHead;

public class Game {

	public enum Move {
		UPPER_LINE_RIGHT, UPPER_LINE_LEFT, RIGHT_COLUMN_DOWN, RIGHT_COLUMN_UP, LOWER_LINE_LEFT, LOWER_LINE_RIGHT, LEFT_COLUMN_UP, LEFT_COLUMN_DOWN;
	}

	private DeadRabbitHead leftUpperHead, rightUpperHead, rightLowerHead,
			leftLowerHead;

	private DeadRabbitHead rightUpperHeadInitial, leftUpperHeadInitial,
			rightLowerHeadInitial, leftLowerHeadInitial;

	private int possibleMoves;

	public Game(DeadRabbitHead leftUpperHead, DeadRabbitHead rightUpperHead,
			DeadRabbitHead leftLowerHead, DeadRabbitHead rightLowerHead,
			int possibleMoves) {
		leftUpperHeadInitial = leftUpperHead;
		rightUpperHeadInitial = rightUpperHead;
		rightLowerHeadInitial = rightLowerHead;
		leftLowerHeadInitial = leftLowerHead;
		this.possibleMoves = possibleMoves;

		reset();
	}

	public void move(Move move) {
		switch (move) {
		case UPPER_LINE_LEFT:
			slideUpperLineLeft();
			break;
		case UPPER_LINE_RIGHT:
			slideUpperLineRight();
			break;
		case RIGHT_COLUMN_DOWN:
			slideRightColumnDown();
			break;
		case RIGHT_COLUMN_UP:
			slideRightColumnUp();
			break;
		case LOWER_LINE_LEFT:
			slideLowerLineLeft();
			break;
		case LOWER_LINE_RIGHT:
			slideLowerLineRight();
			break;
		case LEFT_COLUMN_DOWN:
			slideLeftColumnDown();
			break;
		case LEFT_COLUMN_UP:
			slideLeftColumnUp();
			break;
		}
	}

	public void slideUpperLineRight() {
		leftUpperHead.turnRight();
		rightUpperHead.turnRight();
	}

	public void slideUpperLineLeft() {
		leftUpperHead.turnLeft();
		rightUpperHead.turnLeft();
	}

	public void slideRightColumnDown() {
		rightUpperHead.turnDown();
		rightLowerHead.turnDown();
	}

	public void slideRightColumnUp() {
		rightUpperHead.turnUp();
		rightLowerHead.turnUp();
	}

	public void slideLowerLineLeft() {
		leftLowerHead.turnLeft();
		rightLowerHead.turnLeft();
	}

	public void slideLowerLineRight() {
		leftLowerHead.turnRight();
		rightLowerHead.turnRight();
	}

	public void slideLeftColumnUp() {
		leftLowerHead.turnUp();
		leftUpperHead.turnUp();
	}

	public void slideLeftColumnDown() {
		leftLowerHead.turnDown();
		leftUpperHead.turnDown();
	}

	public boolean areAllRabbitsAtWinnerPosition() {
		return rightLowerHead.isInDefaultPosition()
				&& rightUpperHead.isInDefaultPosition()
				&& leftLowerHead.isInDefaultPosition()
				&& leftUpperHead.isInDefaultPosition();
	}

	public void reset() {
		this.rightLowerHead = rightLowerHeadInitial.clone();
		this.rightUpperHead = rightUpperHeadInitial.clone();
		this.leftLowerHead = leftLowerHeadInitial.clone();
		this.leftUpperHead = leftUpperHeadInitial.clone();
	}

	public List<Move> solve() throws UnsovableGameException {
		List<Move> solution = new ArrayList<Move>(possibleMoves);

		MovePossibilityTree tree = new MovePossibilityTree(possibleMoves);

		for (List<Move> possibleSolution : tree.possibleSolutions()) {

			for (Move move : possibleSolution)
				move(move);

			if (areAllRabbitsAtWinnerPosition()) {
				solution = possibleSolution;
				break;
			}

			reset();
		}

		if (solution.isEmpty())
			throw new UnsovableGameException();

		return solution;
	}

}
