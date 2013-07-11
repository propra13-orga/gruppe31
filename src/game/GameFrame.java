package game;

import game.figuren.Spieler;

import java.awt.BorderLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.filechooser.FileFilter;

/**
 * GameFrame erzeugt das Spielfenster. Der KeyListener fragt die Werte der
 * umliegenden Felder ab und führt das Programm entsprechend weiter.
 */
public class GameFrame extends JFrame implements KeyListener {

	/** Icons für die Anzeige des Levels werden deklariert */
	private static final Icon ICONEINS = new ImageIcon(Konstanten.DIRECTION
			+ "/src/game/Images/1.png");
	private static final Icon ICONZWEI = new ImageIcon(Konstanten.DIRECTION
			+ "/src/game/Images/2.png");
	private static final Icon ICONDREI = new ImageIcon(Konstanten.DIRECTION
			+ "/src/game/Images/3.png");

	/** Icons für die Anzeige der Gesundheitsleiste werden deklariert */
	private static final Icon ICONLEBENVOLL = new ImageIcon(
			Konstanten.DIRECTION + "/src/game/Images/Lebenvoll.png");
	private static final Icon ICONLEBENFAST = new ImageIcon(
			Konstanten.DIRECTION + "/src/game/Images/Lebenfast.png");
	private static final Icon ICONLEBENHALB = new ImageIcon(
			Konstanten.DIRECTION + "/src/game/Images/Lebenhalb.png");
	private static final Icon ICONLEBENWENIG = new ImageIcon(
			Konstanten.DIRECTION + "/src/game/Images/Lebenwenig.png");

	/** Icons für die Anzeige der Manaleiste werden deklariert */
	private static final Icon ICONMANAVOLL = new ImageIcon(Konstanten.DIRECTION
			+ "/src/game/Images/Manavoll.png");
	private static final Icon ICONMANAHALB = new ImageIcon(Konstanten.DIRECTION
			+ "/src/game/Images/Manahalb.png");
	private static final Icon ICONMANALEER = new ImageIcon(Konstanten.DIRECTION
			+ "/src/game/Images/Manaleer.png");

	/** Icons für die Ruestungsanzeige deklariert */
	private static final Icon ICONRUESTUNGVOLL = new ImageIcon(
			Konstanten.DIRECTION + "/src/game/Images/Ruestungvoll.png");
	private static final Icon ICONRUESTUNGHALB = new ImageIcon(
			Konstanten.DIRECTION + "/src/game/Images/Ruestunghalb.png");
	private static final Icon ICONRUESTUNGWEG = new ImageIcon(
			Konstanten.DIRECTION + "/src/game/Images/Ruestungweg.png");

	/** Icons für die Goldanzeige deklariert */
	private static final Icon ICON0GOLD = new ImageIcon(Konstanten.DIRECTION
			+ "/src/game/Images/Gold0.png");
	private static final Icon ICON50GOLD = new ImageIcon(Konstanten.DIRECTION
			+ "/src/game/Images/Gold50.png");
	private static final Icon ICON100GOLD = new ImageIcon(Konstanten.DIRECTION
			+ "/src/game/Images/Gold100.png");
	private static final Icon ICON150GOLD = new ImageIcon(Konstanten.DIRECTION
			+ "/src/game/Images/Gold150.png");
	private static final Icon ICON200GOLD = new ImageIcon(Konstanten.DIRECTION
			+ "/src/game/Images/Gold200.png");
	private static final Icon ICON250GOLD = new ImageIcon(Konstanten.DIRECTION
			+ "/src/game/Images/Gold250.png");
	private static final Icon ICON300GOLD = new ImageIcon(Konstanten.DIRECTION
			+ "/src/game/Images/Gold300.png");
	private static final Icon ICON350GOLD = new ImageIcon(Konstanten.DIRECTION
			+ "/src/game/Images/Gold350.png");

