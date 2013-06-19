package game;

import java.awt.event.*;
import javax.swing.*;

/**
 * ein Objekt dieser Klasse ist das Steuerungsfenster, in welchem sich der
 * Nutzer die Steuerung ansehen kann
 */
public class Steuerung {

	private JButton Sschliessen;

	private static final Icon iconSteuerung = new ImageIcon(
			Konstanten.direction + "/src/game/Images/Steuerung.png");

	private static final JLabel STEUERUNG = new JLabel(iconSteuerung);

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
