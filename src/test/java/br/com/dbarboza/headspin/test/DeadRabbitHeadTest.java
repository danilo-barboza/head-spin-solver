package br.com.dbarboza.headspin.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.dbarboza.headspin.model.DeadRabbitHead;
import static br.com.dbarboza.headspin.model.DeadRabbitHead.Side.*;

public class DeadRabbitHeadTest {

	@Test
	public void testTurnRightWhenEarUp() {
		DeadRabbitHead head = DeadRabbitHead.defaultPosition();

		head.turnRight();

		assertEquals(head.facePosition(), RIGHT);
		assertEquals(head.earPosition(), UP);
	}

}
