package game;

import game.figuren.Spieler;

import java.awt.Point;
import java.awt.event.KeyEvent;

/** ist f�r den jeweiligen Raum zust�ndig. das Spielfeld wird erstellt */
public class Spielfeld {

	/** Deklaration eines GameObject Arrays */
	public final GameObject[][] feld;

	/** Deklaration von Variablen f�r Zeilen und Spalten */
	private int zeilen;
	private int spalten;

	/** Deklaration von Feldern */
	private Spieler spieler;
	private Spiel spiel;

	/**
	 * erstellt ein Array feld, das nur aus GameObjects bestehen kann f�r jeden
	 * case wird ein Objekt der jeweiligen Klasse erstellt, welches den case
	 * �berschreibt
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
	 * setzt das GameObject an die gew�nschte Position
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
	 *            Spielfigur wird �bergeben
	 * @param keyCode
	 *            KeyCode wird �bergeben
	 */
	public void aktion(Spieler spielfigur, int keyCode) {
		
		/* Spielfigur Position abfragen */
		Point position = spielfigur.getPosition();
		Point fokus = position;
		
		System.out.print(position);
		
		/* Abfragen f�r die Pfeiltasten */
		if (keyCode == KeyEvent.VK_LEFT) {
			fokus.x--;
		} else if (keyCode == KeyEvent.VK_RIGHT) {
			fokus.x++;
		} else if (keyCode == KeyEvent.VK_UP) {
			fokus.y--;
		} else if (keyCode == KeyEvent.VK_DOWN) {
			fokus.y++;
		}
		
		/* Abfrage f�r ich laufe auf RASEN = normale Bewegung */
		if(gibObjekt(fokus).getClass() == Rasen.class){
			position = fokus;
		} 
		
		/* Objekte drum herum pr�fen */
		
		/* Bewegung durchf�hren */
		this.setzeObjekt(spielfigur, position);

	}
}
