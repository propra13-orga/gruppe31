package game;

/**
 * ein Objekt dieser Klasse ist das Ziel
 * 
 */
public class Ziel extends GameObject {

	/** Icon für Ziel wird deklariert */
	private static final String ICONCUPCAKE = Konstanten.DIRECTION
			+ "/src/game/Images/Cupcake.jpg";

	/** bild vom Typ String wird deklariert */
	private String bild;

	/** Konstruktor initialisiert icon */
	public Ziel() {
		bild = ICONCUPCAKE;
	}

	@Override
	public String getPicture() {
		return bild;
	}

}
