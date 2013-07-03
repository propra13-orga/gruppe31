package game;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * die Objekte dieser Klasse sind die Bombe und der M�ll
 * 
 */
public class Falle extends GameObject {

	/** Icons f�r verschiedene Arten von Waffe werden deklariert */
	private static final Icon ICONBOMBE = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Peng.png");
	private static final Icon ICONMUELL = new ImageIcon(Konstanten.direction
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
	 * Getter f�r schaden
	 * @return
	 */
	public int getSchaden() {
		return schaden;
	}

	/** 
	 * Setter f�r schaden
	 * @param schaden
	 */
	public void setSchaden(int schaden) {
		this.schaden = schaden;
	}

	@Override
	public Icon getIcon() {
		return icon;
	}
}
