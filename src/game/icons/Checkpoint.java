package game.icons;

import java.io.Serializable;

import game.GameObject;
import game.Konstanten;

/**
 * ein Objekt dieser Klasse ist der Checkpoint
 * 
 */
public class Checkpoint extends GameObject implements Serializable {

	/** Icon f�r Checkpoint wird deklariert */
	private static final String ICONSAVE = Konstanten.DIRECTION
			+ "/src/game/Images/Save.png";

	/** bild vom Typ String wird deklariert */
	private String bild;

	/** Konstruktor initialisiert icon */
	public Checkpoint() {
		bild = ICONSAVE;
	}

	@Override
	public String getPicture() {
		return bild;
	}

}
