package game;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
*erzeugt die Spielfelder in Form eines Arrays und
*setzt an die entsprechenden Werte die passenden 
*Bilder.
*/
public class Spielfeld {
	
	static int Spielfigurx;
	static int Spielfigury;
	
 	/*setzt den Ausgangspunkt bei Pfadangaben auf gruppe31*/
	static String direction = System.getProperty("user.dir");
	
	/* erzeugt verschiedene Icons mit Bildern*/
	static Icon iconRasen = new ImageIcon(direction+"/src/game/Images/Rasen.jpg");
	static Icon iconGrenze = new ImageIcon(direction+"/src/game/Images/Grenze.jpg");
	static Icon iconPudel = new ImageIcon(direction+"/src/game/Images/Pudel.jpg");
	static Icon iconGegner = new ImageIcon(direction+"/src/game/Images/Gegner.jpg");
	static Icon iconZiel = new ImageIcon(direction+"/src/game/Images/Ziel.jpg");
 
 	/* erstellt das Array des ersten Levels; 0: freies Feld, 1: Baum, 2: Pudel, 3: Gegner, 4: Level weiter, 5: Spiel gewonnen*/
 	public static void level1() {
		
		/*erzeugt ein Panel, um Komponenten (hier:Labels) darauf zu setzen; muss im Fokus sein, damit KeyListener greift*/
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setFocusable(true);
		
		int [][] feld1 = {{1,1,1,1,1,1,1,1},
						  {1,2,0,1,0,0,0,1},
						  {1,0,0,1,0,0,0,4},
						  {1,0,0,0,0,0,0,1},
						  {1,0,0,1,0,0,0,1},
						  {1,1,1,1,1,1,1,1}};
		
		/*erstellt so viele Labels, wie für Array benötigt*/
		JLabel[] labels=new JLabel[48];
		
				for (int i = 0; i < feld1.length; i++) {	
					    for (int j = 0; j < feld1[i].length; j++) {	
					    	
					    	/*fügt dem jeweiligen Wert das passende Icon (=Bild) hinzu*/
					    	if (feld1[i][j]==0){
								labels[i]=new JLabel(iconRasen);
								panel.add(labels[i]);
								labels[i].setBounds(j*100,i*100,100,100);
							}
					    	else if (feld1[i][j]==1){
								labels[i]=new JLabel(iconGrenze);
								labels[i].setBounds(j*100,i*100,100,100);
								panel.add(labels[i]);  
							}
					    	else if (feld1[i][j]==2){
					    		Spielfigurx=i;
					    		Spielfigury=j;
								labels[i]=new JLabel(iconPudel);
								labels[i].setBounds(j*100,i*100,100,100);
								panel.add(labels[i]);
							}
					    	else if (feld1[i][j]==4){
								labels[i]=new JLabel(iconRasen);
								labels[i].setBounds(j*100,i*100,100,100);
								panel.add(labels[i]);
							}
						Frame.f.setContentPane(panel);
					   }
				}	
 	}
 	
 	public static void level2() {

		int [][] feld2 = {{1,1,1,1,1,1,1,1},
						  {1,0,0,0,0,0,0,1},
						  {2,0,1,0,1,1,1,1},
						  {1,1,1,0,0,0,0,1},
						  {1,0,0,0,1,0,0,4},
						  {1,1,1,1,1,1,1,1}};
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		/*erstellt verschiedene Icons für jedes Bild*/
		JLabel[] labels=new JLabel[48];
		
				for (int i = 0; i < feld2.length; i++) {	
					    for (int j = 0; j < feld2[i].length; j++) {	
					    	
					    	/*Versuch die Bilder an die passenden Stellen zu setzen*/
					    	if (feld2[i][j]==0){
								labels[i]=new JLabel(iconRasen);
								panel.add(labels[i]);
								labels[i].setBounds(j*100,i*100,100,100);
							}
					    	else if (feld2[i][j]==1){
								labels[i]=new JLabel(iconGrenze);
								labels[i].setBounds(j*100,i*100,100,100);
								panel.add(labels[i]);  
							}	
					    	else if (feld2[i][j]==2){
								labels[i]=new JLabel(iconPudel);
								labels[i].setBounds(j*100,i*100,100,100);
								panel.add(labels[i]);
							}
					    	else if (feld2[i][j]==3){
								labels[i]=new JLabel(iconGegner);
								labels[i].setBounds(j*100,i*100,100,100);
								panel.add(labels[i]);
							}
					    	else if (feld2[i][j]==4){
								labels[i]=new JLabel(iconRasen);
								labels[i].setBounds(j*100,i*100,100,100);
								panel.add(labels[i]);
							}
						Frame.f.setContentPane(panel);
					   }
				}	
 	}
 	
 	public static void level3() {

		int [][] feld3 = {{1,1,1,1,1,1,1,1},
						  {1,0,3,0,0,0,0,1},
						  {1,0,0,0,1,0,0,5},
						  {1,1,1,0,1,0,0,1},
						  {2,0,0,0,1,0,3,1},
						  {1,1,1,1,1,1,1,1}};
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		/*erstellt verschiedene Icons für jedes Bild*/
		JLabel[] labels=new JLabel[48];
		
				for (int i = 0; i < feld3.length; i++) {	
					    for (int j = 0; j < feld3[i].length; j++) {	
					    	
					    	/*Versuch die Bilder an die passenden Stellen zu setzen*/
					    	if (feld3[i][j]==0){
									labels[i]=new JLabel(iconRasen);
									panel.add(labels[i]);
									labels[i].setBounds(j*100,i*100,100,100);
								}
							
					    	else if (feld3[i][j]==1){
								labels[i]=new JLabel(iconGrenze);
								labels[i].setBounds(j*100,i*100,100,100);
								panel.add(labels[i]);  
							}
							
					    	else if (feld3[i][j]==2){
								labels[i]=new JLabel(iconPudel);
								labels[i].setBounds(j*100,i*100,100,100);
								panel.add(labels[i]);
							}
							
					    	else if (feld3[i][j]==3){
								labels[i]=new JLabel(iconGegner);
								labels[i].setBounds(j*100,i*100,100,100);
								panel.add(labels[i]);
							}
					    	else if (feld3[i][j]==4){
								labels[i]=new JLabel(iconRasen);
								labels[i].setBounds(j*100,i*100,100,100);
								panel.add(labels[i]);
							}
					    	else if (feld3[i][j]==5){
					    		labels[i]=new JLabel(iconZiel);
								labels[i].setBounds(j*100,i*100,100,100);
								panel.add(labels[i]);
							}
					    Frame.f.setContentPane(panel);
					    }
				}	
 	}
}

 	