	/** Icons für die Anzeige der aktuellen Waffe(n) deklariert */
	private static final Icon ICONKEINEQ = new ImageIcon(Konstanten.DIRECTION
			+ "/src/game/Images/KeinEq.png");
	private static final Icon ICONSCHWERT = new ImageIcon(Konstanten.DIRECTION
			+ "/src/game/Images/Schwert.png");
	private static final Icon ICONHALS = new ImageIcon(Konstanten.DIRECTION
			+ "/src/game/Images/Hals.png");
	private static final Icon ICONBRILLE = new ImageIcon(Konstanten.DIRECTION
			+ "/src/game/Images/Brille.png");
	private static final Icon ICONBRILLEHALS = new ImageIcon(
			Konstanten.DIRECTION + "/src/game/Images/BrilleHals.png");
	private static final Icon ICONBRILLESCHWERT = new ImageIcon(
			Konstanten.DIRECTION + "/src/game/Images/BrilleSchwert.png");
	private static final Icon ICONSCHWERTHALS = new ImageIcon(
			Konstanten.DIRECTION + "/src/game/Images/SchwertHals.png");
	private static final Icon ICONALLESEQ = new ImageIcon(Konstanten.DIRECTION
			+ "/src/game/Images/Eqalles.png");

	/** Icons für die Anzeige der Leben deklariert */
	private static final Icon ICONHERZ1 = new ImageIcon(Konstanten.DIRECTION
			+ "/src/game/Images/Herz1.png");
	private static final Icon ICONHERZ2 = new ImageIcon(Konstanten.DIRECTION
			+ "/src/game/Images/Herz2.png");
	private static final Icon ICONHERZ3 = new ImageIcon(Konstanten.DIRECTION
			+ "/src/game/Images/Herz3.png");

	/** Labels für Anzeige des aktuellen Levels deklariert */
	private JLabel EINS = new JLabel(ICONEINS);
	private JLabel ZWEI = new JLabel(ICONZWEI);
	private JLabel DREI = new JLabel(ICONDREI);

	/** Labels für Anzeige der Gesundheitslietse deklariert */
	private JLabel LEBENVOLL = new JLabel(ICONLEBENVOLL);
	private JLabel LEBENFAST = new JLabel(ICONLEBENFAST);
	private JLabel LEBENHALB = new JLabel(ICONLEBENHALB);
	private JLabel LEBENWENIG = new JLabel(ICONLEBENWENIG);

	/** Labels für die Manaanzeige deklariert */
	private JLabel MANAVOLL = new JLabel(ICONMANAVOLL);
	private JLabel MANAHALB = new JLabel(ICONMANAHALB);
	private JLabel MANALEER = new JLabel(ICONMANALEER);

	/** Labels für die Ruestungsanzeige deklariert */
	private JLabel RUESTUNGVOLL = new JLabel(ICONRUESTUNGVOLL);
	private JLabel RUESTUNGHALB = new JLabel(ICONRUESTUNGHALB);
	private JLabel RUESTUNGWEG = new JLabel(ICONRUESTUNGWEG);

	/** Labels für die Goldanzeige deklariert */
	private JLabel GOLD0 = new JLabel(ICON0GOLD);
	private JLabel GOLD50 = new JLabel(ICON50GOLD);
	private JLabel GOLD100 = new JLabel(ICON100GOLD);
	private JLabel GOLD150 = new JLabel(ICON150GOLD);
	private JLabel GOLD200 = new JLabel(ICON200GOLD);
	private JLabel GOLD250 = new JLabel(ICON250GOLD);
	private JLabel GOLD300 = new JLabel(ICON300GOLD);
	private JLabel GOLD350 = new JLabel(ICON350GOLD);

	/** Labels für die Anzeige der aktuellen Waffe(n)deklariert */
	private JLabel KEINRQ = new JLabel(ICONKEINEQ);
	private JLabel SCHWERT = new JLabel(ICONSCHWERT);
	private JLabel BRILLE = new JLabel(ICONBRILLE);
	private JLabel HALS = new JLabel(ICONHALS);
	private JLabel SCHWERTHALS = new JLabel(ICONSCHWERTHALS);
	private JLabel BRILLESCHWERT = new JLabel(ICONBRILLESCHWERT);
	private JLabel BRILLEHALS = new JLabel(ICONBRILLEHALS);
	private JLabel ALLESEQ = new JLabel(ICONALLESEQ);

	/** Labels für die Anzeige der Leben deklariert */
	private JLabel HERZ1 = new JLabel(ICONHERZ1);
	private JLabel HERZ2 = new JLabel(ICONHERZ2);
	private JLabel HERZ3 = new JLabel(ICONHERZ3);

	/** Panel für Anzeigenleiste deklariert */
	private Panel leiste = new Panel();

	/** Button wird für Gewonnen- und Verlorenfenster deklariert */
	private JButton gvschliessen;

	/** Deklaration von Feldern */
	private Spiel spiel;
//	private Spielfigur spielfigur;

	/** Deklaration eines Strings Datei */
	private String datei;

