package game;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * ein Objekt dieser Klasse ist Shophealth
 * 
 */
public class Shophealth extends Item {

	/** Icon für Trank im Shop wird deklariert */
	private static final Icon ICONSHOPTRANK = new ImageIcon(
			Konstanten.DIRECTION + "/src/game/Images/Heiltrank1.png");

	/** icon vom Typ Icon wird deklariert */
	private Icon icon;

	/** Konstruktor initialisiert icon */
	public Shophealth() {
		icon = ICONSHOPTRANK;
	}

	@Override
	public Icon getIcon() {
		return icon;
	}

}
