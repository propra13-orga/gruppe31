package game;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * ein Objekt dieser Klasse ist die Shopruestung
 * 
 */
public class Shopruestung extends Item {

	private static final Icon icon = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/HalsbandRasen.png");

	@Override
	public Icon getIcon() {
		// TODO Auto-generated method stub
		return icon;
	}

}
