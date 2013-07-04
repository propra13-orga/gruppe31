package game;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * die Objekte dieser Klasse sind der Fliegenpilz und die Biene
 * 
 */
public class Gegner extends Spielfigur {

	/** verschiedene Icons für verschiedene Gegner werden deklariert */
	private static final Icon ICONGEGNER1 = new ImageIcon(Konstanten.DIRECTION
			+ "/src/game/Images/Gegner1.png");
	private static final Icon ICONGEGNER2 = new ImageIcon(Konstanten.DIRECTION
			+ "/src/game/Images/Gegner2.png");

	/** icon vom Typ Icon wird deklariert */
	private Icon icon;

	/** ko wird deklariert */
	private int ko;

	/** Koonstrauktor initialisiert icon */
	public Gegner() {
		setKo(0);
		setGesundheit(Konstanten.VOLLH);
		
		/* richtiges Icon setzen */
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
	public Icon getIcon() {
		return icon;
	}
}
