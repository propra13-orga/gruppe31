package game;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * ein Objekt dieser Klasse ist Gold
 * 
 */
public class Gold extends Item {

	/** Icon f�r Gold wird deklariert */
	private static final Icon ICONGOLD = new ImageIcon(Konstanten.DIRECTION
			+ "/src/game/Images/Gold1.png");

	/** icon vom Typ Icon wird deklariert */
	private Icon icon;

	/** gold wird deklariert */
	private int gold;

	/** Konstruktor initialisiert icon */
	public Gold() {
		icon = ICONGOLD;
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
	public Icon getIcon() {
		return icon;
	}
}
