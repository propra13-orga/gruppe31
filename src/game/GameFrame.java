package game;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * GameFrame erzeugt das Menufenster. Den Werten im Array werden die
 * entsprechenden Bilder zugeordnet. Der KeyListener fragt die Werte der
 * umliegenden Felder ab und führt das Programm entsprechend weiter.
 */
public class GameFrame extends JFrame implements KeyListener {

	private static final String direction = System.getProperty("user.dir");

	Carlos carlos;

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

	/* Platzhalter für Marcel */

	private static final Icon iconAnzeige = new ImageIcon(direction
			+ "/src/game/Images/Anzeige.jpg");

	private JLabel Anzeige = new JLabel(iconAnzeige);

	private Panel Wald = new Panel();
	private Panel Leiste = new Panel();

	private JButton GVschliessen;

	/* Variabeln für die neue und alte Position der Spielfigur */
	private int Spielfigurx;
	private int altx;
	private int Spielfigury;
	private int alty;

	private int aktuellesSpielfeld[][] = new int[16][12];
	private int level;

	/* ein Array von Levels */
	private static final int[][][] LEVELS = {
			{
					{ GRENZE, GRENZE, GRENZE, GRENZE, GRENZE, GRENZE, GRENZE,
							GRENZE },
					{ GRENZE, RASEN, RASEN, RASEN, RASEN, RASEN, CARLOS, GRENZE },
					{ GRENZE, PUDEL, RASEN, WAFFE, RASEN, RASEN, RASEN, GRENZE },
					{ GRENZE, RASEN, RASEN, RASEN, RASEN, MANA, RASEN, GRENZE },
					{ GRENZE, RASEN, HEALTH, RASEN, RASEN, RASEN, RASEN, WEITER },
					{ GRENZE, GRENZE, GRENZE, GRENZE, GRENZE, GRENZE, GRENZE,
							GRENZE } },

			{
					{ GRENZE, GRENZE, GRENZE, GRENZE, GRENZE, GRENZE, GRENZE,
							GRENZE },
					{ GRENZE, RASEN, RASEN, RASEN, RASEN, RASEN, GEGNER, GRENZE },
					{ ZURUECK, PUDEL, GRENZE, RASEN, GRENZE, GRENZE, GRENZE,
							GRENZE },
					{ GRENZE, GRENZE, GRENZE, RASEN, RASEN, RASEN, RASEN,
							GRENZE },
					{ GRENZE, WAFFE, RASEN, RASEN, GRENZE, RASEN, RASEN, WEITER },
					{ GRENZE, GRENZE, GRENZE, GRENZE, GRENZE, GRENZE, GRENZE,
							GRENZE } },

			{
					{ GRENZE, GRENZE, GRENZE, GRENZE, GRENZE, GRENZE, GRENZE,
							GRENZE },
					{ GRENZE, RASEN, GEGNER, RASEN, RASEN, RASEN, RASEN, GRENZE },
					{ GRENZE, RASEN, RASEN, RASEN, GRENZE, RASEN, RASEN, BOSS },
					{ GRENZE, GRENZE, GRENZE, RASEN, GRENZE, RASEN, RASEN,
							GRENZE },
					{ ZURUECK, PUDEL, RASEN, RASEN, GRENZE, RASEN, GEGNER,
							GRENZE },
					{ GRENZE, GRENZE, GRENZE, GRENZE, GRENZE, GRENZE, GRENZE,
							GRENZE } } };

