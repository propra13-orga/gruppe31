package game.items;

import java.io.Serializable;

import game.Konstanten;

/**
 * ein Objekt dieser Klasse ist die Shopruestung
 * 
 */
public class Shopruestung extends Item implements Serializable {

	/** Icon f�r R�stung im SHop wird deklariert */
	private static final String ICONSHOPRUESTUNG = Konstanten.DIRECTION
			+ "/src/game/Images/HalsbandRasen.png";

	/** bild vom Typ String wird deklariert */
	private String bild;

	/** Konstruktor initialisiert icon */
	public Shopruestung() {
		bild = ICONSHOPRUESTUNG;
	}

	@Override
	public String getPicture() {
		return bild;
	}

}
