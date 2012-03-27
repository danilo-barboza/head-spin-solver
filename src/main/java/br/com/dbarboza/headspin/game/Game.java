package br.com.dbarboza.headspin.game;

import java.util.List;

import br.com.dbarboza.headspin.game.exception.UnsovableGameException;
import br.com.dbarboza.headspin.model.DeadRabbitHead;

public class Game {

	public enum Move {
		UPPER_LINE_RIGHT, UPPER_LINE_LEFT, RIGHT_COLUMN_DOWN, RIGHT_COLUMN_UP, LOWER_LINE_LEFT, LOWER_LINE_RIGHT, LEFT_COLUMN_UP, LEFT_COLUMN_DOWN;

		/**
		 * @param move
		 * @return
		 */
		public boolean cancels(Move move) {
			switch (this) {
			case UPPER_LINE_LEFT:
				return UPPER_LINE_RIGHT.equals(move);
			case UPPER_LINE_RIGHT:
				return UPPER_LINE_LEFT.equals(move);
			case RIGHT_COLUMN_DOWN:
				return RIGHT_COLUMN_UP.equals(move);
			case RIGHT_COLUMN_UP:
				return RIGHT_COLUMN_DOWN.equals(move);
			case LOWER_LINE_LEFT:
				return LOWER_LINE_RIGHT.equals(move);
			case LOWER_LINE_RIGHT:
				return LOWER_LINE_LEFT.equals(move);
			case LEFT_COLUMN_DOWN:
				return LEFT_COLUMN_UP.equals(move);
			case LEFT_COLUMN_UP:
				return LEFT_COLUMN_DOWN.equals(move);
			}

			return false;
		}
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
		MovePossibilityTree tree = new MovePossibilityTree(possibleMoves);

		return tree.scan(new SolutionTester() {
			@Override
			public boolean testPossibleSolution(List<Move> possibleSolution) {
				for (Move move : possibleSolution) {
					move(move);
				}

				if (areAllRabbitsAtWinnerPosition()) {
					return true;
				}

				reset();
				return false;
			}
		});
	}

}
