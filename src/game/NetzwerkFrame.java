package game;

import game.icons.Rasen;

import java.awt.Point;
import java.awt.event.KeyEvent;

/**
 * die Klasse ist für die GUI des Spielfeldes im Netzwerkmodus zuständig
 * 
 * @author Denise
 * 
 */
public class NetzwerkFrame extends GameFrame {


	private Server server;
	private Client client;

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
	public NetzwerkFrame(String titel, int x, int y, Server server, Client client) throws Exception {
		super(titel, x, y);
		
		this.server = server;
		this.client = client;
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
		if (this.server != null) {
			
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
			
			System.out.println("SERVER VERSENDET SPIEL");
			
			this.server.versende(this.spiel);			
			
			aktualisieren();
			this.zeichnen(this.spiel.getAktuellesSpielfeld());
			

		} else {
			
			System.out.println("CLIENT VERSENDET TASTENDRUCK");
			
			this.client.versende(keyCode);
		}
	}

	public void verarbeiteObjekt(Object obj) {
		
		if (this.server != null) {
			
			KeyEvent event = (KeyEvent) obj;
			this.spiel.aktion(event.getKeyCode(), this);
			
			this.aktualisieren();
			this.zeichnen(this.spiel.getAktuellesSpielfeld());
			this.setzeAnzeige(this.spiel.spieler.get(0));
			
			System.out.println("SPIEL GESENDET");
			System.out.println(this.spiel.getAktuellesSpielfeld().gibObjekt(new Point(14, 7)) instanceof Rasen);
			
			this.server.versende(this.spiel);
			
		} else {
			
			Spiel spiel = (Spiel) obj;
			
			this.spiel = spiel;			
			this.aktualisieren();
			this.zeichnen(this.spiel.getAktuellesSpielfeld());	
			this.setzeAnzeige(this.spiel.spieler.get(1));
		}
	}

}
