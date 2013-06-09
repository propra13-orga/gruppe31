package game;

import java.io.*;
import java.util.ArrayList;

/**
 * die Klasse kann die Räume aus der Textdatei einlesen, das aktuelleSpielfeld
 * speichern und ein Level vor oder zurück gehen
 */
public class LevelManager {

	private int level = 0;

	/* Liste von Spielfeldern */
	private ArrayList<Level> levels = new ArrayList<Level>();

	/**
	 * die Methode liest die einzelnen Räume ein und schreibt sie in die
	 * ArrayList array
	 * 
	 * in Textdatei rechts=y-Achse (12 Zeichen) runter=x-Achse (16 Zeichen)
	 * 
	 * @throws Exception
	 */
	public void init() throws Exception {
		/* öffnet FileReader mit Textdatei */
		FileReader fr = new FileReader(Konstanten.direction + "/src/game/Raum/LEVEL1.txt");
		/* öffnet BufferedReader und liest .txt hinein */
		BufferedReader br = new BufferedReader(fr);

		String line = br.readLine();
		do {
			Integer[][] array = new Integer[16][12];
			int startx = -1, starty = -1;
			
			for (int j = 0; j < 16; j++, line = br.readLine()) {
				if (line.length() != 12) {
					throw new Exception(
							"Falsche Anzahl an Zeichen in dieser Zeile!");
				} else {
					int pruefe;
					for (int i = 0; i < 12; i++) {
						pruefe = array[j][i] = Integer.parseInt(line.substring(
								i, i + 1));
						/* wenn das gelesene Zeichen eine 2 ist wird die Startposition festgehalten */
						if (pruefe == 2) {
							startx = j;
							starty = i;
						}
					}
				}
			}
			levels.add(new Level(array, startx, starty));
			do
				line = br.readLine();
			while (line == "");
		} while (line != null);

		fr.close();
	}

	/** durch das Hochzählen von level gelangt man ein Level weiter */
	public boolean LevelWeiter() {
		/* wird geprüft, ob man sich bereits im vorletzen Level befindet */
		if (level == levels.size() - 1) {
			return false;
			/* wenn nicht, kann man ein Level weiter */
		} else {
			level++;
		}
		return true;
	}

	/** durch das Runterzählen von level gelangt man ein Level zurück */
	public boolean LevelZurueck() {
		/* wenn man sich im ersten Level befindet kann man nicht zurück gehen */
		if (level == 0) {
			return false;
			/* ansonsten wird runtergezählt */
		} else {
			level--;
		}
		return true;
	}

	/** das aktuelleLevel wird in array gespeichert */
	public void kopiereAktuellesLevel(Integer[][] array) {
		for (int x = 0; x < 16; x++) {
			for (int y = 0; y < 12; y++) {
				array[x][y] = levels.get(level).feld[x][y];
			}
		}
	}
	
	public int getStartx() {
		return levels.get(level).startx;
	}
	
	public int getStarty() {
		return levels.get(level).starty;
	}
}
