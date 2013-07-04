package game;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * ein Objekt dieser Klasse ist der Rasen
 * 
 */
public class Rasen extends GameObject {

	/** Icon für Rasen wird deklariert*/
	private static final Icon ICONRASEN = new ImageIcon(Konstanten.DIRECTION
			+ "/src/game/Images/Rasen1.jpg");

	/** icon vom Typ Icon wird deklariert*/
	private Icon icon;

	
	/** Konstruktor initialisiert icon*/
	public Rasen() {
		icon = ICONRASEN;
	}

	@Override
	public Icon getIcon() {
		return icon;
	}
}
