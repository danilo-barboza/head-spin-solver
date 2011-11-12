package br.com.dbarboza.headspin.test;

import static br.com.dbarboza.headspin.model.DeadRabbitHead.Side.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.List;

import org.junit.Test;

import br.com.dbarboza.headspin.game.Game;
import br.com.dbarboza.headspin.game.Game.Move;
import br.com.dbarboza.headspin.model.DeadRabbitHead;

public class Pack2SolutionTest {

	private final int possibleMoves = 2;

	@Test
	public void solveLevel2() {
		DeadRabbitHead rightUpperHead = new DeadRabbitHead(UP, BACK);
		DeadRabbitHead rightLowerHead = new DeadRabbitHead(UP, BACK);
		DeadRabbitHead leftLowerHead = new DeadRabbitHead(UP, BACK);
		DeadRabbitHead leftUpperHead = new DeadRabbitHead(UP, BACK);

		Game game = new Game(rightUpperHead, leftUpperHead, rightLowerHead,
				leftLowerHead, possibleMoves);

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

		Game game = new Game(leftUpperHead, rightUpperHead, rightLowerHead,
				leftLowerHead, possibleMoves);

		List<Move> solution = game.solve();

		System.out.println(solution);
	}

	public static void main(String[] args) throws Exception {

		// DeadRabbitHead leftUpperHead = new DeadRabbitHead(LEFT, DOWN);
		// DeadRabbitHead rightUpperHead = new DeadRabbitHead(BACK, LEFT);
		// DeadRabbitHead rightLowerHead = new DeadRabbitHead(RIGHT, BACK);
		// DeadRabbitHead leftLowerHead = new DeadRabbitHead(FRONT, DOWN);
		//
		// Game game = new Game(leftUpperHead, rightUpperHead, rightLowerHead,
		// leftLowerHead, 7);
		//
		// List<Move> solution = game.solve();
		//
		// System.out.println(solution);
		
		File file =new File("lib\\junit-4.8.2.jar");
		
		file.createNewFile();

		System.out.println(file.exists());

	}

	public static void printObjectMemory(long memoryBeforeAllocation) {
		long endMemory = Runtime.getRuntime().totalMemory()
				- Runtime.getRuntime().freeMemory();

		if(endMemory - memoryBeforeAllocation > 0)
			System.out.println();
		
		System.out.println("total memory in use after allocation "
				+ (endMemory - memoryBeforeAllocation));
	}

}
