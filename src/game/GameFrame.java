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

	private static final Icon iconEins = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/1.png");
	private static final Icon iconZwei = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/2.png");
	private static final Icon iconDrei = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/3.png");

	private static final Icon iconLebenVoll = new ImageIcon(
			Konstanten.direction + "/src/game/Images/Lebenvoll.png");
	private static final Icon iconLebenFast = new ImageIcon(
			Konstanten.direction + "/src/game/Images/Lebenfast.png");
	private static final Icon iconLebenHalb = new ImageIcon(
			Konstanten.direction + "/src/game/Images/Lebenhalb.png");
	private static final Icon iconLebenWenig = new ImageIcon(
			Konstanten.direction + "/src/game/Images/Lebenwenig.png");

	private static final Icon iconManaVoll = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Manavoll.png");
	private static final Icon iconManaHalb = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Manahalb.png");
	private static final Icon iconManaLeer = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Manaleer.png");

	private static final Icon iconRuestungVoll = new ImageIcon(
			Konstanten.direction + "/src/game/Images/Ruestungvoll.png");
	private static final Icon iconRuestungHalb = new ImageIcon(
			Konstanten.direction + "/src/game/Images/Ruestunghalb.png");
	private static final Icon iconRuestungWeg = new ImageIcon(
			Konstanten.direction + "/src/game/Images/Ruestungweg.png");

	private static final Icon icon0Gold = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Gold0.png");
	private static final Icon icon50Gold = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Gold50.png");
	private static final Icon icon100Gold = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Gold100.png");
	private static final Icon icon150Gold = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Gold150.png");
	private static final Icon icon200Gold = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Gold200.png");
	private static final Icon icon250Gold = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Gold250.png");
	private static final Icon icon300Gold = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Gold300.png");
	private static final Icon icon350Gold = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Gold350.png");

	private static final Icon iconKeinEq = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/KeinEq.png");
	private static final Icon iconSchwert = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Schwert.png");
	private static final Icon iconHals = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Hals.png");
	private static final Icon iconBrille = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Brille.png");
	private static final Icon iconBrilleHals = new ImageIcon(
			Konstanten.direction + "/src/game/Images/BrilleHals.png");
	private static final Icon iconBrilleSchwert = new ImageIcon(
			Konstanten.direction + "/src/game/Images/BrilleShwert.png");
	private static final Icon iconSchwertHals = new ImageIcon(
			Konstanten.direction + "/src/game/Images/SchwertHals.png");
	private static final Icon iconAllesEq = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/AllesEq.png");

	private static final Icon iconHerz1 = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Herz1.png");
	private static final Icon iconHerz2 = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Herz2.png");
	private static final Icon iconHerz3 = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Herz3.png");

	private JLabel Eins = new JLabel(iconEins);
	private JLabel Zwei = new JLabel(iconZwei);
	private JLabel Drei = new JLabel(iconDrei);

	private JLabel LebenVoll = new JLabel(iconLebenVoll);
	private JLabel LebenFast = new JLabel(iconLebenFast);
	private JLabel LebenHalb = new JLabel(iconLebenHalb);
	private JLabel LebenWenig = new JLabel(iconLebenWenig);

	private JLabel ManaVoll = new JLabel(iconManaVoll);
	private JLabel ManaHalb = new JLabel(iconManaHalb);
	private JLabel ManaLeer = new JLabel(iconManaLeer);

	private JLabel RuestungVoll = new JLabel(iconRuestungVoll);
	private JLabel RuestungHalb = new JLabel(iconRuestungHalb);
	private JLabel RuestungWeg = new JLabel(iconRuestungWeg);

	private JLabel Gold0 = new JLabel(icon0Gold);
	private JLabel Gold50 = new JLabel(icon50Gold);
	private JLabel Gold100 = new JLabel(icon100Gold);
	private JLabel Gold150 = new JLabel(icon150Gold);
	private JLabel Gold200 = new JLabel(icon200Gold);
	private JLabel Gold250 = new JLabel(icon250Gold);
	private JLabel Gold300 = new JLabel(icon300Gold);
	private JLabel Gold350 = new JLabel(icon350Gold);

	private JLabel KeinEq = new JLabel(iconKeinEq);
	private JLabel Schwert = new JLabel(iconSchwert);
	private JLabel Brille = new JLabel(iconBrille);
	private JLabel Hals = new JLabel(iconHals);
	private JLabel SchwertHals = new JLabel(iconSchwertHals);
	private JLabel BrilleSchwert = new JLabel(iconBrilleSchwert);
	private JLabel BrilleHals = new JLabel(iconBrilleHals);
	private JLabel AllesEq = new JLabel(iconAllesEq);

	private JLabel Herz1 = new JLabel(iconHerz1);
	private JLabel Herz2 = new JLabel(iconHerz2);
	private JLabel Herz3 = new JLabel(iconHerz3);

	private Panel Leiste = new Panel();

	private JButton GVschliessen;

	private LevelManager levelManager;
	private GameFrame gameFrame;
	private Carlos carlos;
	private Zeichner zeichner;
	private Shop shop;

	private Integer aktuellesSpielfeld[][] = new Integer[16][12];
	public Integer CheckSpielfeld[][] = new Integer[16][12];

	private int Spielfigurx;
	private int Spielfigury;
	private int Gegnerx;
	private int Gegnery;
	private int checkx;
	private int checky;
	private int level;

	public int bewaffnet = 0;
	public int gold = 0;
	public int health = 100;
	public int ruestung = 0;
	public int mana = 0;
	public int ko = 0;
	public int bosshealth = 300;
	public int leben = 3;
	public int save = 0;

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

	/** aktualisiert die Darstellung */
	public void Aktualisieren() {
		validate();
		repaint();
	}

	/** setzt die Anzeige mit all den Informationen */
	public void setzeAnzeige() {
		Leiste.removeAll();

		/* für die Levelanzeige */
		if (level == 0) {
			Leiste.add(Eins);
		} else if (level == 1) {
			Leiste.add(Eins);
		} else if (level == 2) {
			Leiste.add(Eins);
		} else if (level == 3) {
			Leiste.add(Zwei);
		} else if (level == 4) {
			Leiste.add(Zwei);
		} else if (level == 5) {
			Leiste.add(Zwei);
		} else if (level == 6) {
			Leiste.add(Drei);
		} else if (level == 7) {
			Leiste.add(Drei);
		} else if (level == 8) {
			Leiste.add(Drei);
		}

		/* für die Healthanzeige */
		if (health == 100) {
			Leiste.add(LebenVoll);
		} else if (health == 75) {
			Leiste.add(LebenFast);
		} else if (health == 50) {
			Leiste.add(LebenHalb);
		} else if (health == 25) {
			Leiste.add(LebenWenig);
		}

		Leiste.add(ManaVoll);
		Leiste.add(RuestungVoll);

		/* für die Goldanzeige */
		if (gold == 0) {
			Leiste.add(Gold0);
		} else if (gold == 50) {
			Leiste.add(Gold50);
		} else if (gold == 100) {
			Leiste.add(Gold100);
		} else if (gold == 150) {
			Leiste.add(Gold150);
		} else if (gold == 200) {
			Leiste.add(Gold200);
		} else if (gold == 250) {
			Leiste.add(Gold250);
		} else if (gold == 300) {
			Leiste.add(Gold300);
		} else if (gold == 350) {
			Leiste.add(Gold350);
		}

		if (bewaffnet == 0) {
			Leiste.add(KeinEq);
		} else if (bewaffnet == 1) {
			Leiste.add(Brille);
		}
		

		/* für die Lebenanzeige */
		if (leben == 3) {
			Leiste.add(Herz3);
		} else if (leben == 2) {
			Leiste.add(Herz2);
		} else if (leben == 1) {
			Leiste.add(Herz1);
		}

		Aktualisieren();
	}

	/**
	 * das aktuelle Spielfeld wird kopiert und die Position der Spielfigur wird
	 * festgehalten
	 */
	public void getLevel() {
		levelManager.kopiereAktuellesLevel(aktuellesSpielfeld);
		Spielfigurx = levelManager.getStartx();
		Spielfigury = levelManager.getStarty();
		Gegnerx = levelManager.getStartGegnerx();
		Gegnery = levelManager.getStartGegnery();
		level = levelManager.getlevel();
	}

	/**
	 * hier wird ein neues Fenster mit dem Spielausgang Gewonnen aufgerufen
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

	/** hier wird geprüft, ob ein Checkpoint überlaufen wurde */
	public void Checkpoint() {
		if (save == 1) {
			if (leben > 0) {
				health = 100;
				Spielfigurx = checkx;
				Spielfigury = checky;
				zeichner.zeichneSpielfeld(CheckSpielfeld);
				setzeAnzeige();
			} else if (leben <= 0) {
				Verloren();
			}
		} else if (save == 0) {
			Verloren();
		}
	}

	/**
	 * hier wird ein neues Fenster mit dem Spielausgang Verloren aufgerufen
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

		/* Abfragen für die Pfeiltasten */
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

		/* wenn Gegner ko = 0, dann führe die Gegnerbewegung aus */
		if (ko == 0) {

			if (aktuellesSpielfeld[Gegnerx][Gegnery] == Konstanten.RASEN) {
				aktuellesSpielfeld[Gegnerx][Gegnery] = Konstanten.GEGNER;
				aktuellesSpielfeld[altGegx][altGegy] = Konstanten.RASEN;
				zeichner.zeichneSpielfeld(aktuellesSpielfeld);
			} else if (aktuellesSpielfeld[Gegnerx][Gegnery] == Konstanten.GRENZE) {
				aktuellesSpielfeld[Gegnerx][Gegnery] = Konstanten.GRENZE;
				aktuellesSpielfeld[altGegx][altGegy] = Konstanten.GEGNER;
				Gegnerx = altGegx;
				Gegnery = altGegy;
			} else if (aktuellesSpielfeld[Gegnerx][Gegnery] == Konstanten.PUDEL) {
				aktuellesSpielfeld[Gegnerx][Gegnery] = Konstanten.PUDEL;
				aktuellesSpielfeld[altGegx][altGegy] = Konstanten.GEGNER;
				Gegnerx = altGegx;
				Gegnery = altGegy;
			} else if (aktuellesSpielfeld[Gegnerx][Gegnery] == Konstanten.BOSS1) {
				aktuellesSpielfeld[Gegnerx][Gegnery] = Konstanten.BOSS1;
				aktuellesSpielfeld[altGegx][altGegy] = Konstanten.GEGNER;
				Gegnerx = altGegx;
				Gegnery = altGegy;
			} else if (aktuellesSpielfeld[Gegnerx][Gegnery] == Konstanten.BOSS2) {
				aktuellesSpielfeld[Gegnerx][Gegnery] = Konstanten.BOSS2;
				aktuellesSpielfeld[altGegx][altGegy] = Konstanten.GEGNER;
				Gegnerx = altGegx;
				Gegnery = altGegy;
			} else if (aktuellesSpielfeld[Gegnerx][Gegnery] == Konstanten.BOSS3) {
				aktuellesSpielfeld[Gegnerx][Gegnery] = Konstanten.BOSS3;
				aktuellesSpielfeld[altGegx][altGegy] = Konstanten.GEGNER;
				Gegnerx = altGegx;
				Gegnery = altGegy;
			} else if (aktuellesSpielfeld[Gegnerx][Gegnery] == Konstanten.CUPCAKE) {
				aktuellesSpielfeld[Gegnerx][Gegnery] = Konstanten.CUPCAKE;
				aktuellesSpielfeld[altGegx][altGegy] = Konstanten.GEGNER;
				Gegnerx = altGegx;
				Gegnery = altGegy;
			} else if (aktuellesSpielfeld[Gegnerx][Gegnery] == Konstanten.ZURUECK) {
				aktuellesSpielfeld[Gegnerx][Gegnery] = Konstanten.ZURUECK;
				aktuellesSpielfeld[altGegx][altGegy] = Konstanten.GEGNER;
				Gegnerx = altGegx;
				Gegnery = altGegy;
			} else if (aktuellesSpielfeld[Gegnerx][Gegnery] == Konstanten.GOLD) {
				aktuellesSpielfeld[Gegnerx][Gegnery] = Konstanten.GOLD;
				aktuellesSpielfeld[altGegx][altGegy] = Konstanten.GEGNER;
				Gegnerx = altGegx;
				Gegnery = altGegy;
			}
			/* wenn Gegner ko ungleich 0, tue nichts */
		} else if (ko != 0) {
			// nothing to do here
		}

		/* Abfragen für ich laufe auf GEGNER */
		if (aktuellesSpielfeld[Spielfigurx][Spielfigury] == Konstanten.GEGNER) {
			/* zieht mir health ab */
			health = health - 25;
			/* wenn meine health+rüstung <= 0 rufe Checkpoint auf */
			if (health + ruestung <= 0) {
				aktuellesSpielfeld[altx][alty] = Konstanten.RASEN;
				aktuellesSpielfeld[checkx][checky] = Konstanten.PUDEL;
				leben = leben - 1;
				Checkpoint();
				/* ansonsten bleibt die Spielfigur (verletzt) auf seinem Feld */
			} else if (health + ruestung > 0) {
				aktuellesSpielfeld[altx][alty] = Konstanten.PUDEL;
				aktuellesSpielfeld[Spielfigurx][Spielfigury] = Konstanten.GEGNER;
				Spielfigurx = altx;
				Spielfigury = alty;

			}
		}

		/* Abfrage für ich laufe auf FALLE */
		else if (aktuellesSpielfeld[Spielfigurx][Spielfigury] == Konstanten.FALLE) {
			Verloren();

			/* Abfrage für ich laufe auf WEITER */
		} else if (aktuellesSpielfeld[Spielfigurx][Spielfigury] == Konstanten.WEITER) {
			levelManager.LevelWeiter();
			bosshealth = 300;
			ko = 0;
			getLevel();
			zeichner.zeichneSpielfeld(aktuellesSpielfeld);

			/* Abfrage für ich laufe auf BOSS1 */
		} else if (aktuellesSpielfeld[Spielfigurx][Spielfigury] == Konstanten.BOSS1) {
			health = health - 25;
			if (health + ruestung <= 0) {
				leben = leben - 1;
				aktuellesSpielfeld[altx][alty] = Konstanten.RASEN;
				aktuellesSpielfeld[checkx][checky] = Konstanten.PUDEL;
				Checkpoint();
			} else if (health + ruestung > 0) {
				aktuellesSpielfeld[altx][alty] = Konstanten.PUDEL;
				aktuellesSpielfeld[Spielfigurx][Spielfigury] = Konstanten.BOSS1;
				Spielfigurx = altx;
				Spielfigury = alty;
			}

			/* Abfrage für ich laufe gegen BOSS2 */
		} else if (aktuellesSpielfeld[Spielfigurx][Spielfigury] == Konstanten.BOSS2) {
			health = health - 50;
			if (health + ruestung <= 0) {
				leben = leben - 1;
				aktuellesSpielfeld[altx][alty] = Konstanten.RASEN;
				aktuellesSpielfeld[checkx][checky] = Konstanten.PUDEL;
				Checkpoint();
			} else if (health + ruestung > 0) {
				aktuellesSpielfeld[altx][alty] = Konstanten.PUDEL;
				aktuellesSpielfeld[Spielfigurx][Spielfigury] = Konstanten.BOSS2;
				Spielfigurx = altx;
				Spielfigury = alty;
			}

			/* Abfrage für ich laufe gegen BOSS3 */
		} else if (aktuellesSpielfeld[Spielfigurx][Spielfigury] == Konstanten.BOSS3) {
			health = health - 100;
			if (health + ruestung <= 0) {
				leben = leben - 1;
				aktuellesSpielfeld[altx][alty] = Konstanten.RASEN;
				aktuellesSpielfeld[checkx][checky] = Konstanten.PUDEL;
				Checkpoint();
			} else if (health + ruestung > 0) {
				aktuellesSpielfeld[altx][alty] = Konstanten.PUDEL;
				aktuellesSpielfeld[Spielfigurx][Spielfigury] = Konstanten.BOSS3;
				Spielfigurx = altx;
				Spielfigury = alty;
			}

			/* Abfrage für ich laufe auf ZURUECK */
		} else if (aktuellesSpielfeld[Spielfigurx][Spielfigury] == Konstanten.ZURUECK) {
			aktuellesSpielfeld[Spielfigurx][Spielfigury] = Konstanten.ZURUECK;
			aktuellesSpielfeld[altx][alty] = Konstanten.PUDEL;
			Spielfigurx = altx;
			Spielfigury = alty;

			/* Abfrage für ich laufe gegen CARLOS */
		} else if (aktuellesSpielfeld[Spielfigurx][Spielfigury] == Konstanten.CARLOS) {
			carlos = new Carlos();
			aktuellesSpielfeld[altx][alty] = Konstanten.PUDEL;
			aktuellesSpielfeld[Spielfigurx][Spielfigury] = Konstanten.CARLOS;
			Spielfigurx = altx;
			Spielfigury = alty;

			/* Abfrage für ich laufe gegen HUETTE */
		} else if (aktuellesSpielfeld[Spielfigurx][Spielfigury] == Konstanten.HUETTE) {
			shop = new Shop();
			aktuellesSpielfeld[Spielfigurx][Spielfigury] = Konstanten.RASEN;
			aktuellesSpielfeld[altx][alty] = Konstanten.PUDEL;
			aktuellesSpielfeld[Spielfigurx][Spielfigury] = Konstanten.HUETTE;
			Spielfigurx = altx;
			Spielfigury = alty;

			/* Abfrage für ich laufe gegen CUPCAKE */
		} else if (aktuellesSpielfeld[Spielfigurx][Spielfigury] == Konstanten.CUPCAKE) {
			Gewonnen();

			/* Abfrage für ich laufe gegen GRENZE */
		} else if (aktuellesSpielfeld[Spielfigurx][Spielfigury] == Konstanten.GRENZE) {
			aktuellesSpielfeld[altx][alty] = Konstanten.PUDEL;
			aktuellesSpielfeld[Spielfigurx][Spielfigury] = Konstanten.GRENZE;
			Spielfigurx = altx;
			Spielfigury = alty;

			/* ABfrage für ich laufe auf GOLD */
		} else if (aktuellesSpielfeld[Spielfigurx][Spielfigury] == Konstanten.GOLD) {
			gold = gold + 50;
			aktuellesSpielfeld[Spielfigurx][Spielfigury] = Konstanten.PUDEL;
			aktuellesSpielfeld[altx][alty] = Konstanten.RASEN;
			zeichner.zeichneSpielfeld(aktuellesSpielfeld);

			/* Abfrage für ich laufe auf MANA */
		} else if (aktuellesSpielfeld[Spielfigurx][Spielfigury] == Konstanten.MANA) {
			mana = 50;
			aktuellesSpielfeld[Spielfigurx][Spielfigury] = Konstanten.PUDEL;
			aktuellesSpielfeld[altx][alty] = Konstanten.RASEN;
			zeichner.zeichneSpielfeld(aktuellesSpielfeld);

			/* Abfrage für ich laufe auf RUESTUNG */
		} else if (aktuellesSpielfeld[Spielfigurx][Spielfigury] == Konstanten.RUESTUNG) {
			ruestung = 50;
			aktuellesSpielfeld[Spielfigurx][Spielfigury] = Konstanten.PUDEL;
			aktuellesSpielfeld[altx][alty] = Konstanten.RASEN;
			zeichner.zeichneSpielfeld(aktuellesSpielfeld);

			/* Abfrage für ich laufe auf HEALTH */
		} else if (aktuellesSpielfeld[Spielfigurx][Spielfigury] == Konstanten.HEALTH) {
			health = 100;
			setzeAnzeige();
			aktuellesSpielfeld[Spielfigurx][Spielfigury] = Konstanten.PUDEL;
			aktuellesSpielfeld[altx][alty] = Konstanten.RASEN;
			zeichner.zeichneSpielfeld(aktuellesSpielfeld);

			/* Abfrage für ich laufe auf WAFFE */
		} else if (aktuellesSpielfeld[Spielfigurx][Spielfigury] == Konstanten.WAFFE) {
			bewaffnet = 1;
			setzeAnzeige();
			aktuellesSpielfeld[Spielfigurx][Spielfigury] = Konstanten.PUDEL;
			aktuellesSpielfeld[altx][alty] = Konstanten.RASEN;
			zeichner.zeichneSpielfeld(aktuellesSpielfeld);

			/* Abfrage für ich laufe auf GEGNERTOT */
		} else if (aktuellesSpielfeld[Spielfigurx][Spielfigury] == Konstanten.GEGNERTOT) {
			aktuellesSpielfeld[Spielfigurx][Spielfigury] = Konstanten.PUDEL;
			aktuellesSpielfeld[altx][alty] = Konstanten.RASEN;
			zeichner.zeichneSpielfeld(aktuellesSpielfeld);

			/* Abfrage für ich laufe auf RASEN = normale Bewegung */
		} else if (aktuellesSpielfeld[Spielfigurx][Spielfigury] == Konstanten.RASEN) {
			aktuellesSpielfeld[Spielfigurx][Spielfigury] = Konstanten.PUDEL;
			aktuellesSpielfeld[altx][alty] = Konstanten.RASEN;
			zeichner.zeichneSpielfeld(aktuellesSpielfeld);

			/* Abfrage für ich laufe auf CHECKPOINT */
		} else if (aktuellesSpielfeld[Spielfigurx][Spielfigury] == Konstanten.CHECKPOINT) {
			aktuellesSpielfeld[Spielfigurx][Spielfigury] = Konstanten.PUDEL;
			aktuellesSpielfeld[altx][alty] = Konstanten.RASEN;
			CheckSpielfeld = aktuellesSpielfeld;
			checkx = Spielfigurx;
			checky = Spielfigury;
			save = 1;
			zeichner.zeichneSpielfeld(aktuellesSpielfeld);
		}

		/* Abfragen für die Leertaste */
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			/* wenn Erna nicht bewaffnet, dann kein Ereignis */
			if (bewaffnet == 0) {
				// nothing to do here

				/* wenn Erna bewaffnet */
			} else if (bewaffnet == 1) {
				/* in Richtung des Schusses einen hochzählen */
				locx++;
				/* solange wie man nicht auf GRENZE trifft */
				while (aktuellesSpielfeld[locx][Spielfigury] != Konstanten.GRENZE) {
					/* wenn dort RASEN setze Laserbild und zähle hoch */
					if (aktuellesSpielfeld[locx][Spielfigury] == Konstanten.RASEN) {
						aktuellesSpielfeld[locx][Spielfigury] = Konstanten.LASER;
						zeichner.zeichneSpielfeld(aktuellesSpielfeld);
						locx++;
						/* Verzögerung der Anzeige um 300 Millisekunden */
						try {
							Thread.sleep(300);
						} catch (InterruptedException hj) {
							hj.printStackTrace();
						}

						/* wenn dort GEGNER setze GEGNERTOT und unbeweglich */
					} else if (aktuellesSpielfeld[locx][Spielfigury] == Konstanten.GEGNER) {
						aktuellesSpielfeld[locx][Spielfigury] = Konstanten.GEGNERTOT;
						zeichner.zeichneSpielfeld(aktuellesSpielfeld);
						ko = 1;
						break;

						/* wenn dort BOSS1 ziehe bosshealth ab */
					} else if (aktuellesSpielfeld[locx][Spielfigury] == Konstanten.BOSS1) {
						bosshealth = bosshealth - 100;
						/* wenn bosshealth erschöpft, setze dort RASEN */
						if (bosshealth <= 0) {
							aktuellesSpielfeld[locx][Spielfigury] = Konstanten.RASEN;
							zeichner.zeichneSpielfeld(aktuellesSpielfeld);
							break;
						} else if (bosshealth > 0) {
							aktuellesSpielfeld[locx][Spielfigury] = Konstanten.BOSS1;
							break;
						}

					} else if (aktuellesSpielfeld[locx][Spielfigury] == Konstanten.BOSS2) {
						bosshealth = bosshealth - 100;
						if (bosshealth <= 0) {
							aktuellesSpielfeld[locx][Spielfigury] = Konstanten.RASEN;
							zeichner.zeichneSpielfeld(aktuellesSpielfeld);
							break;
						} else if (bosshealth > 0) {
							aktuellesSpielfeld[locx][Spielfigury] = Konstanten.BOSS2;
							break;
						}

					} else if (aktuellesSpielfeld[locx][Spielfigury] == Konstanten.BOSS3) {
						bosshealth = bosshealth - 100;
						if (bosshealth <= 0) {
							aktuellesSpielfeld[locx][Spielfigury] = Konstanten.RASEN;
							zeichner.zeichneSpielfeld(aktuellesSpielfeld);
							break;
						} else if (bosshealth > 0) {
							aktuellesSpielfeld[locx][Spielfigury] = Konstanten.BOSS3;
							break;
						}

					} else
						break;
				}

				/* anschließend wird die Schussanzeige zurück gesetzt */
				locx = Spielfigurx;
				locx++;

				while (aktuellesSpielfeld[locx][Spielfigury] == Konstanten.LASER) {
					aktuellesSpielfeld[locx][Spielfigury] = Konstanten.RASEN;
					zeichner.zeichneSpielfeld(aktuellesSpielfeld);
					locx++;
					try {
						Thread.sleep(300);
					} catch (InterruptedException hj) {
						hj.printStackTrace();
					}
				}
			}
		}

		/* Abfragen für die Steuerungstaste */
		if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
			if (mana == 0) {
				// nothing to do here

				/* wenn mana = 1, gib Erna ihre RayBan und pflege sie gesund */
			} else if (mana == 1) {
				bewaffnet = 1;
				health = 200;
			}
		}
		setzeAnzeige();
	}

	public void keyReleased(KeyEvent e) {
		// nothing to do here
	}

	public void keyTyped(KeyEvent e) {
		// nothing to do here
	}
}