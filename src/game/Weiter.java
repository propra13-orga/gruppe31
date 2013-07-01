package game;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * ein Objekt dieser Klasse ist Weiter
 * 
 */
public class Weiter extends GameObject {
	
	private static final Icon icon = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Weiter1.jpg");

	@Override
	public Icon getIcon() {
		// TODO Auto-generated method stub
		return icon;
	}
}
