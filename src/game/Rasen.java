package game;

/**
 * ein Objekt dieser Klasse ist der Rasen
 * 
 */
public class Rasen extends GameObject {

	/** Icon f�r Rasen wird deklariert */
	private static final String ICONRASEN = Konstanten.DIRECTION
			+ "/src/game/Images/Rasen1.jpg";

	/** bild vom Typ String wird deklariert */
	private String bild;

	/** Konstruktor initialisiert icon */
	public Rasen() {
		bild = ICONRASEN;
	}

	@Override
	public String getPicture() {
		return bild;
	}
}
