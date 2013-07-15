package game;

import game.figuren.Spieler;
import game.icons.Carlos;
import game.icons.Checkpoint;
import game.icons.Grenze;
import game.icons.Huette;
import game.icons.Luke;
import game.icons.Rasen;
import game.icons.SchalterZu;
import game.icons.SchalterAuf;
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
import java.awt.event.KeyEvent;

/** ist für den jeweiligen Raum zuständig. das Spielfeld wird erstellt */
public class Spielfeld {

	/** Deklaration eines GameObject Arrays */
	public final GameObject[][] feld;

	/** Deklaration von Variablen für Zeilen und Spalten */
	private int zeilen;
	private int spalten;

	/** Deklaration von Feldern */
	private Spieler spieler;
	private Spiel spiel;
	private NPC npc;
	private NPC2 npc2;
	private GameFrame gameFrame;

	/**
	 * erstellt ein Array feld, das nur aus GameObjects bestehen kann für jeden
	 * case wird ein Objekt der jeweiligen Klasse erstellt, welches den case
	 * überschreibt
	 * 
	 * @param hoehe
	 *            hoehe des Spielfeldes
	 * @param breite
	 *            breite des Spielfeldes
	 * @throws SpielfeldException
	 *             wirft eine Exception
	 */
	public Spielfeld(int hoehe, int breite) throws SpielfeldException {
		this.spalten = hoehe;
		this.zeilen = breite;
		this.feld = new GameObject[hoehe][breite];
	}

	/**
	 * Gibt die Breite dieses Spielfelds zurueck.
	 * 
	 * @return Die Breite dieses Spielfelds.
	 */
	public int gibBreite() {
		return this.spalten;
	}

	/**
	 * Gibt die Hoehe dieses Spielfelds zurueck.
	 * 
	 * @return Die Hoehe dieses Spielfelds.
	 */
	public int gibHoehe() {
		return this.zeilen;
	}

	/**
	 * setzt das GameObject an die gewünschte Position
	 * 
	 * @param objekt
	 *            Das Objekt, welches bewegt werden soll
	 * @param position
	 *            Angabe der Position des Objektes
	 */
	public void setzeObjekt(GameObject objekt, Point position) {
		this.feld[position.x][position.y] = objekt;
	}

	/**
	 * gibt das GameObject an Postion wieder Achtung: position.x ist die
	 * y-Position und andersrum
	 * 
	 * @param position
	 *            Position des GameObjects
	 * @return position
	 */
	public GameObject gibObjekt(Point position) {
		return this.feld[position.y][position.x];
	}

	/**
	 * Spielfigur wird bewegt
	 * 
	 * @param spielfigur
	 *            Spielfigur wird übergeben
	 * @param keyCode
	 *            KeyCode wird übergeben
	 */
	public void aktion(Spieler spielfigur, int keyCode) {

		/* Spielfigur Position abfragen */
		Point position = spielfigur.getPosition();
		Point fokus = position;

		System.out.print(position);

		/* Abfragen für die Pfeiltasten */
		if (keyCode == KeyEvent.VK_LEFT) {
			fokus.x--;
		} else if (keyCode == KeyEvent.VK_RIGHT) {
			fokus.x++;
		} else if (keyCode == KeyEvent.VK_UP) {
			fokus.y--;
		} else if (keyCode == KeyEvent.VK_DOWN) {
			fokus.y++;
		}

		GameObject obj = this.gibObjekt(fokus);

		/* Objekte drum herum prüfen */
		if (obj instanceof Rasen) {
			this.setzeObjekt(obj, position);
			position = fokus;
		} else if (obj instanceof Grenze) {
			fokus = position;
		} else if (obj instanceof Huette) {
			fokus = position;
		} else if (obj instanceof Carlos) {
			npc = new NPC();
		} else if (obj instanceof Checkpoint) {
			//Checkpoint();
		} else if (obj instanceof Weiter) {
			spiel.levelWeiter(1);
		} else if (obj instanceof Zurueck) {
			spiel.levelZurueck(1);
		} else if (obj instanceof Ziel) {
			gameFrame.gewonnen();
		} else if (obj instanceof Brille) {
			spieler.setBewaffnet(true);
			position = fokus;
		} else if (obj instanceof Gold) {
			//spieler.setGold(+50);
			position = fokus;
		} else if (obj instanceof Health) {
			spieler.setGesundheit(Konstanten.VOLLH);
			position = fokus;
		} else if (obj instanceof Mana) {
			spieler.setMana(Konstanten.VOLLM);
			position = fokus;
		} else if (obj instanceof Ruestung) {
			spieler.setHalsband(true);
			position = fokus;
		} else if (obj instanceof Schwert) {
			spieler.setBeschwertet(true);
			position = fokus;
		} else if (obj instanceof Shophealth) {
			spieler.setGesundheit(Konstanten.VOLLH);
			//spieler.setGold(-50);
			position = fokus;
		} else if (obj instanceof Shopmana) {
			spieler.setMana(Konstanten.VOLLM);
			//spieler.setGold(-50);
			position = fokus;
		} else if (obj instanceof Shopruestung) {
			spieler.setHalsband(true);
			//spieler.setGold(-50);
			position = fokus;
		} else if (obj instanceof Luke) {
			npc2 = new NPC2();
			fokus = position;
		} else if (obj instanceof SchalterZu) {
			//
		}

		/* Bewegung durchführen */
		this.spieler.setPosition(position);
	}

	/*
	 * Prüfung ob Checkpoint besucht wurde und Zurücksetzen des Spiels oder
	 * Ausgang Verloren
	 * 
	 * public void Checkpoint() { if (save == 1) { if (leben > 0) { health =
	 * 100; Spielfigurx = checkx; Spielfigury = checky;
	 * zeichner.zeichneSpielfeld(CheckSpielfeld); setzeAnzeige(); } else if
	 * (leben <= 0) { Verloren(); } } else if (save == 0) { Verloren(); } }
	 */
}
