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
	public class GameFrame extends JFrame implements KeyListener{
		
	static String direction = System.getProperty("user.dir");
	
	static Icon iconRasen = new ImageIcon(direction+"/src/game/Images/Rasen.jpg");
	static Icon iconGrenze = new ImageIcon(direction+"/src/game/Images/Grenze.jpg");
	static Icon iconPudel = new ImageIcon(direction+"/src/game/Images/Pudel.jpg");
	static Icon iconGegner = new ImageIcon(direction+"/src/game/Images/Gegner.jpg");
	static Icon iconZiel = new ImageIcon(direction+"/src/game/Images/Ziel.jpg");
	
	public JButton schliessen;
	
	int Spielfigurx;
	int Spielfigury;
	
	int[][] aktuellesSpielfeld;
	int level;
	
	static final int [][][] levels = { 
		{{1,1,1,1,1,1,1,1},
		{1,2,0,1,0,0,0,1},
		{1,0,0,1,0,0,0,4},
		{1,0,0,0,0,0,0,1},
		{1,0,0,1,0,0,0,1},
		{1,1,1,1,1,1,1,1}},
			
	   {{1,1,1,1,1,1,1,1},
		{1,0,0,0,0,0,0,1},
		{2,0,1,0,1,1,1,1},
		{1,1,1,0,0,0,0,1},
		{1,0,0,0,1,0,0,4},
		{1,1,1,1,1,1,1,1}},
		
		{{1,1,1,1,1,1,1,1},
		{1,0,3,0,0,0,0,1},
		{1,0,0,0,1,0,0,5},
		{1,1,1,0,1,0,0,1},
		{2,0,0,0,1,0,3,1},
		{1,1,1,1,1,1,1,1}}
	};
	
	public GameFrame() {
		addKeyListener(this);
		this.setResizable(false);
		this.setTitle("Erna's Adventure");
		this.setSize(800,630);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setLayout(null);
		
		level=-1;
		NextLevel();
	}
	
	/* allgemeine Methode zum Erzeugen der Level*/
	public void Levelaufruf(int [][] feld) {
		/*erzeugt Panel um darauf arbeiten zu können*/
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
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
					    		Spielfigurx=i;
					    		Spielfigury=j;
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
						this.setContentPane(panel);
					   }
				}	
 	}
	
	/*das Gewonnenfenster wird erzeugt*/
	public void Gewonnen() {
		
		try{
			this.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File(direction+"/src/game/Images/Gewonnen.jpg")))));
		}
		catch(IOException a) {
			System.out.println("das Bild kann nicht gefunden werden");
		}
		
		this.setResizable(false);
		this.setSize(800,600);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		this.setLocationRelativeTo(null);
		this.setVisible(true);	
		
		/* der Button schliessen bewirkt ein Verschwinden des Fensters, sodass das Menufenster zu sehen ist*/
		schliessen = new JButton("Dieses Fenster schließen");
		schliessen.setBounds(550,450,200,40);
		this.add(schliessen);
		
		ActionListener alschliessen = new ActionListener() {
			public void actionPerformed( ActionEvent e ) {		
				dispose();
		    }
		};
		schliessen.addActionListener(alschliessen);
	}
	
	public void Verloren() {
		
		try{
			this.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File(direction+"/src/game/Images/GameOver.jpg")))));
		}
		catch(IOException a) {
			System.out.println("das Bild kann nicht gefunden werden");
		}
		
		this.setResizable(false);
		this.setSize(800,600);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		this.setLocationRelativeTo(null);
		this.setVisible(true);	
		
		/* der Button schliessen bewirkt ein Verschwinden des Fensters, sodass das Menufenster zu sehen ist*/
		schliessen = new JButton("Dieses Fenster schließen");
		schliessen.setBounds(550,450,200,40);
		this.add(schliessen);
		
		ActionListener alschliessen = new ActionListener() {
			public void actionPerformed( ActionEvent e ) {		
				dispose();
		    }
		};
		schliessen.addActionListener(alschliessen);
	}
	
	protected void LevelAktualisieren() {
		validate(); 
	    repaint();
	}
	
	protected void NextLevel() {
		level++;
		int[][] reference = levels[level];
		aktuellesSpielfeld= new int [reference.length][reference[0].length];
		for (int x=0; x<reference.length; x++) {
			for (int y =0; y<reference[0].length; y++) {
				aktuellesSpielfeld[x][y] = reference[x][y];
			}
		}
		Levelaufruf(aktuellesSpielfeld);
		LevelAktualisieren();
	}

	public void keyReleased(KeyEvent e) {
		/*fragt die KeyEvents ab und führt das Programm entsprechend weiter*/
			if (e.getKeyCode() == KeyEvent.VK_LEFT) { 
				System.out.println("es wurde links gedrückt");
				/*wenn der Wert des abgefragten Feldes 3 ist, erscheint das Verlorenfenster*/
				if (aktuellesSpielfeld[Spielfigurx][Spielfigury-1] == 3) {
					Verloren();
				}
				/*wenn der Wert des abgefragten Feldes 4 ist, erscheint das nächste Level*/
				else if (aktuellesSpielfeld[Spielfigurx][Spielfigury-1] == 4) {
					NextLevel();
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
				if (aktuellesSpielfeld[Spielfigurx-1][Spielfigury+1] == 3) {
					Verloren();
				}
				else if (aktuellesSpielfeld[Spielfigurx][Spielfigury+1] == 4) {
					NextLevel();
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
					NextLevel();
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
					NextLevel();
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

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
} 