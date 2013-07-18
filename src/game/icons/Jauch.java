package game.icons;

import game.GameObject;
import game.Konstanten;

public class Jauch extends GameObject {

	/** Icon für Checkpoint wird deklariert */
	private static final String ICONJAUCH = Konstanten.DIRECTION
			+ "/src/game/Images/Jauch.jpg";

	/** bild vom Typ String wird deklariert */
	private String bild;

	/** Konstruktor initialisiert icon */
	public Jauch() {
		bild = ICONJAUCH;
	}

	@Override
	public String getPicture() {
		return bild;
	}
}
