package game.icons;

import java.awt.Point;

import game.GameObject;
import game.Konstanten;

/**
 * ein Objekt dieser Klasse ist die Barriere
 * 
 */
public class Barriere extends GameObject {

	/** Icon für Baum wird deklariert */
	private static final String ICONBARRIERE = Konstanten.DIRECTION
			+ "/src/game/Images/Barriere.jpg";

	/** bild vom Typ String wird deklariert */
	private String bild;
	
	/** Die Position dieser Figur in der xy-Ebene. */
	private Point position;

	/** Konstruktor initialisiert icon */
	public Barriere() {
		bild = ICONBARRIERE;
	}

	@Override
	public String getPicture() {
		return bild;
	}

	/**
	 * Gibt die aktuelle Position der Barriere zurück
	 * 
	 * @return Die aktuelle Position der Barriere
	 */
	public Point getPosition() {

		return position;
	}

	/**
	 * Setzt die aktuelle Position der Barriere.
	 * 
	 * @param neuePosition
	 *            Die neue Position der Figur.
	 */
	public void setPosition(Point neuePosition) {

		this.position = neuePosition;
	}

}