package game;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * die Klasse kann die Räume aus den Textdateien einlesen
 */
public class Spiel {

	private Spielfeld aktspielfeld;

	/** Liste von Spielfeldern wird deklariert */
	private ArrayList<Spielfeld> levels;

	private GameObject[][] aktSpielfeld;

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
			aktSpielfeld = new GameObject[Konstanten.SPALTEN][Konstanten.ZEILEN];

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
						int pruefe;
						GameObject gameObject = null;

						pruefe = (int) line.charAt(i);

						java.awt.Point position = new java.awt.Point();

						if (pruefe == Konstanten.RASEN) {
							gameObject = new Rasen();
						} else if (pruefe == Konstanten.GRENZE) {
							gameObject = new Grenze();
						} else if (pruefe == Konstanten.PUDEL) {
							gameObject = new Spieler();
						} else if (pruefe == Konstanten.GEGNER) {
							gameObject = new Gegner();
						} else if (pruefe == Konstanten.FALLE) {
							gameObject = new Falle();
						} else if (pruefe == Konstanten.WEITER) {
							gameObject = new Weiter();
						} else if (pruefe == Konstanten.BOSS) {
							gameObject = new Bossgegner();
						} else if (pruefe == Konstanten.ZURUECK) {
							gameObject = new Zurueck();
						} else if (pruefe == Konstanten.CARLOS) {
							gameObject = new Carlos();
						} else if (pruefe == Konstanten.CUPCAKE) {
							gameObject = new Ziel();
						} else if (pruefe == Konstanten.HUETTE) {
							gameObject = new Huette();
						} else if (pruefe == Konstanten.WAFFE) {
							gameObject = new Brille();
						} else if (pruefe == Konstanten.GOLD) {
							gameObject = new Gold();
						} else if (pruefe == Konstanten.MANA) {
							gameObject = new Mana();
						} else if (pruefe == Konstanten.HEALTH) {
							gameObject = new Health();
						} else if (pruefe == Konstanten.RUESTUNG) {
							gameObject = new Ruestung();
						} else if (pruefe == Konstanten.CHECKPOINT) {
							gameObject = new Checkpoint();
						} else if (pruefe == Konstanten.SCHWERT) {
							gameObject = new Schwert();
						} else if (pruefe == Konstanten.SHOPMANA) {
							gameObject = new Shopmana();
						} else if (pruefe == Konstanten.SHOPHEALTH) {
							gameObject = new Shophealth();
						} else if (pruefe == Konstanten.SHOPRUESTUNG) {
							gameObject = new Shopruestung();
						}

						position.x = j;
						position.y = i;

						setzeObjekt(gameObject, position);
						aktSpielfeld[j][i] = gameObject;
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

	public void setzeObjekt(GameObject objekt, Point point) {

	}

	/**
	 * Getter für aktuellesSpielfeld
	 * 
	 * @return array gibt das array dieser Klasse zurück
	 */
	public GameObject[][] getAktuellesSpielfeld() {
		return aktSpielfeld;
	}
}
