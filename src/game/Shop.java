package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/** löst aus, wenn der KeyListener im Gameplay HUETTE registriert */
public class Shop {
	
	private GameFrame gameFrame;

	private static final Icon iconShop = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Shopfenster.png");
	private static final Icon iconWaffe = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/BrilleShop.png");
	private static final Icon iconMana = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/ManaShop.png");
	private static final Icon iconTrank = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/LebenShop.png");
	private static final Icon iconHalsband = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/HalsbandShop.png");

	private static final JLabel SHOP = new JLabel(iconShop);

	private JButton Waffe = new JButton(iconWaffe);
	private JButton Mana = new JButton(iconMana);
	private JButton Trank = new JButton(iconTrank);
	private JButton Halsband = new JButton(iconHalsband);
	private JButton schliessen = new JButton();

	/** Konstruktor, der alle EIgenschaften des Fensters aufruft */
	public Shop() {
		final JFrame frame = new JFrame();

		frame.setResizable(false);
		frame.setSize(500, 300);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		SHOP.setBounds(0, 0, 500, 300);
		SHOP.setVisible(true);
		frame.add(SHOP);

		Waffe.setBounds(75, 120, 75, 75);
		Waffe.setVisible(true);
		SHOP.add(Waffe);

		Mana.setBounds(175, 120, 75, 75);
		Mana.setVisible(true);
		SHOP.add(Mana);

		Trank.setBounds(275, 120, 75, 75);
		Trank.setVisible(true);
		SHOP.add(Trank);

		Halsband.setBounds(375, 120, 75, 75);
		Halsband.setVisible(true);
		SHOP.add(Halsband);

		schliessen = new JButton("Dieses Fenster schließen");
		schliessen.setBounds(0, 250, 500, 25);
		SHOP.add(schliessen);

		ActionListener alWaffe = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//gold = gold - 50;
				//bewaffnet = 1;
				//gameFrame.setzeAnzeige();
				System.out.println("Du hast dir eine Waffe gekauft und musstest mit Münzen bezahlen!");
			}
		};

		ActionListener alMana = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//gold = gold - 50;
				//mana = 1;
				//gameFrame.setzeAnzeige();
				System.out.println("Du hast dir Mana gekauft und musstest mit Münzen bezahlen!");
			}
		};

		ActionListener alTrank = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//gold = gold - 50;
				//health = 100;
				//gameFrame.setzeAnzeige();
				System.out.println("Du hast dir einen Trank gekauft und musstest mit Münzen bezahlen!");
			}
		};

		ActionListener alHalsband = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//gold = gold - 50;
				//ruestung = 50;
				//gameFrame.setzeAnzeige();
				System.out.println("Du hast dir eine Rüstung gekauft und musstest mit Münzen bezahlen!");
			}
		};

		ActionListener alschliessen = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		};

		Waffe.addActionListener(alWaffe);
		Mana.addActionListener(alMana);
		Trank.addActionListener(alTrank);
		Halsband.addActionListener(alHalsband);
		schliessen.addActionListener(alschliessen);
	}
}
