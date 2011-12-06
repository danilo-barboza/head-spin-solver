package br.com.dbarboza.headspin.test.packs;

import static br.com.dbarboza.headspin.model.DeadRabbitHead.Side.*;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import br.com.dbarboza.headspin.game.Game;
import br.com.dbarboza.headspin.game.Game.Move;
import br.com.dbarboza.headspin.model.DeadRabbitHead;

public class Pack02SolutionTest {

	private static final int POSSIBLE_MOVES = 2;

	@Test
	public void solveLevel2() {
		DeadRabbitHead rightUpperHead = new DeadRabbitHead(UP, BACK);
		DeadRabbitHead rightLowerHead = new DeadRabbitHead(UP, BACK);
		DeadRabbitHead leftLowerHead = new DeadRabbitHead(UP, BACK);
		DeadRabbitHead leftUpperHead = new DeadRabbitHead(UP, BACK);

		Game game = new Game(rightUpperHead, leftUpperHead, leftLowerHead,
				rightLowerHead, POSSIBLE_MOVES);

		List<Move> solution = game.solve();

		System.out.println(solution);

		assertEquals(2, solution.size());
		assertTrue(solution.contains(Move.LEFT_COLUMN_DOWN));
		solution.remove(solution.indexOf(Move.LEFT_COLUMN_DOWN));
		assertEquals(solution.get(0), Move.RIGHT_COLUMN_DOWN);

	}

	@Test
	public void solveLevel3() {
		DeadRabbitHead leftUpperHead = new DeadRabbitHead(LEFT, BACK);
		DeadRabbitHead rightUpperHead = new DeadRabbitHead(LEFT, UP);
		DeadRabbitHead rightLowerHead = DeadRabbitHead.defaultPosition();
		DeadRabbitHead leftLowerHead = new DeadRabbitHead(UP, BACK);

		Game game = new Game(leftUpperHead, rightUpperHead, leftLowerHead,
				rightLowerHead, POSSIBLE_MOVES);

		List<Move> solution = game.solve();

		System.out.println(solution);
	}

}
