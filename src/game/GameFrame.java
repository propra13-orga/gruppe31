package game;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * GameFrame erzeugt das Spielfenster. Der KeyListener fragt die Werte der
 * umliegenden Felder ab und führt das Programm entsprechend weiter.
 */
public class GameFrame extends JFrame implements KeyListener {

	/* Platzhalter für Marcel */

	private static final Icon iconAnzeige = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Anzeige.jpg");

	private JLabel Anzeige = new JLabel(iconAnzeige);

	private Panel Leiste = new Panel();

	private JButton GVschliessen;

	private LevelManager levelManager;
	private GameFrame gameFrame;
	private Carlos carlos;
	private Zeichner zeichner;

	private Integer aktuellesSpielfeld[][] = new Integer[16][12];

	private int Spielfigurx;
	private int Spielfigury;

	public int bewaffnet = 0;
	public int gold = 0;
	public int health = 100;
	public int ruestung = 0;
	public int mana = 0;

	/**
	 * Konstruktor, der die Eigenschaften des Spielfensters festsetzt. der
	 * Zeichner wird auf das Spielfenster gesetzt und der LevelManager wird
	 * aufgerufen. Das nächste (hier: erste) Level wird aufgerufen und der
	 * Zeichner zeichnet das entsprechende Spielfeld
	 * 
	 * @throws Exception
	 */
	public GameFrame() throws Exception {
		this.setResizable(true);
		this.setTitle("Erna's Adventure");
		this.setSize(810, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setFocusable(true);
		this.addKeyListener(this);

		zeichner = new Zeichner();
		this.add(zeichner);

		this.setVisible(true);

		levelManager = new LevelManager();
		levelManager.init();

		getLevel();

		zeichner.zeichneSpielfeld(aktuellesSpielfeld);

		setzeAnzeige();

		getContentPane().add(Leiste, BorderLayout.SOUTH);

		this.requestFocus();
	}

	/* hier arbeitet Marcel */
	public void setzeAnzeige() {
		Leiste.add(Anzeige);
	}

	/**
	 * das aktuelle Spielfeld wird kopiert und die Position der Spielfigur wird
	 * festgehalten
	 * 
	 * Möglichkeit für Valentin: Checkpoints
	 */
	public void getLevel() {
		levelManager.kopiereAktuellesLevel(aktuellesSpielfeld);
		Spielfigurx = levelManager.getStartx();
		Spielfigury = levelManager.getStarty();
	}

	/**
	 * durch den KeyListener ausgelöst, wird hier ein neues Fenster mit dem
	 * Spielausgang Gewonnen aufgerufen
	 */
	public void Gewonnen() {
		getContentPane().removeAll();

		try {
			this.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File(
					Konstanten.direction + "/src/game/Images/Gewonnen.jpg")))));
		} catch (IOException a) {
			System.out.println("das Bild kann nicht gefunden werden");
		}

		this.setResizable(false);
		this.setSize(800, 600);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

		GVschliessen = new JButton("Dieses Fenster schließen");
		GVschliessen.setBounds(550, 450, 200, 40);
		this.add(GVschliessen);

		ActionListener alschliessen = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		};
		GVschliessen.addActionListener(alschliessen);
	}

	/**
	 * durch den KeyListener ausgelöst, wird hier ein neues Fenster mit dem
	 * Spielausgang Verloren aufgerufen
	 */
	public void Verloren() {
		getContentPane().removeAll();

		try {
			this.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File(
					Konstanten.direction + "/src/game/Images/GameOver.jpg")))));
		} catch (IOException a) {
			System.out.println("das Bild kann nicht gefunden werden");
		}

		this.setResizable(false);
		this.setSize(800, 600);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

		GVschliessen = new JButton("Dieses Fenster schließen");
		GVschliessen.setBounds(550, 450, 200, 40);
		this.add(GVschliessen);

		ActionListener alschliessen = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		};
		GVschliessen.addActionListener(alschliessen);
	}

	/**
	 * der KeyListener reagiert, wenn eine Taste gedrückt wurde und führt das
	 * Programm entsprechend weiter
	 */
	public void keyPressed(KeyEvent e) {

		int altx = Spielfigurx;
		int alty = Spielfigury;

		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			Spielfigurx--;
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			Spielfigurx++;
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			Spielfigury--;
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			Spielfigury++;
		}

		if (aktuellesSpielfeld[Spielfigurx][Spielfigury] == Konstanten.GEGNER) {
			Verloren();
		} else if (aktuellesSpielfeld[Spielfigurx][Spielfigury] == Konstanten.WEITER) {
			levelManager.LevelWeiter();
			getLevel();
			zeichner.zeichneSpielfeld(aktuellesSpielfeld);
		} else if (aktuellesSpielfeld[Spielfigurx][Spielfigury] == Konstanten.BOSS) {
			Verloren();
			zeichner.zeichneSpielfeld(aktuellesSpielfeld);
		} else if (aktuellesSpielfeld[Spielfigurx][Spielfigury] == Konstanten.ZURUECK) {
			levelManager.LevelZurueck();
		} else if (aktuellesSpielfeld[Spielfigurx][Spielfigury] == Konstanten.CARLOS) {
			carlos = new Carlos();
			aktuellesSpielfeld[Spielfigurx][Spielfigury] = Konstanten.RASEN;
			aktuellesSpielfeld[altx][alty] = Konstanten.PUDEL;
			aktuellesSpielfeld[Spielfigurx][Spielfigury] = Konstanten.CARLOS;
			Spielfigurx = altx;
			Spielfigury = alty;
		} else if (aktuellesSpielfeld[Spielfigurx][Spielfigury] == Konstanten.GRENZE) {
			aktuellesSpielfeld[altx][alty] = Konstanten.PUDEL;
			aktuellesSpielfeld[Spielfigurx][Spielfigury] = Konstanten.GRENZE;
			Spielfigurx = altx;
			Spielfigury = alty;
		} else if (aktuellesSpielfeld[Spielfigurx][Spielfigury] == Konstanten.GOLD) {
			gold = gold + 100;
			aktuellesSpielfeld[Spielfigurx][Spielfigury] = Konstanten.PUDEL;
			aktuellesSpielfeld[altx][alty] = Konstanten.RASEN;
			zeichner.zeichneSpielfeld(aktuellesSpielfeld);
		} else if (aktuellesSpielfeld[Spielfigurx][Spielfigury] == Konstanten.MANA) {
			mana = mana + 10;
			aktuellesSpielfeld[Spielfigurx][Spielfigury] = Konstanten.PUDEL;
			aktuellesSpielfeld[altx][alty] = Konstanten.RASEN;
			zeichner.zeichneSpielfeld(aktuellesSpielfeld);
		} else if (aktuellesSpielfeld[Spielfigurx][Spielfigury] == Konstanten.RUESTUNG) {
			ruestung = ruestung + 50;
			aktuellesSpielfeld[Spielfigurx][Spielfigury] = Konstanten.PUDEL;
			aktuellesSpielfeld[altx][alty] = Konstanten.RASEN;
			zeichner.zeichneSpielfeld(aktuellesSpielfeld);
		} else if (aktuellesSpielfeld[Spielfigurx][Spielfigury] == Konstanten.HEALTH) {
			health = 100;
			aktuellesSpielfeld[Spielfigurx][Spielfigury] = Konstanten.PUDEL;
			aktuellesSpielfeld[altx][alty] = Konstanten.RASEN;
			zeichner.zeichneSpielfeld(aktuellesSpielfeld);
		} else if (aktuellesSpielfeld[Spielfigurx][Spielfigury] == Konstanten.WAFFE) {
			bewaffnet = 1;
			aktuellesSpielfeld[Spielfigurx][Spielfigury] = Konstanten.PUDEL;
			aktuellesSpielfeld[altx][alty] = Konstanten.RASEN;
			zeichner.zeichneSpielfeld(aktuellesSpielfeld);
		} else if (aktuellesSpielfeld[Spielfigurx][Spielfigury] == Konstanten.RASEN) {
			aktuellesSpielfeld[Spielfigurx][Spielfigury] = Konstanten.PUDEL;
			aktuellesSpielfeld[altx][alty] = Konstanten.RASEN;
			zeichner.zeichneSpielfeld(aktuellesSpielfeld);
		}
	}

	public void keyReleased(KeyEvent e) {
		// nothing to do here
	}

	public void keyTyped(KeyEvent e) {
		// nothing to do here
	}
}