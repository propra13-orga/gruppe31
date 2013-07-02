package game;

import java.awt.*;
import java.awt.event.KeyEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * diese Klasse ist für alles zuständig, was für das Spielfeld gezeichnet wird
 */
public class Zeichner extends Canvas {

	private static final Icon iconLaser = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Laser1.png");
	private static final Icon iconGegnertot = new ImageIcon(
			Konstanten.direction + "/src/game/Images/Gegnertot1.png");
	private static final Icon iconStunk = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Stunk.jpg");

	private Spielfeld spielfeld;
	private GameFrame gameFrame;

	public Zeichner(GameFrame pGameFrame) throws Exception {
		gameFrame = pGameFrame;
	}

	/**
	 * für jedes Feld im Array wird ein Icon gesetzt, welches aus den jeweiligen
	 * Objektklassen geholt wird
	 * 
	 * @param Graphics g
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
