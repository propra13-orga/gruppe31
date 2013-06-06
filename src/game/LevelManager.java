package game;

import java.io.*;
import java.util.ArrayList;

/**
 * die Klasse kann die Räume aus der Textdatei einlesen, das aktuelleSpielfeld
 * speichern und ein Level vor oder zurück gehen
 */
public class LevelManager {

	private static final String direction = System.getProperty("user.dir");

	private int level = 0;

	/* Liste von Spielfeldern */
	private ArrayList<Integer[][]> levels = new ArrayList<Integer[][]>();

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
		FileReader fr = new FileReader(direction + "/src/game/Raum/LEVEL1.txt");
		/* öffnet BufferedReader und liest .txt hinein */
		BufferedReader br = new BufferedReader(fr);

		String line = br.readLine();
		do {
			Integer[][] array = new Integer[16][12];
			for (int j = 0; j < 16; j++, line = br.readLine()) {
				if (line.length() != 12) {
					throw new Exception(
							"Falsche Anzahl an Zeichen in dieser Zeile!");
				} else {
					for (int i = 0; i < 12; i++)
						array[j][i] = Integer
								.parseInt(line.substring(i, i + 1));
				}
			}
			levels.add(array);
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
				array[x][y] = levels.get(level)[x][y];
			}
		}
	}

}
