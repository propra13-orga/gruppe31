package game;

/** ist für das jeweilige Level zuständig */
public class InfoLevel {

	/* diese Angaben sollen aus anderen Klassen abfragbar sein, daher public */
	public final Integer[][] feld;
	public final int startx, starty;

	/**
	 * ruft aus dem abgefragten Level das Spielfeldarray und die Position der
	 * Spielfigur ab
	 */
	public InfoLevel(Integer[][] feld, int startx, int starty) {
		this.feld = feld;
		this.startx = startx;
		this.starty = starty;
	}
}
