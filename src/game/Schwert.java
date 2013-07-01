package game;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * ein Objekt dieser Klasse ist das Schwert
 * 
 */
public class Schwert extends Item {

	private static final Icon icon = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Schwertrasen.png");

	@Override
	public Icon getIcon() {
		// TODO Auto-generated method stub
		return icon;
	}
}
