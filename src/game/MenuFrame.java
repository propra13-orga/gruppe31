package game;

import java.awt.Color;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;
import javax.imageio.ImageIO;

/**
 * MenuFrame erzeugt das Menufenster. Ein Hintergrundbild wird gesetzt, es
 * werden 2 Buttons und ein Label auf das Fenster gesetzt
 */
public class MenuFrame extends JFrame {

	/* setzt den Anfang der Pfadangabe auf die Arbeitsumgebung */
	private static final String direction = System.getProperty("user.dir");

	private static final Icon iconSteuerung = new ImageIcon(direction
			+ "/src/game/Images/Steuerung.png");

	private static final JLabel STEUERUNG = new JLabel(iconSteuerung);

	private JButton start;
	private JButton steuerung;
	private JButton ende;
	private JButton Sschliessen;

	GameFrame gameframe;

	/**
	 * Konstruktor, der alle Einstellungen des Menüfensters aufruft
	 */
	public MenuFrame() {

		try {
			this.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File(
					direction + "/src/game/Images/Startscreen.jpg")))));
		} catch (IOException a) {
			System.out.println("das Bild kann nicht gefunden werden");
		}

		this.setResizable(false);
		this.setTitle("Menu");
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setLayout(null);

		start = new JButton("Spiel starten");
		start.setBounds(350, 300, 200, 40);
		this.add(start);

		steuerung = new JButton("Steuerung");
		steuerung.setBounds(350, 350, 200, 40);
		this.add(steuerung);

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
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		};

		ActionListener alsteuerung = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final JFrame fst = new JFrame();

				fst.setBackground(Color.green);
				fst.setResizable(true);
				fst.setSize(400, 400);
				fst.setLayout(null);
				fst.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				fst.setLocationRelativeTo(null);
				fst.setVisible(true);

				STEUERUNG.setBounds(0, 0, 400, 310);
				STEUERUNG.setVisible(true);
				fst.add(STEUERUNG);

				Sschliessen = new JButton("Dieses Fenster schließen");
				Sschliessen.setBounds(0, 310, 400, 50);
				fst.add(Sschliessen);

				ActionListener alschliessen = new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						fst.dispose();
					}
				};
				Sschliessen.addActionListener(alschliessen);
			}
		};

		ActionListener alende = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		};

		start.addActionListener(alstart);
		steuerung.addActionListener(alsteuerung);
		ende.addActionListener(alende);
	}

	/**
	 * erzeugt ein neues Menufenster aus dem Konstruktor
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		MenuFrame Frame = new MenuFrame();
	}
}