package game;

/**
 * eine eigene Klasse für die Exception, die im Spielfeld geworfen werden kann
 * 
 */
public class SpielfeldException extends Exception {

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
