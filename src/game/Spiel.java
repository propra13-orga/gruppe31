package game;

import game.figuren.Bossgegner;
import game.figuren.Falle;
import game.figuren.Gegner;
import game.figuren.Spieler;
import game.icons.Carlos;
import game.icons.Checkpoint;
import game.icons.Grenze;
import game.icons.Huette;
import game.icons.Luke;
import game.icons.Rasen;
import game.icons.SchalterAuf;
import game.icons.SchalterZu;
import game.icons.Weiter;
import game.icons.Ziel;
import game.icons.Zurueck;
import game.items.Brille;
import game.items.Gold;
import game.items.Health;
import game.items.Mana;
import game.items.Ruestung;
import game.items.Schwert;
import game.items.Shophealth;
import game.items.Shopmana;
import game.items.Shopruestung;

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

	/** Zeiger auf das aktuelle Spielfeld */
	private int aktSpielfeld;

	/** Deklarierung des Feldes */
	private Spieler spieler;
	private Gegner gegner;
	private Spielfeld spielfeld;

	/**
	 * Konstruktor erzeugt ArrayList, welche Spielfelder beinhaltet
	 */
	public Spiel() {
		levels = new ArrayList<Spielfeld>();
		this.aktSpielfeld = -1;
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
						GameObject gameObject = null;
						pruefe = (int) line.charAt(i);

						if (pruefe == Konstanten.RASEN) {
							gameObject = new Rasen();
						} else if (pruefe == Konstanten.GRENZE) {
							gameObject = new Grenze();
						} else if (pruefe == Konstanten.PUDEL) {
							this.spieler = new Spieler("Erna");
							this.spieler.setPosition(new Point(i, j));
							gameObject = this.spieler;
						} else if (pruefe == Konstanten.PUDEL2) {
							this.spieler = new Spieler("Luke");
							this.spieler.setPosition(new Point(i, j));
							gameObject = this.spieler;
						} else if (pruefe == Konstanten.GEGNER) {
							this.gegner = new Gegner("Pilz");
							gegner.setPosition(new Point(i, j));
							gameObject = this.gegner;
						} else if (pruefe == Konstanten.GEGNER2) {
							this.gegner = new Gegner("Biene");
							gegner.setPosition(new Point(i, j));
							gameObject = this.gegner;
						} else if (pruefe == Konstanten.FALLE) {
							gameObject = new Falle();
						} else if (pruefe == Konstanten.WEITER) {
							gameObject = new Weiter();
						} else if (pruefe == Konstanten.BOSS1V) {
							gameObject = new Bossgegner(Konstanten.RAUM3);
						} else if (pruefe == Konstanten.BOSS2V) {
							gameObject = new Bossgegner(Konstanten.RAUM6);
						} else if (pruefe == Konstanten.BOSS3V) {
							gameObject = new Bossgegner(Konstanten.RAUM9);
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
						} else if (pruefe == Konstanten.LUKE) {
							gameObject = new Luke();
						} else if (pruefe == Konstanten.SCHALTERZU) {
							gameObject = new SchalterZu();
						} else if (pruefe == Konstanten.SCHALTERAUF) {
							gameObject = new SchalterAuf();
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
		/*
		 * setzt das aktuelleSpielfeld wieder an den Anfang, damit der erste
		 * Raum angezeigt wird
		 */
		aktSpielfeld = 0;
	}

	/**
	 * Getter f�r aktuellesSpielfeld
	 * 
	 * @return array gibt das array dieser Klasse zur�ck
	 */
	public Spielfeld getAktuellesSpielfeld() {
		return levels.get(aktSpielfeld);
	}

	/**
	 * Getter f�r den Spieler
	 * 
	 * @return spieler
	 */
	public Spieler getSpieler() {
		return this.spieler;
	}

	/**
	 * Bewegung wird auf dem aktuellen Spielfeld durchgef�hrt
	 * 
	 * @param keyCode
	 *            Kommandozeilenparameter
	 */
	public void aktion(int keyCode) {
		levels.get(aktSpielfeld).aktion(this.spieler, keyCode);
	}

	/**
	 * set aktuelles Spielfeld einen hoch
	 */
	public void levelWeiter() {
		this.aktSpielfeld = aktSpielfeld + 1;

	}

	/**
	 * set aktuelles Spielfeld einen runter
	 */
	public void levelZurueck() {
		this.aktSpielfeld = aktSpielfeld - 1;

	}
}
