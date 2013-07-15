package game;

import java.awt.BorderLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

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
	private Panel leiste = new Panel();

	/** Button wird für Gewonnen- und Verlorenfenster deklariert */
	private JButton gvschliessen;

	/** Deklaration von Feldern */
	private Spiel spiel;
	private Musik musik;

	/** Deklaration eines Strings Datei */
	private String datei;

	/** Deklaration eines Strings für Exception im Gewonnen- und Verlorenfenster */
	private String exception = "Das Bild kann nicht gefunden werden ";

	/** Deklaration eines Strings für das Schließen */
	private String schliessen = "Dieses Fenster schließen";

	/** Deklaration eines Buttons zum Speichern */
	private JButton save;

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
		this.setResizable(true);
		this.setTitle(titel);
		this.setLocation(x, y);
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
				/* eigener Debugger ;-)*/
				 System.out.println(object.getClass().getSimpleName() + ":" +
				 object.getPicture());
				 

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
	 * unteren Bereich des Spielfensters und spielt Musik ab
	 */
	public void setzeAnzeige() {

		leiste.removeAll();

		/* für die Levelanzeige */
		int level = 0;
		if (level == Konstanten.RAUMEINS) {
			leiste.add(eins);
		} else if (level == Konstanten.RAUMZWEI) {
			leiste.add(eins);
		} else if (level == Konstanten.RAUMDREI) {
			leiste.add(eins);
		} else if (level == Konstanten.RAUMVIER) {
			leiste.add(zwei);
		} else if (level == Konstanten.RAUMFUENF) {
			leiste.add(zwei);
		} else if (level == Konstanten.RAUMSECHS) {
			leiste.add(zwei);
		} else if (level == Konstanten.RAUMSIEBEN) {
			leiste.add(drei);
		} else if (level == Konstanten.RAUMACHT) {
			leiste.add(drei);
		} else if (level == Konstanten.RAUMNEUN) {
			leiste.add(drei);
		}
		aktualisieren();

		/* für die Healthanzeige */
		int health = spiel.getSpieler().getGesundheit();
		if (health == Konstanten.VOLLH) {
			leiste.add(lebenVoll);
		} else if (health == Konstanten.DREIVIERTELH) {
			leiste.add(lebenFast);
		} else if (health == Konstanten.HALBH) {
			leiste.add(lebenHalb);
		} else if (health == Konstanten.EINVIERTELH) {
			leiste.add(lebenWenig);
		}
		aktualisieren();

		/* für die Manaanzeige */
		int mana = spiel.getSpieler().getMana();
		if (mana == Konstanten.VOLLM) {
			leiste.add(manaVoll);
		} else if (mana == Konstanten.HALBM) {
			leiste.add(manaHalb);
		} else if (mana == Konstanten.LEERM) {
			leiste.add(manaLeer);
		}

		/* für die Rüstungsanzeige */
		int ruestung = spiel.getSpieler().getRuestung();
		if (ruestung == Konstanten.VOLLR) {
			leiste.add(ruestungVoll);
		} else if (ruestung == Konstanten.HALBR) {
			leiste.add(ruestungHalb);
		} else if (ruestung == Konstanten.LEERR) {
			leiste.add(ruestungWeg);
		}
		aktualisieren();

		/* für die Goldanzeige */
		int gold = spiel.getSpieler().getGold();
		if (gold == Konstanten.GOLD0) {
			leiste.add(gold0);
		} else if (gold == Konstanten.GOLD50) {
			leiste.add(gold50);
		} else if (gold == Konstanten.GOLD100) {
			leiste.add(gold100);
		} else if (gold == Konstanten.GOLD150) {
			leiste.add(gold150);
		} else if (gold == Konstanten.GOLD200) {
			leiste.add(gold200);
		} else if (gold == Konstanten.GOLD250) {
			leiste.add(gold250);
		} else if (gold == Konstanten.GOLD300) {
			leiste.add(gold300);
		} else if (gold == Konstanten.GOLD350) {
			leiste.add(gold350);
		}
		aktualisieren();

		boolean bewaffnet = spiel.getSpieler().getBewaffnet();
		boolean beschwertet = spiel.getSpieler().getBeschwertet();
		boolean halsband = spiel.getSpieler().getHalsband();
		if (!bewaffnet) {
			if (!beschwertet) {
				if (!halsband) {
					leiste.add(keinEq);
				} else if (halsband) {
					leiste.add(hals);
				}
			} else if (beschwertet) {
				if (!halsband) {
					leiste.add(schwert);
				} else if (halsband) {
					leiste.add(schwertHals);
				}
			}
		} else if (bewaffnet) {
			if (!beschwertet) {
				if (!halsband) {
					leiste.add(brille);
				} else if (halsband) {
					leiste.add(brilleHals);
				}
			} else if (beschwertet) {
				if (!halsband) {
					leiste.add(brilleSchwert);
				} else if (halsband) {
					leiste.add(allesEq);
				}
			}
		}
		aktualisieren();

		/* für die Lebenanzeige */
		int leben = Konstanten.VOLLL;
		if (leben == Konstanten.VOLLL) {
			leiste.add(herz3);
		} else if (leben == Konstanten.ZWEIDRITTELL) {
			leiste.add(herz2);
		} else if (leben == Konstanten.EINDRITTELL) {
			leiste.add(herz1);
		}
		aktualisieren();

		setzeLoadButton();
		setzeSaveButton();
	}

	/** setzt einen Laden Button auf das GameFrame */
	public void setzeLoadButton() {
		save = new JButton("Laden");

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

		save.addActionListener(alsave);
		save.setBounds(Konstanten.XLOAD, Konstanten.YLOAD,
				Konstanten.BREITELOAD, Konstanten.HOEHELOAD);
		this.add(save);
	}

	/** setzt einen Speichern Button auf das GameFrame */
	public void setzeSaveButton() {
		save = new JButton("Speichern");

		ActionListener alsave = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					PrintWriter pWriter = new PrintWriter(new FileWriter(
							Konstanten.DIRECTION
									+ "/src/game/Szenario/test.txt"));
					pWriter.println("Ernas Adventure möchte gespeichert werden !");
					pWriter.flush();
				} catch (IOException ioe) {
					ioe.printStackTrace();
				}
			}
		};

		save.addActionListener(alsave);
		save.setBounds(Konstanten.XSAVE, Konstanten.YSAVE,
				Konstanten.BREITESAVE, Konstanten.HOEHESAVE);
		this.add(save);
	}

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
		gvschliessen.setBounds(Konstanten.XGV, Konstanten.YGV,
				Konstanten.BREITEGV, Konstanten.HOEHEGV);
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
		gvschliessen.setBounds(Konstanten.XGV, Konstanten.YGV,
				Konstanten.BREITEGV, Konstanten.HOEHEGV);
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