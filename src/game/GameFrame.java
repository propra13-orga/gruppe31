package game;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Panel;
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

	private static final String direction = System.getProperty("user.dir");

	private static final int RASEN = 0;
	private static final int GRENZE = 1;
	private static final int PUDEL = 2;
	private static final int GEGNER = 3;
	private static final int WEITER = 4;
	private static final int BOSS = 5;
	private static final int ZURUECK = 6;

	/* erstellt Icons und weist ihnen Bilder zu */
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

	/* Platzhalter Icons*/
	private static final Icon iconCarlos1 = new ImageIcon(direction
			+ "/src/game/Images/Carlos1.png");
	private static final Icon iconAnzeige = new ImageIcon(direction
			+ "/src/game/Images/Anzeige.jpg");
	private static final Icon iconWald = new ImageIcon(direction
			+ "/src/game/Images/Wald.jpg");

	private JButton schliessen;

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
					{ GRENZE, RASEN, RASEN, GRENZE, RASEN, RASEN, RASEN, GRENZE },
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

	private GridBagConstraints gridBagConstraints;

	/*PLatzhalter Labels */
	private JLabel Carlos1 = new JLabel(iconCarlos1);
	private JLabel Anzeige = new JLabel(iconAnzeige);
	private JLabel Wald = new JLabel(iconWald);

	private JButton Weiter = new JButton("Weiter");
	private JButton Skip = new JButton("Überspringen");

	private Panel mainPanel = new Panel();
	private Panel Spielfeld = new Panel();
	private Panel Leiste = new Panel();
	private Panel NPC = new Panel();
	private Panel Buttons = new Panel();
	

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

		/*
		 * setzt den Anfangswert der Level auf -1, um im Levelarray bei 0
		 * starten zu können und ruft das nächste (hier: erste) Level auf
		 */
		level = -1;
		// NextLevel();

		mainPanel.setLayout(new GridBagLayout());

		setzeWald();
		setzeNPC();
		setzeAnzeige();
		setzeButtons();

		getContentPane().add(mainPanel, BorderLayout.CENTER);
	}

	public void setzeWald() {
		Spielfeld.add(Wald);
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridwidth = 6;
		gridBagConstraints.gridheight = 4;
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.weighty = 0.0;
		mainPanel.add(Spielfeld, gridBagConstraints);
	}

	public void setzeNPC() {
		NPC.add(Carlos1);
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 6;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.gridheight = 4;
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.weighty = 0.0;
		mainPanel.add(NPC, gridBagConstraints);
	}

	public void setzeAnzeige() {
		Leiste.add(Anzeige);
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 5;
		gridBagConstraints.gridwidth = 6;
		gridBagConstraints.gridheight = 1;
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.weighty = 1.0;
		mainPanel.add(Leiste, gridBagConstraints);
	}

	public void setzeButtons() {
		Buttons.add(Weiter, BorderLayout.NORTH);
		Buttons.add(Skip, BorderLayout.SOUTH);
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 6;
		gridBagConstraints.gridy = 5;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.gridheight = 1;
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.weighty = 1.0;
		mainPanel.add(Buttons, gridBagConstraints);
	}

	/**
	 * allgemeine Methode zum Erzeugen der Level mit Zurodnung der Bilder
	 * 
	 * @param feld
	 */
	public void Levelaufruf(int[][] feld) {
		
		Panel panel = new Panel();
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
					labels[i] = new JLabel(iconBaum);
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
				} else if (feld[i][j] == BOSS) {
					labels[i] = new JLabel(iconBoss);
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
			if (aktuellesSpielfeld[Spielfigurx][Spielfigury - 1] == GEGNER) {
				Verloren();
			}
			/*
			 * wenn der Wert des abgefragten Feldes 4 ist, erscheint das nächste
			 * Level
			 */
			else if (aktuellesSpielfeld[Spielfigurx][Spielfigury - 1] == WEITER) {
				NextLevel();
			}
			/*
			 * wenn der Wert des abgefragten Feldes 5 ist, erscheint das
			 * Gewonnenfenster
			 */
			else if (aktuellesSpielfeld[Spielfigurx][Spielfigury - 1] == BOSS) {
				Verloren();
			}
			/*
			 * wenn der Wert des abgefragten Feldes 4 ist, erscheint das nächste
			 * Level
			 */
			else if (aktuellesSpielfeld[Spielfigurx][Spielfigury - 1] == ZURUECK) {
				LastLevel();
			}
			/*
			 * wenn der Wert des abgefragten Feldes 0 ist, wird das aktuelle
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
