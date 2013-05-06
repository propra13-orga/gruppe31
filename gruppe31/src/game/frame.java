package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class frame extends JFrame implements ActionListener {
	private JButton schliessen;
	private JButton ende;

	public static void main(String[] args) {
		frame frame = new frame ("Menu");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,400);
		
		frame.setLayout(null);
		frame.setVisible(true);
	}
	
	public frame (String title) {
		
		super(title);
		
		schliessen = new JButton("Spiel starten");
		schliessen.setBounds(120,120,160,40);
		schliessen.addActionListener(this);
		add(schliessen);
		
		ende = new JButton("Beenden");
		ende.setBounds(120,200,160,40);
		ende.addActionListener(this);
		add(ende);
		
		JLabel label = new JLabel ("Made by Pinky and the Gang");
		label.setBounds(200,340,150,20);
		add(label);
		
	}
	
	public static void fenster() {
		JFrame fenster = new JFrame();
		fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenster.setSize(400,400);
		fenster.setVisible(true);
	}


	public void actionPerformed(ActionEvent e) {
		if (e.getSource()== schliessen) {
			fenster();
		}
		if (e.getSource()== ende) {
			System.exit(0);
		}
		
	}

}
