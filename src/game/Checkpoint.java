package game;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * ein Objekt dieser Klasse ist der Checkpoint
 *
 */
public class Checkpoint extends GameObject {

	private static final Icon icon = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Save.png");

	@Override
	public Icon getIcon() {
		// TODO Auto-generated method stub
		return icon;
	}

}
