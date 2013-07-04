package game;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * ein Objekt dieser Klasse ist Mana
 * 
 */
public class Mana extends Item {

	/** Icon f�r Mana wird deklariert */
	private static final Icon ICONMANA = new ImageIcon(Konstanten.DIRECTION
			+ "/src/game/Images/Mana1.png");

	/** icon vom Typ Icon wird deklariert */
	private Icon icon;

	/** mana wird deklariert */
	private int mana;

	/** Konstruktor initialisiert icon */
	public Mana() {
		icon = ICONMANA;
		
		mana = Konstanten.VOLLM;
	}

	/**
	 * Getter f�r mana;
	 * 
	 * @return mana Anzahl an Mana die man bekommen kann
	 */
	public int getMana() {
		return mana;
	}

	/**
	 * Setter f�r mana
	 * 
	 * @param mana
	 *            Kommandozeilenparameter
	 */
	public void setMana(int mana) {
		this.mana = mana;
	}

	@Override
	public Icon getIcon() {
		return icon;
	}
}
