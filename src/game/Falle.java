package game;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * die Objekte dieser Klasse sind die Bombe und der Müll
 * 
 */
public class Falle extends GameObject {

	/** Icons für verschiedene Arten von Waffe werden deklariert */
	private static final Icon ICONBOMBE = new ImageIcon(Konstanten.DIRECTION
			+ "/src/game/Images/Peng.png");
	private static final Icon ICONMUELL = new ImageIcon(Konstanten.DIRECTION
			+ "/src/game/Images/Falle.png");

	/** icon vom Typ Icon wird initialisiert */
	private Icon icon;

	/** schaden wird deklariert */
	private int schaden;

	/** Konstruktor weist Icon das richtige Icon zu */
	public Falle() {
		/* Icon zuweisen */
	}

	/**
	 * Getter für schaden
	 * 
	 * @return schaden Der Schaden, der von dieser Falle ausgehen kann
	 */
	public int getSchaden() {
		return schaden;
	}

	@Override
	public Icon getIcon() {
		return icon;
	}
}
