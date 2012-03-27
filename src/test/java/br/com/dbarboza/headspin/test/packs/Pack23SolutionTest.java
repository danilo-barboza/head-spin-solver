/**
 * 
 */
package br.com.dbarboza.headspin.test.packs;

import static br.com.dbarboza.headspin.model.DeadRabbitHead.Side.*;

import java.util.List;

import org.junit.Test;

import br.com.dbarboza.headspin.game.Game;
import br.com.dbarboza.headspin.game.Game.Move;
import br.com.dbarboza.headspin.model.DeadRabbitHead;

/**
 * @author danilo
 * 
 */
public class Pack23SolutionTest {

	private static final int POSSIBLE_MOVES = 8;

	@Test
	public void solveLevel1() {
		DeadRabbitHead leftUpperHead = new DeadRabbitHead(DOWN, FRONT);
		DeadRabbitHead rightUpperHead = new DeadRabbitHead(BACK, DOWN);
		DeadRabbitHead leftLowerHead = new DeadRabbitHead(UP, LEFT);
		DeadRabbitHead rightLowerHead = new DeadRabbitHead(LEFT, DOWN);

		Game game = new Game(leftUpperHead, rightUpperHead, leftLowerHead,
				rightLowerHead, POSSIBLE_MOVES);

		List<Move> solution = game.solve();

		System.out.println(solution);

	}

}
