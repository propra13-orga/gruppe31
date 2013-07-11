package game;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

/**
 * ein Objekt dieser Klasse ist das NPCFenster, in welchem dem Spieler die
 * wichtigsten Informationen zum Spiel vom NPC gegeben werden
 */
public class NPC {

	/** Icons f�r NPX Anzeige werden deklariert */
	private static final Icon ICONCARLOS1 = new ImageIcon(Konstanten.DIRECTION
			+ "/src/game/Images/Carlos1.png");
	private static final Icon ICONCARLOS2 = new ImageIcon(Konstanten.DIRECTION
			+ "/src/game/Images/Carlos2.png");
	private static final Icon ICONCARLOS3 = new ImageIcon(Konstanten.DIRECTION
			+ "/src/game/Images/Carlos3.png");
	private static final Icon ICONCARLOS4 = new ImageIcon(Konstanten.DIRECTION
			+ "/src/game/Images/Carlos4.png");
	private static final Icon ICONCARLOS5 = new ImageIcon(Konstanten.DIRECTION
			+ "/src/game/Images/Carlos5.png");
	private static final Icon ICONCARLOS6 = new ImageIcon(Konstanten.DIRECTION
			+ "/src/game/Images/Carlos6.png");
	private static final Icon ICONCARLOS7 = new ImageIcon(Konstanten.DIRECTION
			+ "/src/game/Images/Carlos7.png");
	private static final Icon ICONCARLOS8 = new ImageIcon(Konstanten.DIRECTION
			+ "/src/game/Images/Carlos8.png");
	private static final Icon ICONCARLOS9 = new ImageIcon(Konstanten.DIRECTION
			+ "/src/game/Images/Carlos9.png");
	private static final Icon ICONCARLOS10 = new ImageIcon(Konstanten.DIRECTION
			+ "/src/game/Images/Carlos10.png");
	private static final Icon ICONCARLOS11 = new ImageIcon(Konstanten.DIRECTION
			+ "/src/game/Images/Carlos11.png");

	/** Labels f�r NPC Anzeige werden deklariert */
	private static final JLabel NPC1 = new JLabel(ICONCARLOS1);
	private static final JLabel NPC2 = new JLabel(ICONCARLOS2);
	private static final JLabel NPC3 = new JLabel(ICONCARLOS3);
	private static final JLabel NPC4 = new JLabel(ICONCARLOS4);
	private static final JLabel NPC5 = new JLabel(ICONCARLOS5);
	private static final JLabel NPC6 = new JLabel(ICONCARLOS6);
	private static final JLabel NPC7 = new JLabel(ICONCARLOS7);
	private static final JLabel NPC8 = new JLabel(ICONCARLOS8);
	private static final JLabel NPC9 = new JLabel(ICONCARLOS9);
	private static final JLabel NPC10 = new JLabel(ICONCARLOS10);
	private static final JLabel NPC11 = new JLabel(ICONCARLOS11);

	/** Buttons f�r NPC Anzeige werden deklariert */
	private JButton weiter;
	private JButton skip;

	/**
	 * Konstruktor erstellt ein neues Fenster, in dem der Nutzer mit dem NPC
	 * interagieren kann
	 */
	public NPC() {

		final JFrame frame = new JFrame();

		frame.setResizable(false);
		frame.setSize(205, 590);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
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

		NPC6.setBounds(0, -50, 200, 600);
		NPC6.setVisible(false);
		frame.add(NPC6);

		NPC7.setBounds(0, -50, 200, 600);
		NPC7.setVisible(false);
		frame.add(NPC7);

		NPC8.setBounds(0, -50, 200, 600);
		NPC8.setVisible(false);
		frame.add(NPC8);

		NPC9.setBounds(0, -50, 200, 600);
		NPC9.setVisible(false);
		frame.add(NPC9);

		NPC10.setBounds(0, -50, 200, 600);
		NPC10.setVisible(false);
		frame.add(NPC10);

		NPC11.setBounds(0, -50, 200, 600);
		NPC11.setVisible(false);
		frame.add(NPC11);

		weiter = new JButton("Weiter");
		weiter.setBounds(0, 500, 200, 30);
		frame.add(weiter);

		skip = new JButton("�berspringen");
		skip.setBounds(0, 532, 200, 30);
		frame.add(skip);

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
					NPC5.setVisible(false);
					NPC6.setVisible(true);
				} else if (NPC6.isVisible()) {
					NPC6.setVisible(false);
					NPC7.setVisible(true);
				} else if (NPC7.isVisible()) {
					NPC7.setVisible(false);
					NPC8.setVisible(true);
				} else if (NPC8.isVisible()) {
					NPC8.setVisible(false);
					NPC9.setVisible(true);
				} else if (NPC9.isVisible()) {
					NPC9.setVisible(false);
					NPC10.setVisible(true);
				} else if (NPC10.isVisible()) {
					NPC10.setVisible(false);
					NPC11.setVisible(true);
				} else if (NPC11.isVisible()) {
					frame.dispose();
				}
			}
		};

		ActionListener alskip = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		};
		weiter.addActionListener(alweiter);
		skip.addActionListener(alskip);
	}
}
