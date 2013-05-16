package game;

import java.awt.BorderLayout;
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
	
	static String bla = System.getProperty("user.dir");
	
	static Icon iconRasen = new ImageIcon(bla + "/gruppe31/gruppe31/src/game/Images/Rasen.jpg");
	static Icon iconGrenze = new ImageIcon("src/Game/Images/Grenze.jpg");
	static Icon iconPudel = new ImageIcon("src/Game/Images/Pudel.png");
	static Icon iconGegner = new ImageIcon("src/Game/Images/Gegner.png");
	static Icon iconZiel = new ImageIcon("src/Game/Images/Ziel.jpg");
 
 	/* erstellt das Array; 0: freies Feld, 1: Baum, 2: Pudel, 3: Gegner */
 	public static void level1() {
 		
 		/*erstellt verschiedene Icons für jedes Bild*/
 		
		JLabel[] labels=new JLabel[48];
		
		int [][] feld1 = {{1,1,1,1,1,1,1,1},{1,0,0,0,0,0,0,1},{1,0,0,0,0,0,0,1},{1,2,0,0,0,0,0,1},{1,0,0,0,0,0,0,1},{1,1,1,1,1,1,1,1}};
		
		JPanel panel = new JPanel();
		
				for (int i = 0; i < feld1.length; i++) {	
					    for (int j = 0; j < feld1[i].length; j++) {	
					    	  	
					    	/*Versuch die Bilder an die passenden Stellen zu setzen*/
					    	if (feld1[i][j]==0){

									labels[i]=new JLabel(iconRasen);
									panel.add(labels[i],BorderLayout.CENTER);
						            panel.setVisible(true);
						            /*// gibt jede Ausgabe in der Konsole an. ->insgesamt 48x */
						            System.out.println("i="+i+"\tj="+j+"\tfeldtyp="+feld1[i][j]);
								}
							
					    	else if (feld1[i][j]==1){
									labels[i]=new JLabel(iconGrenze);
									panel.add(labels[i], BorderLayout.CENTER);
						            panel.setVisible(true);
						            System.out.println("i="+i+"\tj="+j+"\tfeldtyp="+feld1[i][j]);
								}
							
					    	else if (feld1[i][j]==2){
									labels[i]=new JLabel(iconPudel);
									panel.add(labels[i], BorderLayout.CENTER);
						            panel.setVisible(true);
						            System.out.println("i="+i+"\tj="+j+"\tfeldtyp="+feld1[i][j]);
								}
							
					    	else if (feld1[i][j]==3){
									labels[i]=new JLabel(iconGegner);
									panel.add(labels[i], BorderLayout.CENTER);
						            panel.setVisible(true);  
						            System.out.println("i="+i+"\tj="+j+"\tfeldtyp="+feld1[i][j]);
								}
							
					   }
				}
				
			Frame.f.add(panel);
 	}
 	
public static void level2() {
 		
 		/*erstellt verschiedene Icons für jedes Bild*/
 		
		JLabel[] labels=new JLabel[48];
		
		int [][] feld1 = {{1,1,1,1,1,1,1,1},{1,0,0,0,1,0,0,1},{1,0,0,0,1,0,0,1},{1,2,0,0,0,0,0,1},{1,0,0,0,0,1,1,1},{1,1,1,1,1,4,1,1}};
		
				for (int i = 0; i < feld1.length; i++) {	
					    for (int j = 0; j < feld1[i].length; j++) {	
					    	  	
					    	/*Versuch die Bilder an die passenden Stellen zu setzen*/
					    	if (feld1[i][j]==0){

									labels[i]=new JLabel(iconRasen);
									Frame.f.getContentPane().add(labels[i],BorderLayout.CENTER);
						            Frame.f.pack();
						            Frame.f.setVisible(true);
						            /*// gibt jede Ausgabe in der Konsole an. ->insgesamt 48x */
						            System.out.println("i="+i+"\tj="+j+"\tfeldtyp="+feld1[i][j]);
								}
							
					    	else if (feld1[i][j]==1){
									labels[i]=new JLabel(iconGrenze);
									Frame.f.getContentPane().add(labels[i], BorderLayout.CENTER);
						            Frame.f.pack();
						            Frame.f.setVisible(true);
						            System.out.println("i="+i+"\tj="+j+"\tfeldtyp="+feld1[i][j]);
								}
							
					    	else if (feld1[i][j]==2){
									labels[i]=new JLabel(iconPudel);
									Frame.f.getContentPane().add(labels[i], BorderLayout.CENTER);
						            Frame.f.pack();
						            Frame.f.setVisible(true);
						            System.out.println("i="+i+"\tj="+j+"\tfeldtyp="+feld1[i][j]);
								}
							
					    	else if (feld1[i][j]==3){
									labels[i]=new JLabel(iconGegner);
									Frame.f.getContentPane().add(labels[i], BorderLayout.CENTER);
						            Frame.f.pack();
						            Frame.f.setVisible(true);  
						            System.out.println("i="+i+"\tj="+j+"\tfeldtyp="+feld1[i][j]);
								}
					    	else if (feld1[i][j]==4){
								labels[i]=new JLabel(iconRasen);
								Frame.f.getContentPane().add(labels[i], BorderLayout.CENTER);
					            Frame.f.pack();
					            Frame.f.setVisible(true);  
					            System.out.println("i="+i+"\tj="+j+"\tfeldtyp="+feld1[i][j]);
							}
							
					   }
				}
 	}

