package game;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * ein Objekt dieser Klasse ist der Rasen
 * 
 */
public class Rasen extends GameObject {

	private static final Icon icon = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Rasen1.jpg");

	@Override
	public Icon getIcon() {
		return icon;
	}
}
