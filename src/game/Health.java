package game;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * ein Objekt dieser Klasse ist Health
 * 
 */
public class Health extends Item {

	/** Icon für Trank wird deklariert */
	private static final Icon ICONTRANK = new ImageIcon(Konstanten.DIRECTION
			+ "/src/game/Images/Heiltrank1.png");

	/** icon vom Typ Icon wird deklariert */
	private Icon icon;

	/** Konstruktor initialisiert icon */
	public Health() {
		icon = ICONTRANK;
	}

	@Override
	public Icon getIcon() {
		return icon;
	}
}
