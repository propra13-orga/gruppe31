package game;

/**
 * ein Objekt dieser Klasse ist Gold
 * 
 */
public class Gold extends Item {

	/** Icon f�r Gold wird deklariert */
	private static final String ICONGOLD = Konstanten.DIRECTION
			+ "/src/game/Images/Gold1.png";

	/** bild vom Typ String wird deklariert */
	private String bild;

	/** gold wird deklariert */
	private int gold;

	/** Konstruktor initialisiert icon */
	public Gold() {
		bild = ICONGOLD;
	}

	/**
	 * Gibt die Anzahl an Gold zur�ck, die der Spieler aktuell besitzt.
	 * 
	 * @return gold Die aktuelle Anzahl an Goldm�nzen, -1 wenn der Spieler
	 *         �berschuldet ist.
	 */
	public int getGold() {
		return gold;
	}

	/**
	 * Setter f�r gold
	 * 
	 * @param gold
	 *            Kommandozeilenparameter
	 */
	public void setGold(int gold) {
		this.gold = gold;
	}

	@Override
	public String getPicture() {
		return bild;
	}
}
