package game;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * ein Objekt dieser Klasse ist Shopmana
 * 
 */
public class Shopmana extends Item {

	/** Icon für Mana im Shop wird deklariert */
	private static final Icon ICONSHOPMANA = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Mana1.png");

	/** icon vom Typ Icon wird deklariert */
	private Icon icon;

	/** mana wird deklariert */
	private int mana;

	/** Konstruktor initialisiert icon */
	public Shopmana() {
		icon = ICONSHOPMANA;
	}

	/**
	 * Getter für mana
	 * 
	 * @return
	 */
	public int getMana() {
		return mana;
	}

	/**
	 * Setter für mana
	 * 
	 * @return
	 */
	public void setMana(int mana) {
		this.mana = mana;
	}

	@Override
	public Icon getIcon() {
		return icon;
	}

}
