package game;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * ein Objekt dieser Klasse ist die Grenze
 * 
 */
public class Grenze extends GameObject {

	/** Icon für Baum wird deklariert */
	private static final Icon ICONBAUM = new ImageIcon(Konstanten.DIRECTION
			+ "/src/game/Images/Baum1.jpg");

	/** icon vom Typ Icon wird deklariert */
	private Icon icon;

	/** Konstruktor initialisiert icon */
	public Grenze() {
		icon = ICONBAUM;
	}

	@Override
	public Icon getIcon() {
		return icon;
	}

}
