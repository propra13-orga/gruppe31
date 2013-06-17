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
			Konstanten.direction + "/src/game/Images/BrilleSchwert.png");
	private static final Icon iconSchwertHals = new ImageIcon(
			Konstanten.direction + "/src/game/Images/SchwertHals.png");
	private static final Icon iconAllesEq = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Eqalles.png");

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
	private Panel Spielfeld = new Panel();

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
	public int beschwertet = 0;
	public int halsband = 0;

	public int gold = 0;
	public int health = 100;
	public int ruestung = 0;
	public int mana = 0;

	public int leben = 3;

	public int ko = 0;
	public int bosshealth = 100;
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
		this.setSize(900, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setFocusable(true);
		this.addKeyListener(this);

		zeichner = new Zeichner(this);
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

		/* für die Levelanzeige , set Bounds funktioniert nur bei Layout null */
		if (level == 0) {
			Eins.setBounds(-40, 590, 100, 100);
			Leiste.add(Eins);
		} else if (level == 1) {
			Eins.setBounds(-40, 590, 100, 100);
			Leiste.add(Eins);
		} else if (level == 2) {
			Eins.setBounds(-40, 590, 100, 100);
			Leiste.add(Eins);
		} else if (level == 3) {
			Zwei.setBounds(-40, 590, 100, 100);
			Leiste.add(Zwei);
		} else if (level == 4) {
			Zwei.setBounds(-40, 590, 100, 100);
			Leiste.add(Zwei);
		} else if (level == 5) {
			Zwei.setBounds(-40, 590, 100, 100);
			Leiste.add(Zwei);
		} else if (level == 6) {
			Drei.setBounds(-40, 590, 100, 100);
			Leiste.add(Drei);
		} else if (level == 7) {
			Drei.setBounds(-40, 590, 100, 100);
			Leiste.add(Drei);
		} else if (level == 8) {
			Drei.setBounds(-40, 590, 100, 100);
			Leiste.add(Drei);
		}
		Aktualisieren();

		/* für die Healthanzeige */
		if (health == 100) {
			LebenVoll.setBounds(23, 590, 150, 100);
			Leiste.add(LebenVoll);
		} else if (health == 75) {
			LebenFast.setBounds(23, 590, 150, 100);
			Leiste.add(LebenFast);
		} else if (health == 50) {
			LebenFast.setBounds(23, 590, 150, 100);
			Leiste.add(LebenHalb);
		} else if (health == 25) {
			LebenFast.setBounds(23, 590, 150, 100);
			Leiste.add(LebenWenig);
		}
		Aktualisieren();

		/* für die Manaanzeige */
		if (mana == 2) {
			ManaVoll.setBounds(170, 590, 150, 100);
			Leiste.add(ManaVoll);
		} else if (mana == 1) {
			ManaHalb.setBounds(170, 590, 150, 100);
			Leiste.add(ManaHalb);
		} else if (mana == 0) {
			ManaLeer.setBounds(170, 590, 150, 100);
			Leiste.add(ManaLeer);
		}

		if (ruestung == 50) {
			RuestungVoll.setBounds(320, 590, 150, 100);
			Leiste.add(RuestungVoll);
		} else if (ruestung == 25) {
			RuestungHalb.setBounds(320, 590, 150, 100);
			Leiste.add(RuestungHalb);
		} else if (ruestung == 0) {
			RuestungWeg.setBounds(320, 590, 150, 100);
			Leiste.add(RuestungWeg);
		}
		Aktualisieren();

		/* für die Goldanzeige */
		if (gold == 0) {
			Gold0.setBounds(470, 590, 100, 100);
			Leiste.add(Gold0);
		} else if (gold == 50) {
			Gold50.setBounds(470, 590, 100, 100);
			Leiste.add(Gold50);
		} else if (gold == 100) {
			Gold100.setBounds(470, 590, 100, 100);
			Leiste.add(Gold100);
		} else if (gold == 150) {
			Gold150.setBounds(470, 590, 100, 100);
			Leiste.add(Gold150);
		} else if (gold == 200) {
			Gold200.setBounds(470, 590, 100, 100);
			Leiste.add(Gold200);
		} else if (gold == 250) {
			Gold250.setBounds(470, 590, 100, 100);
			Leiste.add(Gold250);
		} else if (gold == 300) {
			Gold300.setBounds(470, 590, 100, 100);
			Leiste.add(Gold300);
		} else if (gold == 350) {
			Gold350.setBounds(470, 590, 100, 100);
			Leiste.add(Gold350);
		}
		Aktualisieren();

		if (bewaffnet == 0) {
			if (beschwertet == 0) {
				if (halsband == 0) {
					KeinEq.setBounds(570, 590, 125, 100);
					Leiste.add(KeinEq);
				} else if (halsband == 1) {
					Hals.setBounds(570, 590, 125, 100);
					Leiste.add(Hals);
				}
			} else if (beschwertet == 1) {
				if (halsband == 0) {
					Schwert.setBounds(570, 590, 125, 100);
					Leiste.add(Schwert);
				} else if (halsband == 1) {
					SchwertHals.setBounds(570, 590, 125, 100);
					Leiste.add(SchwertHals);
				}
			}
		} else if (bewaffnet == 1) {
			if (beschwertet == 0) {
				if (halsband == 0) {
					Brille.setBounds(570, 590, 125, 100);
					Leiste.add(Brille);
				} else if (halsband == 1) {
					BrilleHals.setBounds(570, 590, 125, 100);
					Leiste.add(BrilleHals);
				}
			} else if (beschwertet == 1) {
				if (halsband == 0) {
					BrilleSchwert.setBounds(570, 590, 125, 100);
					Leiste.add(BrilleSchwert);
				} else if (halsband == 1) {
					AllesEq.setBounds(570, 590, 125, 100);
					Leiste.add(AllesEq);
				}
			}
		}
		Aktualisieren();

		/* für die Lebenanzeige */
		if (leben == 3) {
			Herz3.setBounds(690, 590, 100, 100);
			Leiste.add(Herz3);
		} else if (leben == 2) {
			Herz2.setBounds(690, 590, 100, 100);
			Leiste.add(Herz2);
		} else if (leben == 1) {
			Herz1.setBounds(690, 590, 100, 100);
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

	/** gibt bewaffnet wieder */
	public int getBewaffnet() {
		return bewaffnet;
	}

	/** gibt beschwertet wieder */
	public int getBeschwertet() {
		return beschwertet;
	}

	/** gibt halsband wieder */
	public int getHalsband() {
		return halsband;
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
		int locy = Spielfigury;

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
			} else if (aktuellesSpielfeld[Gegnerx][Gegnery] == Konstanten.BOSS1v) {
				aktuellesSpielfeld[Gegnerx][Gegnery] = Konstanten.BOSS1v;
				aktuellesSpielfeld[altGegx][altGegy] = Konstanten.GEGNER;
				Gegnerx = altGegx;
				Gegnery = altGegy;
			} else if (aktuellesSpielfeld[Gegnerx][Gegnery] == Konstanten.BOSS2v) {
				aktuellesSpielfeld[Gegnerx][Gegnery] = Konstanten.BOSS2v;
				aktuellesSpielfeld[altGegx][altGegy] = Konstanten.GEGNER;
				Gegnerx = altGegx;
				Gegnery = altGegy;
			} else if (aktuellesSpielfeld[Gegnerx][Gegnery] == Konstanten.BOSS3v) {
				aktuellesSpielfeld[Gegnerx][Gegnery] = Konstanten.BOSS3v;
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
			} else if (aktuellesSpielfeld[Gegnerx][Gegnery] == Konstanten.HEALTH) {
				aktuellesSpielfeld[Gegnerx][Gegnery] = Konstanten.HEALTH;
				aktuellesSpielfeld[altGegx][altGegy] = Konstanten.GEGNER;
				Gegnerx = altGegx;
				Gegnery = altGegy;
			} else if (aktuellesSpielfeld[Gegnerx][Gegnery] == Konstanten.CARLOS) {
				aktuellesSpielfeld[Gegnerx][Gegnery] = Konstanten.CARLOS;
				aktuellesSpielfeld[altGegx][altGegy] = Konstanten.GEGNER;
				Gegnerx = altGegx;
				Gegnery = altGegy;
			} else if (aktuellesSpielfeld[Gegnerx][Gegnery] == Konstanten.HUETTE) {
				aktuellesSpielfeld[Gegnerx][Gegnery] = Konstanten.HUETTE;
				aktuellesSpielfeld[altGegx][altGegy] = Konstanten.GEGNER;
				Gegnerx = altGegx;
				Gegnery = altGegy;
			} else if (aktuellesSpielfeld[Gegnerx][Gegnery] == Konstanten.MANA) {
				aktuellesSpielfeld[Gegnerx][Gegnery] = Konstanten.MANA;
				aktuellesSpielfeld[altGegx][altGegy] = Konstanten.GEGNER;
				Gegnerx = altGegx;
				Gegnery = altGegy;
			} else if (aktuellesSpielfeld[Gegnerx][Gegnery] == Konstanten.SCHWERT) {
				aktuellesSpielfeld[Gegnerx][Gegnery] = Konstanten.SCHWERT;
				aktuellesSpielfeld[altGegx][altGegy] = Konstanten.GEGNER;
				Gegnerx = altGegx;
				Gegnery = altGegy;
			} else if (aktuellesSpielfeld[Gegnerx][Gegnery] == Konstanten.RUESTUNG) {
				aktuellesSpielfeld[Gegnerx][Gegnery] = Konstanten.RUESTUNG;
				aktuellesSpielfeld[altGegx][altGegy] = Konstanten.GEGNER;
				Gegnerx = altGegx;
				Gegnery = altGegy;
			} else if (aktuellesSpielfeld[Gegnerx][Gegnery] == Konstanten.CHECKPOINT) {
				aktuellesSpielfeld[Gegnerx][Gegnery] = Konstanten.CHECKPOINT;
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
			if (ruestung > 0) {
				ruestung = ruestung - 25;
				if (ruestung == 0) {
					halsband = 0;
				}
			} else if (ruestung == 0) {
				health = health - 25;
				halsband = 0;
			}
			/* wenn meine health <= 0 rufe Checkpoint auf */
			if (health <= 0) {
				aktuellesSpielfeld[altx][alty] = Konstanten.RASEN;
				aktuellesSpielfeld[checkx][checky] = Konstanten.PUDEL;
				leben = leben - 1;
				Checkpoint();
				/* ansonsten bleibt die Spielfigur (verletzt) auf seinem Feld */
			} else if (health > 0) {
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
			bosshealth = 100;
			ko = 0;
			save = 0;
			getLevel();
			zeichner.zeichneSpielfeld(aktuellesSpielfeld);

			/* Abfrage für ich laufe auf BOSS1 */
		} else if (aktuellesSpielfeld[Spielfigurx][Spielfigury] == Konstanten.BOSS1v) {
			if (ruestung > 0) {
				ruestung = ruestung - 25;
			} else if (ruestung == 0) {
				health = health - 25;
			}
			if (health + ruestung <= 0) {
				leben = leben - 1;
				aktuellesSpielfeld[altx][alty] = Konstanten.RASEN;
				aktuellesSpielfeld[checkx][checky] = Konstanten.PUDEL;
				Checkpoint();
			} else if (health + ruestung > 0) {
				aktuellesSpielfeld[altx][alty] = Konstanten.PUDEL;
				aktuellesSpielfeld[Spielfigurx][Spielfigury] = Konstanten.BOSS1v;
				Spielfigurx = altx;
				Spielfigury = alty;
			}
		} else if (aktuellesSpielfeld[Spielfigurx][Spielfigury] == Konstanten.BOSS1m) {
			if (ruestung > 0) {
				ruestung = ruestung - 25;
			} else if (ruestung == 0) {
				health = health - 25;
			}
			if (health + ruestung <= 0) {
				leben = leben - 1;
				aktuellesSpielfeld[altx][alty] = Konstanten.RASEN;
				aktuellesSpielfeld[checkx][checky] = Konstanten.PUDEL;
				Checkpoint();
			} else if (health + ruestung > 0) {
				aktuellesSpielfeld[altx][alty] = Konstanten.PUDEL;
				aktuellesSpielfeld[Spielfigurx][Spielfigury] = Konstanten.BOSS1m;
				Spielfigurx = altx;
				Spielfigury = alty;
			}
		} else if (aktuellesSpielfeld[Spielfigurx][Spielfigury] == Konstanten.BOSS1w) {
			if (ruestung > 0) {
				ruestung = ruestung - 25;
			} else if (ruestung == 0) {
				health = health - 25;
			}
			if (health + ruestung <= 0) {
				leben = leben - 1;
				aktuellesSpielfeld[altx][alty] = Konstanten.RASEN;
				aktuellesSpielfeld[checkx][checky] = Konstanten.PUDEL;
				Checkpoint();
			} else if (health + ruestung > 0) {
				aktuellesSpielfeld[altx][alty] = Konstanten.PUDEL;
				aktuellesSpielfeld[Spielfigurx][Spielfigury] = Konstanten.BOSS1w;
				Spielfigurx = altx;
				Spielfigury = alty;
			}

			/* Abfrage für ich laufe gegen BOSS2 */
		} else if (aktuellesSpielfeld[Spielfigurx][Spielfigury] == Konstanten.BOSS2v) {
			if (ruestung > 0) {
				ruestung = 50 - ruestung;
				health = health - ruestung;
				ruestung = 0;
			} else if (ruestung == 0) {
				health = health - 50;
			}
			if (health + ruestung <= 0) {
				leben = leben - 1;
				aktuellesSpielfeld[altx][alty] = Konstanten.RASEN;
				aktuellesSpielfeld[checkx][checky] = Konstanten.PUDEL;
				Checkpoint();
			} else if (health + ruestung > 0) {
				aktuellesSpielfeld[altx][alty] = Konstanten.PUDEL;
				aktuellesSpielfeld[Spielfigurx][Spielfigury] = Konstanten.BOSS2v;
				Spielfigurx = altx;
				Spielfigury = alty;
			}
		} else if (aktuellesSpielfeld[Spielfigurx][Spielfigury] == Konstanten.BOSS2m) {
			if (ruestung > 0) {
				ruestung = 50 - ruestung;
				health = health - ruestung;
				ruestung = 0;
			} else if (ruestung == 0) {
				health = health - 50;
			}
			if (health + ruestung <= 0) {
				leben = leben - 1;
				aktuellesSpielfeld[altx][alty] = Konstanten.RASEN;
				aktuellesSpielfeld[checkx][checky] = Konstanten.PUDEL;
				Checkpoint();
			} else if (health + ruestung > 0) {
				aktuellesSpielfeld[altx][alty] = Konstanten.PUDEL;
				aktuellesSpielfeld[Spielfigurx][Spielfigury] = Konstanten.BOSS2m;
				Spielfigurx = altx;
				Spielfigury = alty;
			}
		} else if (aktuellesSpielfeld[Spielfigurx][Spielfigury] == Konstanten.BOSS2w) {
			if (ruestung > 0) {
				ruestung = 50 - ruestung;
				health = health - ruestung;
				ruestung = 0;
			} else if (ruestung == 0) {
				health = health - 50;
			}
			if (health + ruestung <= 0) {
				leben = leben - 1;
				aktuellesSpielfeld[altx][alty] = Konstanten.RASEN;
				aktuellesSpielfeld[checkx][checky] = Konstanten.PUDEL;
				Checkpoint();
			} else if (health + ruestung > 0) {
				aktuellesSpielfeld[altx][alty] = Konstanten.PUDEL;
				aktuellesSpielfeld[Spielfigurx][Spielfigury] = Konstanten.BOSS2w;
				Spielfigurx = altx;
				Spielfigury = alty;
			}

			/* Abfrage für ich laufe gegen BOSS3 */
		} else if (aktuellesSpielfeld[Spielfigurx][Spielfigury] == Konstanten.BOSS3v) {
			if (ruestung > 0) {
				ruestung = 100 - ruestung;
				health = health - ruestung;
				ruestung = 0;
			} else if (ruestung == 0) {
				health = health - 100;
			}
			if (health + ruestung <= 0) {
				leben = leben - 1;
				aktuellesSpielfeld[altx][alty] = Konstanten.RASEN;
				aktuellesSpielfeld[checkx][checky] = Konstanten.PUDEL;
				Checkpoint();
			} else if (health + ruestung > 0) {
				aktuellesSpielfeld[altx][alty] = Konstanten.PUDEL;
				aktuellesSpielfeld[Spielfigurx][Spielfigury] = Konstanten.BOSS3v;
				Spielfigurx = altx;
				Spielfigury = alty;
			}
		} else if (aktuellesSpielfeld[Spielfigurx][Spielfigury] == Konstanten.BOSS3m) {
			if (ruestung > 0) {
				ruestung = 100 - ruestung;
				health = health - ruestung;
				ruestung = 0;
			} else if (ruestung == 0) {
				health = health - 100;
			}
			if (health + ruestung <= 0) {
				leben = leben - 1;
				aktuellesSpielfeld[altx][alty] = Konstanten.RASEN;
				aktuellesSpielfeld[checkx][checky] = Konstanten.PUDEL;
				Checkpoint();
			} else if (health + ruestung > 0) {
				aktuellesSpielfeld[altx][alty] = Konstanten.PUDEL;
				aktuellesSpielfeld[Spielfigurx][Spielfigury] = Konstanten.BOSS3m;
				Spielfigurx = altx;
				Spielfigury = alty;
			}
		} else if (aktuellesSpielfeld[Spielfigurx][Spielfigury] == Konstanten.BOSS3w) {
			if (ruestung > 0) {
				ruestung = 100 - ruestung;
				health = health - ruestung;
				ruestung = 0;
			} else if (ruestung == 0) {
				health = health - 100;
			}
			if (health + ruestung <= 0) {
				leben = leben - 1;
				aktuellesSpielfeld[altx][alty] = Konstanten.RASEN;
				aktuellesSpielfeld[checkx][checky] = Konstanten.PUDEL;
				Checkpoint();
			} else if (health + ruestung > 0) {
				aktuellesSpielfeld[altx][alty] = Konstanten.PUDEL;
				aktuellesSpielfeld[Spielfigurx][Spielfigury] = Konstanten.BOSS3w;
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
			mana = 2;
			aktuellesSpielfeld[Spielfigurx][Spielfigury] = Konstanten.PUDEL;
			aktuellesSpielfeld[altx][alty] = Konstanten.RASEN;
			zeichner.zeichneSpielfeld(aktuellesSpielfeld);

			/* Abfrage für ich laufe auf RUESTUNG */
		} else if (aktuellesSpielfeld[Spielfigurx][Spielfigury] == Konstanten.RUESTUNG) {
			ruestung = 50;
			halsband = 1;
			aktuellesSpielfeld[Spielfigurx][Spielfigury] = Konstanten.PUDEL;
			aktuellesSpielfeld[altx][alty] = Konstanten.RASEN;
			zeichner.zeichneSpielfeld(aktuellesSpielfeld);

			/* Abfrage für ich laufe auf HEALTH */
		} else if (aktuellesSpielfeld[Spielfigurx][Spielfigury] == Konstanten.HEALTH) {
			health = 100;
			aktuellesSpielfeld[Spielfigurx][Spielfigury] = Konstanten.PUDEL;
			aktuellesSpielfeld[altx][alty] = Konstanten.RASEN;
			zeichner.zeichneSpielfeld(aktuellesSpielfeld);

			/* Abfrage für ich laufe auf WAFFE */
		} else if (aktuellesSpielfeld[Spielfigurx][Spielfigury] == Konstanten.WAFFE) {
			bewaffnet = 1;
			aktuellesSpielfeld[Spielfigurx][Spielfigury] = Konstanten.PUDEL;
			aktuellesSpielfeld[altx][alty] = Konstanten.RASEN;
			zeichner.zeichneSpielfeld(aktuellesSpielfeld);

			/* Abfrage für ich laufe auf SCHWERT */
		} else if (aktuellesSpielfeld[Spielfigurx][Spielfigury] == Konstanten.SCHWERT) {
			beschwertet = 1;
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
			locx = Spielfigurx;
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
					} else if (aktuellesSpielfeld[locx][Spielfigury] == Konstanten.BOSS1v) {
						bosshealth = bosshealth - 34;
						/* wenn bosshealth erschöpft, setze dort RASEN */
						aktuellesSpielfeld[locx][Spielfigury] = Konstanten.BOSS1m;
						zeichner.zeichneSpielfeld(aktuellesSpielfeld);
						break;
					} else if (aktuellesSpielfeld[locx][Spielfigury] == Konstanten.BOSS1m) {
						bosshealth = bosshealth - 34;
						aktuellesSpielfeld[locx][Spielfigury] = Konstanten.BOSS1w;
						zeichner.zeichneSpielfeld(aktuellesSpielfeld);
						break;
					} else if (aktuellesSpielfeld[locx][Spielfigury] == Konstanten.BOSS1w) {
						aktuellesSpielfeld[locx][Spielfigury] = Konstanten.RASEN;
						break;
					} else if (aktuellesSpielfeld[locx][Spielfigury] == Konstanten.BOSS2v) {
						bosshealth = bosshealth - 34;
						/* wenn bosshealth erschöpft, setze dort RASEN */
						aktuellesSpielfeld[locx][Spielfigury] = Konstanten.BOSS2m;
						zeichner.zeichneSpielfeld(aktuellesSpielfeld);
						break;
					} else if (aktuellesSpielfeld[locx][Spielfigury] == Konstanten.BOSS2m) {
						bosshealth = bosshealth - 34;
						aktuellesSpielfeld[locx][Spielfigury] = Konstanten.BOSS2w;
						zeichner.zeichneSpielfeld(aktuellesSpielfeld);
						break;
					} else if (aktuellesSpielfeld[locx][Spielfigury] == Konstanten.BOSS2w) {
						aktuellesSpielfeld[locx][Spielfigury] = Konstanten.RASEN;
						break;
					} else if (aktuellesSpielfeld[locx][Spielfigury] == Konstanten.BOSS3v) {
						bosshealth = bosshealth - 34;
						/* wenn bosshealth erschöpft, setze dort RASEN */
						aktuellesSpielfeld[locx][Spielfigury] = Konstanten.BOSS3m;
						zeichner.zeichneSpielfeld(aktuellesSpielfeld);
						break;
					} else if (aktuellesSpielfeld[locx][Spielfigury] == Konstanten.BOSS3m) {
						bosshealth = bosshealth - 34;
						aktuellesSpielfeld[locx][Spielfigury] = Konstanten.BOSS3w;
						zeichner.zeichneSpielfeld(aktuellesSpielfeld);
						break;
					} else if (aktuellesSpielfeld[locx][Spielfigury] == Konstanten.BOSS3w) {
						aktuellesSpielfeld[locx][Spielfigury] = Konstanten.RASEN;
						break;
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
			zeichner.zeichneSpielfeld(aktuellesSpielfeld);

		}
		if (e.getKeyCode() == KeyEvent.VK_X) {
			locx = Spielfigurx;
			/* wenn Erna nicht beschwertet, dann kein Ereignis */
			if (beschwertet == 0) {
				// nothing to do here

				/* wenn Erna beschwertet */
			} else if (beschwertet == 1) {
				locx++;
				if (aktuellesSpielfeld[locx][Spielfigury] == Konstanten.GEGNER) {
					aktuellesSpielfeld[locx][Spielfigury] = Konstanten.GEGNERTOT;
					zeichner.zeichneSpielfeld(aktuellesSpielfeld);
					ko = 1;
					/* wenn dort BOSS1 ziehe bosshealth ab */
				} else if (aktuellesSpielfeld[locx][Spielfigury] == Konstanten.BOSS1v) {
					bosshealth = bosshealth - 34;
					/* wenn bosshealth erschöpft, setze dort RASEN */
					aktuellesSpielfeld[locx][Spielfigury] = Konstanten.BOSS1m;
					zeichner.zeichneSpielfeld(aktuellesSpielfeld);
				} else if (aktuellesSpielfeld[locx][Spielfigury] == Konstanten.BOSS1m) {
					bosshealth = bosshealth - 34;
					aktuellesSpielfeld[locx][Spielfigury] = Konstanten.BOSS1w;
					zeichner.zeichneSpielfeld(aktuellesSpielfeld);
				} else if (aktuellesSpielfeld[locx][Spielfigury] == Konstanten.BOSS1w) {
					aktuellesSpielfeld[locx][Spielfigury] = Konstanten.RASEN;
				} else if (aktuellesSpielfeld[locx][Spielfigury] == Konstanten.BOSS2v) {
					bosshealth = bosshealth - 34;
					/* wenn bosshealth erschöpft, setze dort RASEN */
					aktuellesSpielfeld[locx][Spielfigury] = Konstanten.BOSS2m;
					zeichner.zeichneSpielfeld(aktuellesSpielfeld);
				} else if (aktuellesSpielfeld[locx][Spielfigury] == Konstanten.BOSS2m) {
					bosshealth = bosshealth - 34;
					aktuellesSpielfeld[locx][Spielfigury] = Konstanten.BOSS2w;
					zeichner.zeichneSpielfeld(aktuellesSpielfeld);
				} else if (aktuellesSpielfeld[locx][Spielfigury] == Konstanten.BOSS2w) {
					aktuellesSpielfeld[locx][Spielfigury] = Konstanten.RASEN;
				} else if (aktuellesSpielfeld[locx][Spielfigury] == Konstanten.BOSS3v) {
					bosshealth = bosshealth - 34;
					/* wenn bosshealth erschöpft, setze dort RASEN */
					aktuellesSpielfeld[locx][Spielfigury] = Konstanten.BOSS3m;
					zeichner.zeichneSpielfeld(aktuellesSpielfeld);
				} else if (aktuellesSpielfeld[locx][Spielfigury] == Konstanten.BOSS3m) {
					bosshealth = bosshealth - 34;
					aktuellesSpielfeld[locx][Spielfigury] = Konstanten.BOSS3w;
					zeichner.zeichneSpielfeld(aktuellesSpielfeld);
				} else if (aktuellesSpielfeld[locx][Spielfigury] == Konstanten.BOSS3w) {
					aktuellesSpielfeld[locx][Spielfigury] = Konstanten.RASEN;
				} else if (aktuellesSpielfeld[locx][Spielfigury] == Konstanten.RASEN) {
					aktuellesSpielfeld[locx][Spielfigury] = Konstanten.RASEN;
				}
				locx = Spielfigurx;
				locx--;
				if (aktuellesSpielfeld[locx][Spielfigury] == Konstanten.GEGNER) {
					aktuellesSpielfeld[locx][Spielfigury] = Konstanten.GEGNERTOT;
					zeichner.zeichneSpielfeld(aktuellesSpielfeld);
					ko = 1;
					/* wenn dort BOSS1 ziehe bosshealth ab */
				} else if (aktuellesSpielfeld[locx][Spielfigury] == Konstanten.BOSS1v) {
					bosshealth = bosshealth - 34;
					/* wenn bosshealth erschöpft, setze dort RASEN */
					aktuellesSpielfeld[locx][Spielfigury] = Konstanten.BOSS1m;
					zeichner.zeichneSpielfeld(aktuellesSpielfeld);
				} else if (aktuellesSpielfeld[locx][Spielfigury] == Konstanten.BOSS1m) {
					bosshealth = bosshealth - 34;
					aktuellesSpielfeld[locx][Spielfigury] = Konstanten.BOSS1w;
					zeichner.zeichneSpielfeld(aktuellesSpielfeld);
				} else if (aktuellesSpielfeld[locx][Spielfigury] == Konstanten.BOSS1w) {
					aktuellesSpielfeld[locx][Spielfigury] = Konstanten.RASEN;
				} else if (aktuellesSpielfeld[locx][Spielfigury] == Konstanten.BOSS2v) {
					bosshealth = bosshealth - 34;
					/* wenn bosshealth erschöpft, setze dort RASEN */
					aktuellesSpielfeld[locx][Spielfigury] = Konstanten.BOSS2m;
					zeichner.zeichneSpielfeld(aktuellesSpielfeld);
				} else if (aktuellesSpielfeld[locx][Spielfigury] == Konstanten.BOSS2m) {
					bosshealth = bosshealth - 34;
					aktuellesSpielfeld[locx][Spielfigury] = Konstanten.BOSS2w;
					zeichner.zeichneSpielfeld(aktuellesSpielfeld);
				} else if (aktuellesSpielfeld[locx][Spielfigury] == Konstanten.BOSS2w) {
					aktuellesSpielfeld[locx][Spielfigury] = Konstanten.RASEN;
				} else if (aktuellesSpielfeld[locx][Spielfigury] == Konstanten.BOSS3v) {
					bosshealth = bosshealth - 34;
					/* wenn bosshealth erschöpft, setze dort RASEN */
					aktuellesSpielfeld[locx][Spielfigury] = Konstanten.BOSS3m;
					zeichner.zeichneSpielfeld(aktuellesSpielfeld);
				} else if (aktuellesSpielfeld[locx][Spielfigury] == Konstanten.BOSS3m) {
					bosshealth = bosshealth - 34;
					aktuellesSpielfeld[locx][Spielfigury] = Konstanten.BOSS3w;
					zeichner.zeichneSpielfeld(aktuellesSpielfeld);
				} else if (aktuellesSpielfeld[locx][Spielfigury] == Konstanten.BOSS3w) {
					aktuellesSpielfeld[locx][Spielfigury] = Konstanten.RASEN;
				} else if (aktuellesSpielfeld[locx][Spielfigury] == Konstanten.RASEN) {
					aktuellesSpielfeld[locx][Spielfigury] = Konstanten.RASEN;
				}
				locy++;
				if (aktuellesSpielfeld[Spielfigurx][locy] == Konstanten.GEGNER) {
					aktuellesSpielfeld[Spielfigurx][locy] = Konstanten.GEGNERTOT;
					zeichner.zeichneSpielfeld(aktuellesSpielfeld);
					ko = 1;
					/* wenn dort BOSS1 ziehe bosshealth ab */
				} else if (aktuellesSpielfeld[Spielfigurx][locy] == Konstanten.BOSS1v) {
					bosshealth = bosshealth - 34;
					/* wenn bosshealth erschöpft, setze dort RASEN */
					aktuellesSpielfeld[Spielfigurx][locy] = Konstanten.BOSS1m;
					zeichner.zeichneSpielfeld(aktuellesSpielfeld);
				} else if (aktuellesSpielfeld[locx][Spielfigury] == Konstanten.BOSS1m) {
					bosshealth = bosshealth - 34;
					aktuellesSpielfeld[Spielfigurx][locy] = Konstanten.BOSS1w;
					zeichner.zeichneSpielfeld(aktuellesSpielfeld);
				} else if (aktuellesSpielfeld[Spielfigurx][locy] == Konstanten.BOSS1w) {
					aktuellesSpielfeld[Spielfigurx][locy] = Konstanten.RASEN;
				} else if (aktuellesSpielfeld[Spielfigurx][locy] == Konstanten.BOSS2v) {
					bosshealth = bosshealth - 34;
					/* wenn bosshealth erschöpft, setze dort RASEN */
					aktuellesSpielfeld[Spielfigurx][locy] = Konstanten.BOSS2m;
					zeichner.zeichneSpielfeld(aktuellesSpielfeld);
				} else if (aktuellesSpielfeld[Spielfigurx][locy] == Konstanten.BOSS2m) {
					bosshealth = bosshealth - 34;
					aktuellesSpielfeld[Spielfigurx][locy] = Konstanten.BOSS2w;
					zeichner.zeichneSpielfeld(aktuellesSpielfeld);
				} else if (aktuellesSpielfeld[Spielfigurx][locy] == Konstanten.BOSS2w) {
					aktuellesSpielfeld[Spielfigurx][locy] = Konstanten.RASEN;
				} else if (aktuellesSpielfeld[Spielfigurx][locy] == Konstanten.BOSS3v) {
					bosshealth = bosshealth - 34;
					/* wenn bosshealth erschöpft, setze dort RASEN */
					aktuellesSpielfeld[Spielfigurx][locy] = Konstanten.BOSS3m;
					zeichner.zeichneSpielfeld(aktuellesSpielfeld);
				} else if (aktuellesSpielfeld[Spielfigurx][locy] == Konstanten.BOSS3m) {
					bosshealth = bosshealth - 34;
					aktuellesSpielfeld[Spielfigurx][locy] = Konstanten.BOSS3w;
					zeichner.zeichneSpielfeld(aktuellesSpielfeld);
				} else if (aktuellesSpielfeld[Spielfigurx][locy] == Konstanten.BOSS3w) {
					aktuellesSpielfeld[Spielfigurx][locy] = Konstanten.RASEN;
				} else if (aktuellesSpielfeld[Spielfigurx][locy] == Konstanten.RASEN) {
					aktuellesSpielfeld[Spielfigurx][locy] = Konstanten.RASEN;
				}
				locy = Spielfigury;
				locy--;
				if (aktuellesSpielfeld[Spielfigurx][locy] == Konstanten.GEGNER) {
					aktuellesSpielfeld[Spielfigurx][locy] = Konstanten.GEGNERTOT;
					zeichner.zeichneSpielfeld(aktuellesSpielfeld);
					ko = 1;
					/* wenn dort BOSS1 ziehe bosshealth ab */
				} else if (aktuellesSpielfeld[Spielfigurx][locy] == Konstanten.BOSS1v) {
					bosshealth = bosshealth - 34;
					/* wenn bosshealth erschöpft, setze dort RASEN */
					aktuellesSpielfeld[Spielfigurx][locy] = Konstanten.BOSS1m;
					zeichner.zeichneSpielfeld(aktuellesSpielfeld);
				} else if (aktuellesSpielfeld[locx][Spielfigury] == Konstanten.BOSS1m) {
					bosshealth = bosshealth - 34;
					aktuellesSpielfeld[Spielfigurx][locy] = Konstanten.BOSS1w;
					zeichner.zeichneSpielfeld(aktuellesSpielfeld);
				} else if (aktuellesSpielfeld[Spielfigurx][locy] == Konstanten.BOSS1w) {
					aktuellesSpielfeld[Spielfigurx][locy] = Konstanten.RASEN;
				} else if (aktuellesSpielfeld[Spielfigurx][locy] == Konstanten.BOSS2v) {
					bosshealth = bosshealth - 34;
					/* wenn bosshealth erschöpft, setze dort RASEN */
					aktuellesSpielfeld[Spielfigurx][locy] = Konstanten.BOSS2m;
					zeichner.zeichneSpielfeld(aktuellesSpielfeld);
				} else if (aktuellesSpielfeld[Spielfigurx][locy] == Konstanten.BOSS2m) {
					bosshealth = bosshealth - 34;
					aktuellesSpielfeld[Spielfigurx][locy] = Konstanten.BOSS2w;
					zeichner.zeichneSpielfeld(aktuellesSpielfeld);
				} else if (aktuellesSpielfeld[Spielfigurx][locy] == Konstanten.BOSS2w) {
					aktuellesSpielfeld[Spielfigurx][locy] = Konstanten.RASEN;
				} else if (aktuellesSpielfeld[Spielfigurx][locy] == Konstanten.BOSS3v) {
					bosshealth = bosshealth - 34;
					/* wenn bosshealth erschöpft, setze dort RASEN */
					aktuellesSpielfeld[Spielfigurx][locy] = Konstanten.BOSS3m;
					zeichner.zeichneSpielfeld(aktuellesSpielfeld);
				} else if (aktuellesSpielfeld[Spielfigurx][locy] == Konstanten.BOSS3m) {
					bosshealth = bosshealth - 34;
					aktuellesSpielfeld[Spielfigurx][locy] = Konstanten.BOSS3w;
					zeichner.zeichneSpielfeld(aktuellesSpielfeld);
				} else if (aktuellesSpielfeld[Spielfigurx][locy] == Konstanten.BOSS3w) {
					aktuellesSpielfeld[Spielfigurx][locy] = Konstanten.RASEN;
				} else if (aktuellesSpielfeld[Spielfigurx][locy] == Konstanten.RASEN) {
					aktuellesSpielfeld[Spielfigurx][locy] = Konstanten.RASEN;
				}

			}
			zeichner.zeichneSpielfeld(aktuellesSpielfeld);
		}

		/* Abfragen für die Steuerungstaste */
		if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
			if (mana == 0) {
				// nothing to do here

				/*
				 * wenn mana = 1, gib Erna ihr Schwert, pflege sie gesund
				 * Boss nimmt ihr ihre Laser Ray Ban
				 */
			} else if (mana >= 1) {
				beschwertet = 1;
				bewaffnet = 0;
				health = 100;
				mana = mana - 1;
				zeichner.zeichneSpielfeld(aktuellesSpielfeld);
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