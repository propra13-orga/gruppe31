 package game;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * erstellt die Spielfelder
 * @author Denise
 *
 */
public class Spielfeld {
	
    static ImageIcon myRasen =new ImageIcon("Images/Rasen.jpg");
    static ImageIcon myGrenze =new ImageIcon("Images/Grenze.jpg");
    static ImageIcon myPudel =new ImageIcon("Images/Pudel.png");
    static ImageIcon myGegner =new ImageIcon("Images/Gegner.png");
    
 
 	/*
 	 * erstellt das Array
 	 * 0: freies Feld, 1: Baum
 	 */
 	public static void level1() {
 		
 		int boxWidth = 20;
 		
		int [][] feld1 = {{1,1,1,1,1,1,1,1},{1,0,0,0,0,0,0,1},{1,0,0,0,0,0,0,1},{1,2,0,0,0,0,0,1},{1,0,0,0,0,0,0,1},{1,1,1,1,1,1,1,1}};
						
		for (int i = 0; i < feld1.length; i++) {
 					for (int j = 0; j < feld1[i].length; j++) {

							if (feld1[i][j]==0){
								JLabel labels[] = new JLabel[feld1.length];
								 for(int i1=0;i1<feld1.length;i1++)
								{
								  labels[i1] = new JLabel (myRasen);
								  frame.f.add(labels[i1]);
								}
							}
							else if (feld1[i][j]==1){
								JLabel labels[] = new JLabel[feld1.length];
								 for(int i1=0;i1<feld1.length;i1++)
								{
								  labels[i1] = new JLabel (myGrenze);
								  frame.f.add(labels[i1]);
								}
							}
							else if (feld1[i][j]==2){
								JLabel labels[] = new JLabel[feld1.length];
								 for(int i1=0;i1<feld1.length;i1++)
								{
								  labels[i1] = new JLabel (myPudel);
								  frame.f.add(labels[i1]);
								}
							}
							else if (feld1[i][j]==3){
								JLabel labels[] = new JLabel[feld1.length];
								 for(int i1=0;i1<feld1.length;i1++)
								{
								  labels[i1] = new JLabel (myGegner);
								  frame.f.add(labels[i1]);
								}
							}
 					}
		}
	}

}	
