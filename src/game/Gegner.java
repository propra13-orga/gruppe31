package game;

import java.awt.Point;
import java.awt.event.KeyEvent;

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

	/** Deklaration der Felder */
	private Spiel spiel;

	/** bild vom Typ String wird deklariert */
	private String bild;

	/** ko wird deklariert */
	private int ko;

	/** Die Position dieser Figur in der xy-Ebene. */
	private Point position;

	/** Koonstrauktor initialisiert icon */
	public Gegner() {
		setKo(0);
		setGesundheit(Konstanten.VOLLH);

		bild = ICONGEGNER1;
		/* TODO ICONGEGNER2 ebenfalls setzen */
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

	/**
	 * Bewegung des Gegners wird ausgeführt
	 * 
	 * @param e
	 *            registrierter Tastendruck
	 */
	public void bewegeGegner(KeyEvent e) {

		Spielfeld aktuellesSpielfeld = spiel.getAktuellesSpielfeld();

		int gegnerX = getPosition().x;
		int gegnerY = getPosition().y;

		/* Abfragen für die Pfeiltasten */
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			gegnerX--;
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			gegnerX++;
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			gegnerY--;
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			gegnerY++;
		}
		
		/* TODO: Prüfe was da ist */
		
		//setzeObjekt(GameObject objekt, Point position);

	}

	/**
	 * Gibt die aktuelle Position dieser Figur zurück.
	 * 
	 * @return Die aktuelle Position der Figur.
	 */
	public Point getPosition() {

		return position;
	}

	/**
	 * Setzt die aktuelle Position dieser Figur.
	 * 
	 * @param neuePosition
	 *            Die neue Position der Figur.
	 */
	public void setPosition(Point neuePosition) {

		this.position = neuePosition;
	}

	@Override
	public String getPicture() {
		return bild;
	}
}
