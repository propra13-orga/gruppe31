package game;

import java.awt.event.KeyEvent;
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
	}

	/**
	 * prüft das KeyEvent und führt Server/Client entsprechend weiter
	 * 
	 * @param arg0
	 *            KeyEvent Parameter
	 */

	public void keyReleased(KeyEvent arg0) {

		int keyCode = arg0.getKeyCode();
		
		/* Prüfe, ob Server etwas gedrückt hat */
		if ("Server-Spiel".equals(this.getTitle())) {
			
			/* nur Server kann das Spiel starten */
			if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
				try {
					erzeugeSpiel();
					setzeAnzeige(this.spiel.getSpieler().get(0));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			/* leite Tastendruck an spiel weiter */
			try {
				spiel.aktion(keyCode, this);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			aktualisieren();
			this.zeichnen(this.spiel.getAktuellesSpielfeld());

			ausgehend.print(this.spiel);
			ausgehend.flush();
			
			
		} else if ("Client-Spiel".equals(this.getTitle())) {
			
			try {
				spiel.aktion(keyCode, this);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			aktualisieren();
			this.zeichnen(this.spiel.getAktuellesSpielfeld());
			this.setzeAnzeige(this.spiel.getSpieler().get(1));

			ausgehend.println(this.spiel);
			ausgehend.flush();
		}
	}

}
