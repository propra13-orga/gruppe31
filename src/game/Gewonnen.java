package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Gewonnen {
	
	private static final String direction = System.getProperty("user.dir");
	
	private JButton GVschliessen;
	
	public Gewonnen() {
		final JFrame FrGe = new JFrame();
		
		try {
			FrGe.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File(
					direction + "/src/game/Images/Gewonnen.jpg")))));
		} catch (IOException a) {
			System.out.println("das Bild kann nicht gefunden werden");
		}

		FrGe.setResizable(false);
		FrGe.setSize(800, 600);
		FrGe.setLayout(null);
		FrGe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		FrGe.setLocationRelativeTo(null);
		FrGe.setVisible(true);

		GVschliessen = new JButton("Dieses Fenster schlieﬂen");
		GVschliessen.setBounds(550, 450, 200, 40);
		FrGe.add(GVschliessen);

		/* der Button schliessen schlieﬂt das aktuelle Fenster */
		ActionListener alschliessen = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrGe.dispose();
			}
		};
		GVschliessen.addActionListener(alschliessen);
	}

}
