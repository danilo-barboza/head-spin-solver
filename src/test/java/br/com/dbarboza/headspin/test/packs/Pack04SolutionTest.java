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
public class Pack04SolutionTest {

	private static final int POSSIBLE_MOVES = 4;

	@Test
	public void solveLevel3() {
		DeadRabbitHead leftUpperHead = new DeadRabbitHead(LEFT, UP);
		DeadRabbitHead rightUpperHead = new DeadRabbitHead(LEFT, DOWN);
		DeadRabbitHead leftLowerHead = new DeadRabbitHead(LEFT, UP);
		DeadRabbitHead rightLowerHead = new DeadRabbitHead(LEFT, DOWN);

		Game game = new Game(leftUpperHead, rightUpperHead, leftLowerHead,
				rightLowerHead, POSSIBLE_MOVES);

		List<Move> solution = game.solve();

		System.out.println(solution);
	}

	@Test
	public void solveLevel4() {
		DeadRabbitHead leftUpperHead = new DeadRabbitHead(DOWN, LEFT);
		DeadRabbitHead rightUpperHead = new DeadRabbitHead(RIGHT, UP);
		DeadRabbitHead leftLowerHead = new DeadRabbitHead(DOWN, FRONT);
		DeadRabbitHead rightLowerHead = DeadRabbitHead.defaultPosition();

		Game game = new Game(leftUpperHead, rightUpperHead, leftLowerHead,
				rightLowerHead, POSSIBLE_MOVES);

		List<Move> solution = game.solve();

		System.out.println(solution);
	}

	@Test
	public void solveLevel5() {
		DeadRabbitHead leftUpperHead = new DeadRabbitHead(BACK, DOWN);
		DeadRabbitHead rightUpperHead = new DeadRabbitHead(DOWN, FRONT);
		DeadRabbitHead leftLowerHead = new DeadRabbitHead(LEFT, DOWN);
		DeadRabbitHead rightLowerHead = new DeadRabbitHead(LEFT, FRONT);

		Game game = new Game(leftUpperHead, rightUpperHead, leftLowerHead,
				rightLowerHead, POSSIBLE_MOVES);

		List<Move> solution = game.solve();

		System.out.println(solution);
	}

	@Test
	public void solveLevel7() {
		DeadRabbitHead leftUpperHead = new DeadRabbitHead(RIGHT, BACK);
		DeadRabbitHead rightUpperHead = new DeadRabbitHead(RIGHT, BACK);
		DeadRabbitHead leftLowerHead = new DeadRabbitHead(RIGHT, BACK);
		DeadRabbitHead rightLowerHead = new DeadRabbitHead(RIGHT, BACK);

		Game game = new Game(leftUpperHead, rightUpperHead, leftLowerHead,
				rightLowerHead, POSSIBLE_MOVES);

		List<Move> solution = game.solve();

		System.out.println(solution);
	}

	@Test
	public void solveLevel11() {
		DeadRabbitHead leftUpperHead = new DeadRabbitHead(FRONT, LEFT);
		DeadRabbitHead rightUpperHead = new DeadRabbitHead(FRONT, RIGHT);
		DeadRabbitHead leftLowerHead = new DeadRabbitHead(UP, BACK);
		DeadRabbitHead rightLowerHead = new DeadRabbitHead(DOWN, FRONT);

		Game game = new Game(leftUpperHead, rightUpperHead, leftLowerHead,
				rightLowerHead, POSSIBLE_MOVES);

		List<Move> solution = game.solve();

		System.out.println(solution);
	}
	
	@Test
	public void solveLevel13() {
		DeadRabbitHead leftUpperHead = new DeadRabbitHead(LEFT, BACK);
		DeadRabbitHead rightUpperHead = new DeadRabbitHead(LEFT, UP);
		DeadRabbitHead leftLowerHead = new DeadRabbitHead(FRONT, RIGHT);
		DeadRabbitHead rightLowerHead = new DeadRabbitHead(FRONT, UP);
		
		Game game = new Game(leftUpperHead, rightUpperHead, leftLowerHead,
				rightLowerHead, POSSIBLE_MOVES);
		
		List<Move> solution = game.solve();
		
		System.out.println(solution);
	}

	@Test
	public void solveLevel17() {
		DeadRabbitHead leftUpperHead = new DeadRabbitHead(DOWN, FRONT);
		DeadRabbitHead rightUpperHead = new DeadRabbitHead(DOWN, FRONT);
		DeadRabbitHead leftLowerHead = new DeadRabbitHead(UP, FRONT);
		DeadRabbitHead rightLowerHead = new DeadRabbitHead(UP, FRONT);

		Game game = new Game(leftUpperHead, rightUpperHead, leftLowerHead,
				rightLowerHead, POSSIBLE_MOVES);

		List<Move> solution = game.solve();

		System.out.println(solution);
	}
	
	@Test
	public void solveLevel19() {
		DeadRabbitHead leftUpperHead = new DeadRabbitHead(LEFT, DOWN);
		DeadRabbitHead rightUpperHead = new DeadRabbitHead(RIGHT, UP);
		DeadRabbitHead leftLowerHead = new DeadRabbitHead(LEFT, DOWN);
		DeadRabbitHead rightLowerHead = new DeadRabbitHead(LEFT, UP);
		
		Game game = new Game(leftUpperHead, rightUpperHead, leftLowerHead,
				rightLowerHead, POSSIBLE_MOVES);
		
		List<Move> solution = game.solve();
		
		System.out.println(solution);
	}

}
