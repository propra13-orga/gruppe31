package game;

/**
 * erstellt die Spielfelder
 * @author Denise
 *
 */
public class Spielfeld {

	/*hauptarray fuers spielfeld sotiert nach [spalte][reihe]*/
	int[][] spielfeld = new int [20][15];
	int level;
	int reihe;
	int spalte;
	int aktuellesLevel;
	
	/*muss in der main-class direkt am anfang ausgefuehrt werden*/
	public void levelsErstellen() {
	/*Allen Randfeldern in allen Leveln den Wert 1 ("hier is ne mauer") geben*/
		for (spalte=0; spalte<20; spalte++) {
			for (reihe=0; reihe<15; reihe++) {
				for (level=0; level<4; level++) {
					if ((spalte==0)|(spalte==19)|(reihe==0)|(reihe==14)) {			
						spielfeld[spalte][reihe]=1;
						
					}
					else {
						spielfeld[spalte][reihe]=0;
					}
				}
			}
		}
		//startfelder(2) und zielfelder(3) setzen, erstmal fuer alle level das gleiche
		spielfeld[0][5]=spielfeld[0][5]=spielfeld[0][5]=spielfeld[0][5]=2;
		spielfeld[19][5]=spielfeld[19][5]=spielfeld[19][5]=spielfeld[19][5]=3;
		
		//testfallen&mobs
		spielfeld[1][6]=spielfeld[1][4]=spielfeld[2][6]=spielfeld[2][4]=4;
		
		//spielfigur(6) testweise an den Anfang setzten
		spielfeld[1][5]=5;
	}

	public void levelDarstellen() {
		for (spalte=0;spalte<20;spalte++) {
			for(reihe=0;reihe<15;reihe++) {
				
				System.out.print("Bild");				
		    }
		System.out.println("");
		
				/* stellt an allen orten das dem wert entsprechende bild dar
				if (spielfeld[spalte][reihe]==0){
					StdDraw.picture(20+40*spalte,20+40*reihe, "Image/Rasen.jpg"); 
				}
				else if (spielfeld[spalte][reihe]==1){
					StdDraw.picture(20+40*spalte,20+40*reihe, "Image/Grenze.jpg");
				}
				else if (spielfeld[spalte][reihe]==2){
					StdDraw.picture(20+40*spalte,20+40*reihe, "Image/Rasen.jpg");
				}
				else if (spielfeld[spalte][reihe]==3){
					StdDraw.picture(20+40*spalte,20+40*reihe, "Image/Rasen.jpg");
				}
				else if (spielfeld[spalte][reihe]==4){
					StdDraw.picture(20+40*spalte,20+40*reihe, "Image/Gegner.png");
				}
				else if (spielfeld[spalte][reihe]==5){
					StdDraw.picture(20+40*spalte,20+40*reihe, "Image/Pudel.png");
				}
			}*/
		}
	}


	public int wertBeiKoordinaten(int n,int m)
	{
		return spielfeld[n][m];
	}
}