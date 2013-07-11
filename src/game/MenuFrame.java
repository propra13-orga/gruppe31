package game;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

/**
 * MenuFrame erzeugt das Menufenster. Ein Hintergrundbild wird gesetzt, es
 * werden 3 Buttons und ein Label auf das Fenster gesetzt
 */
public class MenuFrame extends JFrame {

	/** Icon für Steuerung wird deklariert */
	private static final Icon ICONSTEUERUNG = new ImageIcon(
			Konstanten.DIRECTION + "/src/game/Images/Steuerung.png");

	/** Label für Steuerung wird deklariert */
	private static final JLabel STEUERUNG = new JLabel(ICONSTEUERUNG);

	/** Deklaration der Buttons für MenuFrame */
	private JButton start;
	private JButton start2;
	private JButton control;
	private JButton ende;

	/** Deklaration der Buttons für NetzwerkFrame */
	private JButton server;
	private JButton client;

	/** Deklaration von Feldern */
	private GameFrame gameframe;

	/**
	 * Konstruktor, der alle Einstellungen des Menüfensters aufruft
	 */
	public MenuFrame() {

		try {
			this.setContentPane(new JLabel(
					new ImageIcon(ImageIO.read(new File(Konstanten.DIRECTION
							+ "/src/game/Images/Startscreen.jpg")))));
		} catch (IOException a) {
			System.out.println("das Bild kann nicht gefunden werden");
		}

		this.setResizable(false);
		this.setTitle("Menu");
		this.setSize(Konstanten.BREITE - 100, Konstanten.HOEHE - 100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setLayout(null);

		start = new JButton("Spiel starten");
		start.setBounds(350, 300, 200, 40);
		this.add(start);

		start2 = new JButton("Netzwerkmodus");
		start2.setBounds(350, 350, 200, 40);
		this.add(start2);

		control = new JButton("Steuerung");
		control.setBounds(350, 400, 200, 40);
		this.add(control);

		ende = new JButton("Beenden");
		ende.setBounds(350, 450, 200, 40);
		this.add(ende);

		JLabel label = new JLabel("Made by Pinky and the Gang");
		label.setBounds(600, 500, 200, 40);
		this.add(label);

		ActionListener alstart = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					gameframe = new GameFrame();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		};

		ActionListener alstart2 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/* Netzwerkauswahl wird erstellt */
				try {
					netzwerk();
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		};

		ActionListener alsteuerung = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				steuerung();
			}
		};

		ActionListener alende = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		};

		start.addActionListener(alstart);
		start2.addActionListener(alstart2);
		control.addActionListener(alsteuerung);
		ende.addActionListener(alende);
	}

	/**
	 * Methode ruft neues Fenster zu Netzwerkauswahl auf
	 * 
	 * @throws Exception
	 *             wirft möglicherweise Exception
	 */
	public void netzwerk() throws Exception {

		// Erstellung Array vom Datentyp Object, Hinzufügen der Optionen
		Object[] options = { "Sever", "Client" };

		int selected = JOptionPane.showOptionDialog(null, "Netzwerkrolle",
				"Alternativen", JOptionPane.DEFAULT_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

		/* wenn Server gewählt wurde, wird Server-Thread gestartet */
		if (selected == 0) {
			new Server().start();
			/* wenn Client gewählt wurde, wird Client-Thread gestartet */
		} else if (selected == 1) {
			new Chatter().start();
		}
	}

	/** Methode ruft neues Fenster auf */
	public void steuerung() {
		final JFrame frame = new JFrame();

		frame.setResizable(true);
		frame.setSize(Konstanten.BREITEST, Konstanten.HOEHEST);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		STEUERUNG.setBounds(0, 0, Konstanten.BREITEST, Konstanten.HOEHEST);
		STEUERUNG.setVisible(true);
		frame.add(STEUERUNG);
	}

	/**
	 * Main-Methode erzeugt ein neues Menufenster aus dem Konstruktor
	 * 
	 * @param args
	 *            Kommandozeilenparameter
	 */
	public static void main(String[] args) {
		MenuFrame frame = new MenuFrame();
	}
}