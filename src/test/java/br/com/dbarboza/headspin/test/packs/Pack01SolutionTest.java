package br.com.dbarboza.headspin.test.packs;

import java.util.List;

import org.junit.Test;

import br.com.dbarboza.headspin.game.Game;
import br.com.dbarboza.headspin.game.Game.Move;
import br.com.dbarboza.headspin.model.DeadRabbitHead;

import static br.com.dbarboza.headspin.model.DeadRabbitHead.Side.*;

import static org.junit.Assert.*;

public class Pack01SolutionTest {

	private static final int POSSIBLE_MOVES = 1;

	@Test
	public void solveLevel1() {
		DeadRabbitHead rightUpperHead = DeadRabbitHead.defaultPosition();
		DeadRabbitHead rightLowerHead = DeadRabbitHead.defaultPosition();
		DeadRabbitHead leftLowerHead = new DeadRabbitHead(DOWN, FRONT);
		DeadRabbitHead leftUpperHead = new DeadRabbitHead(DOWN, FRONT);

		Game game = new Game(leftUpperHead, rightUpperHead, leftLowerHead,
				rightLowerHead, POSSIBLE_MOVES);

		List<Move> solution = game.solve();
		assertEquals(1, solution.size());

		assertEquals(Move.LEFT_COLUMN_UP, solution.get(0));
	}

	@Test
	public void solveLevel2() {
		DeadRabbitHead leftUpperHead = DeadRabbitHead.defaultPosition();
		DeadRabbitHead rightUpperHead = DeadRabbitHead.defaultPosition();
		DeadRabbitHead rightLowerHead = new DeadRabbitHead(RIGHT, UP);
		DeadRabbitHead leftLowerHead = new DeadRabbitHead(RIGHT, UP);

		Game game = new Game(rightUpperHead, leftUpperHead, leftLowerHead,
				rightLowerHead, POSSIBLE_MOVES);

		List<Move> solution = game.solve();

		assertEquals(1, solution.size());
		assertEquals(Move.LOWER_LINE_LEFT, solution.get(0));

	}
}
