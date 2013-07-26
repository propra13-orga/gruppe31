package game.items;

import java.io.Serializable;

import game.Konstanten;

/**
 * ein Objekt dieser Klasse ist Shophealth
 * 
 */
public class Shophealth extends Item implements Serializable {

	/** Icon für Trank im Shop wird deklariert */
	private static final String ICONSHOPTRANK = Konstanten.DIRECTION
			+ "/src/game/Images/Heiltrank1.png";

	/** bild vom Typ String wird deklariert */
	private String bild;

	/** Konstruktor initialisiert icon */
	public Shophealth() {
		bild = ICONSHOPTRANK;
	}

	@Override
	public String getPicture() {
		return bild;
	}

}
