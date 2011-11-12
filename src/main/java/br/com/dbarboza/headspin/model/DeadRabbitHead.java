package br.com.dbarboza.headspin.model;

import static br.com.dbarboza.headspin.model.DeadRabbitHead.Side.*;

/**
 * @author danilo
 * 
 */
public class DeadRabbitHead implements Cloneable {
	public enum Side {
		UP, DOWN, RIGHT, LEFT, FRONT, BACK;

		public Side oppositeSide() {
			switch (this) {
			case UP:
				return DOWN;
			case DOWN:
				return UP;
			case RIGHT:
				return LEFT;
			case LEFT:
				return RIGHT;
			case FRONT:
				return BACK;
			case BACK:
				return FRONT;
			default:
				throw new RuntimeException("This must NEVER happen.");
			}
		}
	}

	/**
	 * The DEFAULT
	 */
	private static final DeadRabbitHead DEFAULT_POSTIION = new DeadRabbitHead(
			Side.FRONT, Side.UP);

	public static DeadRabbitHead defaultPosition() {
		return DEFAULT_POSTIION.clone();
	}

	private Position facePosition;
	private Position earPosition;

	public DeadRabbitHead(Side facePosition, Side earPosition) {
		this.facePosition = this.new Position(facePosition);
		this.earPosition = this.new Position(earPosition);

		validate();
	}

	public Side facePosition() {
		return facePosition.side;
	}

	public Side earPosition() {
		return earPosition.side;
	}

	public void turnRight() {
		boolean isFaceHorizontal = facePosition.isHorizontal();
		if (isFaceHorizontal && earPosition.isHorizontal()) {
			facePosition.turnRight();
			earPosition.turnRight();
		} else if (isFaceHorizontal)
			facePosition.turnRight();
		else
			earPosition.turnRight();
	}

	public void turnLeft() {
		boolean isFaceHorizontal = facePosition.isHorizontal();
		if (isFaceHorizontal && earPosition.isHorizontal()) {
			facePosition.turnLeft();
			earPosition.turnLeft();
		} else if (isFaceHorizontal)
			facePosition.turnLeft();
		else
			earPosition.turnLeft();
	}

	public void turnUp() {
		boolean isFaceVertical = facePosition.isVertical();
		if (isFaceVertical && earPosition.isVertical()) {
			facePosition.turnUp();
			earPosition.turnUp();
		} else if (isFaceVertical)
			facePosition.turnUp();
		else
			earPosition.turnUp();
	}

	public void turnDown() {
		boolean isFaceVertical = facePosition.isVertical();
		if (isFaceVertical && earPosition.isVertical()) {
			facePosition.turnDown();
			earPosition.turnDown();
		} else if (isFaceVertical)
			facePosition.turnDown();
		else
			earPosition.turnDown();
	}

	public boolean isInDefaultPosition() {
		DeadRabbitHead def = defaultPosition();
		return def.facePosition.equals(facePosition)
				&& def.earPosition.equals(earPosition);
	}

	@Override
	public String toString() {
		return "The head is with face turned " + facePosition
				+ ", and ear turned " + earPosition + ".";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((earPosition == null) ? 0 : earPosition.hashCode());
		result = prime * result
				+ ((facePosition == null) ? 0 : facePosition.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DeadRabbitHead other = (DeadRabbitHead) obj;
		if (earPosition == null) {
			if (other.earPosition != null)
				return false;
		} else if (!earPosition.equals(other.earPosition))
			return false;
		if (facePosition == null) {
			if (other.facePosition != null)
				return false;
		} else if (!facePosition.equals(other.facePosition))
			return false;
		return true;
	}

	@Override
	public DeadRabbitHead clone() {
		DeadRabbitHead clone = null;
		try {
			clone = (DeadRabbitHead) super.clone();
			clone.earPosition = earPosition.clone();
			clone.facePosition = facePosition.clone();
		} catch (CloneNotSupportedException e) {
			// Will never happen but...
			throw new RuntimeException("This is REALLY weird!", e);
		}

		return clone;
	}

	private void validate() {
		if (earPosition.equals(facePosition)
				|| facePosition.side.oppositeSide().equals(earPosition.side))
			throw new IllegalStateException(
					"A face cannot be in the same or opposite side of the ear.");

	}

	private class Position implements Cloneable {

		private Side side;

		public Position(Side side) {
			this.side = side;
		}

		public boolean isHorizontal() {
			return side.equals(RIGHT) || side.equals(LEFT)
					|| side.equals(FRONT) || side.equals(BACK);
		}

		public boolean isVertical() {
			return side.equals(UP) || side.equals(DOWN) || side.equals(FRONT)
					|| side.equals(BACK);
		}

		void turnRight() {
			switch (side) {
			case RIGHT:
				this.side = BACK;
				break;
			case BACK:
				this.side = LEFT;
				break;
			case LEFT:
				this.side = FRONT;
				break;
			case FRONT:
				this.side = RIGHT;
				break;
			default:
				throw new Error(
						"A side can be only turned right when in horizontal position.");
			}
		}

		void turnLeft() {
			switch (side) {
			case RIGHT:
				this.side = FRONT;
				break;
			case BACK:
				this.side = RIGHT;
				break;
			case LEFT:
				this.side = BACK;
				break;
			case FRONT:
				this.side = LEFT;
				break;
			default:
				throw new Error(
						"A side can be only turned left when in horizontal position.");
			}
		}

		void turnUp() {
			switch (side) {
			case FRONT:
				this.side = UP;
				break;
			case UP:
				this.side = BACK;
				break;
			case BACK:
				this.side = DOWN;
				break;
			case DOWN:
				this.side = FRONT;
				break;
			default:
				throw new Error(
						"A side can only be turned up if it's in vertical position.");
			}
		}

		void turnDown() {
			switch (side) {
			case FRONT:
				this.side = DOWN;
				break;
			case DOWN:
				this.side = BACK;
				break;
			case BACK:
				this.side = UP;
				break;
			case UP:
				this.side = FRONT;
				break;
			default:
				throw new Error(
						"A side can only be turned down if it's in vertical position.");
			}
		}

		@Override
		public String toString() {
			return side.toString();
		}

		@Override
		public Position clone() throws CloneNotSupportedException {
			return (Position) super.clone();
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((side == null) ? 0 : side.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Position other = (Position) obj;
			if (side == null) {
				if (other.side != null)
					return false;
			} else if (!side.equals(other.side))
				return false;
			return true;
		}
	}

}