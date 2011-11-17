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
public class Pack09SolutionTest {
	
	private static final int POSSIBLE_MOVES = 5;

	@Test
	public void solveLevel1() {
		DeadRabbitHead leftUpperHead = new DeadRabbitHead(DOWN, BACK);
		DeadRabbitHead rightUpperHead = new DeadRabbitHead(UP, FRONT);
		DeadRabbitHead leftLowerHead = new DeadRabbitHead(DOWN, LEFT);
		DeadRabbitHead rightLowerHead = new DeadRabbitHead(LEFT, FRONT);
		
		Game game = new Game(leftUpperHead, rightUpperHead, leftLowerHead,
				rightLowerHead, POSSIBLE_MOVES);
		
		List<Move> solution = game.solve();
		
		System.out.println(solution);
		
	}
	
	@Test
	public void solveLevel3() {
		DeadRabbitHead leftUpperHead = new DeadRabbitHead(DOWN, RIGHT);
		DeadRabbitHead rightUpperHead = new DeadRabbitHead(BACK, RIGHT);
		DeadRabbitHead leftLowerHead = new DeadRabbitHead(DOWN, LEFT);
		DeadRabbitHead rightLowerHead = new DeadRabbitHead(BACK, LEFT);
		
		Game game = new Game(leftUpperHead, rightUpperHead, leftLowerHead,
				rightLowerHead, POSSIBLE_MOVES);
		
		List<Move> solution = game.solve();
		
		System.out.println(solution);
		
	}

}
