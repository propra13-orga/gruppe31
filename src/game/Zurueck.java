package game;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * ein Objekt dieser Klasse ist Zurueck
 * 
 */
public class Zurueck extends GameObject {

	/** Icon für Zurueck wird deklariert */
	private static final Icon ICONZURUECK = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Zurueck1.jpg");

	/** icon vom Typ Icon wird deklariert */
	private Icon icon;

	/** Konstruktor initialisiert icon */
	public Zurueck() {
		icon = ICONZURUECK;
	}

	@Override
	public Icon getIcon() {
		return icon;
	}

}
