package game;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * ein Objekt dieser Klasse ist ein Bossgegner
 * 
 */
public class Bossgegner extends Spielfigur {

	/** verschiedene Icons für den Bossgegner werden deklariert */
	private static final Icon ICONBOSS1V = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Boss1voll.png");
	private static final Icon ICONBOSS1M = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Boss1mitte.png");
	private static final Icon ICONBOSS1W = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Boss1wenig.png");
	private static final Icon ICONBOSS2V = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Boss2voll.png");
	private static final Icon ICONBOSS2M = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Boss2mitte.png");
	private static final Icon ICONBOSS2W = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Boss2wenig.png");
	private static final Icon ICONBOSS3V = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Boss3voll.png");
	private static final Icon ICONBOSS3M = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Boss3mitte.png");
	private static final Icon ICONBOSS3W = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Boss3wenig.png");

	/** icon vom Typ Icon wird deklariert */
	private Icon icon;

	/** Konstruktor initialisiert icon */
	public Bossgegner() {
		// * richtiges Icon auswählen */
	}

	@Override
	public Icon getIcon() {
		return icon;
	}

	@Override
	protected boolean internalTryMove(GameObject ziel) {
		// darf ich dahin oder nicht
		return false;
	}

}
