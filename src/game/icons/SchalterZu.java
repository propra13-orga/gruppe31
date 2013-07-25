package game.icons;

import java.io.Serializable;

import game.GameObject;
import game.Konstanten;

/**
 * ein Objekt dieser Klasse ist Carlos, der NPC
 * 
 */
public class SchalterZu extends GameObject implements Serializable {

	/** Icon f�r Carlos wird deklariert */
	private static final String ICONZU = Konstanten.DIRECTION
			+ "/src/game/Images/Schalterzu.png";

	/** bild vom Typ String wird deklariert */
	private String bild;

	/** Konstruktor initialisiert icon */
	public SchalterZu() {
		bild = ICONZU;
	}

	@Override
	public String getPicture() {
		return bild;
	}

}
