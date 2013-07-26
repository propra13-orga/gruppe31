package game;

import java.io.Serializable;

/**
 * eine eigene Klasse f�r die Exception, die im Spielfeld geworfen werden kann
 * 
 */
public class SpielfeldException extends Exception implements Serializable {

	/**
	 * Konstruktor ruft Exception Fenster auf
	 * 
	 * @param message
	 *            fordert einen String
	 */
	public SpielfeldException(String message) {
		super(message);
	}
}
