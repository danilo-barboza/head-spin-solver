/**
 * 
 */
package br.com.dbarboza.headspin.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import br.com.dbarboza.headspin.model.DeadRabbitHead.Side;

/**
 * Translates the {@link Side} enum, so we can reference it in portuguese.
 * 
 * @author danilo
 * 
 */
public class SideTranslator {

	private static Map<String, String> PROPS = new HashMap<String, String>(
			Side.values().length);

	static {
		PROPS.put("UP", "CIMA");
		PROPS.put("DOWN", "BAIXO");
		PROPS.put("RIGHT", "DIREITA");
		PROPS.put("LEFT", "ESQUERDA");
		PROPS.put("FRONT", "FRENTE");
		PROPS.put("BACK", "TRAS,TRÁS");
	}

	/**
	 * 
	 */
	public SideTranslator() {
	}

	public String translate(String side) {
		for (Entry<String, String> entry : PROPS.entrySet()) {
			if (entry.getValue().contains(side.toUpperCase())) {
				return entry.getKey();
			}
		}

		return side;
	}

}
