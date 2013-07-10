package game;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * diese Klasse repr�sentiert das komplette Spiel, welches aus verschiedenen
 * Spielfelder besteht. Das Spiel wird aus einer Textdatei eingelesen
 */
public class Spiel {

	/** Liste von Spielfeldern wird deklariert */
	private ArrayList<Spielfeld> levels;

	/** Liste aller Spieler */
	private ArrayList<Spieler> Spieler;

	/** Zeiger auf das aktuelle Spielfeld */
	private int aktSpielfeld;

	/** Deklarierung des Feldes */
	private Spielfeld spielfeld;

	/**
	 * Konstruktor erzeugt ArrayList, welche Spielfelder beinhaltet
	 */
	public Spiel() {
		levels = new ArrayList<Spielfeld>();
		this.aktSpielfeld = -1;
		Spieler = new ArrayList<Spieler>();
	}

	/**
	 * die Methode liest die einzelnen R�ume ein und schreibt sie in die
	 * ArrayList array. Zus�tzlich werden die Positionen der Spielfigur und der
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

		/* �ffnet FileReader mit Textdatei */
		FileReader fr = new FileReader(Konstanten.DIRECTION
				+ "/src/game/Szenario/" + datei);
		/* �ffnet BufferedReader und liest .txt hinein */
		BufferedReader br = new BufferedReader(fr);

		/* in line wird eine Zeile gespeichert */
		String line = br.readLine();
		do {
			int hoehe = line.charAt(0);
			int breite = line.charAt(1);

			/* ein neues Spielfeld wird initialisiert */
			spielfeld = new Spielfeld(Konstanten.ZEILEN, Konstanten.SPALTEN);

			/* die Zeilen werden gelesen, bis man bei der 16. angekommen ist */
			for (int j = 0; j < Konstanten.SPALTEN; j++, line = br.readLine()) {
				/* wenn mehr als 12 Zeichen gelesen werden, Fehlermeldung */
				if (line.length() != Konstanten.ZEILEN) {
					JOptionPane
							.showMessageDialog(
									null,
									"Die Anzahl der Zeichen in dieser Textdatei ist ung�ltig!",
									"Error", JOptionPane.ERROR_MESSAGE);
					System.exit(0);
				} else {
					/*
					 * die Zeichen einer Zeile werden gelesen und in das Array
					 * geparst
					 */
					for (int i = 0; i < Konstanten.ZEILEN; i++) {
						int pruefe;
						GameObject gameObject;
						pruefe = (int) line.charAt(i);

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
						} else {
							gameObject = new Spieler();
						}

						spielfeld.setzeObjekt(gameObject, new Point(i, j));
						levels.add(spielfeld);
						aktSpielfeld++;
					}
				}
			}
			do
				line = br.readLine();
			/*
			 * der obere Block wird ausgef�hrt bis eine Leerzeile gefunden wird,
			 * geschieht das, wird ein neues Spielfeldarray angelegt
			 */
			while ("".equals(line));
			/*
			 * und der komplette obere Block wird ausgef�hrt, bis der
			 * BufferedReader das Ende der Datei gefunden hat
			 */
		} while (line != null);
		fr.close();
	}

	/**
	 * Getter f�r aktuellesSpielfeld
	 * 
	 * @return array gibt das array dieser Klasse zur�ck
	 */
	public Spielfeld getAktuellesSpielfeld() {
		return levels.get(aktSpielfeld);
	}
}
