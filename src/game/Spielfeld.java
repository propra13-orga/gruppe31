package game;

import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * erstellt die Spielfelder
 * @author Denise
 *
 */
public class Spielfeld {  
	
	static String direction = System.getProperty("user.dir");
	
	static Icon iconRasen = new ImageIcon(direction+"/src/game/Images/Rasen.jpg");
	static Icon iconGrenze = new ImageIcon(direction+"/src/game/Images/Grenze.jpg");
	static Icon iconPudel = new ImageIcon(direction+"/src/game/Images/Pudel.png");
	static Icon iconGegner = new ImageIcon(direction+"/src/game/Images/Gegner.png");
	static Icon iconZiel = new ImageIcon(direction+"/src/game/Images/Ziel.jpg");
 
 	/* erstellt das Array; 0: freies Feld, 1: Baum, 2: Pudel, 3: Gegner */
 	public static void level1() {
 		
 		/*erstellt verschiedene Icons für jedes Bild*/
 		
		JLabel[] labels=new JLabel[48];

		
		int [][] feld1 = {{1,1,1,1,1,1,1,1},{1,0,0,0,0,0,0,1},{1,0,0,0,0,0,0,0},
						{1,2,0,0,0,0,0,1},{1,0,0,0,0,0,0,1},{1,1,1,1,1,1,1,1}};
		
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());  //richtiges finden; freie positionieren von Komponenten
		
				for (int i = 0; i < feld1.length; i++) {	
					    for (int j = 0; j < feld1[i].length; j++) {	
					    	
					    	/*Versuch die Bilder an die passenden Stellen zu setzen*/
					    	if (feld1[i][j]==0){
									labels[i]=new JLabel(iconRasen);
									panel.add(labels[i]);
									labels[i].setLocation(i*100,j*100);
								}
							
					    	else if (feld1[i][j]==1){
									labels[i]=new JLabel(iconGrenze);
									labels[i].setLocation(i*100,j*100);
									panel.add(labels[i]);  
								}
							
					    	else if (feld1[i][j]==2){
									labels[i]=new JLabel(iconPudel);
									labels[i].setLocation(i*100,j*100);
									panel.add(labels[i]);
								}
							
					    	else if (feld1[i][j]==3){
									labels[i]=new JLabel(iconGegner);
									labels[i].setLocation(i*100,j*100);
									panel.add(labels[i]);
								}
					    	
						Frame.f.setContentPane(panel);
					   }
				}	
 	}
}

 	

