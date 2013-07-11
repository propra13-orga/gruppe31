package game.items;

import game.Konstanten;

/**
 * ein Objekt dieser Klasse ist Mana
 * 
 */
public class Mana extends Item {

	/** Icon für Mana wird deklariert */
	private static final String ICONMANA = Konstanten.DIRECTION
			+ "/src/game/Images/Mana1.png";

	/** bild vom Typ String wird deklariert */
	private String bild;

	/** mana wird deklariert */
	private int mana;

	/** Konstruktor initialisiert icon */
	public Mana() {
		bild = ICONMANA;

		mana = Konstanten.VOLLM;
	}

	/**
	 * Getter für mana;
	 * 
	 * @return mana Anzahl an Mana die man bekommen kann
	 */
	public int getMana() {
		return mana;
	}

	/**
	 * Setter für mana
	 * 
	 * @param mana
	 *            Kommandozeilenparameter
	 */
	public void setMana(int mana) {
		this.mana = mana;
	}

	@Override
	public String getPicture() {
		return bild;
	}
}
