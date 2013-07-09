package game;

/**
 * ein Objekt dieser Klasse ist die Laserbrille
 * 
 */
public class Brille extends Item {

	/** Icon f�r Waffe wird deklariert */
	private static final String ICONWAFFE = Konstanten.DIRECTION
			+ "/src/game/Images/Waffe1.png";

	/** bild vom Typ String wird deklariert */
	private String bild;

	/** Konstruktor initialisiert icon */
	public Brille() {
		bild = ICONWAFFE;
	}

	@Override
	public String getPicture() {
		return bild;
	}

}
