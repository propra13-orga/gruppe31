package game;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

/**
 * MenuFrame erzeugt das Menufenster. Ein Hintergrundbild wird gesetzt, es
 * werden 3 Buttons und ein Label auf das Fenster gesetzt
 */
public class MenuFrame extends JFrame {
	
	/** Icon f�r Steuerung wird deklariert */
	private static final Icon ICONSTEUERUNG = new ImageIcon(
			Konstanten.DIRECTION + "/src/game/Images/Steuerung.png");

	/** Label f�r Steuerung wird deklariert */
	private static final JLabel STEUERUNG = new JLabel(ICONSTEUERUNG);

	/** Deklaration der Buttons f�r MenuFrame */
	private JButton start;
	private JButton control;
	private JButton ende;

	/** Deklaration von Feldern */
	private GameFrame gameframe;

	/**
	 * Konstruktor, der alle Einstellungen des Men�fensters aufruft
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
		this.setSize(Konstanten.BREITE, Konstanten.HOEHE);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setLayout(null);

		start = new JButton("Spiel starten");
		start.setBounds(350, 300, 200, 40);
		this.add(start);

		control = new JButton("Steuerung");
		control.setBounds(350, 350, 200, 40);
		this.add(control);

		ende = new JButton("Beenden");
		ende.setBounds(350, 400, 200, 40);
		this.add(ende);

		JLabel label = new JLabel("Made by Pinky and the Gang");
		label.setBounds(600, 450, 200, 40);
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
		control.addActionListener(alsteuerung);
		ende.addActionListener(alende);
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
	 * @param args Kommandozeilenparameter
	 */
	public static void main(String[] args) {
		MenuFrame frame = new MenuFrame();
	}
}