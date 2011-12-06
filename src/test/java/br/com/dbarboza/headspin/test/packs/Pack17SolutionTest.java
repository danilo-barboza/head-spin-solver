/**
 * 
 */
package br.com.dbarboza.headspin.test.packs;

import static br.com.dbarboza.headspin.model.DeadRabbitHead.Side.*;

import java.util.List;

import br.com.dbarboza.headspin.game.Game;
import br.com.dbarboza.headspin.game.Game.Move;
import br.com.dbarboza.headspin.model.DeadRabbitHead;

/**
 * @author danilo
 * 
 */
public class Pack17SolutionTest {

	private static final int POSSIBLE_MOVES = 7;

	// FIXME can't handle more than 7 possible moves with a -Xmx120m!!
	public void solveLevel1() {
		DeadRabbitHead leftUpperHead = new DeadRabbitHead(FRONT, DOWN);
		DeadRabbitHead rightUpperHead = new DeadRabbitHead(FRONT, DOWN);
		DeadRabbitHead leftLowerHead = new DeadRabbitHead(RIGHT, DOWN);
		DeadRabbitHead rightLowerHead = new DeadRabbitHead(RIGHT, DOWN);

		Game game = new Game(leftUpperHead, rightUpperHead, leftLowerHead,
				rightLowerHead, POSSIBLE_MOVES);

		List<Move> solution = game.solve();

		System.out.println(solution);

	}

}
