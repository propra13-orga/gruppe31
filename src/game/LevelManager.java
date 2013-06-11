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
	private ArrayList<InfoLevel> levels = new ArrayList<InfoLevel>();

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
		FileReader fr = new FileReader(Konstanten.direction
				+ "/src/game/Raum/Raum.txt");
		/* öffnet BufferedReader und liest .txt hinein */
		BufferedReader br = new BufferedReader(fr);

		/* in line wird eine Zeile gespeichert */
		String line = br.readLine();
		do {
			/* ein Array von 16*12 wird initialisiert */
			Integer[][] array = new Integer[16][12];
			/* Startpositionen der Spielfigur werden auf -1 gesetzt */
			int startx = -1, starty = -1;
			int gegnerx = 0, gegnery = 0;

			/* die Zeilen werden gelesen, bis man bei der 16. angekommen ist */
			for (int j = 0; j < 16; j++, line = br.readLine()) {
				/* wenn mehr als 12 Zeichen gelesen werden, Fehlermeldung */
				if (line.length() != 12) {
					throw new Exception(
							"Falsche Anzahl an Zeichen in dieser Zeile!");
				} else {
					int pruefe;
					/*
					 * die Zeichen einer Zeile werden gelesen und in das Array
					 * geparst
					 */
					for (int i = 0; i < 12; i++) {
						pruefe = array[j][i] = (int) line.charAt(i);

						/*
						 * wenn das gelesene Zeichen eine 2 ist wird die
						 * Startposition der Spielfigur festgehalten
						 */
						if (pruefe == Konstanten.PUDEL) {
							startx = j;
							starty = i;
						}

						if (pruefe == Konstanten.GEGNER) {
							gegnerx = j;
							gegnery = i;
						}
					}
				}
			}
			/*
			 * in die ArrayList wird ein neues Level gespeichert (sowohl das
			 * Spielfeldarray, als auch die Position der Spielfigur
			 */
			levels.add(new InfoLevel(array, startx, starty, gegnerx, gegnery));
			do
				line = br.readLine();
			/*
			 * der obere Block wird ausgeführt bis eine Leerzeile gefunden wird,
			 * geschieht das, wird ein neues Spielfeldarray angelegt
			 */
			while (line == "");
			/*
			 * und der komplette obere Block wird ausgeführt, bis der
			 * BufferedReader das Ende der Datei gefunden hat
			 */
		} while (line != null);

		fr.close();
	}

	/** durch das Hochzählen von level gelangt man ein Level weiter */
	public boolean LevelWeiter() {
		/* wird geprüft, ob man sich bereits im letzten Level befindet */
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

	/*
	 * gibt das aktuelle Level wieder public int getAktLevel() { return level; }
	 */

	/**
	 * gibt die X-Koordinate der Spielfigur aus dem jeweiligen Level der
	 * ArrayList wieder
	 */
	public int getStartx() {
		return levels.get(level).startx;
	}

	/**
	 * gibt die Y-Koordinate der Spielfigur aus dem jeweiligen Level der
	 * ArrayList wieder
	 */
	public int getStarty() {
		return levels.get(level).starty;
	}

	public int getStartGegnerx() {
		return levels.get(level).gegnerx;
	}

	public int getStartGegnery() {
		return levels.get(level).gegnery;
	}
}
