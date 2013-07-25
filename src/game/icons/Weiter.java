package game.icons;

import java.io.Serializable;

import game.GameObject;
import game.Konstanten;

/**
 * ein Objekt dieser Klasse ist Weiter
 * 
 */
public class Weiter extends GameObject implements Serializable {

	/** Icon für Weiter wird deklarier */
	private static final String ICONWEITER = Konstanten.DIRECTION
			+ "/src/game/Images/Weiter1.jpg";

	/** bild vom Typ String wird deklariert */
	private String bild;

	/** Konstruktor initialisiert icon */
	public Weiter() {
		bild = ICONWEITER;
	}

	@Override
	public String getPicture() {
		return bild;
	}
}
