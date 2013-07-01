package game;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * ein Objekt dieser Klasse ist Mana
 * 
 */
public class Mana extends Item {
	
	private static final Icon icon = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Mana1.png");

	private int mana;

	public int getMana() {
		return mana;
	}

	public void setMana(int mana) {
		this.mana = mana;
	}

	@Override
	public Icon getIcon() {
		// TODO Auto-generated method stub
		return icon;
	}
}
