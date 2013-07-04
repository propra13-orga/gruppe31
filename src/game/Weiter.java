package game;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * ein Objekt dieser Klasse ist Weiter
 * 
 */
public class Weiter extends GameObject {

	/** Icon für Weiter wird deklariert */
	private static final Icon ICONWEITER = new ImageIcon(Konstanten.DIRECTION
			+ "/src/game/Images/Weiter1.jpg");

	/** icon vom Typ Icon wird deklariert */
	private Icon icon;

	/** Konstruktor initialisiert icon */
	public Weiter() {
		icon = ICONWEITER;
	}

	@Override
	public Icon getIcon() {
		return icon;
	}
}
