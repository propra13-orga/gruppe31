package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

/** diese Klasse erzeugt sowohl das Menüfenster,
 * als auch das Spielfenster. Die Buttons im Menüfenster
 * sind anklickbar und bewirken das Schließen des Fensters,
 * oder das Öffnen des Spielfensters.
 */
public class Frame extends JFrame {
	
	public static JButton start;
	public static JButton ende;
	
	public static Frame f = new Frame();
	public static Frame F = new Frame();
	
	
	/* ruft das Menüfenster auf*/
	public static void main(String[] args) { 
		Menufenster();
	}
	
	
	/*erzeugt das Menüfenster mit zwei Buttons und einem Label*/
	public static void Menufenster() {	
		
		String direction = System.getProperty("user.dir");
		
		/*setzt das Hintergrundbild. Wenn es nicht gefunden wird erscheint ein Text*/
		try{
			F.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File(direction+"/src/game/Images/Startscreen.jpg")))));
		}
		catch(IOException a) {
			System.out.println("das Bild kann nicht gefunden werden");
		}
		
		/*Eigenschaften des Menüfensters (Größe, Schließbar, mittig setzen,..)*/
		F.setResizable(false);
		F.setTitle("Menu");
		F.setSize(800,600);
		F.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		F.setLocationRelativeTo(null);
		F.setVisible(true);
		F.setLayout(null);
		
		/*erstellt Label mit Text, setzt seine Position fest und setzt es auf das Menüfenster*/
		JLabel label = new JLabel ("Made by Pinky and the Gang");
		label.setBounds(500,550,200,40);
		F.add(label);
		
		start = new JButton("Spiel starten");
		start.setBounds(400,350,200,40);
		F.add(start);
		
		ende = new JButton("Beenden");
		ende.setBounds(400,400,200,40);
		F.add(ende);
		
		/*registriert Mausklick auf Button start und öffnet das Spielfenster*/
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
		  }
	
	/* public void keyTyped(java.awt.event.KeyEvent e) {
	        // do nothing
	    }

	    public void keyPressed(java.awt.event.KeyEvent e) {
	        if (e.getKeyCode() == KeyEvent.VK_LEFT) feld1[i][j] = feld1[i-1][j];
	        if (e.getKeyCode() == KeyEvent.VK_RIGHT) feld1[i][j] = feld1[i+1][j];
	        if (e.getKeyCode() == KeyEvent.VK_UP) feld1[i][j] = feld1[i][j-1];
	        if (e.getKeyCode() == KeyEvent.VK_DOWN) feld1[i][j] = feld1[i][j+1];
	    }

	    public void keyReleased(java.awt.event.KeyEvent e) {
	        //do nothing
	    }*/
	
	/* Eigenschaften des Spielfeldes*/
	public static void Spielfenster() {
		
		f.setResizable(false);
		f.setTitle("Erna's Adventure");
		f.setSize(805,630);
		f.setLayout(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		
		Spielfeld.level1();
	}
} 