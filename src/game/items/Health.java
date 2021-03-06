package game.items;

import java.io.Serializable;

import game.Konstanten;

/**
 * ein Objekt dieser Klasse ist Health
 * 
 */
public class Health extends Item implements Serializable {

	/** Icon f�r Trank wird deklariert */
	private static final String ICONTRANK = Konstanten.DIRECTION
			+ "/src/game/Images/Heiltrank1.png";

	/** bild vom Typ String wird deklariert */
	private String bild;

	/** Konstruktor initialisiert icon */
	public Health() {
		bild = ICONTRANK;
	}

	@Override
	public String getPicture() {
		return bild;
	}
}
