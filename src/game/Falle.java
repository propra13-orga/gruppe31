package game;

/**
 * die Objekte dieser Klasse sind die Bombe und der Müll
 * 
 */
public class Falle extends GameObject {

	/** Icons für verschiedene Arten von Waffe werden deklariert */
	private static final String ICONBOMBE = Konstanten.DIRECTION
			+ "/src/game/Images/Peng.png";
	private static final String ICONMUELL = Konstanten.DIRECTION
			+ "/src/game/Images/Falle.png";

	/** bild vom Typ String wird deklariert */
	private String bild;

	/** schaden wird deklariert */
	private int schaden;

	/** Konstruktor weist Icon das richtige Icon zu */
	public Falle() {
		bild = ICONMUELL;

		schaden = Konstanten.HALBH;
	}

	/**
	 * Getter für schaden
	 * 
	 * @return schaden Der Schaden, der von dieser Falle ausgehen kann
	 */
	public int getSchaden() {
		return schaden;
	}

	@Override
	public String getPicture() {
		return bild;
	}
}
