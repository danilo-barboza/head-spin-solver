package br.com.dbarboza.headspin.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.dbarboza.headspin.game.MovePossibilityTree;

public class MovePossibilityTreeTest {

	@Test
	public void testNumberOfPossibilities() {
		MovePossibilityTree tree;

		for (int i = 1; i <= 6; i++) {
			tree = new MovePossibilityTree(i);

			assertEquals((int) Math.pow(8, i), tree.numberOfPossibleSolutions());
		}

	}

}
