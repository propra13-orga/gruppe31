package game;

/**
 * die Objekte dieser Klasse sind der Fliegenpilz und die Biene
 * 
 */
public class Gegner extends Spielfigur {

	/** verschiedene Icons für verschiedene Gegner werden deklariert */
	private static final String ICONGEGNER1 = Konstanten.DIRECTION
			+ "/src/game/Images/Gegner1.png";
	private static final String ICONGEGNER2 = Konstanten.DIRECTION
			+ "/src/game/Images/Gegner2.png";

	/** bild vom Typ String wird deklariert */
	private String bild;

	/** ko wird deklariert */
	private int ko;

	/** Koonstrauktor initialisiert icon */
	public Gegner() {
		setKo(0);
		setGesundheit(Konstanten.VOLLH);

		bild = ICONGEGNER1;
		/* TODO ICONGEGNER2 ebenfalls setzen*/
	}

	/**
	 * Wertebereich wird festgelegt und zufällige Zahl ausgegeben
	 * 
	 * CheckStyle erwartet anderes Muster, welches ?
	 * 
	 * @param low
	 *            Kommandozeilenparameter
	 * @param high
	 *            Kommandozeilenparameter
	 * @return int
	 */
	public static int random(int low, int high) {
		high++;
		return (int) (Math.random() * (high - low) + low);
	}

	/**
	 * Getter von ko
	 * 
	 * @return ko
	 */
	public int getKo() {
		return ko;
	}

	/**
	 * Setter von ko
	 * 
	 * @param ko
	 *            Kommandozeilenparameter
	 */
	public void setKo(int ko) {
		this.ko = ko;
	}

	@Override
	protected boolean internalTryMove(GameObject ziel) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getPicture() {
		return bild;
	}
}
