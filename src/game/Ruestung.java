package game;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * ein Objekt dieser Klasse ist die Ruestung
 * 
 */
public class Ruestung extends Item {

	/** Icon für Ruestung wird deklariert */
	private static final Icon ICONRUESTUNG = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/HalsbandRasen.png");

	/** icon vom Typ Icon wird deklariert */
	private Icon icon;

	/** Konstruktor initialisiert icon */
	public Ruestung() {
		icon = ICONRUESTUNG;
	}

	@Override
	public Icon getIcon() {
		return icon;
	}
}
