/**
 * 
 */
package br.com.dbarboza.headspin.test.cucumber;

import static org.junit.Assert.*;

import java.util.List;

import br.com.dbarboza.headspin.game.Game;
import br.com.dbarboza.headspin.game.Game.Move;
import br.com.dbarboza.headspin.model.DeadRabbitHead;
import br.com.dbarboza.headspin.model.DeadRabbitHead.Side;
import br.com.dbarboza.headspin.test.SideTranslator;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.annotation.pt.Dado;
import cucumber.annotation.pt.E;
import cucumber.annotation.pt.Entao;
import cucumber.annotation.pt.Quando;

/**
 * @author danilo
 * 
 */
public class DeadRabbitHeadStepdefs {

	private DeadRabbitHead leftUpperHead;
	private DeadRabbitHead rightUpperHead;
	private DeadRabbitHead leftLowerHead;
	private DeadRabbitHead rightLowerHead;

	private Integer possibleMoves;
	private List<Move> solution;
	private SideTranslator sideTranslator;

	/**
	 * 
	 */
	public DeadRabbitHeadStepdefs() {
		sideTranslator = new SideTranslator();
	}

	@Given("^the level has (\\d+) possible moves$")
	@Dado("^que o nível possui (\\d+) movimentos possíveis$")
	public void possibleMoves(Integer possibleMoves) {
		this.possibleMoves = possibleMoves;
	}

	@Given("^the left upper head has the face turned \"([^\"]*)\" and the ear turned \"([^\"]*)\"$")
	@Dado("^que a cabeça superior esquerda está com a face virada para \"([^\"]*)\" e a as orelhas viradas para \"([^\"]*)\"$")
	public void theLeftUpperHead(String facePosition, String earPosition) {
		String translatedFacePosition = sideTranslator.translate(facePosition);
		String translatedEarPosition = sideTranslator.translate(earPosition);

		leftUpperHead = new DeadRabbitHead(
				Side.valueOf(translatedFacePosition),
				Side.valueOf(translatedEarPosition));
	}

	@And("^the right upper head has the face turned \"([^\"]*)\" and the ear turned \"([^\"]*)\"$")
	@E("^a cabeça superior direita está com a face virada para \"([^\"]*)\" e a as orelhas viradas para \"([^\"]*)\"$")
	public void theRightUpperHead(String facePosition, String earPosition) {
		String translatedFacePosition = sideTranslator.translate(facePosition);
		String translatedEarPosition = sideTranslator.translate(earPosition);

		rightUpperHead = new DeadRabbitHead(
				Side.valueOf(translatedFacePosition),
				Side.valueOf(translatedEarPosition));
	}

	@And("^the left lower head has the face turned \"([^\"]*)\" and the ear turned \"([^\"]*)\"$")
	@E("^a cabeça inferior esquerda está com a face virada para \"([^\"]*)\" e a as orelhas viradas para \"([^\"]*)\"$")
	public void theLeftLowerHead(String facePosition, String earPosition) {
		String translatedFacePosition = sideTranslator.translate(facePosition);
		String translatedEarPosition = sideTranslator.translate(earPosition);

		leftLowerHead = new DeadRabbitHead(
				Side.valueOf(translatedFacePosition),
				Side.valueOf(translatedEarPosition));
	}

	@And("^the right lower head has the face turned \"([^\"]*)\" and the ear turned \"([^\"]*)\"$")
	@E("^a cabeça inferior direita está com a face virada para \"([^\"]*)\" e a as orelhas viradas para \"([^\"]*)\"$")
	public void theRightLowerHead(String facePosition, String earPosition) {
		String translatedFacePosition = sideTranslator.translate(facePosition);
		String translatedEarPosition = sideTranslator.translate(earPosition);

		rightLowerHead = new DeadRabbitHead(
				Side.valueOf(translatedFacePosition),
				Side.valueOf(translatedEarPosition));
	}

	@When("^I ask for the solution$")
	@Quando("^eu pergunto a solução para o nível$")
	public void gameSolution() {
		Game game = new Game(leftUpperHead, rightUpperHead, leftLowerHead,
				rightLowerHead, possibleMoves);
		this.solution = game.solve();
	}

	@Then("^I should have a list of moves with the same size of the possible moves$")
	@Entao("^deve ser repondindo com uma lista de movimentos com a mesma quantidade de movimentos possíveis$")
	public void checkSolution() {
		assertNotNull(solution);
		assertEquals(solution.size(), possibleMoves.intValue());
	}

}
