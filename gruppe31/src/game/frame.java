package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * erstellt externes Fenster
 * @author Denise
 *
 */
public class frame extends JFrame {
	
	public static void main(String[] args) { 
		frame();
		
	}
	
	
	/*
	 * soll neues externes Fenster mit 2 Buttons und einem Label erstellen
	 */
	public static void frame() {
		JFrame F = new JFrame ("Menu");		
		try{
			F.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("Startscreen.jpg")))));
		}
		catch(IOException a) {
			System.out.println("das Bild kann nicht gefunden werden");
		}
		
		F.setResizable(false);
		F.setSize(800,600);
		F.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		F.setLocationRelativeTo(null);
		
		
		JLabel label = new JLabel ("Made by Pinky and the Gang");
		label.setBounds(500,550,200,40);
		F.add(label);
		
		JButton start = new JButton("Spiel starten");
		start.setBounds(400,350,200,40);
		F.add(start);
		
		JButton ende = new JButton("Beenden");
		ende.setBounds(400,400,200,40);
		F.add(ende);
		
		 ActionListener alstart = new ActionListener() {
		      public void actionPerformed( ActionEvent e ) {
		        fenster();
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
		    F.setVisible(true);
		  }
	
	/**
	 * öffnet neues Fenster wenn "Spiel starten" geklickt
	 * 
	 */
	public static void fenster() {
		
		JFrame fenster = new JFrame("Spiel");
		fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenster.setSize(800,600);
		fenster.setVisible(true);	
	}
}
