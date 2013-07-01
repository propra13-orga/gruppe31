package game;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * ein Objekt dieser Klasse ist das Ziel
 * 
 */
public class Ziel extends GameObject {
	
	private static final Icon icon = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Cupcake.jpg");

	@Override
	public Icon getIcon() {
		// TODO Auto-generated method stub
		return icon;
	}

}
