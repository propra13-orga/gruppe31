package game;

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
	 * erstellt das Array für das erste Level
	 * 0: freies Feld, 1: Baum
	 */
	public static void level1() {
	//	int boxWidth = 20;			//um Position zu setzen
		int [][] feld1 = {{ 0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},{1,2,0,0,0,0,0,0,0,0,0,0,0,0,0,1}, {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}};
		
		for (int i = 0; i < feld1.length; i++) {
			for (int j = 0; j < feld1[i].length; j++) {
			//	int x = boxWidth * j;
			//	int y = boxWidth * i;
				
				if (feld1[i][j]==0){
					Icon _icon = new ImageIcon("Rasen.jpg");
					JLabel _label = new JLabel(_icon);
					frame.spielfenster.add(_label);
				}
				else if (feld1[i][j]==1){
					Icon _icon = new ImageIcon("Grenze.jpg");
					JLabel _label = new JLabel(_icon);
					frame.spielfenster.add(_label);
				}
				else if (feld1[i][j]==2){
					Icon _icon = new ImageIcon("Pudel.png");
					JLabel _label = new JLabel(_icon);
					frame.spielfenster.add(_label);
				}
				else if (feld1[i][j]==3){
					Icon _icon = new ImageIcon("Gegnger.png");
					JLabel _label = new JLabel(_icon);
					frame.spielfenster.add(_label);
				}
				
				/*JLabel spielfeld = new JLabel ("Bild");	//Label erstellen
				spielfeld.setBounds(x,y,50,50);			//Position setzen
				frame.spielfenster.add(spielfeld);		//Label dem Spielfenster hinzufügen
				*/
			}
		}
	}

	/*
	 * erstellt das Array für das zweite Level
	 * 
	 */
	public static void level2() {
		int [][] feld2 = {{ 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{1,0,0,1,0,0,0,1,0,0,0,1,0,0,0,1},{1,0,0,1,0,0,0,1,0,0,0,1,0,0,0,1},{1,0,0,1,0,0,0,1,0,0,0,1,0,0,0,1},{1,0,0,0,0,0,0,1,0,0,0,1,0,0,0,1},{1,0,0,0,0,0,0,1,0,0,0,1,0,0,0,1},{1,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0},{2,0,0,0,0,1,0,0,0,1,0,0,0,1,0,1},{1,0,0,0,0,1,0,0,0,1,0,0,0,1,0,1},{1,0,0,0,0,1,0,0,0,1,0,0,0,1,0,1},{1,0,0,0,0,1,0,0,0,1,0,0,0,1,0,1},{ 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}};
		

		for (int i = 0; i < feld2.length; i++) {	
		    for (int j = 0; j < feld2[i].length; j++) {		
				
				//Versuch die Bilder an die passenden Stellen zu setzen
				if (feld2[i][j]==0){
					Icon _icon = new ImageIcon("Rasen.jpg");
					JLabel _label = new JLabel(_icon);
					frame.spielfenster.add(_label);
				}
				else if (feld2[i][j]==1){
					Icon _icon = new ImageIcon("Grenze.jpg");
					JLabel _label = new JLabel(_icon);
					frame.spielfenster.add(_label);
				}
				else if (feld2[i][j]==2){
					Icon _icon = new ImageIcon("Pudel.png");
					JLabel _label = new JLabel(_icon);
					frame.spielfenster.add(_label);
				}
				else if (feld2[i][j]==3){
					Icon _icon = new ImageIcon("Gegnger.png");
					JLabel _label = new JLabel(_icon);
					frame.spielfenster.add(_label);
				}
		    }
		}	
	}

	/*
	 * erstellt das Array für das dritte Level
	 * 3: Gegner
	 */
	public static void level3() {

		int [][] feld3 = {{ 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{1,0,0,0,1,1,1,0,0,0,0,0,0,0,0,1},{1,0,0,0,1,1,1,0,0,0,0,0,0,0,0,1},{1,0,0,0,1,1,1,0,0,0,0,0,0,0,0,1},{1,0,0,0,1,1,1,0,0,0,0,0,0,0,0,1},{1,0,0,0,0,0,0,0,0,0,3,0,0,0,0,1},{2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1},{1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1},{1,0,0,0,0,0,0,0,0,3,0,0,1,0,0,1},{ 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}};
		

		for (int i = 0; i < feld3.length; i++) {	
		    for (int j = 0; j < feld3[i].length; j++) {
				
				if (feld3[i][j]==0){
					Icon _icon = new ImageIcon("Rasen.jpg");
					JLabel _label = new JLabel(_icon);
					frame.spielfenster.add(_label);
				}
				else if (feld3[i][j]==1){
					Icon _icon = new ImageIcon("Grenze.jpg");
					JLabel _label = new JLabel(_icon);
					frame.spielfenster.add(_label);
				}
				else if (feld3[i][j]==2){
					Icon _icon = new ImageIcon("Pudel.png");
					JLabel _label = new JLabel(_icon);
					frame.spielfenster.add(_label);
				}
				else if (feld3[i][j]==3){
					Icon _icon = new ImageIcon("Gegnger.png");
					JLabel _label = new JLabel(_icon);
					frame.spielfenster.add(_label);
				}
		    }
		}
	}
}