	/**
	 * Konstruktor, der die Eigenschaften des Spielfensters festsetzt und die
	 * beiden Bereiche des Fensters setzt
	 */
	public GameFrame() {
		this.setResizable(false);
		this.setTitle("Erna's Adventure");
		this.setSize(800, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

		/*
		 * setzt den Anfangswert der Level auf -1, um im Levelarray bei 0
		 * starten zu können und ruft das nächste (hier: erste) Level auf
		 */
		level = -1;
		NextLevel();

		setzeAnzeige();

		getContentPane().add(Leiste, BorderLayout.SOUTH);
	}

	/* hier arbeitet Marcel */
	public void setzeAnzeige() {
		Leiste.add(Anzeige);
	}

	/**
	 * allgemeine Methode zum Erzeugen der Level mit Zurodnung der Bilder,
	 * KeyListener wird auf das richtige Panel gesetzt
	 * 
	 * @param feld
	 */
	public void Levelaufruf(int[][] feld) {

		Wald = new Panel();
		Wald.setLayout(null);
		Wald.setFocusable(true);
		Wald.addKeyListener(this);

		/* erstellt so viele Labels, wie für Array benötigt */
		JLabel[] labels = new JLabel[48];

		for (int i = 0; i < feld.length; i++) {
			for (int j = 0; j < feld[i].length; j++) {

				if (feld[i][j] == RASEN) {
					labels[i] = new JLabel(iconRasen);
					Wald.add(labels[i]);
					labels[i].setBounds(j * 100, i * 100, 100, 100);
				} else if (feld[i][j] == GRENZE) {
					labels[i] = new JLabel(iconBaum);
					labels[i].setBounds(j * 100, i * 100, 100, 100);
					Wald.add(labels[i]);
				} else if (feld[i][j] == PUDEL) {
					/* hält die Position der Spielfigur fest */
					Spielfigury = i;
					altx = i;
					Spielfigurx = j;
					alty = j;
					if (bewaffnet == 1) {
						labels[i] = new JLabel(iconAggroErna);
						labels[i].setBounds(j * 100, i * 100, 100, 100);
						Wald.add(labels[i]);
					} else if (bewaffnet == 0) {
						labels[i] = new JLabel(iconPudel);
						labels[i].setBounds(j * 100, i * 100, 100, 100);
						Wald.add(labels[i]);
					}
				} else if (feld[i][j] == GEGNER) {
					labels[i] = new JLabel(iconGegner);
					labels[i].setBounds(j * 100, i * 100, 100, 100);
					Wald.add(labels[i]);
				} else if (feld[i][j] == WEITER) {
					labels[i] = new JLabel(iconWeiter);
					labels[i].setBounds(j * 100, i * 100, 100, 100);
					Wald.add(labels[i]);
				} else if (feld[i][j] == BOSS) {
					labels[i] = new JLabel(iconBoss);
					labels[i].setBounds(j * 100, i * 100, 100, 100);
					Wald.add(labels[i]);
				} else if (feld[i][j] == ZURUECK) {
					labels[i] = new JLabel(iconZurueck);
					labels[i].setBounds(j * 100, i * 100, 100, 100);
					Wald.add(labels[i]);
				} else if (feld[i][j] == CARLOS) {
					labels[i] = new JLabel(iconCarlos);
					labels[i].setBounds(j * 100, i * 100, 100, 100);
					Wald.add(labels[i]);
				} else if (feld[i][j] == WAFFE) {
					labels[i] = new JLabel(iconWaffe);
					labels[i].setBounds(j * 100, i * 100, 100, 100);
					Wald.add(labels[i]);
				} else if (feld[i][j] == GOLD) {
					labels[i] = new JLabel(iconGold);
					labels[i].setBounds(j * 100, i * 100, 100, 100);
					Wald.add(labels[i]);
				} else if (feld[i][j] == MANA) {
					labels[i] = new JLabel(iconMana);
					labels[i].setBounds(j * 100, i * 100, 100, 100);
					Wald.add(labels[i]);
				} else if (feld[i][j] == RUESTUNG) {
					labels[i] = new JLabel(iconRuestung);
					labels[i].setBounds(j * 100, i * 100, 100, 100);
					Wald.add(labels[i]);
				} else if (feld[i][j] == HEALTH) {
					labels[i] = new JLabel(iconHealth);
					labels[i].setBounds(j * 100, i * 100, 100, 100);
					Wald.add(labels[i]);
				}
				getContentPane().removeAll();
				getContentPane().add(Wald, BorderLayout.CENTER);
				getContentPane().add(Leiste, BorderLayout.SOUTH);

				/* Fokus wird wieder auf das Panel Wald gesetzt */
				Wald.requestFocus();
			}
		}
	}

	/**
	 * hier wird die Grafik des Spielfensters erneut aufgerufen
	 */
	protected void LevelAktualisieren() {
		validate();
		repaint();
	}

	/**
	 * die Variabel level zählt hoch, um in das nächste Level zugelangen das
	 * Spielfeld wird erneut durchlaufen und setzt das aktuelle Spielfeld = dem
	 * geänderten
	 * 
	 * Argumentübergabe (true/false?)
	 */
	protected void NextLevel() {
		level++;
		int[][] reference = LEVELS[level];
		aktuellesSpielfeld = new int[reference.length][reference[0].length];
		for (int x = 0; x < reference.length; x++) {
			for (int y = 0; y < reference[0].length; y++) {
				aktuellesSpielfeld[x][y] = reference[x][y];
			}
		}
		Levelaufruf(aktuellesSpielfeld);
		LevelAktualisieren();
	}

	/**
	 * die Variabel level zählt runter, um in das letzte Level zu gelangen
	 */
	protected void LastLevel() {
		level--;
		int[][] reference = LEVELS[level];
		aktuellesSpielfeld = new int[reference.length][reference[0].length];
		for (int x = 0; x < reference.length; x++) {
			for (int y = 0; y < reference[0].length; y++) {
				aktuellesSpielfeld[x][y] = reference[x][y];
			}
		}
		Levelaufruf(aktuellesSpielfeld);
		LevelAktualisieren();
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
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
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
			NextLevel();
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
		}
	}

	public void keyReleased(KeyEvent e) {
		// nothing to do here
	}

	public void keyTyped(KeyEvent e) {
		// nothing to do here
	}

}