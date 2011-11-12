/**
 * 
 */
package br.com.dbarboza.headspin.game;

import java.util.List;

import br.com.dbarboza.headspin.game.Game.Move;

/**
 * @author danilo
 * 
 */
public interface SolutionTester {

	/**
	 * Test the given possible solution. Must only return true to indicate a
	 * valid possible solution.
	 * 
	 * @param possibleSolution
	 * @return
	 */
	public boolean testPossibleSolution(List<Move> possibleSolution);

}
