package game;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * ein Objekt dieser Klasse ist die Shopruestung
 * 
 */
public class Shopruestung extends Item {
	
	/** Icon für Rüstung im SHop wird deklariert*/
	private static final Icon ICONSHOPRUESTUNG = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/HalsbandRasen.png");
	
	/** icon vom Typ Icon wird deklariert*/
	private Icon icon;

		/** Konstruktor initialisiert icon*/
	public Shopruestung() {
		icon = ICONSHOPRUESTUNG;
	}
	
	@Override
	public Icon getIcon() {
		return icon;
	}

}
