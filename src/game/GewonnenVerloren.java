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
import javax.swing.WindowConstants;

public class GewonnenVerloren {

	/** Deklaration eines Strings für das Schließen */
	private String schliessen = "Dieses Fenster schließen";

	/** Deklaration eines Strings für Exception im Gewonnen- und Verlorenfenster */
	private String exception = "Das Bild kann nicht gefunden werden ";

	/** Button wird für Gewonnen- und Verlorenfenster deklariert */
	private JButton gvschliessen;

	public GewonnenVerloren(String zustand) {

		final JFrame gvFrame = new JFrame();

		gvFrame.setResizable(false);
		gvFrame.setSize(Konstanten.BREITEGV, Konstanten.HOEHEGV);
		gvFrame.setLayout(null);
		gvFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		gvFrame.setLocationRelativeTo(null);
		gvFrame.setVisible(true);

		if (zustand == "gewonnen") {
			try {
				gvFrame.setContentPane(new JLabel(new ImageIcon(ImageIO
						.read(new File(Konstanten.DIRECTION
								+ "/src/game/Images/Gewonnen.jpg")))));
			} catch (IOException a) {
				System.out.println(exception);
			}
		} else if (zustand == "verloren") {
			try {
				gvFrame.setContentPane(new JLabel(new ImageIcon(ImageIO
						.read(new File(Konstanten.DIRECTION
								+ "/src/game/Images/GameOver.jpg")))));
			} catch (IOException a) {
				System.out.println(exception);
			}
		}

		gvschliessen = new JButton(schliessen);
		gvschliessen.setBounds(Konstanten.XGVB, Konstanten.YGVB,
				Konstanten.BREITEGVB, Konstanten.HOEHEGVB);
		gvFrame.add(gvschliessen);

		ActionListener alschliessen = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gvFrame.dispose();
			}
		};
		gvschliessen.addActionListener(alschliessen);
	}
}
