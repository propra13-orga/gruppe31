package game.figuren;

import game.Konstanten;
import game.Spiel;
import game.Spielfeld;

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
	private static final String ICONGEGNER1TOT = Konstanten.DIRECTION
			+ "/src/game/Images/Gegnertot1.png";
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

	/**
	 * Koonstrauktor initialisiert icon
	 * 
	 * @param object
	 *            Kommandozeilenparameter
	 */
	public Gegner(String object) {
		setKo(0);
		setGesundheitPlus(Konstanten.VOLLH);

		if ("Pilz".equals(object)) {
			setzeBildPilz();
		} else if ("Biene".equals(object)) {
			bild = ICONGEGNER2;
		}
	}

	/**
	 * setzt das Bild des Pilzes
	 */
	public void setzeBildPilz() {
		if (getGesundheit() == Konstanten.VOLLH) {
			bild = ICONGEGNER1;
		} else if (getGesundheit() == Konstanten.LEERH) {
			bild = ICONGEGNER1TOT;
		}
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
