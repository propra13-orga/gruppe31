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
		
	static String direction = System.getProperty("user.dir");
	
	static Icon iconRasen = new ImageIcon(direction+"/src/game/Images/Rasen.jpg");
	static Icon iconGrenze = new ImageIcon(direction+"/src/game/Images/Grenze.jpg");
	static Icon iconPudel = new ImageIcon(direction+"/src/game/Images/Pudel.jpg");
	static Icon iconGegner = new ImageIcon(direction+"/src/game/Images/Gegner.jpg");
	static Icon iconZiel = new ImageIcon(direction+"/src/game/Images/Ziel.jpg");
	
	public static JButton start;
	public static JButton ende;
	public static JButton schliessen;
	
	public static JFrame F = new Frame();
	public static JFrame f = new Frame();
	
	static int Spielfigurx;
	static int Spielfigury;
	
	static int[][] aktuellesSpielfeld;
	
	static final int[][] feld1 = {{1,1,1,1,1,1,1,1},
								  {1,2,0,1,0,0,0,1},
								  {1,0,0,1,0,0,0,4},
								  {1,0,0,0,0,0,0,1},
								  {1,0,0,1,0,0,0,1},
								  {1,1,1,1,1,1,1,1}};
	
	static final int [][] feld2 = {{1,1,1,1,1,1,1,1},
								   {1,0,0,0,0,0,0,1},
								   {2,0,1,0,1,1,1,1},
								   {1,1,1,0,0,0,0,1},
								   {1,0,0,0,1,0,0,4},
								   {1,1,1,1,1,1,1,1}};
	
	static final int [][] feld3 = {{1,1,1,1,1,1,1,1},
									{1,0,3,0,0,0,0,1},
									{1,0,0,0,1,0,0,5},
									{1,1,1,0,1,0,0,1},
									{2,0,0,0,1,0,3,1},
									{1,1,1,1,1,1,1,1}};
	
	public void processKeyEvent(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) { 
			System.out.println("es wurde links gedrückt");
		}
		else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			System.out.println("es wurde rechts gedrückt");
		}
		else if (e.getKeyCode() == KeyEvent.VK_UP) {
			System.out.println("es wurde hoch gedrückt");
		}
		else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			System.out.println("es wurde runter gedrückt");
		}
	}
	
	public Frame() {
		aktuellesSpielfeld=feld1;
	}
		
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
	}
	
	public static void Spielfenster() {
		f.setResizable(false);
		f.setTitle("Erna's Adventure");
		f.setSize(800,600);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		f.setLayout(null);
		
		aktuellesSpielfeld=feld1;
		
		Levelaufruf(aktuellesSpielfeld);
	}
	
	/* Eigenschaften des Spielfeldes, führt Methode level1 aus der Klasse Spielfeld aus*/
	public static void Levelaufruf(int [][] feld) {
		JPanel panel = new JPanel();
		panel.setLayout(null);		
		
		/*erstellt so viele Labels, wie für Array benötigt*/
		JLabel[] labels=new JLabel[48];
		
				for (int i = 0; i < feld.length; i++) {	
					    for (int j = 0; j < feld[i].length; j++) {	
					    	
					    	/*fügt dem jeweiligen Wert das passende Icon (=Bild) hinzu*/
					    	if (feld[i][j]==0){
								labels[i]=new JLabel(iconRasen);
								panel.add(labels[i]);
								labels[i].setBounds(j*100,i*100,100,100);
							}
					    	else if (feld[i][j]==1){
								labels[i]=new JLabel(iconGrenze);
								labels[i].setBounds(j*100,i*100,100,100);
								panel.add(labels[i]);  
							}
					    	else if (feld[i][j]==2){
					    		Spielfigurx=i;
					    		Spielfigury=j;
								labels[i]=new JLabel(iconPudel);
								labels[i].setBounds(j*100,i*100,100,100);
								panel.add(labels[i]);
							}
					    	else if (feld[i][j]==4){
								labels[i]=new JLabel(iconRasen);
								labels[i].setBounds(j*100,i*100,100,100);
								panel.add(labels[i]);
							}
						Frame.f.setContentPane(panel);
					   }
				}	
 	}
	
	public static void Gewonnen() {
		
		try{
			F.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File(direction+"/src/game/Images/Gewonnen.jpg")))));
		}
		catch(IOException a) {
			System.out.println("das Bild kann nicht gefunden werden");
		}
		
		F.setResizable(false);
		F.setSize(800,600);
		F.setLayout(null);
		F.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		F.setLocationRelativeTo(null);
		F.setVisible(true);	
		
		schliessen = new JButton("Dieses Fenster schließen");
		schliessen.setBounds(550,450,200,40);
		F.add(schliessen);
		
		ActionListener alschliessen = new ActionListener() {
			public void actionPerformed( ActionEvent e ) {		
				F.setVisible(false);
		    }
		};
		
		schliessen.addActionListener(alschliessen);
	}
	
	public static void Verloren() {
		
		try{
			F.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File(direction+"/src/game/Images/GameOver.jpg")))));
		}
		catch(IOException a) {
			System.out.println("das Bild kann nicht gefunden werden");
		}
		
		F.setResizable(false);
		F.setSize(800,600);
		F.setLayout(null);
		F.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		F.setLocationRelativeTo(null);
		F.setVisible(true);	
		
		schliessen = new JButton("Dieses Fenster schließen");
		schliessen.setBounds(300,450,200,40);
		F.add(schliessen);
		
		ActionListener alschliessen = new ActionListener() {
			public void actionPerformed( ActionEvent e ) {		
				F.setVisible(false);
		    }
		};	
		schliessen.addActionListener(alschliessen);
	}
} 