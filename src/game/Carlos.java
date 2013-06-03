package game;

import java.awt.event.*;
import javax.swing.*;

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
	
	public Carlos() {
		
		final JFrame NPC = new JFrame();
		
		NPC.setResizable(false);
		NPC.setSize(205, 590);
		NPC.setLayout(null);
		NPC.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		NPC.setLocationRelativeTo(null);
		NPC.setVisible(true);
		
		NPC1.setBounds(0, -50, 200, 600);
		NPC1.setVisible(true);
		NPC.add(NPC1);

		NPC2.setBounds(0, -50, 200, 600);
		NPC2.setVisible(false);
		NPC.add(NPC2);

		NPC3.setBounds(0, -50, 200, 600);
		NPC3.setVisible(false);
		NPC.add(NPC3);

		NPC4.setBounds(0, -50, 200, 600);
		NPC4.setVisible(false);
		NPC.add(NPC4);

		NPC5.setBounds(0, -50, 200, 600);
		NPC5.setVisible(false);
		NPC.add(NPC5);

		Weiter = new JButton("Weiter");
		Weiter.setBounds(0, 500, 200, 30);
		NPC.add(Weiter);

		Skip = new JButton("Überspringen");
		Skip.setBounds(0, 532, 200, 30);
		NPC.add(Skip);

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
					NPC.dispose();
				}
			}
		};

		ActionListener alskip = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NPC.dispose();
			}
		};
		Weiter.addActionListener(alweiter);
		Skip.addActionListener(alskip);
	}

}
