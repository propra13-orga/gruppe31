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
 
 	/*
 	 * erstellt das Array
 	 * 0: freies Feld, 1: Baum, 2: Pudel, 3: Gegner
 	 */
 	public static  JLabel[] level1() {
 		
 		int boxWidth = 20;
 		
 		/*erstellt verschiedene Icons für jedes Bild*/
		Icon iconRasen = new ImageIcon("src/Game/Images/Rasen.jpg");
		Icon iconGrenze = new ImageIcon("src/Game/Images/Grenze.jpg");
		Icon iconPudel = new ImageIcon("src/Game/Images/Pudel.png");
		Icon iconGegner = new ImageIcon("src/Game/Images/Gegner.png");
 		
		int [][] feld1 = {{1,1,1,1,1,1,1,1},{1,0,0,0,0,0,0,1},{1,0,0,0,0,0,0,1},{1,2,0,0,0,0,0,1},{1,0,0,0,0,0,0,1},{1,1,1,1,1,1,1,1}};
		
				for (int i = 0; i < feld1.length; i++) {	
					    for (int j = 0; j < feld1[i].length; j++) {	
					    	
					    	/*Versuch die Bilder an die passenden Stellen zu setzen*/
					    	if (feld1[i][j]==0){
					    		JLabel[] labels=new JLabel[48];
								for (int i1=0;i1<10;i1++) {
									labels[i1]=new JLabel(iconRasen);
									frame.f.getContentPane().add(labels[i1], BorderLayout.CENTER);
						            frame.f.pack();
						            frame.f.setVisible(true);
								}
							}
					    	else if (feld1[i][j]==1){
					    		JLabel[] labels=new JLabel[48];
								for (int i1=0;i1<10;i1++) {
									labels[i1]=new JLabel(iconGrenze);
									frame.f.getContentPane().add(labels[i1], BorderLayout.CENTER);
						            frame.f.pack();
						            frame.f.setVisible(true);
								}
							}
					    	else if (feld1[i][j]==1){
					    		JLabel[] labels=new JLabel[48];
								for (int i1=0;i1<10;i1++) {
									labels[i1]=new JLabel(iconPudel);
									frame.f.getContentPane().add(labels[i1], BorderLayout.CENTER);
						            frame.f.pack();
						            frame.f.setVisible(true);
								}
							}
					    	else if (feld1[i][j]==1){
					    		JLabel[] labels=new JLabel[48];
								for (int i1=0;i1<10;i1++) {
									labels[i1]=new JLabel(iconGegner);
									frame.f.getContentPane().add(labels[i1], BorderLayout.CENTER);
						            frame.f.pack();
						            frame.f.setVisible(true);
								}
							}
		  
					   }
				}
			return null;
 	}
}

 	

