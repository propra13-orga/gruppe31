package game;

import java.awt.event.*;
import javax.swing.*;

/** öffnet ein neues Fenster, wenn im Menufenster Button control gedrückt wurde */
public class Steuerung {

	private JButton Sschliessen;

	private static final Icon iconSteuerung = new ImageIcon(
			Konstanten.direction + "/src/game/Images/Steuerung.png");

	private static final JLabel STEUERUNG = new JLabel(iconSteuerung);

	/** Konstruktor der alle EInstellungen des Fensters aufruft */
	public Steuerung() {
		final JFrame frame = new JFrame();

		frame.setResizable(true);
		frame.setSize(400, 400);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		STEUERUNG.setBounds(0, 0, 400, 310);
		STEUERUNG.setVisible(true);
		frame.add(STEUERUNG);

		Sschliessen = new JButton("Dieses Fenster schließen");
		Sschliessen.setBounds(0, 310, 400, 50);
		frame.add(Sschliessen);

		ActionListener alschliessen = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		};
		Sschliessen.addActionListener(alschliessen);
	}
}
