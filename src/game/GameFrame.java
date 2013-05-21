package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * diese Klasse erzeugt das Spielfenster. Den Werten im Array werden die
 * entsprechenden Bilder zugeordnet. Der KeyListener fragt die Werte der
 * umliegenden Felder ab und führt das Programm entsprechend weiter.
 */
public class GameFrame extends JFrame implements KeyListener {

	static String direction = System.getProperty("user.dir");

	private static int RASEN = 0;
	private static int GRENZE = 1;
	private static int PUDEL = 2;
	private static int GEGNER = 3;
	private static int WEITER = 4;
	private static int ZIEL = 5;
	private static int ZURUECK = 6;

	/* erstellt Icons und weist ihnen Bilder zu */
	static Icon iconRasen = new ImageIcon(direction
			+ "/src/game/Images/Rasen.jpg");
	static Icon iconGrenze = new ImageIcon(direction
			+ "/src/game/Images/Grenze.jpg");
	static Icon iconPudel = new ImageIcon(direction
			+ "/src/game/Images/Pudel.jpg");
	static Icon iconGegner = new ImageIcon(direction
			+ "/src/game/Images/Gegner.jpg");
	static Icon iconWeiter = new ImageIcon(direction
			+ "/src/game/Images/Weiter.jpg");
	static Icon iconZiel = new ImageIcon(direction
			+ "/src/game/Images/Ziel.jpg");
	static Icon iconZurueck = new ImageIcon(direction
			+ "/src/game/Images/Zurueck.jpg");

	public JButton schliessen;

	/* Variabeln für die Position der Spielfigur */
	int Spielfigurx;
	int Spielfigury;

	/* deklariert das aktuelle Spielfeld */
	int[][] aktuellesSpielfeld;
	/* deklariert eine Variabel für das aktuelle Level */
	int level;

	/* ein Array von Levels */
	private static final int[][][] LEVELS = {
			{ { 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 2, 0, 1, 0, 0, 0, 1 },
					{ 1, 0, 0, 1, 0, 0, 0, 4 }, { 1, 0, 0, 0, 0, 0, 0, 1 },
					{ 1, 0, 0, 1, 0, 0, 0, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1 } },

			{ { 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 0, 0, 0, 0, 0, 0, 1 },
					{ 6, 2, 1, 0, 1, 1, 1, 1 }, { 1, 1, 1, 0, 0, 0, 0, 1 },
					{ 1, 0, 0, 0, 1, 0, 0, 4 }, { 1, 1, 1, 1, 1, 1, 1, 1 } },

			{ { 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 0, 3, 0, 0, 0, 0, 1 },
					{ 1, 0, 0, 0, 1, 0, 0, 5 }, { 1, 1, 1, 0, 1, 0, 0, 1 },
					{ 6, 2, 0, 0, 1, 0, 3, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1 } } };

	/**
	 * Konstruktor, der die Eigenschaften des Spielfensters aufruft und den
	 * KeyListener darauf setzt
	 */
	public GameFrame() {
		addKeyListener(this);
		this.setResizable(false);
		this.setTitle("Erna's Adventure");
		this.setSize(800, 630);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setLayout(null);

		/*
		 * setzt den Anfangswert der Level auf -1, um im Levelarray bei 0
		 * starten zu können und ruft das nächste (hier: erste) Level auf
		 */
		level = -1;
		NextLevel();
	}

