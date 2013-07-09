package game;

import java.awt.Point;

/** ist f�r den jeweiligen Raum zust�ndig. das Spielfeld wird erstellt */
public class Spielfeld {

	/** Deklaration eines GameObject Arrays */
	public final GameObject[][] feld;

	private int Zeilen;
	private int Spalten;

	/**
	 * erstellt ein Array feld, das nur aus GameObjects bestehen kann f�r jeden
	 * case wird ein Objekt der jeweiligen Klasse erstellt, welches den case
	 * �berschreibt
	 * 
	 * @param feld
	 *            Kommandozeilenparameter
	 * @throws SpielfeldException
	 *             wirft eine Exception
	 */
	public Spielfeld(int hoehe, int breite) throws SpielfeldException {
		this.Spalten = hoehe;
		this.Zeilen = breite;
		this.feld = new GameObject[hoehe][breite];
	}

	/**
	 * Gibt die Breite dieses Spielfelds zurueck.
	 * 
	 * @return Die Breite dieses Spielfelds.
	 */
	public int gibBreite() {
		return this.Spalten;
	}

	/**
	 * Gibt die Hoehe dieses Spielfelds zurueck.
	 * 
	 * @return Die Hoehe dieses Spielfelds.
	 */
	public int gibHoehe() {
		return this.Zeilen;
	}

	/**
	 * setzt das GameObject an die gew�nschte Position
	 * 
	 * @param objekt
	 *            Das Objekt, welches bewegt werden soll
	 * @param position
	 */
	public void setzeObjekt(GameObject objekt, Point position) {
		this.feld[position.x][position.y] = objekt;
	}

	/**
	 * gibt das GameObject an Postion wieder
	 * 
	 * @param position
	 *            Position des GameObjects
	 * @return position
	 */
	public GameObject gibObjekt(Point position) {
		return this.feld[position.x][position.y];
	}
}
