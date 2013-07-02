package game;

import java.io.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 * die Klasse kann die Räume aus den Textdateien einlesen
 */
public class Spiel {

	/* Liste von Spielfeldern */
	private ArrayList<Spielfeld> levels = new ArrayList<Spielfeld>();

	private Spielfeld spielfeld;

	private Integer[][] array;

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
			while (line == "");
			/*
			 * und der komplette obere Block wird ausgeführt, bis der
			 * BufferedReader das Ende der Datei gefunden hat
			 */
		} while (line != null);
		fr.close();
	}

	public Integer[][] getAktuellesSpielfeld() {
		return array;
	}
}
