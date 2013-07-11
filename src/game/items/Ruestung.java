package game.items;

import game.Konstanten;

/**
 * ein Objekt dieser Klasse ist die Ruestung
 * 
 */
public class Ruestung extends Item {

	/** Icon für Ruestung wird deklariert */
	private static final String ICONRUESTUNG = Konstanten.DIRECTION
			+ "/src/game/Images/HalsbandRasen.png";

	/** bild vom Typ String wird deklariert */
	private String bild;

	/** Konstruktor initialisiert icon */
	public Ruestung() {
		bild = ICONRUESTUNG;
	}

	@Override
	public String getPicture() {
		return bild;
	}
}
