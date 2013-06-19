package game;

/** ist für das jeweilige Level zuständig */
public class InfoLevel {

	/* diese Angaben sollen aus anderen Klassen abfragbar sein, daher public */
	public final Integer[][] feld;
	public final int startx, starty, gegnerx, gegnery, gegnersx, gegnersy,
			Gegner1, Gegner2;

	/**
	 * ruft aus dem abgefragten Level das Spielfeldarray und die Position der
	 * Spielfigur ab
	 */
	public InfoLevel(Integer[][] feld, int startx, int starty, int gegnerx,
			int gegnery, int gegnersx, int gegnersy, int Gegner1, int Gegner2) {
		this.feld = feld;
		this.startx = startx;
		this.starty = starty;
		this.gegnerx = gegnerx;
		this.gegnery = gegnery;
		this.gegnersx = gegnersx;
		this.gegnersy = gegnersy;
		this.Gegner1 = Gegner1;
		this.Gegner2 = Gegner2;
	}
}
