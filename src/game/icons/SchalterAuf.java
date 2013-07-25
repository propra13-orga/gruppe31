package game.icons;

import java.io.Serializable;

import game.GameObject;
import game.Konstanten;

/**
 * ein Objekt dieser Klasse ist Carlos, der NPC
 * 
 */
public class SchalterAuf extends GameObject implements Serializable {

	/** Icon für Carlos wird deklariert */
	private static final String ICONAUF = Konstanten.DIRECTION
			+ "/src/game/Images/Schalterauf.png";

	/** bild vom Typ String wird deklariert */
	private String bild;

	/** Konstruktor initialisiert icon */
	public SchalterAuf() {
		bild = ICONAUF;
	}

	@Override
	public String getPicture() {
		return bild;
	}

}

