package game;

import java.awt.event.*;
import javax.swing.*;

/** löst aus, wenn der KeyListener CARLOS registriert */
public class Carlos {

	private static final String direction = System.getProperty("user.dir");

	private static final Icon iconCarlos1 = new ImageIcon(direction
			+ "/src/game/Images/Carlos1.png");
	private static final Icon iconCarlos2 = new ImageIcon(direction
			+ "/src/game/Images/Carlos2.png");
	private static final Icon iconCarlos3 = new ImageIcon(direction
			+ "/src/game/Images/Carlos3.png");
	private static final Icon iconCarlos4 = new ImageIcon(direction
			+ "/src/game/Images/Carlos4.png");
	private static final Icon iconCarlos5 = new ImageIcon(direction
			+ "/src/game/Images/Carlos5.png");

	private static final JLabel NPC1 = new JLabel(iconCarlos1);
	private static final JLabel NPC2 = new JLabel(iconCarlos2);
	private static final JLabel NPC3 = new JLabel(iconCarlos3);
	private static final JLabel NPC4 = new JLabel(iconCarlos4);
	private static final JLabel NPC5 = new JLabel(iconCarlos5);

	private JButton Weiter;
	private JButton Skip;

	/**
	 * Konstruktor erstellt ein neues Fenster und zeigt bei jedem Klick auf
	 * Button weiter ein neues Label an
	 */
	public Carlos() {

		final JFrame frame = new JFrame();

		frame.setResizable(false);
		frame.setSize(205, 590);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		NPC1.setBounds(0, -50, 200, 600);
		NPC1.setVisible(true);
		frame.add(NPC1);

		NPC2.setBounds(0, -50, 200, 600);
		NPC2.setVisible(false);
		frame.add(NPC2);

		NPC3.setBounds(0, -50, 200, 600);
		NPC3.setVisible(false);
		frame.add(NPC3);

		NPC4.setBounds(0, -50, 200, 600);
		NPC4.setVisible(false);
		frame.add(NPC4);

		NPC5.setBounds(0, -50, 200, 600);
		NPC5.setVisible(false);
		frame.add(NPC5);

		Weiter = new JButton("Weiter");
		Weiter.setBounds(0, 500, 200, 30);
		frame.add(Weiter);

		Skip = new JButton("Überspringen");
		Skip.setBounds(0, 532, 200, 30);
		frame.add(Skip);

		ActionListener alweiter = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (NPC1.isVisible()) {
					NPC1.setVisible(false);
					NPC2.setVisible(true);
				} else if (NPC2.isVisible()) {
					NPC2.setVisible(false);
					NPC3.setVisible(true);
				} else if (NPC3.isVisible()) {
					NPC3.setVisible(false);
					NPC4.setVisible(true);
				} else if (NPC4.isVisible()) {
					NPC4.setVisible(false);
					NPC5.setVisible(true);
				} else if (NPC5.isVisible()) {
					frame.dispose();
				}
			}
		};

		ActionListener alskip = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		};
		Weiter.addActionListener(alweiter);
		Skip.addActionListener(alskip);
	}

}
