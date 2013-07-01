package game;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * ein Objekt dieser Klasse ist ein Bossgegner
 *
 */
public class Bossgegner extends Spielfigur {
	
	private static final Icon iconBoss1v = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Boss1voll.png");
	private static final Icon iconBoss1m = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Boss1mitte.png");
	private static final Icon iconBoss1w = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Boss1wenig.png");
	private static final Icon iconBoss2v = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Boss2voll.png");
	private static final Icon iconBoss2m = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Boss2mitte.png");
	private static final Icon iconBoss2w = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Boss2wenig.png");
	private static final Icon iconBoss3v = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Boss3voll.png");
	private static final Icon iconBoss3m = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Boss3mitte.png");
	private static final Icon iconBoss3w = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Boss3wenig.png");

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
