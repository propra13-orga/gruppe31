package game;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * ein Objekt dieser Klasse ist die Huette
 * 
 */
public class Huette extends GameObject {

	/** Icon für Shop wird deklariert */
	private static final Icon ICONSHOP = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Shop.png");

	/** icon vom Typ Icon wird deklariert */
	private Icon icon;

	/** Konstruktor initialisiert icon */
	public Huette() {
		icon = ICONSHOP;
	}

	@Override
	public Icon getIcon() {
		return icon;
	}

}
