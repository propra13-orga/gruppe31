package game.icons;

import game.GameObject;
import game.Konstanten;

/**
 * ein Objekt dieser Klasse ist die Huette
 * 
 */
public class Huette extends GameObject {

	/** Icon für Shop wird deklariert */
	private static final String ICONSHOP = Konstanten.DIRECTION
			+ "/src/game/Images/Shop.png";

	/** bild vom Typ String wird deklariert */
	private String bild;

	/** Konstruktor initialisiert icon */
	public Huette() {
		bild = ICONSHOP;
	}

	@Override
	public String getPicture() {
		return bild;
	}

}
