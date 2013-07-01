package game;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * ein Objekt dieser Klasse ist Gold
 * 
 */
public class Gold extends Item {
	
	private static final Icon icon= new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Gold1.png");

	private int gold;

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	@Override
	public Icon getIcon() {
		// TODO Auto-generated method stub
		return icon;
	}
}