	/** Deklaration eines Strings für Exception im Gewonnen- und Verlorenfenster */
	private String exception = "Das Bild kann nicht gefunden werden ";

	/** Deklaration eines Strings für das Schließen */
	private String schliessen = "Dieses Fenster schließen";

	/**
	 * Deklaration von int-Variablen, werden später durch Variablen aus
	 * GameObject Klassen ersetzt
	 */
	private int level;
	private int health;
	private int mana;
	private int ruestung;
	private int gold;
	private int bewaffnet;
	private int beschwertet;
	private int halsband;
	private int leben;

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
		this.setSize(Konstanten.BREITE, Konstanten.HOEHE);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setFocusable(true);
		this.addKeyListener(this);

		spiel = new Spiel();
		chooseFile();
		if (datei == null) {
			return;
		}
		spiel.init(datei);

		setzeAnzeige();

		getContentPane().add(leiste, BorderLayout.SOUTH);

		zeichnen(spiel.getAktuellesSpielfeld());

		this.setVisible(true);
		this.requestFocus();
	}

	/**
	 * erzeugt FileChooser
	 * 
	 * @return f.isDirectory
	 */
	public String chooseFile() {
		/* erzeugt neuen FileChooser */
		JFileChooser fc = new JFileChooser(Konstanten.DIRECTION
				+ "/src/game/Einzelspieler-Szenario");
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
			datei = file.getName();
			/* fängt die Varianten Error und Abbruch durch Nutzer ab */
		} else if (state == JFileChooser.CANCEL_OPTION) {
			JOptionPane.showMessageDialog(null, "Auswahl abgebrochen",
					"Dateiselektion", JOptionPane.INFORMATION_MESSAGE);
		}
		return datei;
	}

	/**
	 * zeichnet das Spielfeld
	 * 
	 * @param spielfeld
	 *            Kommandozeilenparameter
	 */
	public void zeichnen(Spielfeld spielfeld) {
		for (int i = 0; i < Konstanten.SPALTEN; i++) {
			for (int j = 0; j < Konstanten.ZEILEN; j++) {
				GameObject object = spielfeld
						.gibObjekt(new java.awt.Point(i, j));
				/* eigener Debugger ;-) 
				System.out.println(object.getClass().getSimpleName() + ":"
						+ object.getPicture());*/
				
				Icon icon = new ImageIcon(object.getPicture());
				JLabel label = new JLabel(icon);
				label.setBounds(i * Konstanten.SIZE, j * Konstanten.SIZE,
						icon.getIconWidth(), icon.getIconHeight());
				this.add(label);
			}
		}
	}

	/**
	 * aktualisiert die Informationsleiste
	 */
	public void aktualisieren() {
		validate();
		repaint();
	}

	/**
	 * fragt die benötigten Variablen ab und setzt die Informationsleiste im
	 * unteren Bereich des Spielfensters
	 */
	public void setzeAnzeige() {

		Spieler spieler = this.spiel.getSpieler();

		leiste.removeAll();

		/* für die Levelanzeige */
		if (level == 0) {
			leiste.add(EINS);
		} else if (level == 1) {
			leiste.add(EINS);
		} else if (level == 2) {
			leiste.add(EINS);
		} else if (level == 3) {
			leiste.add(ZWEI);
		} else if (level == 4) {
			leiste.add(ZWEI);
		} else if (level == 5) {
			leiste.add(ZWEI);
		} else if (level == 6) {
			leiste.add(DREI);
		} else if (level == 7) {
			leiste.add(DREI);
		} else if (level == 8) {
			leiste.add(DREI);
		}
		aktualisieren();

		/* für die Healthanzeige */
		// spieler.getGesundheit();
		if (health == Konstanten.VOLLH) {
			leiste.add(LEBENVOLL);
		} else if (health == Konstanten.DREIVIERTELH) {
			leiste.add(LEBENFAST);
		} else if (health == Konstanten.HALBH) {
			leiste.add(LEBENHALB);
		} else if (health == Konstanten.EINVIERTELH) {
			leiste.add(LEBENWENIG);
		}
		aktualisieren();

		/* für die Manaanzeige */
		if (mana == Konstanten.VOLLM) {
			leiste.add(MANAVOLL);
		} else if (mana == Konstanten.HALBM) {
			leiste.add(MANAHALB);
		} else if (mana == Konstanten.LEERM) {
			leiste.add(MANALEER);
		}

		if (ruestung == Konstanten.VOLLR) {
			leiste.add(RUESTUNGVOLL);
		} else if (ruestung == Konstanten.HALBR) {
			leiste.add(RUESTUNGHALB);
		} else if (ruestung == Konstanten.LEERR) {
			leiste.add(RUESTUNGWEG);
		}
		aktualisieren();

		/* für die Goldanzeige */
		if (gold == Konstanten.GOLD0) {
			leiste.add(GOLD0);
		} else if (gold == Konstanten.GOLD50) {
			leiste.add(GOLD50);
		} else if (gold == Konstanten.GOLD100) {
			leiste.add(GOLD100);
		} else if (gold == Konstanten.GOLD150) {
			leiste.add(GOLD150);
		} else if (gold == Konstanten.GOLD200) {
			leiste.add(GOLD200);
		} else if (gold == Konstanten.GOLD250) {
			leiste.add(GOLD250);
		} else if (gold == Konstanten.GOLD300) {
			leiste.add(GOLD300);
		} else if (gold == Konstanten.GOLD350) {
			leiste.add(GOLD350);
		}
		aktualisieren();

		if (bewaffnet == 0) {
			if (beschwertet == 0) {
				if (halsband == 0) {
					leiste.add(KEINRQ);
				} else if (halsband == 1) {
					leiste.add(HALS);
				}
			} else if (beschwertet == 1) {
				if (halsband == 0) {
					leiste.add(SCHWERT);
				} else if (halsband == 1) {
					leiste.add(SCHWERTHALS);
				}
			}
		} else if (bewaffnet == 1) {
			if (beschwertet == 0) {
				if (halsband == 0) {
					leiste.add(BRILLE);
				} else if (halsband == 1) {
					leiste.add(BRILLEHALS);
				}
			} else if (beschwertet == 1) {
				if (halsband == 0) {
					leiste.add(BRILLESCHWERT);
				} else if (halsband == 1) {
					leiste.add(ALLESEQ);
				}
			}
		}
		aktualisieren();

		/* für die Lebenanzeige */
		if (leben == Konstanten.VOLLL) {
			leiste.add(HERZ3);
		} else if (leben == Konstanten.ZWEIDRITTELL) {
			leiste.add(HERZ2);
		} else if (leben == Konstanten.EINDRITTELL) {
			leiste.add(HERZ1);
		}
		aktualisieren();
	}

	/*
	 * Prüfung ob Checkpoint besucht wurde und Zurücksetzen des Spiels oder
	 * Ausgang Verloren
	 * 
	 * public void Checkpoint() { if (save == 1) { if (leben > 0) { health =
	 * 100; Spielfigurx = checkx; Spielfigury = checky;
	 * zeichner.zeichneSpielfeld(CheckSpielfeld); setzeAnzeige(); } else if
	 * (leben <= 0) { Verloren(); } } else if (save == 0) { Verloren(); } }
	 */

	/**
	 * es wird ein neues Fenster mit dem Spielausgang Gewonnen aufgerufen
	 */
	public void gewonnen() {
		getContentPane().removeAll();

		try {
			this.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File(
					Konstanten.DIRECTION + "/src/game/Images/Gewonnen.jpg")))));
		} catch (IOException a) {
			System.out.println(exception);
		}

		this.setResizable(false);
		this.setSize(Konstanten.BREITE, Konstanten.HOEHE);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

		gvschliessen = new JButton(schliessen);
		gvschliessen.setBounds(550, 450, 200, 40);
		this.add(gvschliessen);

		ActionListener alschliessen = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		};
		gvschliessen.addActionListener(alschliessen);
	}

	/**
	 * es wird ein neues Fenster mit dem Spielausgang Verloren aufgerufen
	 */
	public void verloren() {

		getContentPane().removeAll();

		try {
			this.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File(
					Konstanten.DIRECTION + "/src/game/Images/GameOver.jpg")))));
		} catch (IOException a) {
			System.out.println(exception);
		}

		this.setResizable(false);
		this.setSize(Konstanten.BREITE, Konstanten.HOEHE);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

		gvschliessen = new JButton(schliessen);
		gvschliessen.setBounds(550, 450, 200, 40);
		this.add(gvschliessen);

		ActionListener alschliessen = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		};
		gvschliessen.addActionListener(alschliessen);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// nothing to do here
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// nothing to do here
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		this.spiel.aktion(arg0.getKeyCode());
		this.zeichnen(this.spiel.getAktuellesSpielfeld());
	}

}