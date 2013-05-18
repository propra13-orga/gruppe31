package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

/** diese Klasse erzeugt sowohl das Menüfenster,
 * als auch das Spielfenster. Die Buttons im Menüfenster
 * sind anklickbar und bewirken das Schließen des Fensters,
 * oder das Öffnen des Spielfensters.
 */
	public class Frame extends JFrame /*implements KeyListener*/ {
		
	static String direction = System.getProperty("user.dir");
	
	public static JButton start;
	public static JButton ende;
	public static JButton schliessen;
	
	public static JFrame f = new Frame();
	public static JFrame F = new Frame();
	
	
	/* ruft das Menüfenster auf*/
	public static void main(String[] args) { 
		Menufenster();
	}
	
	/*erzeugt das Menüfenster mit zwei Buttons und einem Label*/
	public static void Menufenster() {	
		
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
		label.setBounds(600,450,200,40);
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
		    
		 /*setzt die beiden Buttons auf das Menüfenster*/
		 start.addActionListener(alstart);
		 ende.addActionListener(alende);
		 
		/* F.addKeyListener(new KeyListener() {
	            public void keyTyped(java.awt.event.KeyEvent e) { 
	            	/* do nothing 
	            }
	            
	            public void keyReleased(java.awt.event.KeyEvent e) {
	            	/* do nothing  
	            }

	            public void keyPressed(java.awt.event.KeyEvent e) {
	               if (e.getKeyCode() == KeyEvent.VK_LEFT) { 
						if (feld1[Spielfigurx-1][Spielfigury] = 3) {
							Verloren();
						}
						else if (feld1[Spielfigurx-1][Spielfigury] = 4) {
							Spielfeld.level2();
						}
						else if (feld1[Spielfigurx-1][Spielfigury] = 5) {
							Gewonnen();
						}
						else if (feld1[Spielfigurx-1][Spielfigury] = 0) {
							Spielfigurx=Spielfigurx-1;
						}
				   }
				   
	               if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
	               			if (feld1[Spielfigurx+1][Spielfigury] = 3) {
							Verloren();
						}
						else if (feld1[Spielfigurx+1][Spielfigury] = 4) {
							Spielfeld.level2();
						}
						else if (feld1[Spielfigur+1][Spielfigury] = 5) {
							Gewonnen();
						}
						else if (feld1[Spielfigurx+1][Spielfigury] = 0) {
							Spielfigurx=Spielfigurx+1;
						}
				   }
				   
	               if (e.getKeyCode() == KeyEvent.VK_UP) {
	               			if (feld1[Spielfigurx][Spielfigury-1] = 3) {
							Verloren();
						}
						else if (feld1[Spielfigurx][Spielfigury-1] = 4) {
							Spielfeld.level2();
						}
						else if (feld1[Spielfigur][Spielfigury-1] = 5) {
							Gewonnen();
						}
						else if (feld1[Spielfigurx][Spielfigury-1] = 0) {
							Spielfigury=Spielfigury-1;
						}
				   }
				   
	               if (e.getKeyCode() == KeyEvent.VK_DOWN) {
	               			if (feld1[Spielfigurx][Spielfigury+1] = 3) {
							Verloren();
						}
						else if (feld1[Spielfigurx][Spielfigury+1] = 4) {
							Spielfeld.level2();
						}
						else if (feld1[Spielfigur][Spielfigury+1] = 5) {
							Gewonnen();
						}
						else if (feld1[Spielfigurx][Spielfigury+1] = 0) {
							Spielfigury=Spielfigury+1;
						}
				   }
	            } 
				});*/
	} 
	
	
	/* Eigenschaften des Spielfeldes, führt Methode level1 aus der Klasse Spielfeld aus*/
	public static void Spielfenster() {
		f.setResizable(false);
		f.setTitle("Erna's Adventure");
		f.setSize(805,630);
		f.setLayout(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	//	f.addKeyListener(this);
		
		
		Spielfeld.level1();
	}
	
	public static void Gewonnen() {
		
		try{
			f.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File(direction+"/src/game/Images/Gewonnen.jpg")))));
		}
		catch(IOException a) {
			System.out.println("das Bild kann nicht gefunden werden");
		}
		
		f.setResizable(false);
		f.setSize(800,600);
		f.setLayout(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		f.setLocationRelativeTo(null);
		f.setVisible(true);	
		
		schliessen = new JButton("Dieses Fenster schließen");
		schliessen.setBounds(550,450,200,40);
		f.add(schliessen);
		
		/*registriert Mausklick auf Button start und öffnet das Spielfenster*/
		 ActionListener alschliessen = new ActionListener() {
		      public void actionPerformed( ActionEvent e ) {		
		    	  f.setVisible(false);
		      }
		    };
		schliessen.addActionListener(alschliessen);
	}
	
	public static void Verloren() {
		
		try{
			f.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File(direction+"/src/game/Images/GameOver.jpg")))));
		}
		catch(IOException a) {
			System.out.println("das Bild kann nicht gefunden werden");
		}
		
		f.setResizable(false);
		f.setSize(800,600);
		f.setLayout(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		f.setLocationRelativeTo(null);
		f.setVisible(true);	
		
		schliessen = new JButton("Dieses Fenster schließen");
		schliessen.setBounds(300,450,200,40);
		f.add(schliessen);
		
		/*registriert Mausklick auf Button start und öffnet das Spielfenster*/
		 ActionListener alschliessen = new ActionListener() {
		      public void actionPerformed( ActionEvent e ) {		
		    	  f.setVisible(false);
		      }
		    };
		schliessen.addActionListener(alschliessen);
	}
} 