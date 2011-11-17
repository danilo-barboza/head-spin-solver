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
public class Pack13SolutionTest {
	
	private static final int POSSIBLE_MOVES = 6;

	@Test
	public void solveLevel1() {
		DeadRabbitHead leftUpperHead = new DeadRabbitHead(RIGHT, UP);
		DeadRabbitHead rightUpperHead = new DeadRabbitHead(DOWN, RIGHT);
		DeadRabbitHead leftLowerHead = new DeadRabbitHead(FRONT, UP);
		DeadRabbitHead rightLowerHead = new DeadRabbitHead(LEFT, DOWN);
		
		Game game = new Game(leftUpperHead, rightUpperHead, leftLowerHead,
				rightLowerHead, POSSIBLE_MOVES);
		
		List<Move> solution = game.solve();
		
		System.out.println(solution);
		
	}

	@Test
	public void solveLevel3() {
		DeadRabbitHead leftUpperHead = new DeadRabbitHead(FRONT, DOWN);
		DeadRabbitHead rightUpperHead = new DeadRabbitHead(FRONT, DOWN);
		DeadRabbitHead leftLowerHead = new DeadRabbitHead(BACK, DOWN);
		DeadRabbitHead rightLowerHead = new DeadRabbitHead(FRONT, UP);

		Game game = new Game(leftUpperHead, rightUpperHead, leftLowerHead,
				rightLowerHead, POSSIBLE_MOVES);

		List<Move> solution = game.solve();

		System.out.println(solution);

	}
	
	@Test
	public void solveLevel7() {
		DeadRabbitHead leftUpperHead = new DeadRabbitHead(BACK, LEFT);
		DeadRabbitHead rightUpperHead = new DeadRabbitHead(LEFT, BACK);
		DeadRabbitHead leftLowerHead = new DeadRabbitHead(BACK, DOWN);
		DeadRabbitHead rightLowerHead = new DeadRabbitHead(FRONT, LEFT);
		
		Game game = new Game(leftUpperHead, rightUpperHead, leftLowerHead,
				rightLowerHead, POSSIBLE_MOVES);
		
		List<Move> solution = game.solve();
		
		System.out.println(solution);
		
	}

}
