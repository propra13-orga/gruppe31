package game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * die Klasse kann die Räume aus den Textdateien einlesen
 */
public class Spiel {

	/** Liste von Spielfeldern wird deklariert */
	private ArrayList<Spielfeld> levels;

	/** Deklaration eines Integer Arrays */
	private Integer[][] array;

	/**
	 * Konstruktor erzeugt ArrayList
	 */
	public Spiel() {
		levels = new ArrayList<Spielfeld>();
	}

	/**
	 * die Methode liest die einzelnen Räume ein und schreibt sie in die
	 * ArrayList array. Zusätzlich werden die Positionen der Spielfigur und der
	 * Gegner festgehalten
	 * 
	 * in Textdatei rechts=y-Achse (12 Zeichen) runter=x-Achse (16 Zeichen)
	 * 
	 * @param datei
	 *            Kommandozeilenparameter
	 * @throws Exception
	 *             Beschreibung der Exception, die von dieser Methode geworfen
	 *             werden kann
	 */
	public void init(String datei) throws Exception {

		/* öffnet FileReader mit Textdatei */
		FileReader fr = new FileReader(Konstanten.DIRECTION
				+ "/src/game/Szenario/" + datei);
		/* öffnet BufferedReader und liest .txt hinein */
		BufferedReader br = new BufferedReader(fr);

		/* in line wird eine Zeile gespeichert */
		String line = br.readLine();
		do {
			/* ein Array von 16*12 wird initialisiert */
			array = new Integer[Konstanten.SPALTEN][Konstanten.ZEILEN];

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
					/*
					 * die Zeichen einer Zeile werden gelesen und in das Array
					 * geparst
					 */
					for (int i = 0; i < Konstanten.ZEILEN; i++) {
						array[j][i] = (int) line.charAt(i);
					}
				}
			}
			do
				line = br.readLine();
			/*
			 * der obere Block wird ausgeführt bis eine Leerzeile gefunden wird,
			 * geschieht das, wird ein neues Spielfeldarray angelegt
			 */
			while ("".equals(line));
			/*
			 * und der komplette obere Block wird ausgeführt, bis der
			 * BufferedReader das Ende der Datei gefunden hat
			 */
		} while (line != null);
		fr.close();
	}

	/**
	 * Getter für aktuellesSpielfeld
	 * 
	 * @return array gibt das array dieser Klasse zurück
	 */
	public Integer[][] getAktuellesSpielfeld() {
		return array;
	}
}
