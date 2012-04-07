/**
 * 
 */
package br.com.dbarboza.headspin.test.packs;

import static br.com.dbarboza.headspin.model.DeadRabbitHead.Side.*;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.dbarboza.headspin.game.Game;
import br.com.dbarboza.headspin.game.Game.Move;
import br.com.dbarboza.headspin.model.DeadRabbitHead;

/**
 * @author danilo
 *
 */
public class Pack27SolutionTest {
	
	private static final int POSSIBLE_MOVES = 9;

	@Ignore
	@Test
	public void solveLevel1() {
		DeadRabbitHead leftUpperHead = new DeadRabbitHead(DOWN, FRONT);
		DeadRabbitHead rightUpperHead = new DeadRabbitHead(RIGHT, BACK);
		DeadRabbitHead leftLowerHead = new DeadRabbitHead(BACK, RIGHT);
		DeadRabbitHead rightLowerHead = new DeadRabbitHead(RIGHT, BACK);

		Game game = new Game(leftUpperHead, rightUpperHead, leftLowerHead,
				rightLowerHead, POSSIBLE_MOVES);

		List<Move> solution = game.solve();

		System.out.println(solution);

	}

}
