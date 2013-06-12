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
	private int Gegnerx;
	private int Gegnery;

	public int bewaffnet = 0;
	public int gold = 0;
	public int health = 100;
	public int ruestung = 0;
	public int mana = 0;
	public int ko = 0;
	public int bosshealth = 300;
	

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
		Gegnerx = levelManager.getStartGegnerx();
		Gegnery = levelManager.getStartGegnery();
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
		int altGegx = Gegnerx;
		int altGegy = Gegnery;
		int locx = Spielfigurx;

		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			Spielfigurx--;
			Gegnerx++;
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			Spielfigurx++;
			Gegnerx--;
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			Spielfigury--;
			Gegnery++;
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			Spielfigury++;
			Gegnery--;
		}
			if (ko == 0){
				if (aktuellesSpielfeld[Gegnerx][Gegnery] == Konstanten.RASEN) {
					aktuellesSpielfeld[Gegnerx][Gegnery] = Konstanten.GEGNER;
					aktuellesSpielfeld[altGegx][altGegy] = Konstanten.RASEN;
					zeichner.zeichneSpielfeld(aktuellesSpielfeld);
				}
				else if (aktuellesSpielfeld[Gegnerx][Gegnery] == Konstanten.GRENZE) {
					aktuellesSpielfeld[Gegnerx][Gegnery] = Konstanten.GRENZE;
					aktuellesSpielfeld[altGegx][altGegy] = Konstanten.GEGNER;
					Gegnerx = altGegx;
					Gegnery = altGegy;
				}	
				else if (aktuellesSpielfeld[Gegnerx][Gegnery] == Konstanten.PUDEL) {
					aktuellesSpielfeld[Gegnerx][Gegnery] = Konstanten.PUDEL;
					aktuellesSpielfeld[altGegx][altGegy] = Konstanten.GEGNER;
					Gegnerx = altGegx;
					Gegnery = altGegy;
				}
				else if (aktuellesSpielfeld[Gegnerx][Gegnery] == Konstanten.BOSS) {
					aktuellesSpielfeld[Gegnerx][Gegnery] = Konstanten.BOSS;
					aktuellesSpielfeld[altGegx][altGegy] = Konstanten.GEGNER;
					Gegnerx = altGegx;
					Gegnery = altGegy;
				}
				else if (aktuellesSpielfeld[Gegnerx][Gegnery] == Konstanten.CUPCAKE) {
					aktuellesSpielfeld[Gegnerx][Gegnery] = Konstanten.CUPCAKE;
					aktuellesSpielfeld[altGegx][altGegy] = Konstanten.GEGNER;
					Gegnerx = altGegx;
					Gegnery = altGegy;
				}
				else if (ko != 0) {
					ko = 0;
				}
			}
		
		if (aktuellesSpielfeld[Spielfigurx][Spielfigury] == Konstanten.GEGNER) {
			health = health - 20;
			if (health + ruestung <= 0){
				Verloren();
			}
			else if (health + ruestung > 0){
				aktuellesSpielfeld[altx][alty] = Konstanten.PUDEL;
				aktuellesSpielfeld[Spielfigurx][Spielfigury] = Konstanten.GEGNER;
				Spielfigurx = altx;
				Spielfigury = alty;
			}
		} else if (aktuellesSpielfeld[Spielfigurx][Spielfigury] == Konstanten.WEITER) {
			levelManager.LevelWeiter();
			bosshealth = 300;
			getLevel();
			zeichner.zeichneSpielfeld(aktuellesSpielfeld);
		} else if (aktuellesSpielfeld[Spielfigurx][Spielfigury] == Konstanten.BOSS) {
				health = health - 34;
					if (health + ruestung <= 0){
						Verloren();
					}
					else if (health + ruestung > 0){
						aktuellesSpielfeld[altx][alty] = Konstanten.PUDEL;
						aktuellesSpielfeld[Spielfigurx][Spielfigury] = Konstanten.BOSS;
						Spielfigurx = altx;
						Spielfigury = alty;
					}
		} else if (aktuellesSpielfeld[Spielfigurx][Spielfigury] == Konstanten.ZURUECK) {
			levelManager.LevelZurueck();
		} else if (aktuellesSpielfeld[Spielfigurx][Spielfigury] == Konstanten.CARLOS) {
			carlos = new Carlos();
			aktuellesSpielfeld[Spielfigurx][Spielfigury] = Konstanten.RASEN;
			aktuellesSpielfeld[altx][alty] = Konstanten.PUDEL;
			aktuellesSpielfeld[Spielfigurx][Spielfigury] = Konstanten.CARLOS;
			Spielfigurx = altx;
			Spielfigury = alty;
		} else if (aktuellesSpielfeld[Spielfigurx][Spielfigury] == Konstanten.CUPCAKE) {
			Gewonnen();
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
			ruestung = 50;
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
		} else if (aktuellesSpielfeld[Spielfigurx][Spielfigury] == Konstanten.GEGNERTOT) {;
			aktuellesSpielfeld[Spielfigurx][Spielfigury] = Konstanten.PUDEL;
			aktuellesSpielfeld[altx][alty] = Konstanten.RASEN;
			zeichner.zeichneSpielfeld(aktuellesSpielfeld);
		} else if (aktuellesSpielfeld[Spielfigurx][Spielfigury] == Konstanten.RASEN) {
			aktuellesSpielfeld[Spielfigurx][Spielfigury] = Konstanten.PUDEL;
			aktuellesSpielfeld[altx][alty] = Konstanten.RASEN;
			zeichner.zeichneSpielfeld(aktuellesSpielfeld);
		}
		
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			if (bewaffnet == 0){
				// nothing to do here
			}
			else if (bewaffnet == 1){
				locx++;
				while (aktuellesSpielfeld[locx][Spielfigury] != Konstanten.GRENZE){
					if (aktuellesSpielfeld[locx][Spielfigury] == Konstanten.RASEN) {
						aktuellesSpielfeld[locx][Spielfigury] = Konstanten.LASER;
						zeichner.zeichneSpielfeld(aktuellesSpielfeld);
						locx++;
						}
					else if (aktuellesSpielfeld[locx][Spielfigury] == Konstanten.GEGNER) {
						aktuellesSpielfeld[locx][Spielfigury] = Konstanten.GEGNERTOT;
						zeichner.zeichneSpielfeld(aktuellesSpielfeld);
						ko = 1;
						break;
					}
					else if (aktuellesSpielfeld[locx][Spielfigury] == Konstanten.BOSS){
						bosshealth = bosshealth - 100;
							if (bosshealth <= 0){
								aktuellesSpielfeld[locx][Spielfigury] = Konstanten.RASEN;
								zeichner.zeichneSpielfeld(aktuellesSpielfeld);
								break;
							}
							else if (bosshealth > 0){							}
							aktuellesSpielfeld[locx][Spielfigury] = Konstanten.BOSS;
							break;
							}
					else 
						break;
				
				} 
				
				locx = Spielfigurx;
				locx++;
				
				while (aktuellesSpielfeld[locx][Spielfigury] == Konstanten.LASER){
							aktuellesSpielfeld[locx][Spielfigury] = Konstanten.RASEN;
							zeichner.zeichneSpielfeld(aktuellesSpielfeld);
							locx++;
					}
				}
	}
		if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
			if (mana == 0){
				// nothing to do here
			}
			else if (mana == 1) {
				bewaffnet = 1;
				health = 200;
			}
		}
		
	}


	public void keyReleased(KeyEvent e) {
		// nothing to do here
	}

	public void keyTyped(KeyEvent e) {
		// nothing to do here
	}
}