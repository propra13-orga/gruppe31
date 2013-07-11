package game.icons;

import game.GameObject;
import game.Konstanten;

/**
 * ein Objekt dieser Klasse ist Zurueck
 * 
 */
public class Zurueck extends GameObject {

	/** Icon für Zurueck wird deklariert */
	private static final String ICONZURUECK = Konstanten.DIRECTION
			+ "/src/game/Images/Zurueck1.jpg";

	/** bild vom Typ String wird deklariert */
	private String bild;

	/** Konstruktor initialisiert icon */
	public Zurueck() {
		bild = ICONZURUECK;
	}

	@Override
	public String getPicture() {
		return bild;
	}

}
