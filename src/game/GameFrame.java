package game;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;

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

	private Spiel spiel;
	private GameFrame gameFrame;
	private NPC carlos;
	private Zeichner zeichner;

	private Integer aktuellesSpielfeld[][] = new Integer[16][12];
	private Integer CheckSpielfeld[][] = new Integer[16][12];

	private int Spielfigurx;
	private int Spielfigury;
	private int Gegnerx;
	private int Gegnery;
	private int Gegnersx;
	private int Gegnersy;
	private int Gegner1;
	private int Gegner2;
	private int checkx;
	private int checky;
	private int level;

	private int zaehlerlevel = 1;
	private int zaehlerbombe = 0;
	
	private int bewaffnet = 0;
	private int beschwertet = 0;
	private int halsband = 0;

	private int gold = 0;
	private int health = 100;
	private int ruestung = 0;
	private int mana = 0;

	private int leben = 3;
	private int bombex;
	private int bombey;

	private int ko = 0;
	private int bosshealth = 100;
	private int save = 0;

	private String Datei;

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
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setFocusable(true);
		this.addKeyListener(this);

		zeichner = new Zeichner(this);
		this.add(zeichner);

		spiel = new Spiel();
		chooseFile();
		if (Datei == null) {
			return;
		} 
		spiel.init(Datei);

	//	zeichner.zeichneSpielfeld(aktuellesSpielfeld);

		setzeAnzeige();

		getContentPane().add(Leiste, BorderLayout.SOUTH);

		this.setVisible(true);
		this.requestFocus();
	}

	/**
	 * erzeugt FileChooser
	 * @return 
	 * 
	 * @return
	 */
	public String chooseFile() {
		/* erzeugt neuen FileChooser */
		JFileChooser fc = new JFileChooser(Konstanten.direction
				+ "/src/game/Szenario");
		/* FileChooser kann nur eine Datei auswählen */
		fc.setMultiSelectionEnabled(false);
		/* fügt einen FileFilter hinzu */
		fc.setFileFilter(new FileFilter() {
			/* akzeptiert nur txt-Dateien */
			@Override
			public boolean accept(File f) {
				return f.isDirectory()
						|| f.getName().toLowerCase().endsWith(".txt");
			}

			/* Beschreibung des Filters */
			@Override
			public String getDescription() {
				return "Textdateien";
			}
		});

		int state = fc.showOpenDialog(this);
		/* wenn ein oder mehrere Dateien ausgewählt */
		if (state == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			Datei = file.getName();
			/* fängt die Varianten Error und Abbruch durch Nutzer ab */
		} else if (state == JFileChooser.CANCEL_OPTION) {
			JOptionPane.showMessageDialog(null, "Auswahl abgebrochen",
					"Dateiselektion", JOptionPane.INFORMATION_MESSAGE);
		}
		return Datei;
	}

	/**
	 * aktualisiert die Grafik
	 */
	public void Aktualisieren() {
		validate();
		repaint();
	}

	/**
	 * fragt die benötigten Variablen ab und setzt die Informationsleiste im
	 * unteren Bereich des Spielfensters
	 */
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
		if (health == Konstanten.VOLLH) {
			LebenVoll.setBounds(23, 590, 150, 100);
			Leiste.add(LebenVoll);
		} else if (health == Konstanten.DREIVIERTELH) {
			LebenFast.setBounds(23, 590, 150, 100);
			Leiste.add(LebenFast);
		} else if (health == Konstanten.HALBH) {
			LebenFast.setBounds(23, 590, 150, 100);
			Leiste.add(LebenHalb);
		} else if (health == Konstanten.EINVIERTELH) {
			LebenFast.setBounds(23, 590, 150, 100);
			Leiste.add(LebenWenig);
		}
		Aktualisieren();

		/* für die Manaanzeige */
		if (mana == Konstanten.VOLLM) {
			ManaVoll.setBounds(170, 590, 150, 100);
			Leiste.add(ManaVoll);
		} else if (mana == Konstanten.HALBM) {
			ManaHalb.setBounds(170, 590, 150, 100);
			Leiste.add(ManaHalb);
		} else if (mana == Konstanten.LEERM) {
			ManaLeer.setBounds(170, 590, 150, 100);
			Leiste.add(ManaLeer);
		}

		if (ruestung == Konstanten.VOLLR) {
			RuestungVoll.setBounds(320, 590, 150, 100);
			Leiste.add(RuestungVoll);
		} else if (ruestung == Konstanten.HALBR) {
			RuestungHalb.setBounds(320, 590, 150, 100);
			Leiste.add(RuestungHalb);
		} else if (ruestung == Konstanten.LEERR) {
			RuestungWeg.setBounds(320, 590, 150, 100);
			Leiste.add(RuestungWeg);
		}
		Aktualisieren();

		/* für die Goldanzeige */
		if (gold == Konstanten.GOLD0) {
			Gold0.setBounds(470, 590, 100, 100);
			Leiste.add(Gold0);
		} else if (gold == Konstanten.GOLD50) {
			Gold50.setBounds(470, 590, 100, 100);
			Leiste.add(Gold50);
		} else if (gold == Konstanten.GOLD100) {
			Gold100.setBounds(470, 590, 100, 100);
			Leiste.add(Gold100);
		} else if (gold == Konstanten.GOLD150) {
			Gold150.setBounds(470, 590, 100, 100);
			Leiste.add(Gold150);
		} else if (gold == Konstanten.GOLD200) {
			Gold200.setBounds(470, 590, 100, 100);
			Leiste.add(Gold200);
		} else if (gold == Konstanten.GOLD250) {
			Gold250.setBounds(470, 590, 100, 100);
			Leiste.add(Gold250);
		} else if (gold == Konstanten.GOLD300) {
			Gold300.setBounds(470, 590, 100, 100);
			Leiste.add(Gold300);
		} else if (gold == Konstanten.GOLD350) {
			Gold350.setBounds(470, 590, 100, 100);
			Leiste.add(Gold350);
		}
		Aktualisieren();

		if (bewaffnet == 0) {
			if (beschwertet == Konstanten.NULL) {
				if (halsband == Konstanten.NULL) {
					KeinEq.setBounds(570, 590, 125, 100);
					Leiste.add(KeinEq);
				} else if (halsband == Konstanten.EINS) {
					Hals.setBounds(570, 590, 125, 100);
					Leiste.add(Hals);
				}
			} else if (beschwertet == Konstanten.EINS) {
				if (halsband == Konstanten.NULL) {
					Schwert.setBounds(570, 590, 125, 100);
					Leiste.add(Schwert);
				} else if (halsband == Konstanten.EINS) {
					SchwertHals.setBounds(570, 590, 125, 100);
					Leiste.add(SchwertHals);
				}
			}
		} else if (bewaffnet == Konstanten.EINS) {
			if (beschwertet == Konstanten.NULL) {
				if (halsband == Konstanten.NULL) {
					Brille.setBounds(570, 590, 125, 100);
					Leiste.add(Brille);
				} else if (halsband == Konstanten.EINS) {
					BrilleHals.setBounds(570, 590, 125, 100);
					Leiste.add(BrilleHals);
				}
			} else if (beschwertet == Konstanten.EINS) {
				if (halsband == Konstanten.NULL) {
					BrilleSchwert.setBounds(570, 590, 125, 100);
					Leiste.add(BrilleSchwert);
				} else if (halsband == Konstanten.EINS) {
					AllesEq.setBounds(570, 590, 125, 100);
					Leiste.add(AllesEq);
				}
			}
		}
		Aktualisieren();

		/* für die Lebenanzeige */
		if (leben == Konstanten.VOLLL) {
			Herz3.setBounds(690, 590, 100, 100);
			Leiste.add(Herz3);
		} else if (leben == Konstanten.ZWEIDRITTELL) {
			Herz2.setBounds(690, 590, 100, 100);
			Leiste.add(Herz2);
		} else if (leben == Konstanten.EINDRITTELL) {
			Herz1.setBounds(690, 590, 100, 100);
			Leiste.add(Herz1);
		}
		Aktualisieren();
	}

	/*
	 * Prüfung ob Checkpoint besucht wurde und Zurücksetzen des Spiels oder
	 * Ausgang Verloren
	 
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
	}*/

	/**
	 * es wird ein neues Fenster mit dem Spielausgang Gewonnen aufgerufen
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
	 * es wird ein neues Fenster mit dem Spielausgang Verloren aufgerufen
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

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
}