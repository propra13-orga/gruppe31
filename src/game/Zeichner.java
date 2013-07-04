package game;

import java.awt.Canvas;
import java.awt.Graphics;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * diese Klasse ist für alles zuständig, was für das Spielfeld gezeichnet wird
 */
public class Zeichner extends Canvas {

	/** Icons für diverse andere Sachen werden deklariert */
	private static final Icon ICONLASER = new ImageIcon(Konstanten.DIRECTION
			+ "/src/game/Images/Laser1.png");
	private static final Icon ICONGEGNERTOT = new ImageIcon(
			Konstanten.DIRECTION + "/src/game/Images/Gegnertot1.png");
	private static final Icon ICONSTUNK = new ImageIcon(Konstanten.DIRECTION
			+ "/src/game/Images/Stunk.jpg");

	/** Deklaration der Felder */
	private Spielfeld spielfeld;
	private GameFrame gameFrame;

	/**
	 * Konstruktor ruft neues GameFrame auf
	 * 
	 * @param pGameFrame
	 *            Kommandozeilenparameter
	 * @throws Exception
	 *             wirft Exception
	 */
	public Zeichner(GameFrame pGameFrame) throws Exception {
		gameFrame = pGameFrame;
	}

	/**
	 * für jedes Feld im Array wird ein Icon gesetzt, welches aus den jeweiligen
	 * Objektklassen geholt wird
	 * 
	 * @param g
	 *            fordert Graphics
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
	 *            Kommandozeilenparameter
	 */
	public void zeichneSpielfeld(Spielfeld feld) {
		spielfeld = feld;
		repaint();
	}
}
