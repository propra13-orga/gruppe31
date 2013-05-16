package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

/** erstellt externes Fenster
 * @author Denise
 */
 
public class Frame extends JFrame {
	
	public static JButton start;
	public static JButton ende;
	
	public static Frame f = new Frame();
	public static Frame F = new Frame();
	
	
	/* ruft das Menufenster mit Hintergrund auf */
	public static void main(String[] args) { 
		Menufenster();
	}
	
	
	/*soll neues externes Fenster mit 2 Buttons und einem Label erstellen*/
	 
	public static void Menufenster() {	
		try{
			F.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("src/Game/Images/Startscreen.jpg")))));		// setzt das Hintergrundbild
		}
		catch(IOException a) {
			System.out.println("das Bild kann nicht gefunden werden");
		}
		
		/*Eigenschaften des Menufensters (Groeﬂe, Schliessbar, Mittig setzen)*/
		F.setResizable(false);
		F.setTitle("Menu");
		F.setSize(800,600);
		F.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		F.setLocationRelativeTo(null);
		F.setVisible(true);
		F.setLayout(null);
		
		/*erstellt Label mit Text, setzt Position fest und fuegt es zu Menufenster hinzu*/
		JLabel label = new JLabel ("Made by Pinky and the Gang");
		label.setBounds(500,550,200,40);
		F.add(label);
		
		start = new JButton("Spiel starten");
		start.setBounds(400,350,200,40);
		F.add(start);
		
		ende = new JButton("Beenden");
		ende.setBounds(400,400,200,40);
		F.add(ende);
		
		/*registriert Mausklick auf Button start*/
		 ActionListener alstart = new ActionListener() {
		      public void actionPerformed( ActionEvent e ) {		
		    	  Spielfenster();
		      }
		    };
		
		 ActionListener alende = new ActionListener() {
		      public void actionPerformed( ActionEvent e ) {
		    	  System.exit(0);
		      }
		    };
		    start.addActionListener(alstart);
		    ende.addActionListener(alende);
		    F.pack();
		  }
	
	/* Eigenschaften des Spielfeldes*/
	public static void Spielfenster() {
		
		f.setResizable(true);
		f.setTitle("Erna's Adventure");
		f.setSize(800,600);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		
		Spielfeld.level1();
		
		f.pack();
	}
	
} 