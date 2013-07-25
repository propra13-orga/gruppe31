package game.icons;

import java.io.Serializable;

import game.GameObject;
import game.Konstanten;

/**
 * ein Objekt dieser Klasse ist der Rasen
 * 
 */
public class Rasen extends GameObject implements Serializable {

	/** Icon für Rasen wird deklariert */
	private static final String ICONRASEN = Konstanten.DIRECTION
			+ "/src/game/Images/Rasen1.jpg";

	/** bild vom Typ String wird deklariert */
	private String bild;

	/** Konstruktor initialisiert icon */
	public Rasen() {
		bild = ICONRASEN;
	}

	@Override
	public String getPicture() {
		return bild;
	}
}
