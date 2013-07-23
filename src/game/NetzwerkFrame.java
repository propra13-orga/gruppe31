package game;

import game.figuren.Spieler;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * die Klasse ist für die GUI des Spielfeldes im Netzwerkmodus zuständig
 * 
 * @author Denise
 * 
 */
public class NetzwerkFrame extends GameFrame {

	/** Deklaration von PrintWriter und InputStreamReader */
	private PrintWriter ausgehend;
	private InputStreamReader eintreffend;

	/**
	 * Konstruktor wie Oberklasse GameFrame + PW und ISR
	 * 
	 * @param titel
	 *            Kommandozeilenparameter
	 * @param x
	 *            Kommandozeilenparameter
	 * @param y
	 *            Kommandozeilenparameter
	 * @param ausgehend
	 *            Kommandozeilenparameter
	 * @param eintreffend
	 *            Kommandozeilenparameter
	 * @throws Exception
	 *             wirft Exception
	 */
	public NetzwerkFrame(String titel, int x, int y, PrintWriter ausgehend,
			InputStreamReader eintreffend) throws Exception {
		super(titel, x, y);

		this.ausgehend = ausgehend;
		this.eintreffend = eintreffend;

		// TODO Auto-generated constructor stub
	}

	/**
	 * prüft das KeyEvent und führt Server/Client entsprechend weiter
	 * 
	 * @param arg0
	 *            KeyEvent Parameter
	 */

	public void keyReleased(KeyEvent arg0) {
		
		int keyCode = arg0.getKeyCode();

		if (this.getTitle().equals("Server")) {

			/* Taste wurde gedrueckt, Bewegung ausfuehren. */

			ausgehend.print(this.spiel);
			ausgehend.flush();
		} else {

			ausgehend.println(this.spiel);
			ausgehend.flush();
		}
	}

}
