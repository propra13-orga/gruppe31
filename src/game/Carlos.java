package game;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * ein Objekt dieser Klasse ist Carlos, der NPC
 * 
 */
public class Carlos extends GameObject {

	/** Icon für Carlos wird deklariert */
	private static final Icon ICONCARLOS = new ImageIcon(Konstanten.DIRECTION
			+ "/src/game/Images/Carlos.png");

	/** icon vom Typ Icon wird deklariert */
	private Icon icon;

	/** Konstruktor initialisiert icon */
	public Carlos() {
		icon = ICONCARLOS;
	}

	@Override
	public Icon getIcon() {
		return icon;
	}

}
