package game;

/**
 * ein Objekt dieser Klasse ist die Grenze
 * 
 */
public class Grenze extends GameObject {

	/** Icon für Baum wird deklariert */
	private static final String ICONBAUM = Konstanten.DIRECTION
			+ "/src/game/Images/Baum1.jpg";

	/** bild vom Typ String wird deklariert */
	private String bild;

	/** Konstruktor initialisiert icon */
	public Grenze() {
		bild = ICONBAUM;
	}

	@Override
	public String getPicture() {
		return bild;
	}

}
