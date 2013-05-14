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
 
public class frame extends JFrame {
	
	public static JButton start;
	public static JButton ende;
	
	public static Spielfeld mySpielfeld;
	
	/* ruft das Menufenster mit Hintergrund auf */
	public static void main(String[] args) { 
		Menufenster();
	}
	
	
	/*soll neues externes Fenster mit 2 Buttons und einem Label erstellen*/
	 
	public static void Menufenster() {
		frame F = new frame();		
		try{
			F.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("Images/Startscreen.jpg")))));		// setzt das Hintergrundbild
		}
		catch(IOException a) {
			System.out.println("das Bild kann nicht gefunden werden");
		}
		
		/*Eigenschaften des Menufensters (Größe, Schließbar, Mittig setzen)*/
		F.setResizable(false);
		F.setSize(800,600);
		F.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		F.setLocationRelativeTo(null);
		F.setVisible(true);
		F.setLayout(null);
		
		/*erstellt Label mit Text, setzt Position fest und fügt es zu Menufenster hinzu*/
		JLabel label = new JLabel ("Made by Pinky and the Gang");
		label.setBounds(500,550,200,40);
		F.add(label);
		
		start = new JButton("Spiel starten");
		start.setBounds(400,350,200,40);
		F.add(start);
		
		ende = new JButton("Beenden");
		ende.setBounds(400,400,200,40);
		F.add(ende);
		
		mySpielfeld = new Spielfeld();
		
		/*registriert Mausklick auf Button start*/
		 ActionListener alstart = new ActionListener() {
		      public void actionPerformed( ActionEvent e ) {		
		    		mySpielfeld.levelsErstellen(); 						
		    		StdDraw.setCanvasSize(880,660);					
		    		mySpielfeld.levelDarstellen(); 						
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
} 