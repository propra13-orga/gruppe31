package game;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * GameFrame erzeugt das Menufenster. Den Werten im Array werden die
 * entsprechenden Bilder zugeordnet. Der KeyListener fragt die Werte der
 * umliegenden Felder ab und führt das Programm entsprechend weiter.
 */
public class GameFrame extends JFrame implements KeyListener {

	private static final String direction = System.getProperty("user.dir");

	/* Platzhalter für Marcel */

	private static final Icon iconAnzeige = new ImageIcon(direction
			+ "/src/game/Images/Anzeige.jpg");

	private JLabel Anzeige = new JLabel(iconAnzeige);

	private Panel Leiste = new Panel();

	private JButton GVschliessen;

	/* Variabeln für die neue und alte Position der Spielfigur */
	private int Spielfigurx;
	private int altx;
	private int Spielfigury;
	private int alty;

	private LevelManager levelManager;
	
	private Zeichner zeichner;
	private Carlos carlos;
	
	private Integer aktuellesSpielfeld[][] = new Integer[16][12];

	/**
	 * Konstruktor, der die Eigenschaften des Spielfensters festsetzt und die
	 * beiden Bereiche des Fensters setzt
	 * 
	 * @throws Exception
	 */
	public GameFrame() throws Exception {
		this.setResizable(true);
		this.setTitle("Erna's Adventure");
		this.setSize(810, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		zeichner = new Zeichner();
		this.add(zeichner);
		
		this.setVisible(true);

		levelManager = new LevelManager();
		levelManager.init();
		
		levelManager.kopiereAktuellesLevel(aktuellesSpielfeld);
		
		zeichner.setzeSpielfeld(aktuellesSpielfeld);

		setzeAnzeige();

		getContentPane().add(Leiste, BorderLayout.SOUTH);
	}

	/* hier arbeitet Marcel */
	public void setzeAnzeige() {
		Leiste.add(Anzeige);
	}

	/**
	 * hier wird die Grafik des Spielfensters erneut aufgerufen
	 */
	protected void LevelAktualisieren() {
		validate();
		repaint();
	}

	/**
	 * hier wird das Spielfenster verändert und ein einziges Bild daraufgesetzt,
	 * welches den Spielausgang anzeigt
	 * 
	 * Argumentübergabe fehlt noch
	 */
	public void Spielausgang() {

		getContentPane().removeAll();

		try {
			this.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File(
					direction + "/src/game/Images/GameOver.jpg")))));
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
	 * der KeyListener reagiert, während die Taste gedrückt wird und führt das
	 * Programm entsprechend weiter
	 */
	public void keyPressed(KeyEvent e) {
		/*if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			Spielfigurx--;
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			Spielfigurx++;
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			Spielfigury--;
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			Spielfigury++;
		}

		if (aktuellesSpielfeld[Spielfigurx][Spielfigury] == GEGNER) {
			getContentPane().removeAll();
			Spielausgang();
		} else if (aktuellesSpielfeld[Spielfigurx][Spielfigury] == WEITER) {
			levelManager.kopiereAktuellesLevel(aktuellesSpielfeld);
		} else if (aktuellesSpielfeld[Spielfigurx][Spielfigury] == BOSS) {
			getContentPane().removeAll();
			Spielausgang();
		} else if (aktuellesSpielfeld[Spielfigurx][Spielfigury] == ZURUECK) {
			LastLevel();
		} else if (aktuellesSpielfeld[Spielfigurx][Spielfigury] == CARLOS) {
			carlos = new Carlos();
		} else if (aktuellesSpielfeld[Spielfigurx][Spielfigury] == GOLD) {
			gold = gold + 100;
			aktuellesSpielfeld[Spielfigurx][Spielfigury] = PUDEL;
			aktuellesSpielfeld[altx][alty] = RASEN;
		} else if (aktuellesSpielfeld[Spielfigurx][Spielfigury] == MANA) {
			mana = mana + 10;
			aktuellesSpielfeld[Spielfigurx][Spielfigury] = PUDEL;
			aktuellesSpielfeld[altx][alty] = RASEN;
		} else if (aktuellesSpielfeld[Spielfigurx][Spielfigury] == RUESTUNG) {
			ruestung = ruestung + 50;
			aktuellesSpielfeld[Spielfigurx][Spielfigury] = PUDEL;
			aktuellesSpielfeld[altx][alty] = RASEN;
		} else if (aktuellesSpielfeld[Spielfigurx][Spielfigury] == HEALTH) {
			health = 100;
			aktuellesSpielfeld[Spielfigurx][Spielfigury] = PUDEL;
			aktuellesSpielfeld[altx][alty] = RASEN;
		} else if (aktuellesSpielfeld[Spielfigurx][Spielfigury] == WAFFE) {
			bewaffnet = 1;
			aktuellesSpielfeld[Spielfigurx][Spielfigury] = PUDEL;
			aktuellesSpielfeld[altx][alty] = RASEN;
			Levelaufruf(aktuellesSpielfeld);
			LevelAktualisieren();
		} else if (aktuellesSpielfeld[Spielfigurx][Spielfigury] == RASEN) {
			aktuellesSpielfeld[Spielfigurx][Spielfigury] = PUDEL;
			aktuellesSpielfeld[altx][alty] = RASEN;
			Levelaufruf(aktuellesSpielfeld);
			LevelAktualisieren();
		}*/
	}

	public void keyReleased(KeyEvent e) {
		// nothing to do here
	}

	public void keyTyped(KeyEvent e) {
		// nothing to do here
	}

}