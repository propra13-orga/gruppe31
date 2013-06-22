package game;

import java.io.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 * die Klasse kann die Räume aus den Textdateien einlesen, das aktuelleSpielfeld
 * speichern und ein Level vor oder zurück gehen
 */
public class LevelManager {

	private int level = 0;

	private int Gegner1 = 0;
	private int Gegner2 = 0;

	/* Liste von Spielfeldern */
	private ArrayList<InfoLevel> levels = new ArrayList<InfoLevel>();

	/**
	 * die Methode liest die einzelnen Räume ein und schreibt sie in die
	 * ArrayList array. Zusätzlich werden die Positionen der Spielfigur und der
	 * Gegner festgehalten
	 * 
	 * in Textdatei rechts=y-Achse (12 Zeichen) runter=x-Achse (16 Zeichen)
	 * 
	 * @param datei
	 * @throws Exception
	 */
	public void init(String datei) throws Exception { 
		
		/* öffnet FileReader mit Textdatei */
		FileReader fr = new FileReader(Konstanten.direction
				+ "/src/game/Spielfeld/" + datei);
		/* öffnet BufferedReader und liest .txt hinein */
		BufferedReader br = new BufferedReader(fr);

		/* in line wird eine Zeile gespeichert */
		String line = br.readLine();
		do {
			/* ein Array von 16*12 wird initialisiert */
			Integer[][] array = new Integer[Konstanten.SPALTEN][Konstanten.ZEILEN];
			/* Startpositionen der Spielfigur werden auf -1 gesetzt */
			int startx = -1, starty = -1;
			int gegnerx = 0, gegnery = 0;
			int gegnersx = 0, gegnersy = 0;

			/* die Zeilen werden gelesen, bis man bei der 16. angekommen ist */
			for (int j = 0; j < Konstanten.SPALTEN; j++, line = br.readLine()) {
				/* wenn mehr als 12 Zeichen gelesen werden, Fehlermeldung */
				if (line.length() != Konstanten.ZEILEN) {
					JOptionPane
							.showMessageDialog(
									null,
									"Die Anzahl der Zeichen in dieser Textdatei ist ungültig!",
									"Error", JOptionPane.ERROR_MESSAGE);
					System.exit(0);
				} else {
					int pruefe;
					/*
					 * die Zeichen einer Zeile werden gelesen und in das Array
					 * geparst
					 */
					for (int i = 0; i < Konstanten.ZEILEN; i++) {
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
							Gegner1 = 1;
							gegnerx = j;
							gegnery = i;
						} else {
							// nothing to do here
						}

						if (pruefe == Konstanten.GEGNER2) {
							Gegner2 = 1;
							gegnersx = j;
							gegnersy = i;
						}
					}
				}
			}
			/*
			 * in die ArrayList wird ein neues Level gespeichert (sowohl das
			 * Spielfeldarray, als auch die Position der Spielfigur
			 */
			levels.add(new InfoLevel(array, startx, starty, gegnerx, gegnery,
					gegnersx, gegnersy, Gegner1, Gegner2));
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

	/** man gelangt einen Raum weiter */
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

	/**
	 * das aktuelleLevel wird in array gespeichert
	 * 
	 * @param array
	 */
	public void kopiereAktuellesLevel(Integer[][] array) {
		for (int x = 0; x < Konstanten.SPALTEN; x++) {
			for (int y = 0; y < Konstanten.ZEILEN; y++) {
				array[x][y] = levels.get(level).feld[x][y];
			}
		}
	}

	/**
	 * gibt das aktuelle level wieder
	 * 
	 * @return
	 */
	public int getlevel() {
		return level;
	}

	/**
	 * gibt die X-Koordinate der Spielfigur wieder
	 * 
	 * @return
	 */
	public int getStartx() {
		return levels.get(level).startx;
	}

	/**
	 * gibt die Y-Koordinate der Spielfigur wieder
	 * 
	 * @return
	 */
	public int getStarty() {
		return levels.get(level).starty;
	}

	/**
	 * gibt die X-Koordinate von Gegner wieder
	 * 
	 * @return
	 */
	public int getStartGegnerx() {
		return levels.get(level).gegnerx;
	}

	/**
	 * gibt die Y-Koordinate von Gegner wieder
	 * 
	 * @return
	 */
	public int getStartGegnery() {
		return levels.get(level).gegnery;
	}

	/**
	 * gibt die X-Koordinate von Gegner2 wieder
	 * 
	 * @return
	 */
	public int getStartGegnersx() {
		return levels.get(level).gegnersx;
	}

	/**
	 * gibt die Y-Koordinate von Gegner2 wieder
	 * 
	 * @return
	 */
	public int getStartGegnersy() {
		return levels.get(level).gegnersy;
	}

	/**
	 * gibt wieder, ob Gegner1 vorhanden
	 * 
	 * @return
	 */
	public int getGegner1() {
		return levels.get(level).Gegner1;
	}

	/**
	 * gibt wieder, ob Gegner2 vorhanden
	 * 
	 * @return
	 */
	public int getGegner2() {
		return levels.get(level).Gegner2;
	}
}
