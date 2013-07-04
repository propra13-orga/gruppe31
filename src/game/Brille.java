package game;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * ein Objekt dieser Klasse ist die Laserbrille
 * 
 */
public class Brille extends Item {

	/** Icon für Waffe wird deklariert */
	private static final Icon ICONWAFFE = new ImageIcon(Konstanten.DIRECTION
			+ "/src/game/Images/Waffe1.png");

	/** icon vom Typ Icon wird deklariert */
	private Icon icon;

	/** Konstruktor initialisiert icon */
	public Brille() {
		icon = ICONWAFFE;
	}

	@Override
	public Icon getIcon() {
		return icon;
	}

}
