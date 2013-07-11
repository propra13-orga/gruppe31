package game;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


public class Netzwerk extends JFrame {
	

	/** Deklaration der Buttons für NetzwerkFrame */
	private JButton server;
	private JButton client;

	
	public Netzwerk() {
		
		this.setResizable(false);
		this.setTitle("Netzwerkrolle");
		this.setSize(Konstanten.BREITEST, Konstanten.HOEHEST);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setLayout(null);

		server = new JButton("Server");
		server.setBounds(50, 200, 150, 40);
		this.add(server);

		client = new JButton("Client");
		client.setBounds(250, 200, 150, 40);
		this.add(client);
		
		ActionListener alserver = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					/* Server Thread wird erstellt */
					try {
						new Server().start();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
			}
		};
		
		ActionListener alclient = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					/* Client Thread wird erstellt */
					new Chatter().start();
			}
		};
		
		server.addActionListener(alserver);
		client.addActionListener(alclient);
		
		
	}
}
