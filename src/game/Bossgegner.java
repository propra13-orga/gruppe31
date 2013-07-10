package game;

/**
 * ein Objekt dieser Klasse ist ein Bossgegner
 * 
 */
public class Bossgegner extends Spielfigur {

	/** verschiedene Bilder für den Bossgegner werden deklariert */
	private static final String ICONBOSS1V = Konstanten.DIRECTION
			+ "/src/game/Images/Boss1voll.png";
	private static final String ICONBOSS1M = Konstanten.DIRECTION
			+ "/src/game/Images/Boss1mitte.png";
	private static final String ICONBOSS1W = Konstanten.DIRECTION
			+ "/src/game/Images/Boss1wenig.png";
	private static final String ICONBOSS2V = Konstanten.DIRECTION
			+ "/src/game/Images/Boss2voll.png";
	private static final String ICONBOSS2M = Konstanten.DIRECTION
			+ "/src/game/Images/Boss2mitte.png";
	private static final String ICONBOSS2W = Konstanten.DIRECTION
			+ "/src/game/Images/Boss2wenig.png";
	private static final String ICONBOSS3V = Konstanten.DIRECTION
			+ "/src/game/Images/Boss3voll.png";
	private static final String ICONBOSS3M = Konstanten.DIRECTION
			+ "/src/game/Images/Boss3mitte.png";
	private static final String ICONBOSS3W = Konstanten.DIRECTION
			+ "/src/game/Images/Boss3wenig.png";

	/** bild vom Typ String wird deklariert */
	private String bild;

	/** Konstruktor initialisiert icon */
	public Bossgegner() {
		
		/* TODO if (raum == 2) {
			bild = ICONBOSS1V;
		} else if (raum == 5) {
			bild = ICONBOSS2V;
		} else if (raum == 8) {
			bild = ICONBOSS3V;
		}*/
	}

	@Override
	public String getPicture() {
		return bild;
	}

	@Override
	protected boolean internalTryMove(GameObject ziel) {
		// darf ich dahin oder nicht
		return false;
	}

}
