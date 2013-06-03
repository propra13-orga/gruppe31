package game;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.io.*;
import javax.imageio.*;

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

	/* erstellt Bildericons für das Spielfeld */
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

	/* Platzhalter für Marcel */
	private static final Icon iconAnzeige = new ImageIcon(direction
			+ "/src/game/Images/Anzeige.jpg");
	private JLabel Anzeige = new JLabel(iconAnzeige);

	private JButton schliessen;

	private Panel Wald = new Panel();
	private Panel Leiste = new Panel();

	/* Variabeln für die Position der Spielfigur */
	int Spielfigurx;
	int Spielfigury;

	/* deklariert das aktuelle Spielfeld */
	int[][] aktuellesSpielfeld;
	/* deklariert eine Variabel für das aktuelle Level */
	int level;

	/* ein Array von Levels */
	private static final int[][][] LEVELS = {
			{
					{ GRENZE, GRENZE, GRENZE, GRENZE, GRENZE, GRENZE, GRENZE,
							GRENZE },
					{ GRENZE, PUDEL, RASEN, GRENZE, RASEN, RASEN, RASEN, GRENZE },
					{ GRENZE, RASEN, RASEN, GRENZE, RASEN, RASEN, RASEN, WEITER },
					{ GRENZE, RASEN, RASEN, RASEN, RASEN, RASEN, RASEN, GRENZE },
					{ GRENZE, RASEN, RASEN, GRENZE, RASEN, RASEN, CARLOS,
							GRENZE },
					{ GRENZE, GRENZE, GRENZE, GRENZE, GRENZE, GRENZE, GRENZE,
							GRENZE } },

			{
					{ GRENZE, GRENZE, GRENZE, GRENZE, GRENZE, GRENZE, GRENZE,
							GRENZE },
					{ GRENZE, RASEN, RASEN, RASEN, RASEN, RASEN, RASEN, GRENZE },
					{ ZURUECK, PUDEL, GRENZE, RASEN, GRENZE, GRENZE, GRENZE,
							GRENZE },
					{ GRENZE, GRENZE, GRENZE, RASEN, RASEN, RASEN, RASEN,
							GRENZE },
					{ GRENZE, RASEN, RASEN, RASEN, GRENZE, RASEN, RASEN, WEITER },
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
	 * Konstruktor, der die Eigenschaften des Spielfensters aufruft und den
	 * KeyListener darauf setzt
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
	 * allgemeine Methode zum Erzeugen der Level mit Zurodnung der Bilder
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

		/* geht das gesamte Array durch */
		for (int i = 0; i < feld.length; i++) {
			for (int j = 0; j < feld[i].length; j++) {

				/* fügt dem jeweiligen Wert das passende Icon (=Bild) hinzu */
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
					Spielfigurx = i;
					Spielfigury = j;
					labels[i] = new JLabel(iconPudel);
					labels[i].setBounds(j * 100, i * 100, 100, 100);
					Wald.add(labels[i]);
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
				}
				getContentPane().removeAll();
				/* setzt das Panel mit Bildern auf das Spielfenster */
				getContentPane().add(Wald, BorderLayout.CENTER);
				getContentPane().add(Leiste, BorderLayout.SOUTH);

				Wald.requestFocus();

			}
		}
	}

	/**
	 * das Gewonnenfenster wird erzeugt
	 */
	public void Gewonnen() {

		try {
			this.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File(
					direction + "/src/game/Images/Gewonnen.jpg")))));
		} catch (IOException a) {
			System.out.println("das Bild kann nicht gefunden werden");
		}

		this.setResizable(false);
		this.setSize(800, 600);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

		schliessen = new JButton("Dieses Fenster schließen");
		schliessen.setBounds(550, 450, 200, 40);
		this.add(schliessen);

		/* der Button schliessen schließt das aktuelle Fenster */
		ActionListener alschliessen = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		};
		schliessen.addActionListener(alschliessen);
	}

	/**
	 * das Verlorenfenster wird erzeugt
	 */
	public void Verloren() {

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

		/*
		 * der Button schliessen bewirkt ein Verschwinden des Fensters, sodass
		 * das Menufenster zu sehen ist
		 */
		schliessen = new JButton("Dieses Fenster schließen");
		schliessen.setBounds(550, 450, 200, 40);
		this.add(schliessen);

		ActionListener alschliessen = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		};
		schliessen.addActionListener(alschliessen);
	}

	/**
	 * hier wird die Grafik des Spielfensters erneut gezeichnet
	 */
	protected void LevelAktualisieren() {
		validate();
		repaint();
	}

	/**
	 * die Variabel level zählt hoch, um in das nächste Level zugelangen das
	 * Spielfeld wird erneut durchlaufen und setzt das aktuelle Spielfeld = dem
	 * geänderten
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
		/* das neue aktuelle Level wird aufgerufen und erzeugt */
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
		/* das neue aktuelle Level wird aufgerufen und erzeugt */
		Levelaufruf(aktuellesSpielfeld);
		LevelAktualisieren();
	}

	/**
	 * der KeyListener, der regiert, während die Taste gedrückt wird
	 */
	public void keyPressed(KeyEvent e) {
		/* fragt die KeyEvents ab und führt das Programm entsprechend weiter */
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			/*
			 * wenn der Wert des abgefragten Feldes GEGNER ist, erscheint das
			 * Verlorenfenster
			 */
			if (aktuellesSpielfeld[Spielfigurx][Spielfigury - 1] == GEGNER) {
				Verloren();
			}
			/*
			 * wenn der Wert des abgefragten Feldes WEITER ist, erscheint das
			 * nächste Level
			 */
			else if (aktuellesSpielfeld[Spielfigurx][Spielfigury - 1] == WEITER) {
				NextLevel();
			}
			/*
			 * wenn der Wert des abgefragten Feldes BOSS ist, erscheint das
			 * Gewonnenfenster
			 */
			else if (aktuellesSpielfeld[Spielfigurx][Spielfigury - 1] == BOSS) {
				Verloren();
			}
			/*
			 * wenn der Wert des abgefragten Feldes ZURUECK ist, erscheint das
			 * nächste Level
			 */
			else if (aktuellesSpielfeld[Spielfigurx][Spielfigury - 1] == ZURUECK) {
				LastLevel();
				/*
				 * wenn der Wert des abgefragten Feldes CARLOS entspricht, wird
				 * die Methode Carlos aufgerufen
				 */
			} else if (aktuellesSpielfeld[Spielfigurx][Spielfigury - 1] == CARLOS) {
				carlos = new Carlos();
			}
			/*
			 * wenn der Wert des abgefragten Feldes RASEN ist, wird das aktuelle
			 * Feld der Spielfigur auf 0 gesetzt
			 */
			else if (aktuellesSpielfeld[Spielfigurx][Spielfigury - 1] == RASEN) {
				aktuellesSpielfeld[Spielfigurx][Spielfigury] = RASEN;
				/* die x-Position zählt einen runter */
				Spielfigury--;
				/* die neue Position der Spielfigur erhält den Wert 2 */
				aktuellesSpielfeld[Spielfigurx][Spielfigury] = PUDEL;
				/* und das Leve wird erneut aufgerufen */
				Levelaufruf(aktuellesSpielfeld);
				LevelAktualisieren();
			}
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if (aktuellesSpielfeld[Spielfigurx][Spielfigury + 1] == GEGNER) {
				Verloren();
			} else if (aktuellesSpielfeld[Spielfigurx][Spielfigury + 1] == WEITER) {
				NextLevel();
			} else if (aktuellesSpielfeld[Spielfigurx][Spielfigury + 1] == BOSS) {
				Verloren();
			} else if (aktuellesSpielfeld[Spielfigurx][Spielfigury + 1] == ZURUECK) {
				LastLevel();
			} else if (aktuellesSpielfeld[Spielfigurx][Spielfigury + 1] == CARLOS) {
				carlos = new Carlos();
			} else if (aktuellesSpielfeld[Spielfigurx][Spielfigury + 1] == RASEN) {
				aktuellesSpielfeld[Spielfigurx][Spielfigury] = RASEN;
				Spielfigury++;
				aktuellesSpielfeld[Spielfigurx][Spielfigury] = PUDEL;
				Levelaufruf(aktuellesSpielfeld);
				LevelAktualisieren();
			}
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			if (aktuellesSpielfeld[Spielfigurx - 1][Spielfigury] == GEGNER) {
				Verloren();
			} else if (aktuellesSpielfeld[Spielfigurx - 1][Spielfigury] == WEITER) {
				NextLevel();
			} else if (aktuellesSpielfeld[Spielfigurx - 1][Spielfigury] == BOSS) {
				Verloren();
			} else if (aktuellesSpielfeld[Spielfigurx - 1][Spielfigury] == ZURUECK) {
				LastLevel();
			} else if (aktuellesSpielfeld[Spielfigurx - 1][Spielfigury] == CARLOS) {
				carlos = new Carlos();
			} else if (aktuellesSpielfeld[Spielfigurx - 1][Spielfigury] == RASEN) {
				aktuellesSpielfeld[Spielfigurx][Spielfigury] = RASEN;
				Spielfigurx--;
				aktuellesSpielfeld[Spielfigurx][Spielfigury] = PUDEL;
				Levelaufruf(aktuellesSpielfeld);
				LevelAktualisieren();
			}
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			if (aktuellesSpielfeld[Spielfigurx + 1][Spielfigury] == GEGNER) {
				Verloren();
			} else if (aktuellesSpielfeld[Spielfigurx + 1][Spielfigury] == WEITER) {
				NextLevel();
			} else if (aktuellesSpielfeld[Spielfigurx + 1][Spielfigury] == BOSS) {
				Verloren();
			} else if (aktuellesSpielfeld[Spielfigurx + 1][Spielfigury] == ZURUECK) {
				LastLevel();
			} else if (aktuellesSpielfeld[Spielfigurx + 1][Spielfigury] == CARLOS) {
				carlos = new Carlos();
			} else if (aktuellesSpielfeld[Spielfigurx + 1][Spielfigury] == RASEN) {
				aktuellesSpielfeld[Spielfigurx][Spielfigury] = RASEN;
				Spielfigurx++;
				aktuellesSpielfeld[Spielfigurx][Spielfigury] = PUDEL;
				Levelaufruf(aktuellesSpielfeld);
				LevelAktualisieren();
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
