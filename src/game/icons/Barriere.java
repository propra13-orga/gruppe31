package game.icons;

import game.GameObject;
import game.Konstanten;

import java.awt.Point;
import java.io.Serializable;

/**
 * ein Objekt dieser Klasse ist die Barriere
 * 
 */
public class Barriere extends GameObject implements Serializable {

	/** Icon für Baum wird deklariert */
	private static final String ICONBARRIERE = Konstanten.DIRECTION
			+ "/src/game/Images/Barriere.png";

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