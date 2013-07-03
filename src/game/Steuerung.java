package game;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

/**
 * ein Objekt dieser Klasse ist das Steuerungsfenster, in welchem sich der
 * Nutzer die Steuerung ansehen kann
 */
public class Steuerung {

	/** Icon für Steuerung wird deklariert*/
	private static final Icon ICONSTEUERUNG = new ImageIcon(
			Konstanten.direction + "/src/game/Images/Steuerung.png");

	/** Label für Steuerung wird deklariert*/
	private static final JLabel STEUERUNG = new JLabel(ICONSTEUERUNG);


	/** Konstruktor, der ein neues Fenster mit Hintergrundbild aufruft */
	public Steuerung() {
		final JFrame frame = new JFrame();

		frame.setResizable(true);
		frame.setSize(400, 310);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		STEUERUNG.setBounds(0, 0, 400, 310);
		STEUERUNG.setVisible(true);
		frame.add(STEUERUNG);
	}
}
