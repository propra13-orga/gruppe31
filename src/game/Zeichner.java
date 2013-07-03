package game;

import java.awt.Canvas;
import java.awt.Graphics;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * diese Klasse ist f�r alles zust�ndig, was f�r das Spielfeld gezeichnet wird
 */
public class Zeichner extends Canvas {

	/** Icons f�r diverse andere Sachen werden deklariert */
	private static final Icon iconLaser = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Laser1.png");
	private static final Icon iconGegnertot = new ImageIcon(
			Konstanten.direction + "/src/game/Images/Gegnertot1.png");
	private static final Icon iconStunk = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Stunk.jpg");

	/** Deklaration der ... */
	private Spielfeld spielfeld;
	private GameFrame gameFrame;

	/** Konstruktor mit Parameter */
	public Zeichner(GameFrame pGameFrame) throws Exception {
		gameFrame = pGameFrame;
	}

	/**
	 *  f�r jedes Feld im Array wird ein Icon gesetzt, welches aus den jeweiligen
	 * Objektklassen geholt wird
	 * 
	 * @param g
	 */
	public void paint(Graphics g) {

		for (int i = 0; i < spielfeld.feld.length; i++) {
			for (int j = 0; j < spielfeld.feld[i].length; j++) {

				Icon icon = spielfeld.feld[i][j].getIcon();

				icon.paintIcon(this, g, i * Konstanten.SIZE, j
						* Konstanten.SIZE);
			}
		}
	}

	/**
	 * zeichnet das Spielfeld (erneut)
	 * 
	 * @param feld
	 */
	public void zeichneSpielfeld(Spielfeld feld) {
		spielfeld = feld;
		repaint();
	}
}
