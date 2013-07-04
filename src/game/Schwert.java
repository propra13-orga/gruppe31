package game;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * ein Objekt dieser Klasse ist das Schwert
 * 
 */
public class Schwert extends Item {

	/** Icon für Schwert wird deklariert */
	private static final Icon ICONSCHWERT = new ImageIcon(Konstanten.DIRECTION
			+ "/src/game/Images/Schwertrasen.png");

	/** icon vom Typ Icon wird deklariert */
	private Icon icon;

	/** Konstruktor initialisiert icon */
	public Schwert() {
		icon = ICONSCHWERT;
	}

	@Override
	public Icon getIcon() {
		return icon;
	}
}
