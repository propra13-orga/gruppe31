package game;

import java.awt.event.*;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Verloren {
	
	private static final String direction = System.getProperty("user.dir");
	
	private JButton GVschliessen;

	public Verloren() {
		
		final JFrame FrVe = new JFrame();
		
		try {
			FrVe.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File(
					direction + "/src/game/Images/GameOver.jpg")))));
		} catch (IOException a) {
			System.out.println("das Bild kann nicht gefunden werden");
		}

		FrVe.setResizable(false);
		FrVe.setSize(800, 600);
		FrVe.setLayout(null);
		FrVe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		FrVe.setLocationRelativeTo(null);
		FrVe.setVisible(true);

		/*
		 * der Button schliessen bewirkt ein Verschwinden des Fensters, sodass
		 * das Menufenster zu sehen ist
		 */
		GVschliessen = new JButton("Dieses Fenster schlieﬂen");
		GVschliessen.setBounds(550, 450, 200, 40);
		FrVe.add(GVschliessen);

		ActionListener alschliessen = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrVe.dispose();
			}
		};
		GVschliessen.addActionListener(alschliessen);
	}

}