	/**
	 * allgemeine Methode zum Erzeugen der Level mit Zurodnung der Bilder
	 * 
	 * @param feld
	 */
	public void Levelaufruf(int[][] feld) {
		/* erzeugt Panel um darauf arbeiten zu können */
		JPanel panel = new JPanel();
		panel.setLayout(null);

		/* erstellt so viele Labels, wie für Array benötigt */
		JLabel[] labels = new JLabel[48];

		/* geht das gesamte Array durch */
		for (int i = 0; i < feld.length; i++) {
			for (int j = 0; j < feld[i].length; j++) {

				/* fügt dem jeweiligen Wert das passende Icon (=Bild) hinzu */
				if (feld[i][j] == RASEN) {
					labels[i] = new JLabel(iconRasen);
					panel.add(labels[i]);
					labels[i].setBounds(j * 100, i * 100, 100, 100);
				} else if (feld[i][j] == GRENZE) {
					labels[i] = new JLabel(iconGrenze);
					labels[i].setBounds(j * 100, i * 100, 100, 100);
					panel.add(labels[i]);
				} else if (feld[i][j] == PUDEL) {
					/* hält die Position der Spielfigur fest */
					Spielfigurx = i;
					Spielfigury = j;
					labels[i] = new JLabel(iconPudel);
					labels[i].setBounds(j * 100, i * 100, 100, 100);
					panel.add(labels[i]);
				} else if (feld[i][j] == GEGNER) {
					labels[i] = new JLabel(iconGegner);
					labels[i].setBounds(j * 100, i * 100, 100, 100);
					panel.add(labels[i]);
				} else if (feld[i][j] == WEITER) {
					labels[i] = new JLabel(iconWeiter);
					labels[i].setBounds(j * 100, i * 100, 100, 100);
					panel.add(labels[i]);
				} else if (feld[i][j] == ZIEL) {
					labels[i] = new JLabel(iconZiel);
					labels[i].setBounds(j * 100, i * 100, 100, 100);
					panel.add(labels[i]);
				} else if (feld[i][j] == ZURUECK) {
					labels[i] = new JLabel(iconZurueck);
					labels[i].setBounds(j * 100, i * 100, 100, 100);
					panel.add(labels[i]);
				}
				/* setzt das Panel mit Bildern auf das Spielfenster */
				this.setContentPane(panel);
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
			 * wenn der Wert des abgefragten Feldes 3 ist, erscheint das
			 * Verlorenfenster
			 */
			if (aktuellesSpielfeld[Spielfigurx][Spielfigury - 1] == 3) {
				Verloren();
			}
			/*
			 * wenn der Wert des abgefragten Feldes 4 ist, erscheint das nächste
			 * Level
			 */
			else if (aktuellesSpielfeld[Spielfigurx][Spielfigury - 1] == 4) {
				NextLevel();
			}
			/*
			 * wenn der Wert des abgefragten Feldes 5 ist, erscheint das
			 * Gewonnenfenster
			 */
			else if (aktuellesSpielfeld[Spielfigurx][Spielfigury - 1] == 5) {
				Gewonnen();
			}
			/*
			 * wenn der Wert des abgefragten Feldes 4 ist, erscheint das nächste
			 * Level
			 */
			else if (aktuellesSpielfeld[Spielfigurx][Spielfigury - 1] == 6) {
				LastLevel();
			}
			/*
			 * wenn der Wert des abgefragten Feldes 0 ist, wird das aktuelle
			 * Feld der Spielfigur auf 0 gesetzt
			 */
			else if (aktuellesSpielfeld[Spielfigurx][Spielfigury - 1] == 0) {
				aktuellesSpielfeld[Spielfigurx][Spielfigury] = 0;
				/* die x-Position zählt einen runter */
				Spielfigury--;
				/* die neue Position der Spielfigur erhält den Wert 2 */
				aktuellesSpielfeld[Spielfigurx][Spielfigury] = 2;
				/* und das Leve wird erneut aufgerufen */
				Levelaufruf(aktuellesSpielfeld);
				LevelAktualisieren();
			}
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if (aktuellesSpielfeld[Spielfigurx - 1][Spielfigury + 1] == 3) {
				Verloren();
			} else if (aktuellesSpielfeld[Spielfigurx][Spielfigury + 1] == 4) {
				NextLevel();
			} else if (aktuellesSpielfeld[Spielfigurx][Spielfigury + 1] == 5) {
				Gewonnen();
			} else if (aktuellesSpielfeld[Spielfigurx][Spielfigury + 1] == 0) {
				aktuellesSpielfeld[Spielfigurx][Spielfigury] = 0;
				Spielfigury++;
				aktuellesSpielfeld[Spielfigurx][Spielfigury] = 2;
				Levelaufruf(aktuellesSpielfeld);
				LevelAktualisieren();
			}
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			if (aktuellesSpielfeld[Spielfigurx - 1][Spielfigury] == 3) {
				Verloren();
			} else if (aktuellesSpielfeld[Spielfigurx - 1][Spielfigury] == 4) {
				NextLevel();
			} else if (aktuellesSpielfeld[Spielfigurx - 1][Spielfigury] == 5) {
				Gewonnen();
			} else if (aktuellesSpielfeld[Spielfigurx - 1][Spielfigury] == 0) {
				aktuellesSpielfeld[Spielfigurx][Spielfigury] = 0;
				Spielfigurx--;
				aktuellesSpielfeld[Spielfigurx][Spielfigury] = 2;
				Levelaufruf(aktuellesSpielfeld);
				LevelAktualisieren();
			}
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			if (aktuellesSpielfeld[Spielfigurx + 1][Spielfigury] == 3) {
				Verloren();
			} else if (aktuellesSpielfeld[Spielfigurx + 1][Spielfigury] == 4) {
				NextLevel();
			} else if (aktuellesSpielfeld[Spielfigurx + 1][Spielfigury] == 5) {
				Gewonnen();
			} else if (aktuellesSpielfeld[Spielfigurx + 1][Spielfigury] == 0) {
				aktuellesSpielfeld[Spielfigurx][Spielfigury] = 0;
				Spielfigurx++;
				aktuellesSpielfeld[Spielfigurx][Spielfigury] = 2;
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