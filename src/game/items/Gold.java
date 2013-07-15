package game.items;

import game.Konstanten;

/**
 * ein Objekt dieser Klasse ist Gold
 * 
 */
public class Gold extends Item {

	/** Icon für Gold wird deklariert */
	private static final String ICONGOLD = Konstanten.DIRECTION
			+ "/src/game/Images/Gold1.png";

	/** bild vom Typ String wird deklariert */
	private String bild;

	/** gold wird deklariert */
	private int gold;

	/** Konstruktor initialisiert icon */
	public Gold() {
		bild = ICONGOLD;
	}

	@Override
	public String getPicture() {
		return bild;
	}
}
