package game;

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
		int boxWidth = 20;
		int [][] feld1 = {{ 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},{1,2,0,0,0,0,0,0,0,0,0,0,0,0,0,1}, {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}};
		
		for (int i = 0; i < feld1.length; i++) {
			for (int j = 0; j < feld1[i].length; j++) {
				int x = boxWidth * j;
				int y = boxWidth * i;
				
				JLabel spielfeld = new JLabel ("Bild");	//Label erstellen
				spielfeld.setBounds(x,y,50,50);			//Position setzen
				frame.spielfenster.add(spielfeld);		//Label dem Spielfenster hinzufügen
			}
		}
	}

	/*
	 * erstellt das Array für das zweite Level
	 * 
	 */
	public static void level2() {
		int boxWidth = 20;
		int [][] feld1 = {{ 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{1,0,0,1,0,0,0,1,0,0,0,1,0,0,0,1},{1,0,0,1,0,0,0,1,0,0,0,1,0,0,0,1},{1,0,0,1,0,0,0,1,0,0,0,1,0,0,0,1},{1,0,0,0,0,0,0,1,0,0,0,1,0,0,0,1},{1,0,0,0,0,0,0,1,0,0,0,1,0,0,0,1},{1,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0},{2,0,0,0,0,1,0,0,0,1,0,0,0,1,0,1},{1,0,0,0,0,1,0,0,0,1,0,0,0,1,0,1},{1,0,0,0,0,1,0,0,0,1,0,0,0,1,0,1},{1,0,0,0,0,1,0,0,0,1,0,0,0,1,0,1},{ 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}};
		

		for (int i = 0; i < feld1.length; i++) {	
		    for (int j = 0; j < feld1[i].length; j++) {
		    	int x = boxWidth * j;
				int y = boxWidth * i;
				
				JLabel spielfeld = new JLabel ("Bild einfügen");
				spielfeld.setBounds(x,y,50,50);
				frame.spielfenster.add(spielfeld);			
		    }
		}	
	}

	/*
	 * erstellt das Array für das dritte Level
	 * 3: Gegner
	 */
	public static void level3() {
		int boxWidth = 20;
		int [][] feld1 = {{ 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{1,0,0,0,1,1,1,0,0,0,0,0,0,0,0,1},{1,0,0,0,1,1,1,0,0,0,0,0,0,0,0,1},{1,0,0,0,1,1,1,0,0,0,0,0,0,0,0,1},{1,0,0,0,1,1,1,0,0,0,0,0,0,0,0,1},{1,0,0,0,0,0,0,0,0,0,3,0,0,0,0,1},{2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1},{1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1},{1,0,0,0,0,0,0,0,0,3,0,0,1,0,0,1},{ 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}};
		

		for (int i = 0; i < feld1.length; i++) {	
		    for (int j = 0; j < feld1[i].length; j++) {
		    	int x = boxWidth * j;
				int y = boxWidth * i;
				
				JLabel spielfeld = new JLabel ("Bild einfügen");
				spielfeld.setBounds(x,y,50,50);
				frame.spielfenster.add(spielfeld);	
		    }
		}
	}
	
	
}