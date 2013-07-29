package game.figuren;

import java.io.Serializable;

import game.Konstanten;

/**
 * ein Objekt dieser Klasse ist ein Bossgegner
 * 
 */
public class Bossgegner extends Spielfigur implements Serializable {

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

	/**
	 * Konstruktor initialisiert icon
	 * 
	 * @param raum
	 *            erwartet Raumangabe
	 */
	public Bossgegner(int raum) {
		setGesundheit(Konstanten.BOSS99H);
		setzeBild(raum);
	}

	@Override
	public String getPicture() {
		return bild;
	}

	/**
	 * setzt das Bild des Gegners
	 * 
	 * @param raum
	 *            Kommandozeilenparameter
	 */
	public void setzeBild(int raum) {
		if (raum <= Konstanten.RAUM2) {
			if (getGesundheit() == Konstanten.BOSS99H) {
				bild = ICONBOSS1V;
			} else if (getGesundheit() == Konstanten.BOSS66H) {
				bild = ICONBOSS1M;
			} else if (getGesundheit() == Konstanten.BOSS33H) {
				bild = ICONBOSS1W;
			}
		} else if (raum <= Konstanten.RAUM5) {
			if (getGesundheit() == Konstanten.BOSS99H) {
				bild = ICONBOSS2V;
			} else if (getGesundheit() == Konstanten.BOSS66H) {
				bild = ICONBOSS2M;
			} else if (getGesundheit() == Konstanten.BOSS33H) {
				bild = ICONBOSS2W;
			}
		} else if (raum <= Konstanten.RAUM8) {
			if (getGesundheit() == Konstanten.BOSS99H) {
				bild = ICONBOSS3V;
			} else if (getGesundheit() == Konstanten.BOSS66H) {
				bild = ICONBOSS3M;
			} else if (getGesundheit() == Konstanten.BOSS33H) {
				bild = ICONBOSS3W;
			}
		}
	}
}
