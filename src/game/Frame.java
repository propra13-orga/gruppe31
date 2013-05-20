package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

/** diese Klasse erzeugt sowohl das Menüfenster,
 * als auch das Spielfenster. Die Buttons im Menüfenster
 * sind anklickbar und bewirken das Schließen des Fensters,
 * oder das Öffnen des Spielfensters. 
 */
	public class Frame extends JFrame implements KeyListener {
		
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
	
	/* beim Start des Programms ist das aktuelleSpielfeld=das erste Level
	public Frame() {
		aktuellesSpielfeld=feld1;
	}*/
		
	/* ruft das Menüfenster auf*/
	public static void main(String[] args) { 
		aktuellesSpielfeld=feld1;
		Menufenster();
	}
	
	/*erzeugt das Menüfenster mit zwei Buttons,einem Label und Hintergrundbild*/
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
		
		/*beendet das Programm, wenn auf Button ende geklickt wird*/
		ActionListener alende = new ActionListener() {
			public void actionPerformed( ActionEvent e ) {
				System.exit(0);
		    }
		};
		    
		/*weist den Buttons den entsprechenden ActionListener zu */
		start.addActionListener(alstart);
		ende.addActionListener(alende);
	}
	
	/*erzeugt das Spielfenster, setzt diverse Einstellungen und erzeugt darauf das aktuelle Spielfeld*/
	public static void Spielfenster() {
		f.setResizable(false);
		f.setTitle("Erna's Adventure");
		f.setSize(800,630);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		f.setLayout(null);
		
		Levelaufruf(aktuellesSpielfeld);
	}
	
	/* allgemeine Methode zum Erzeugen der Level*/
	public static void Levelaufruf(int [][] feld) {
		/*erzeugt Panel um darauf arbeiten zu können*/
		JPanel panel = new JPanel();
		panel.setLayout(null);	
		panel.setFocusable(true);
		
		/*erstellt so viele Labels, wie für Array benötigt*/
		JLabel[] labels=new JLabel[48];
				
				/*geht das gesamte Array durch*/
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
					    		/*hält die Position der Spielfigur fest*/
					    		Spielfigurx=j;
					    		Spielfigury=i;
								labels[i]=new JLabel(iconPudel);
								labels[i].setBounds(j*100,i*100,100,100);
								panel.add(labels[i]);
							}
					    	else if (feld[i][j]==3){
								labels[i]=new JLabel(iconGegner);
								labels[i].setBounds(j*100,i*100,100,100);
								panel.add(labels[i]);
							}
					    	else if (feld[i][j]==4){
								labels[i]=new JLabel(iconRasen);
								labels[i].setBounds(j*100,i*100,100,100);
								panel.add(labels[i]);
							}
					    	else if (feld[i][j]==5){
								labels[i]=new JLabel(iconZiel);
								labels[i].setBounds(j*100,i*100,100,100);
								panel.add(labels[i]);
							}
						f.setContentPane(panel);
					   }
				}	
 	}
	
	/*das Gewonnenfenster wird erzeugt*/
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
		
		/* der Button schliessen bewirkt ein Verschwinden des Fensters, sodass das Menufenster zu sehen ist*/
		schliessen = new JButton("Dieses Fenster schließen");
		schliessen.setBounds(550,450,200,40);
		f.add(schliessen);
		
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
		
		/* der Button schliessen bewirkt ein Verschwinden des Fensters, sodass das Menufenster zu sehen ist*/
		schliessen = new JButton("Dieses Fenster schließen");
		schliessen.setBounds(550,450,200,40);
		f.add(schliessen);
		
		ActionListener alschliessen = new ActionListener() {
			public void actionPerformed( ActionEvent e ) {		
				f.setVisible(false);
		    }
		};
		schliessen.addActionListener(alschliessen);
	}
	
	protected void LevelAktualisieren() {
		validate(); 
	    repaint();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// nothing to do here
	}

	@Override
	public void keyReleased(KeyEvent e) {
		//nothing to do here
	}

	@Override
	public void keyTyped(KeyEvent e) {
		/*fragt die KeyEvents ab und führt das Programm entsprechend weiter*/
			if (e.getKeyCode() == KeyEvent.VK_LEFT) { 
				System.out.println("es wurde links gedrückt");
				/*wenn der Wert des abgefragten Feldes 3 ist, erscheint das Verlorenfenster*/
				if (aktuellesSpielfeld[Spielfigurx][Spielfigury-1] == 3) {
					Verloren();
				}
				/*wenn der Wert des abgefragten Feldes 4 ist, erscheint das nächste Level*/
				else if (aktuellesSpielfeld[Spielfigurx][Spielfigury-1] == 4) {
					Levelaufruf(feld2);
				}
				/*wenn der Wert des abgefragten Feldes 5 ist, erscheint das Gewonnenfenster*/
				else if (aktuellesSpielfeld[Spielfigurx][Spielfigury-1] == 5) {
					Gewonnen();
				}
				else if (aktuellesSpielfeld[Spielfigurx][Spielfigury-1] == 0) {
					/*wenn der Wert des abgefragten Feldes 0 ist, 
					 * wird das aktuelle Feld der Spielfigur auf 0 gesetzt*/
					aktuellesSpielfeld[Spielfigurx][Spielfigury] = 0;
					/* die x-Position zählt einen runter*/
					Spielfigury--;
					/* die neue Position der Spielfigur erhält den Wert 2*/
					aktuellesSpielfeld[Spielfigurx][Spielfigury] = 2;
					/* und das Leve wird erneut aufgerufen*/
					Levelaufruf(aktuellesSpielfeld);
					LevelAktualisieren();
				}
			}
			
			else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				System.out.println("es wurde rechts gedrückt");
				if (aktuellesSpielfeld[Spielfigurx][Spielfigury+1] == 3) {
					Verloren();
				}
				else if (aktuellesSpielfeld[Spielfigurx][Spielfigury+1] == 4) {
					Levelaufruf(feld2);
				}
				else if (aktuellesSpielfeld[Spielfigurx][Spielfigury+1] == 5) {
					Gewonnen();
				}
				else if (aktuellesSpielfeld[Spielfigurx][Spielfigury+1] == 0) {
					aktuellesSpielfeld[Spielfigurx][Spielfigury] = 0;
					Spielfigury++;
					aktuellesSpielfeld[Spielfigurx][Spielfigury] = 2;
					Levelaufruf(aktuellesSpielfeld);
					LevelAktualisieren();
				}
			}
			
			else if (e.getKeyCode() == KeyEvent.VK_UP) {
				System.out.println("es wurde hoch gedrückt");
				if (aktuellesSpielfeld[Spielfigurx-1][Spielfigury] == 3) {
					Verloren();
				}
				else if (aktuellesSpielfeld[Spielfigurx-1][Spielfigury] == 4) {
					Levelaufruf(feld2);
				}
				else if (aktuellesSpielfeld[Spielfigurx-1][Spielfigury] == 5) {
					Gewonnen();
				}
				else if (aktuellesSpielfeld[Spielfigurx-1][Spielfigury] == 0) {
					aktuellesSpielfeld[Spielfigurx][Spielfigury] = 0;
					Spielfigurx--;
					aktuellesSpielfeld[Spielfigurx][Spielfigury] = 2;
					Levelaufruf(aktuellesSpielfeld);
					LevelAktualisieren();
				}
			}
			
			else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				System.out.println("es wurde runter gedrückt");
				if (aktuellesSpielfeld[Spielfigurx+1][Spielfigury] == 3) {
					Verloren();
				}
				else if (aktuellesSpielfeld[Spielfigurx+1][Spielfigury] == 4) {
					Levelaufruf(feld2);
				}
				else if (aktuellesSpielfeld[Spielfigurx+1][Spielfigury] == 5) {
					Gewonnen();
				}
				else if (aktuellesSpielfeld[Spielfigurx+1][Spielfigury] == 0) {
					aktuellesSpielfeld[Spielfigurx][Spielfigury] = 0;
					Spielfigurx++;
					aktuellesSpielfeld[Spielfigurx][Spielfigury] = 2;
					Levelaufruf(aktuellesSpielfeld);
					LevelAktualisieren();
				}
			}
		
	}
} 