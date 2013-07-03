package game;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * ein Objekt dieser Klasse ist das Ziel
 * 
 */
public class Ziel extends GameObject {

	/** Icon für Ziel wird deklariert */
	private static final Icon ICONCUPCAKE = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Cupcake.jpg");

	/** icon vom Typ Icon wird deklariert */
	private Icon icon;

	/** Konstruktor initialisiert icon */
	public Ziel() {
		icon = ICONCUPCAKE;
	}

	@Override
	public Icon getIcon() {
		return icon;
	}

}
