package game;

import java.awt.event.KeyEvent;

/**
 * die Klasse ist für die GUI des Spielfeldes im Netzwerkmodus zuständig
 * 
 * @author Denise
 * 
 */
public class NetzwerkFrame extends GameFrame {

	/** Deklaration der Felder */
	private Server server;
	private Client client;
	private Musik musik;

	/**
	 * Konstruktor wie Oberklasse GameFrame, Client und Server werden
	 * zugewiesen, Musik wird abgespielt
	 * 
	 * @param titel
	 *            Kommandozeilenparameter
	 * @param x
	 *            Kommandozeilenparameter
	 * @param y
	 *            Kommandozeilenparameter
	 * @param server
	 *            erwartet Server
	 * @param client
	 *            erwartet client
	 * @throws Exception
	 *             wirft Exception
	 */
	public NetzwerkFrame(String titel, int x, int y, Server server,
			Client client) throws Exception {
		super(titel, x, y);

		this.server = server;
		this.client = client;

		musik = new Musik(Konstanten.DIRECTION + "/src/game/Sound/Wald.wav");
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
					e.printStackTrace();
				}
			}

			/* leite Tastendruck an spiel weiter */
			try {
				if (keyCode == KeyEvent.VK_LEFT || keyCode == KeyEvent.VK_RIGHT
						|| keyCode == KeyEvent.VK_UP
						|| keyCode == KeyEvent.VK_DOWN
						|| keyCode == KeyEvent.VK_SPACE
						|| keyCode == KeyEvent.VK_CONTROL
						|| keyCode == KeyEvent.VK_SHIFT
						|| keyCode == KeyEvent.VK_X) {
					spiel.aktion(keyCode, this);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			/* Server versendet das Spiel an CLient */
			this.server.versende(this.spiel);

			/* Server aktualisiert und zeichnet seine Grafik */
			aktualisieren();
			this.zeichnen(this.spiel.getAktuellesSpielfeld());
			this.setzeAnzeige(this.spiel.spieler.get(0));

			/* Client hat etwas gedrückt */
		} else {

			/* Tastendruck des Clients wird gesendet */
			this.client.versende(keyCode);
		}
	}

	/**
	 * NetzwerkFrame verarbeitet das Objekt, das ankommt
	 * 
	 * @param obj
	 *            Kommandozeilenparameter
	 */
	public void verarbeiteObjekt(Object obj) {

		/* wenn ich der Server bin */
		if (this.server != null) {

			/* ist das Objekt ein KeyCode des Clients */
			int keyCode = (int) obj;
			if (keyCode == KeyEvent.VK_W || keyCode == KeyEvent.VK_A
					|| keyCode == KeyEvent.VK_S || keyCode == KeyEvent.VK_D
					|| keyCode == KeyEvent.VK_J || keyCode == KeyEvent.VK_K
					|| keyCode == KeyEvent.VK_N || keyCode == KeyEvent.VK_M) {
				this.spiel.aktion(keyCode, this);
			}

			/* ServerGrafik wird aktualisiert und gezeichnet */
			this.aktualisieren();
			this.zeichnen(this.spiel.getAktuellesSpielfeld());
			this.setzeAnzeige(this.spiel.spieler.get(0));

			/* Server sendet an Client */
			this.server.versende(this.spiel);

			/* wenn ich der Client bin */
		} else {

			/* ist das Objekt ein Spiel */
			Spiel spiel = (Spiel) obj;

			/* das ich bei mir aktualisiere und zeichne */
			this.spiel = spiel;
			this.aktualisieren();
			this.zeichnen(this.spiel.getAktuellesSpielfeld());
			this.setzeAnzeige(this.spiel.spieler.get(1));
		}
	}
}
