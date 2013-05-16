package game;

import java.awt.BorderLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * erstellt die Spielfelder
 * @author Denise
 *
 */
public class Spielfeld {    
 
 	/* erstellt das Array; 0: freies Feld, 1: Baum, 2: Pudel, 3: Gegner */
 	public static void level1() {
 		
 		/*erstellt verschiedene Icons für jedes Bild*/
		Icon iconRasen = new ImageIcon("src/Game/Images/Rasen.jpg");
		Icon iconGrenze = new ImageIcon("src/Game/Images/Grenze.jpg");
		Icon iconPudel = new ImageIcon("src/Game/Images/Pudel.png");
		Icon iconGegner = new ImageIcon("src/Game/Images/Gegner.png");
 		
		JLabel[] labels=new JLabel[48];
		
		/*ContentPane Container*/
		
		int [][] feld1 = {{1,1,1,1,1,1,1,1},{1,0,0,0,0,0,0,1},{1,0,0,0,0,0,0,1},{1,2,0,0,0,0,0,1},{1,0,0,0,0,0,0,1},{1,1,1,1,1,1,1,1}};
		
				for (int i = 0; i < feld1.length; i++) {	
					    for (int j = 0; j < feld1[i].length; j++) {	
					    	  	
					    	/*Versuch die Bilder an die passenden Stellen zu setzen*/
					    	if (feld1[i][j]==0){

									labels[i]=new JLabel(iconRasen);
									frame.f.getContentPane().add(labels[i],BorderLayout.CENTER);
						            frame.f.pack();
						            frame.f.setVisible(true);
						            /*// gibt jede Ausgabe in der Konsole an. ->insgesamt 48x */
						            System.out.println("i="+i+"\tj="+j+"\tfeldtyp="+feld1[i][j]);
								}
							
					    	else if (feld1[i][j]==1){
									labels[i]=new JLabel(iconGrenze);
									frame.f.getContentPane().add(labels[i], BorderLayout.CENTER);
						            frame.f.pack();
						            frame.f.setVisible(true);
						            System.out.println("i="+i+"\tj="+j+"\tfeldtyp="+feld1[i][j]);
								}
							
					    	else if (feld1[i][j]==2){
									labels[i]=new JLabel(iconPudel);
									frame.f.getContentPane().add(labels[i], BorderLayout.CENTER);
						            frame.f.pack();
						            frame.f.setVisible(true);
						            System.out.println("i="+i+"\tj="+j+"\tfeldtyp="+feld1[i][j]);
								}
							
					    	else if (feld1[i][j]==3){
									labels[i]=new JLabel(iconGegner);
									frame.f.getContentPane().add(labels[i], BorderLayout.CENTER);
						            frame.f.pack();
						            frame.f.setVisible(true);  
						            System.out.println("i="+i+"\tj="+j+"\tfeldtyp="+feld1[i][j]);
								}
							
					   }
				}
 	}
}

 	

