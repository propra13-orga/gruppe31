package game;

import java.awt.*;
import java.awt.event.KeyEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * diese Klasse ist für alles zuständig, was auf dem GameFrame Fenster für das
 * Spielfeld gezeichnet wird
 */
public class Zeichner extends Canvas {

	private static final Icon iconRasen = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Rasen1.jpg");
	private static final Icon iconBaum = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Baum1.jpg");
	private static final Icon iconPudel = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Pudel1.jpg");
	private static final Icon iconGegner = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Gegner1.png");
	private static final Icon iconWeiter = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Weiter1.jpg");
	private static final Icon iconBoss = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Boss1.png");
	private static final Icon iconZurueck = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Zurueck1.jpg");
	private static final Icon iconCarlos = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Carlos.png");
	private static final Icon iconWaffe = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Waffe1.png");
	private static final Icon iconAggroErna = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/PudelWaffe1.png");
	private static final Icon iconGold = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Gold1.png");
	private static final Icon iconMana = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Mana1.png");
	private static final Icon iconHealth = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Heiltrank1.png");
	private static final Icon iconRuestung = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Ruestung1.png");

	Integer[][] Spielfeld;
	
	private GameFrame gameFrame;

	/**
	 * für jedes Feld im Array Spielfeld kann ein Icon gesetzt werden, welches
	 * anschließend gezeichnet wird
	 */
	public void paint(Graphics g) {
		int size = 50;
		for (int i = 0; i < Spielfeld.length; i++) {
			for (int j = 0; j < Spielfeld[i].length; j++) {

				Icon icon;

				switch (Spielfeld[i][j]) {
				case Konstanten.RASEN:
					icon = iconRasen;
					break;
				case Konstanten.GRENZE:
					icon = iconBaum;
					break;
				case Konstanten.GEGNER:
					icon = iconGegner;
					break;
				case Konstanten.WEITER:
					icon = iconWeiter;
					break;
				case Konstanten.BOSS:
					icon = iconBoss;
					break;
				case Konstanten.ZURUECK:
					icon = iconZurueck;
					break;
				case Konstanten.CARLOS:
					icon = iconCarlos;
					break;
				case Konstanten.WAFFE:
					icon = iconWaffe;
					break;
				case Konstanten.GOLD:
					icon = iconGold;
					break;
				case Konstanten.MANA:
					icon = iconMana;
					break;
				case Konstanten.RUESTUNG:
					icon = iconRuestung;
					break;
				case Konstanten.HEALTH:
					icon = iconHealth;
					break;
				case Konstanten.PUDEL:
					icon = iconPudel;
					break;
				default:
					icon = iconPudel;
					break;
				}
				icon.paintIcon(this, g, i * size, j * size);
			}
		}
	}

	/** zeichnet das Spielfeld erneut */
	public void zeichneSpielfeld(Integer[][] feld) {
		Spielfeld = feld;
		repaint();
	}
}
