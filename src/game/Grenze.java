package game;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * ein Objekt dieser Klasse ist die Grenze
 * 
 */
public class Grenze extends GameObject {
	
	private static final Icon icon = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Baum1.jpg");

	@Override
	public Icon getIcon() {
		return icon;
	}

}
