package game.icons;

import game.GameObject;
import game.Konstanten;

/**
 * ein Objekt dieser Klasse ist Carlos, der NPC
 * 
 */
public class Laser extends GameObject {

	/** Icon für Carlos wird deklariert */
	private static final String ICONLASER = Konstanten.DIRECTION
			+ "/src/game/Images/Laser.png";

	/** bild vom Typ String wird deklariert */
	private String bild;

	/** Konstruktor initialisiert icon */
	public Laser() {
		bild = ICONLASER;
	}

	@Override
	public String getPicture() {
		return bild;
	}
}