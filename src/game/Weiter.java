package game;

/**
 * ein Objekt dieser Klasse ist Weiter
 * 
 */
public class Weiter extends GameObject {

	/** Icon für Weiter wird deklariert */
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