public static void level3() {
		
		/*erstellt verschiedene Icons für jedes Bild*/
		
	JLabel[] labels=new JLabel[48];
	
	int [][] feld1 = {{1,2,1,1,1,1,1,1},{1,0,0,0,1,0,0,1},{1,0,0,0,1,1,0,1},{1,0,0,0,0,1,0,1},{1,0,0,0,0,1,0,1},{1,1,5,1,1,1,1,1}};
	
			for (int i = 0; i < feld1.length; i++) {	
				    for (int j = 0; j < feld1[i].length; j++) {	
				    	  	
				    	/*Versuch die Bilder an die passenden Stellen zu setzen*/
				    	if (feld1[i][j]==0){

								labels[i]=new JLabel(iconRasen);
								Frame.f.getContentPane().add(labels[i],BorderLayout.CENTER);
					            Frame.f.pack();
					            Frame.f.setVisible(true);
					            /*// gibt jede Ausgabe in der Konsole an. ->insgesamt 48x */
					            System.out.println("i="+i+"\tj="+j+"\tfeldtyp="+feld1[i][j]);
							}
						
				    	else if (feld1[i][j]==1){
								labels[i]=new JLabel(iconGrenze);
								Frame.f.getContentPane().add(labels[i], BorderLayout.CENTER);
					            Frame.f.pack();
					            Frame.f.setVisible(true);
					            System.out.println("i="+i+"\tj="+j+"\tfeldtyp="+feld1[i][j]);
							}
						
				    	else if (feld1[i][j]==2){
								labels[i]=new JLabel(iconPudel);
								Frame.f.getContentPane().add(labels[i], BorderLayout.CENTER);
					            Frame.f.pack();
					            Frame.f.setVisible(true);
					            System.out.println("i="+i+"\tj="+j+"\tfeldtyp="+feld1[i][j]);
							}
						
				    	else if (feld1[i][j]==3){
								labels[i]=new JLabel(iconGegner);
								Frame.f.getContentPane().add(labels[i], BorderLayout.CENTER);
					            Frame.f.pack();
					            Frame.f.setVisible(true);  
					            System.out.println("i="+i+"\tj="+j+"\tfeldtyp="+feld1[i][j]);
							}
				    	else if (feld1[i][j]==4){
							labels[i]=new JLabel(iconRasen);
							Frame.f.getContentPane().add(labels[i], BorderLayout.CENTER);
				            Frame.f.pack();
				            Frame.f.setVisible(true);  
				            System.out.println("i="+i+"\tj="+j+"\tfeldtyp="+feld1[i][j]);
						}
				    	else if (feld1[i][j]==5){
							labels[i]=new JLabel(iconZiel);
							Frame.f.getContentPane().add(labels[i], BorderLayout.CENTER);
				            Frame.f.pack();
				            Frame.f.setVisible(true);  
				            System.out.println("i="+i+"\tj="+j+"\tfeldtyp="+feld1[i][j]);
						}	
				   }
			}
	}
}

 	

