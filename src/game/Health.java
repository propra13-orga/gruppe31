package game;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * ein Objekt dieser Klasse ist Health
 * 
 */
public class Health extends Item {
	
	private static final Icon icon = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Heiltrank1.png");

	@Override
	public Icon getIcon() {
		// TODO Auto-generated method stub
		return icon;
	}
}
