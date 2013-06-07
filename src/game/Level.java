package game;

public class Level {

	public Level(Integer[][] feld, int startx, int starty) {
		this.feld = feld;
		this.startx = startx;
		this.starty = starty;
	}

	public final Integer[][] feld;
	public final int startx, starty;
}
