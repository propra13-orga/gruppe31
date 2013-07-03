package game;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * ein Objekt dieser Klasse ist Gold
 * 
 */
public class Gold extends Item {

	/** Icon für Gold wird deklariert */
	private static final Icon ICONGOLD = new ImageIcon(Konstanten.direction
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
	 * Getter für gold;
	 * 
	 * @return
	 */
	public int getGold() {
		return gold;
	}

	/**
	 * Setter für gold
	 * 
	 * @param gold
	 */
	public void setGold(int gold) {
		this.gold = gold;
	}

	@Override
	public Icon getIcon() {
		return icon;
	}
}
