package game;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * ein Objekt dieser Klasse ist Mana
 * 
 */
public class Mana extends Item {
	
	/** Icon für Mana wird deklariert*/
	private static final Icon ICONMANA = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Mana1.png");
	
	/** icon vom Typ Icon wird deklariert*/
	private Icon icon;
	
	/** mana wird deklariert*/
	private int mana;
	
	/** Konstruktor initialisiert icon*/
	public Mana() {
		icon = ICONMANA;
	}
	
	/**
	 * Getter für mana;
	 * @return
	 */
	public int getMana() {
		return mana;
	}

	/**
	 * Setter für mana
	 * @param mana
	 */
	public void setMana(int mana) {
		this.mana = mana;
	}

	@Override
	public Icon getIcon() {
		return icon;
	}
}
