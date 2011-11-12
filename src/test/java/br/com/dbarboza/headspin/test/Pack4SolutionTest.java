/**
 * 
 */
package br.com.dbarboza.headspin.test;

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
public class Pack4SolutionTest {

	private final int possibleMoves = 4;

	@Test
	public void solveLevel3() {
		DeadRabbitHead leftUpperHead = new DeadRabbitHead(LEFT, UP);
		DeadRabbitHead rightUpperHead = new DeadRabbitHead(LEFT, DOWN);
		DeadRabbitHead leftLowerHead = new DeadRabbitHead(LEFT, UP);
		DeadRabbitHead rightLowerHead = new DeadRabbitHead(LEFT, DOWN);

		Game game = new Game(leftUpperHead, rightUpperHead, rightLowerHead,
				leftLowerHead, possibleMoves);

		List<Move> solution = game.solve();

		System.out.println(solution);
	}

}
