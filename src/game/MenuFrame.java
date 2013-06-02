package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * diese Klasse erzeugt das Men�fenster. Die Buttons im Men�fenster sind
 * anklickbar und bewirken das Schlie�en des Fensters, oder das �ffnen des
 * Spielfensters.
 */
public class MenuFrame extends JFrame {

	/* setzt den Anfang der Pfadangabe auf die Arbeitsumgebung */
	private static final String direction = System.getProperty("user.dir");

	/*
	 * deklariert zwei Buttons, die nur von dieser Klasse aus angesprochen
	 * werden k�nnen
	 */
	private JButton start;
	private JButton ende;

	/* deklariert ein GameFrame gameframe aus dem Package */
	GameFrame gameframe;

	/**
	 * Konstruktor, der alle Einstellungen des Men�fensters aufruft
	 */
	public MenuFrame() {

		try {
			this.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File(
					direction + "/src/game/Images/Startscreen.jpg")))));
		} catch (IOException a) {
			System.out.println("das Bild kann nicht gefunden werden");
		}

		/* Eigenschaften des Men�fensters (Gr��e, Schlie�bar, mittig setzen,..) */
		this.setResizable(false);
		this.setTitle("Menu");
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setLayout(null);

		/*
		 * erstellt Label mit Text, setzt seine Position fest und setzt es auf
		 * das Men�fenster
		 */
		JLabel label = new JLabel("Made by Pinky and the Gang");
		label.setBounds(600, 450, 200, 40);
		this.add(label);

		start = new JButton("Spiel starten");
		start.setBounds(400, 350, 200, 40);
		this.add(start);

		ende = new JButton("Beenden");
		ende.setBounds(400, 400, 200, 40);
		this.add(ende);

		/* registriert Mausklick auf Button start und �ffnet ein neues GameFrame */
		ActionListener alstart = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					gameframe = new GameFrame();
			}
		};

		/* beendet das Programm, wenn auf Button ende geklickt wird */
		ActionListener alende = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		};

		/* weist den Buttons den entsprechenden ActionListener zu */
		start.addActionListener(alstart);
		ende.addActionListener(alende);
	}

	/**
	 * erzeugt ein neues Men�fenster aus dem Konstruktor
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		MenuFrame Frame = new MenuFrame();
	}
}