package game;

import game.figuren.Spieler;

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
	 * @param figur
	 *            Spielfigur wird übergeben
	 * @param keyCode
	 *            KeyCode wird übergeben
	 */
	public void aktion(Spielfigur figur, int keyCode) {
		
		/* Spielfigur Position abfragen */
		Point position = spieler.getPosition();
		Point pruefe = position;
		
		/* Abfragen für die Pfeiltasten */
		if (keyCode == KeyEvent.VK_LEFT) {
			pruefe.x--;
		} else if (keyCode == KeyEvent.VK_RIGHT) {
			pruefe.x++;
		} else if (keyCode == KeyEvent.VK_UP) {
			pruefe.y--;
		} else if (keyCode == KeyEvent.VK_DOWN) {
			pruefe.y++;
		}
		
		System.out.println(pruefe);

		
		/* Objekte drum herum prüfen */
		
		/* Bewegung durchführen */

	}
}
