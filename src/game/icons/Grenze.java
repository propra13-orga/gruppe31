package game.icons;

import java.io.Serializable;

import game.GameObject;
import game.Konstanten;

/**
 * ein Objekt dieser Klasse ist die Grenze
 * 
 */
public class Grenze extends GameObject implements Serializable {

	/** Icon für Baum wird deklariert */
	private static final String ICONBAUM = Konstanten.DIRECTION
			+ "/src/game/Images/Baum1.jpg";

	/** bild vom Typ String wird deklariert */
	private String bild;

	/** Konstruktor initialisiert icon */
	public Grenze() {
		bild = ICONBAUM;
	}

	@Override
	public String getPicture() {
		return bild;
	}

}
