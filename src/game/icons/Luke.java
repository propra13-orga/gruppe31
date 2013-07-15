package game.icons;

import game.GameObject;
import game.Konstanten;

/**
 * ein Objekt dieser Klasse ist Carlos, der NPC
 * 
 */
public class Luke extends GameObject {

	/** Icon für Carlos wird deklariert */
	private static final String ICONCARLOS = Konstanten.DIRECTION
			+ "/src/game/Images/Luke.png";

	/** bild vom Typ String wird deklariert */
	private String bild;

	/** Konstruktor initialisiert icon */
	public Luke() {
		bild = ICONCARLOS;
	}

	@Override
	public String getPicture() {
		return bild;
	}

}
