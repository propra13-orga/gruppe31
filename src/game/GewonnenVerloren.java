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

/**
 * die Objekte dieser Klasse sind je nach übergebenen Parameter das Gewonnen
 * oder Verlorenfenster
 * 
 * @author Denise
 * 
 */
public class GewonnenVerloren {

	/** Deklaration eines Strings für das Schließen */
	private String schliessen = "Dieses Fenster schließen";

	/** Deklaration eines Strings für Exception im Gewonnen- und Verlorenfenster */
	private String exception = "Das Bild kann nicht gefunden werden ";

	/** Button wird für Gewonnen- und Verlorenfenster deklariert */
	private JButton gvschliessen;

	/** Deklaration von Feldern */
	private Musik musik;

	/**
	 * * dem Konstruktor wird ein String mit übergeben, welcher darüber
	 * entscheidet, welches Hintergrundbild gesetzt wird und welche
	 * Hintergrundmusik gespielt wird
	 * 
	 * @param zustand
	 *            Kommandozeilenparameter
	 */
	public GewonnenVerloren(String zustand) {

		final JFrame gvFrame = new JFrame();

		gvFrame.setResizable(false);
		gvFrame.setSize(Konstanten.BREITEGV, Konstanten.HOEHEGV);
		gvFrame.setLayout(null);
		gvFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		gvFrame.setLocationRelativeTo(null);
		gvFrame.setVisible(true);

		if ("gewonnen".equals(zustand)) {
			musik = new Musik(Konstanten.DIRECTION + "/src/game/Sound/Sieg.wav");
			try {
				gvFrame.setContentPane(new JLabel(new ImageIcon(ImageIO
						.read(new File(Konstanten.DIRECTION
								+ "/src/game/Images/Gewonnen.jpg")))));
			} catch (IOException a) {
				System.out.println(exception);
			}
		} else if ("verloren".equals(zustand)) {
			musik = new Musik(Konstanten.DIRECTION + "/src/game/Sound/Verloren.wav");
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
