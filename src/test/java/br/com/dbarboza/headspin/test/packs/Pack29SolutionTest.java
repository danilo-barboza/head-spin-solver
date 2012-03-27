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
public class Pack29SolutionTest {
	
	private static final int POSSIBLE_MOVES = 10;

	@Test
	public void solveLevel3() {
		DeadRabbitHead leftUpperHead = new DeadRabbitHead(FRONT, LEFT);
		DeadRabbitHead rightUpperHead = new DeadRabbitHead(DOWN, RIGHT);
		DeadRabbitHead leftLowerHead = new DeadRabbitHead(LEFT, BACK);
		DeadRabbitHead rightLowerHead = new DeadRabbitHead(BACK, RIGHT);

		Game game = new Game(leftUpperHead, rightUpperHead, leftLowerHead,
				rightLowerHead, POSSIBLE_MOVES);

		List<Move> solution = game.solve();

		System.out.println(solution);

	}

}
