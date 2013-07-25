package game.icons;

import java.io.Serializable;

import game.GameObject;
import game.Konstanten;

/**
 * ein Objekt dieser Klasse ist Carlos, der NPC
 * 
 */
public class Carlos extends GameObject implements Serializable {

	/** Icon für Carlos wird deklariert */
	private static final String ICONCARLOS = Konstanten.DIRECTION
			+ "/src/game/Images/Carlos.png";

	/** bild vom Typ String wird deklariert */
	private String bild;

	/** Konstruktor initialisiert icon */
	public Carlos() {
		bild = ICONCARLOS;
	}

	@Override
	public String getPicture() {
		return bild;
	}

}
