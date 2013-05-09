package game;

import javax.swing.JFrame;


/**
 * richtet Spielfelder ein
 * @author Denise
 *
 */
public class spielfelder extends JFrame {
		
		static int [][] level1 = new int [6][5];
		static int [][] level2 = new int [6][5];
		static int [][] level3 = new int [6][5];
		static int  reihe;
		static int spalte;
		
		/**
		 * Spielfeld erstellen
		 */
	public static void feldErstellen() {
			 /*Feldern am Rand 1 zuweisen*/
			 	for (spalte=0; (spalte==0)||(spalte==19); spalte++) {
			 		for (reihe=0; reihe<=14; reihe++) {
			 			level1[spalte][reihe]=1;
			 			level1[spalte][reihe]=1;
			 			level1[spalte][reihe]=1;
			 			level1[spalte][reihe]=1;
			 		 }
			 		for (reihe=0; (reihe==0)||(reihe==14); spalte++) {
			 	 		for (spalte=0; spalte<=19; spalte++) {
			 	 			level1[spalte][reihe]=1;
			 	 			level1[spalte][reihe]=1;
			 	 			level1[spalte][reihe]=1;
			 	 			level1[spalte][reihe]=1;

			 	 		}
			 		}
			 	 //Eingänge setzen
			 		level1[1][5]=level2[0][5]=level3[0][5];
			 	 //Ausgänge setzen
			 		level1[19][5]=level2[19][5]=level3[19][5];
			 	}
	}
			 	
	public static void feldDarstellen() {
		StdDraw.setXscale(0.0,800);
		StdDraw.setYscale(0,600);
		for (spalte=0;spalte<20;spalte++) {
			 for(reihe=0;reihe<15;reihe++) {
				 
				 	// stellt an allen orten das dem wert entsprechende bild dar
			 		if (level1[spalte][reihe]==0){
			 			StdDraw.picture(20+40*spalte,20+40*reihe, "Rasen.jpg"); 
			 		}
			 		else if (level1[spalte][reihe]==1){
			 			StdDraw.picture(20+40*spalte,20+40*reihe, "Grenze.jpg");
			 		}
			 		else if (level1[spalte][reihe]==2){
			 			StdDraw.picture(20+40*spalte,20+40*reihe, "Grenze.jpg");
			 		}
			 		else if (level1[spalte][reihe]==3){
			 			StdDraw.picture(20+40*spalte,20+40*reihe, "Rasen.jpg");
			 		}
			 		else if (level1[spalte][reihe]==4){
			 			StdDraw.picture(20+40*spalte,20+40*reihe, "Gegner.jpg");
			 		}
			 		else if (level1[spalte][reihe]==5){
			 			StdDraw.picture(20+40*spalte,20+40*reihe, "Pudel.png");
			 		}
			 	}
			}
	}
}

	

	
		
	
	
	
	



