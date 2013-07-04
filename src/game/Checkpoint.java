package game;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * ein Objekt dieser Klasse ist der Checkpoint
 * 
 */
public class Checkpoint extends GameObject {

	/** Icon für Checkpoint wird deklariert */
	private static final Icon ICONSAVE = new ImageIcon(Konstanten.DIRECTION
			+ "/src/game/Images/Save.png");

	/** icon vom Typ Icon wird deklariert */
	private Icon icon;

	/** Konstruktor initialisiert icon */
	public Checkpoint() {
		icon = ICONSAVE;
	}

	@Override
	public Icon getIcon() {
		return icon;
	}

}
