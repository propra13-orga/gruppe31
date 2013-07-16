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
public class NPC2 {

	/** Icons für NPX Anzeige werden deklariert */
	private static final Icon ICONLUKE1 = new ImageIcon(Konstanten.DIRECTION
			+ "/src/game/Images/Luke1.png");
	

	/** Labels für NPC Anzeige werden deklariert */
	
	private static final JLabel NPC12 = new JLabel(ICONLUKE1);

	/** Buttons für NPC Anzeige werden deklariert */
	private JButton ok;

	/**
	 * Konstruktor erstellt ein neues Fenster, in dem der Nutzer mit dem NPC
	 * interagieren kann
	 */
	public NPC2() {

		final JFrame frame = new JFrame();

		frame.setResizable(false);
		frame.setSize(Konstanten.BREITENPC, Konstanten.HOEHENPC);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		NPC12.setBounds(Konstanten.POSXNPC, Konstanten.POYNPC, Konstanten.BREITENPCF, Konstanten.HOEHENPCF);
		NPC12.setVisible(true);
		frame.add(NPC12);


		ok = new JButton("Okay, danke!");
		ok.setBounds(Konstanten.XOK, Konstanten.YOK, Konstanten.BREITEOK, Konstanten.HOEHEOK);
		frame.add(ok);
		
		ActionListener alok= new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		};

		ok.addActionListener(alok);
	}
}
