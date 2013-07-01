package game;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * die Objekte dieser Klasse sind die Bombe und der Müll
 * 
 */
public class Falle extends GameObject {
	private int schaden;

	private static final Icon iconBombe = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Peng.png");
	private static final Icon iconMuell = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Falle.png");

	public int getSchaden() {
		return schaden;
	}

	public void setSchaden(int schaden) {
		this.schaden = schaden;
	}

	@Override
	public Icon getIcon() {
		// TODO Auto-generated method stub
		return null;
	}
}
