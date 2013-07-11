package game.items;

import game.Konstanten;

/**
 * ein Objekt dieser Klasse ist das Schwert
 * 
 */
public class Schwert extends Item {

	/** Icon für Schwert wird deklariert */
	private static final String ICONSCHWERT = Konstanten.DIRECTION
			+ "/src/game/Images/Schwertrasen.png";

	/** bild vom Typ String wird deklariert */
	private String bild;

	/** Konstruktor initialisiert icon */
	public Schwert() {
		bild = ICONSCHWERT;
	}

	@Override
	public String getPicture() {
		return bild;
	}
}
