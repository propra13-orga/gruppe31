package game;

import java.awt.*;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * diese Klasse ist für alles zuständig, was auf dem GameFrame Fenster für das
 * Spielfeld gezeichnet wird
 */
public class Zeichner extends Canvas {

	private static final String direction = System.getProperty("user.dir");

	private static final Icon iconRasen = new ImageIcon(direction
			+ "/src/game/Images/Rasen1.jpg");
	private static final Icon iconBaum = new ImageIcon(direction
			+ "/src/game/Images/Baum1.jpg");
	private static final Icon iconPudel = new ImageIcon(direction
			+ "/src/game/Images/Pudel1.jpg");
	private static final Icon iconGegner = new ImageIcon(direction
			+ "/src/game/Images/Gegner1.png");
	private static final Icon iconWeiter = new ImageIcon(direction
			+ "/src/game/Images/Weiter1.jpg");
	private static final Icon iconBoss = new ImageIcon(direction
			+ "/src/game/Images/Boss1.png");
	private static final Icon iconZurueck = new ImageIcon(direction
			+ "/src/game/Images/Zurueck1.jpg");
	private static final Icon iconCarlos = new ImageIcon(direction
			+ "/src/game/Images/Carlos.png");
	private static final Icon iconWaffe = new ImageIcon(direction
			+ "/src/game/Images/Waffe1.png");
	private static final Icon iconAggroErna = new ImageIcon(direction
			+ "/src/game/Images/PudelWaffe1.png");
	private static final Icon iconGold = new ImageIcon(direction
			+ "/src/game/Images/Gold1.png");
	private static final Icon iconMana = new ImageIcon(direction
			+ "/src/game/Images/Mana1.png");
	private static final Icon iconHealth = new ImageIcon(direction
			+ "/src/game/Images/Heiltrank1.png");
	private static final Icon iconRuestung = new ImageIcon(direction
			+ "/src/game/Images/Ruestung1.png");

	private static final int RASEN = 0;
	private static final int GRENZE = 1;
	private static final int PUDEL = 2;
	private static final int GEGNER = 3;
	private static final int WEITER = 4;
	private static final int BOSS = 5;
	private static final int ZURUECK = 6;
	private static final int CARLOS = 7;
	private static final int WAFFE = 8;
	private static final int GOLD = 9;
	private static final int MANA = 10;
	private static final int HEALTH = 11;
	private static final int RUESTUNG = 12;

	public int bewaffnet = 0;
	public int gold = 0;
	public int health = 100;
	public int ruestung = 0;
	public int mana = 0;

	Integer[][] Spielfeld;

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
				case RASEN:
					icon = iconRasen;
					break;
				case GRENZE:
					icon = iconBaum;
					break;
				case GEGNER:
					icon = iconGegner;
					break;
				case WEITER:
					icon = iconWeiter;
					break;
				case BOSS:
					icon = iconBoss;
					break;
				case ZURUECK:
					icon = iconZurueck;
					break;
				case CARLOS:
					icon = iconCarlos;
					break;
				case WAFFE:
					icon = iconWaffe;
					break;
				case GOLD:
					icon = iconGold;
					break;
				case MANA:
					icon = iconMana;
					break;
				case RUESTUNG:
					icon = iconRuestung;
					break;
				case HEALTH:
					icon = iconHealth;
					break;
				case PUDEL:
					icon = iconPudel;
					break;
				default:
					icon = iconPudel;
					break;

				}
				icon.paintIcon(this, g, i * size, j * size);

				/*
				 * getContentPane().removeAll(); getContentPane().add(Wald,
				 * BorderLayout.CENTER); getContentPane().add(Leiste,
				 * BorderLayout.SOUTH);
				 */
			}
		}
	}

	/** zeichnet das Spielfeld erneut */
	public void setzeSpielfeld(Integer[][] feld) {
		Spielfeld = feld;
		repaint();
	}
}
