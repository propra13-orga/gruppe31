package game;

import java.awt.event.*;
import java.io.*;

import javax.swing.*;
import javax.imageio.ImageIO;

import java.io.File;


/**
 * MenuFrame erzeugt das Menufenster. Ein Hintergrundbild wird gesetzt, es
 * werden 3 Buttons und ein Label auf das Fenster gesetzt
 */
public class MenuFrame extends JFrame {

	private JButton start;
	private JButton control;
	private JButton ende;

	private GameFrame gameframe;
	private Steuerung steuerung;

	/**
	 * Konstruktor, der alle Einstellungen des Menüfensters aufruft
	 */
	public MenuFrame() {

		try {
			this.setContentPane(new JLabel(
					new ImageIcon(ImageIO.read(new File(Konstanten.direction
							+ "/src/game/Images/Startscreen.jpg")))));
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
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		};

		ActionListener alsteuerung = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				steuerung = new Steuerung();
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

	/**
	 * Main-Methode erzeugt ein neues Menufenster aus dem Konstruktor
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		MenuFrame Frame = new MenuFrame();
	}
}