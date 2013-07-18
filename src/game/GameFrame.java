package game;

import java.awt.Container;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.imageio.ImageIO;

import game.figuren.Bossgegner;
import game.figuren.Falle;
import game.figuren.Gegner;
import game.figuren.Spieler;
import game.figuren.Spielfigur;
import game.icons.Barriere;
import game.icons.Carlos;
import game.icons.Checkpoint;
import game.icons.Grenze;
import game.icons.Huette;
import game.icons.Luke;
import game.icons.Rasen;
import game.icons.SchalterAuf;
import game.icons.SchalterZu;
import game.icons.Weiter;
import game.icons.Ziel;
import game.icons.Zurueck;
import game.items.Brille;
import game.items.Gold;
import game.items.Health;
import game.items.Mana;
import game.items.Ruestung;
import game.items.Schwert;
import game.items.Shophealth;
import game.items.Shopmana;
import game.items.Shopruestung;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
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
	private JLabel eins = new JLabel(ICONEINS);
	private JLabel zwei = new JLabel(ICONZWEI);
	private JLabel drei = new JLabel(ICONDREI);

	/** Labels für Anzeige der Gesundheitslietse deklariert */
	private JLabel lebenVoll = new JLabel(ICONLEBENVOLL);
	private JLabel lebenFast = new JLabel(ICONLEBENFAST);
	private JLabel lebenHalb = new JLabel(ICONLEBENHALB);
	private JLabel lebenWenig = new JLabel(ICONLEBENWENIG);

	/** Labels für die Manaanzeige deklariert */
	private JLabel manaVoll = new JLabel(ICONMANAVOLL);
	private JLabel manaHalb = new JLabel(ICONMANAHALB);
	private JLabel manaLeer = new JLabel(ICONMANALEER);

	/** Labels für die Ruestungsanzeige deklariert */
	private JLabel ruestungVoll = new JLabel(ICONRUESTUNGVOLL);
	private JLabel ruestungHalb = new JLabel(ICONRUESTUNGHALB);
	private JLabel ruestungWeg = new JLabel(ICONRUESTUNGWEG);

	/** Labels für die Goldanzeige deklariert */
	private JLabel gold0 = new JLabel(ICON0GOLD);
	private JLabel gold50 = new JLabel(ICON50GOLD);
	private JLabel gold100 = new JLabel(ICON100GOLD);
	private JLabel gold150 = new JLabel(ICON150GOLD);
	private JLabel gold200 = new JLabel(ICON200GOLD);
	private JLabel gold250 = new JLabel(ICON250GOLD);
	private JLabel gold300 = new JLabel(ICON300GOLD);
	private JLabel gold350 = new JLabel(ICON350GOLD);

	/** Labels für die Anzeige der aktuellen Waffe(n)deklariert */
	private JLabel keinEq = new JLabel(ICONKEINEQ);
	private JLabel schwert = new JLabel(ICONSCHWERT);
	private JLabel brille = new JLabel(ICONBRILLE);
	private JLabel hals = new JLabel(ICONHALS);
	private JLabel schwertHals = new JLabel(ICONSCHWERTHALS);
	private JLabel brilleSchwert = new JLabel(ICONBRILLESCHWERT);
	private JLabel brilleHals = new JLabel(ICONBRILLEHALS);
	private JLabel allesEq = new JLabel(ICONALLESEQ);

	/** Labels für die Anzeige der Leben deklariert */
	private JLabel herz1 = new JLabel(ICONHERZ1);
	private JLabel herz2 = new JLabel(ICONHERZ2);
	private JLabel herz3 = new JLabel(ICONHERZ3);

	/** Panel für Anzeigenleiste deklariert */
	private JPanel panelAnzeige = new JPanel();
	private JPanel panelSpielfeld = new JPanel();
	private JPanel panelButtons = new JPanel();

	/** Deklaration von Feldern */
	private Spiel spiel;
	private Musik musik;

	/** Deklaration eines Strings Datei */
	private String datei;

	/** Deklaration eines Buttons zum Speichern */
	private JButton save;
	private JButton load;

	String saveSpielfeld;

	/**
	 * Konstruktor, der die Eigenschaften des Spielfensters festsetzt. der
	 * Zeichner wird auf das Spielfenster gesetzt und der LevelManager wird
	 * aufgerufen. Das nächste (hier: erste) Level wird aufgerufen und der
	 * Zeichner zeichnet das entsprechende Spielfeld
	 * 
	 * @param y
	 *            Parameter für y-Position
	 * @param x
	 *            Paramter für x-Position
	 * @param titel
	 *            Parameter für Fenstertitel
	 * @throws Exception
	 *             wirft Exception
	 */
	public GameFrame(String titel, int x, int y) throws Exception {

		/* Fenster-Eigenschaften setzen. */
		this.setResizable(true);
		this.setTitle(titel);
		this.setSize(Konstanten.BREITE, Konstanten.HOEHE);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setFocusable(true);
		this.addKeyListener(this);
		this.setVisible(true);

		/* Fenster-Komponenten erzeugen. */
		Container contentPane = this.getContentPane();
		contentPane.setLayout(null);
		this.panelSpielfeld.setLayout(null);

		this.panelSpielfeld.setBounds(contentPane.getBounds().x,
				contentPane.getBounds().y, contentPane.getBounds().width,
				contentPane.getBounds().height
						- (contentPane.getBounds().height / Konstanten.PANEL));

		this.panelAnzeige.setBounds(contentPane.getBounds().x,
				contentPane.getBounds().y + contentPane.getBounds().height
						- (contentPane.getBounds().height / Konstanten.PANEL),
				contentPane.getBounds().width, contentPane.getBounds().height
						- (contentPane.getBounds().height / Konstanten.PANEL));

		this.panelButtons.setBounds(Konstanten.XBU, Konstanten.YBU,
				Konstanten.BREITEBU, Konstanten.HOEHEBU);

		getContentPane().add(panelSpielfeld);
		getContentPane().add(panelAnzeige);
		getContentPane().add(panelButtons);

		/* Spiel erzeugen. */
		spiel = new Spiel();
		chooseFile();
		if (datei == null) {
			return;
		}
		spiel.init(datei);

		setzeAnzeige();

		setzeLoadButton();
		setzeSaveButton();

		zeichnen(spiel.getAktuellesSpielfeld());

		this.requestFocus();

		musik = new Musik(Konstanten.DIRECTION + "/src/game/Sound/Wald.wav");
	}

	/**
	 * erzeugt FileChooser
	 * 
	 * @return f.isDirectory
	 */
	public String chooseFile() {
		/* erzeugt neuen FileChooser */
		JFileChooser fc = new JFileChooser(Konstanten.DIRECTION
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
			datei = file.getName();
			/* fängt die Varianten Error und Abbruch durch Nutzer ab */
		} else if (state == JFileChooser.CANCEL_OPTION) {
			JOptionPane.showMessageDialog(null, "Auswahl abgebrochen",
					"Dateiselektion", JOptionPane.INFORMATION_MESSAGE);
			dispose();
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

		this.panelSpielfeld.removeAll();

		for (int i = 0; i < Konstanten.SPALTEN; i++) {
			for (int j = 0; j < Konstanten.ZEILEN; j++) {

				GameObject object = spielfeld
						.gibObjekt(new java.awt.Point(i, j));

				/*
				 * eigener Debugger ;-)
				 * System.out.println(object.getClass().getSimpleName() + ":" +
				 * object.getPicture());
				 */
				Icon icon = new ImageIcon(object.getPicture());
				JLabel label = new JLabel(new ImageIcon(object.getPicture()));
				label.setBounds(i * Konstanten.SIZE, j * Konstanten.SIZE,
						icon.getIconWidth(), icon.getIconHeight());
				this.panelSpielfeld.add(label);
			}
		}

		aktualisieren();
	}

	/**
	 * aktualisiert die Informationsleiste
	 */
	public void aktualisieren() {

		this.revalidate();
		this.repaint();
	}

	/**
	 * fragt die benötigten Variablen ab und setzt die Informationsleiste im
	 * unteren Bereich des Spielfensters und spielt Musik ab
	 */
	public void setzeAnzeige() {

		panelAnzeige.removeAll();

		/* für die Levelanzeige */
		int level = 0;
		/* TODO int level = this.spiel.getSpielfeldNummer(); */
		if (level == Konstanten.RAUMEINS) {
			panelAnzeige.add(eins);
		} else if (level == Konstanten.RAUMZWEI) {
			panelAnzeige.add(eins);
		} else if (level == Konstanten.RAUMDREI) {
			panelAnzeige.add(eins);
		} else if (level == Konstanten.RAUMVIER) {
			panelAnzeige.add(zwei);
		} else if (level == Konstanten.RAUMFUENF) {
			panelAnzeige.add(zwei);
		} else if (level == Konstanten.RAUMSECHS) {
			panelAnzeige.add(zwei);
		} else if (level == Konstanten.RAUMSIEBEN) {
			panelAnzeige.add(drei);
		} else if (level == Konstanten.RAUMACHT) {
			panelAnzeige.add(drei);
		} else if (level == Konstanten.RAUMNEUN) {
			panelAnzeige.add(drei);
		}

		/* für die Healthanzeige */
		int health = spiel.getSpieler().getGesundheit();
		if (health == Konstanten.VOLLH) {
			panelAnzeige.add(lebenVoll);
		} else if (health == Konstanten.DREIVIERTELH) {
			panelAnzeige.add(lebenFast);
		} else if (health == Konstanten.HALBH) {
			panelAnzeige.add(lebenHalb);
		} else if (health == Konstanten.EINVIERTELH) {
			panelAnzeige.add(lebenWenig);
		}

		/* für die Manaanzeige */
		int mana = spiel.getSpieler().getMana();
		if (mana == Konstanten.VOLLM) {
			panelAnzeige.add(manaVoll);
		} else if (mana == Konstanten.HALBM) {
			panelAnzeige.add(manaHalb);
		} else if (mana == Konstanten.LEERM) {
			panelAnzeige.add(manaLeer);
		}

		/* für die Rüstungsanzeige */
		int ruestung = spiel.getSpieler().getRuestung();
		if (ruestung == Konstanten.VOLLR) {
			panelAnzeige.add(ruestungVoll);
		} else if (ruestung == Konstanten.HALBR) {
			panelAnzeige.add(ruestungHalb);
		} else if (ruestung == Konstanten.LEERR) {
			panelAnzeige.add(ruestungWeg);
		}

		/* für die Goldanzeige */
		int gold = spiel.getSpieler().getGold();
		if (gold == Konstanten.GOLD0) {
			panelAnzeige.add(gold0);
		} else if (gold == Konstanten.GOLD50) {
			panelAnzeige.add(gold50);
		} else if (gold == Konstanten.GOLD100) {
			panelAnzeige.add(gold100);
		} else if (gold == Konstanten.GOLD150) {
			panelAnzeige.add(gold150);
		} else if (gold == Konstanten.GOLD200) {
			panelAnzeige.add(gold200);
		} else if (gold == Konstanten.GOLD250) {
			panelAnzeige.add(gold250);
		} else if (gold == Konstanten.GOLD300) {
			panelAnzeige.add(gold300);
		} else if (gold == Konstanten.GOLD350) {
			panelAnzeige.add(gold350);
		}

		boolean bewaffnet = spiel.getSpieler().getBewaffnet();
		boolean beschwertet = spiel.getSpieler().getBeschwertet();
		boolean halsband = spiel.getSpieler().getHalsband();
		if (!bewaffnet) {
			if (!beschwertet) {
				if (!halsband) {
					panelAnzeige.add(keinEq);
				} else if (halsband) {
					panelAnzeige.add(hals);
				}
			} else if (beschwertet) {
				if (!halsband) {
					panelAnzeige.add(schwert);
				} else if (halsband) {
					panelAnzeige.add(schwertHals);
				}
			}
		} else if (bewaffnet) {
			if (!beschwertet) {
				if (!halsband) {
					panelAnzeige.add(brille);
				} else if (halsband) {
					panelAnzeige.add(brilleHals);
				}
			} else if (beschwertet) {
				if (!halsband) {
					panelAnzeige.add(brilleSchwert);
				} else if (halsband) {
					panelAnzeige.add(allesEq);
				}
			}
		}

		/* für die Lebenanzeige */
		int leben = spiel.getSpieler().getLeben();
		if (leben == Konstanten.DREILEBEN) {
			panelAnzeige.add(herz3);
		} else if (leben == Konstanten.ZWEILEBEN) {
			panelAnzeige.add(herz2);
		} else if (leben == Konstanten.EINLEBEN) {
			panelAnzeige.add(herz1);
		}

		aktualisieren();
	}

	/** setzt einen Laden Button auf das GameFrame */
	public void setzeLoadButton() {

		load = new JButton("Laden");
		load.setVisible(true);

		ActionListener alsave = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new GameFrame("Erna's Adventure", Konstanten.XGF,
							Konstanten.YGF);
					dispose();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		};

		load.addActionListener(alsave);
		panelButtons.add(load);
	}

	/** setzt einen Speichern Button auf das GameFrame */
	public void setzeSaveButton() {
		save = new JButton("Speichern");
		save.setVisible(true);

		ActionListener alsave = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getSave();
				try {
					PrintWriter pWriter = new PrintWriter(new FileWriter(
							Konstanten.DIRECTION
									+ "/src/game/Szenario/gespeichert.txt"));

					pWriter.println(saveSpielfeld);
					pWriter.flush();
				} catch (IOException ioe) {
					ioe.printStackTrace();
				}

			}
		};

		save.addActionListener(alsave);
		save.setBounds(Konstanten.XSAVE, Konstanten.YSAVE,
				Konstanten.BREITESAVE, Konstanten.HOEHESAVE);
		panelButtons.add(save);
	}

	/**
	 * übergibt String mit Buchstaben des aktuellen Spielfelds
	 * 
	 * @return saveSpielfeld
	 */
	public String getSave() {
		Spielfeld spielfeld = spiel.getAktuellesSpielfeld();

		int health = spiel.getSpieler().getGesundheit();
		int gold = spiel.getSpieler().getGold();
		int mana = spiel.getSpieler().getMana();
		boolean brille = spiel.getSpieler().getBewaffnet();
		boolean schwert = spiel.getSpieler().getBeschwertet();
		boolean halsband = spiel.getSpieler().getHalsband();
		int leben = spiel.getSpieler().getLeben();

		saveSpielfeld = saveSpielfeld + Konstanten.ZEILENUMBRUCH + health
				+ Konstanten.ZEILENUMBRUCH + gold + Konstanten.ZEILENUMBRUCH
				+ mana + Konstanten.ZEILENUMBRUCH + leben
				+ Konstanten.ZEILENUMBRUCH + brille + Konstanten.ZEILENUMBRUCH
				+ schwert + Konstanten.ZEILENUMBRUCH + halsband
				+ Konstanten.ZEILENUMBRUCH;

		for (int i = 0; i < Konstanten.SPALTEN; i++) {
			for (int j = 0; j < Konstanten.ZEILEN; j++) {
				Point position = new Point(i, j);
				GameObject teste = spielfeld.gibObjekt(position);

				if (teste instanceof Rasen) {
					saveSpielfeld = saveSpielfeld + " ";
				} else if (teste instanceof Grenze) {
					saveSpielfeld = saveSpielfeld + "#";
				} else if (teste instanceof Spieler) {
					saveSpielfeld = saveSpielfeld + "P";
				} else if (teste instanceof Gegner) {
					saveSpielfeld = saveSpielfeld + "G";
				} else if (teste instanceof Falle) {
					saveSpielfeld = saveSpielfeld + "U";
				} else if (teste instanceof Weiter) {
					saveSpielfeld = saveSpielfeld + "W";
				} else if (teste instanceof Zurueck) {
					saveSpielfeld = saveSpielfeld + "Z";
				} else if (teste instanceof Carlos) {
					saveSpielfeld = saveSpielfeld + "C";
				} else if (teste instanceof Ziel) {
					saveSpielfeld = saveSpielfeld + "F";
				} else if (teste instanceof Huette) {
					saveSpielfeld = saveSpielfeld + "E";
				} else if (teste instanceof Brille) {
					saveSpielfeld = saveSpielfeld + "S";
				} else if (teste instanceof Gold) {
					saveSpielfeld = saveSpielfeld + "O";
				} else if (teste instanceof Mana) {
					saveSpielfeld = saveSpielfeld + "M";
				} else if (teste instanceof Health) {
					saveSpielfeld = saveSpielfeld + "H";
				} else if (teste instanceof Ruestung) {
					saveSpielfeld = saveSpielfeld + "R";
				} else if (teste instanceof Checkpoint) {
					saveSpielfeld = saveSpielfeld + "C";
				} else if (teste instanceof Schwert) {
					saveSpielfeld = saveSpielfeld + "ß";
				} else if (teste instanceof Shopmana) {
					saveSpielfeld = saveSpielfeld + "A";
				} else if (teste instanceof Shophealth) {
					saveSpielfeld = saveSpielfeld + "Q";
				} else if (teste instanceof Shopruestung) {
					saveSpielfeld = saveSpielfeld + "Ü";
				} else if (teste instanceof Bossgegner) {
					saveSpielfeld = saveSpielfeld + "B";
				} else if (teste instanceof Luke) {
					saveSpielfeld = saveSpielfeld + "L";
				} else if (teste instanceof SchalterZu) {
					saveSpielfeld = saveSpielfeld + "&";
				} else if (teste instanceof SchalterAuf) {
					saveSpielfeld = saveSpielfeld + "#";
				} else if (teste instanceof Barriere) {
					saveSpielfeld = saveSpielfeld + "I";
				}
			}
			saveSpielfeld = saveSpielfeld + "\n";
		}
		System.out.println(saveSpielfeld);
		return saveSpielfeld;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// nothing to do here
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		this.spiel.aktion(arg0.getKeyCode());
		aktualisieren();
		this.zeichnen(this.spiel.getAktuellesSpielfeld());
		this.setzeAnzeige();
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
	}

}