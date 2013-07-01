package game;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * die Objekte dieser Klasse sind der Fliegenpilz und die Biene
 * 
 */
public class Gegner extends Spielfigur {
	private int ko;

	private static final Icon iconGegner = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Gegner1.png");
	private static final Icon iconGegner2 = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Gegner2.png");

	public Gegner() {
		setKo(0);
		setBewaffnet(0);
		setGesundheit(100);
	}

	/**
	 * bitte ergänzen
	 * 
	 * @param low
	 * @param high
	 * @return
	 */
	public static int Random(int low, int high) {
		high++;
		return (int) (Math.random() * (high - low) + low);
	}

	public int getKo() {
		return ko;
	}

	public void setKo(int ko) {
		this.ko = ko;
	}

	@Override
	protected boolean internalTryMove(GameObject ziel) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Icon getIcon() {
		// TODO Auto-generated method stub
		return null;
	}
}
