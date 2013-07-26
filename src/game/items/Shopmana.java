package game.items;

import java.io.Serializable;

import game.Konstanten;

/**
 * ein Objekt dieser Klasse ist Shopmana
 * 
 */
public class Shopmana extends Item implements Serializable {

	/** Icon f�r Mana im Shop wird deklariert */
	private static final String ICONSHOPMANA = Konstanten.DIRECTION
			+ "/src/game/Images/Mana1.png";

	/** bild vom Typ String wird deklariert */
	private String bild;

	/** mana wird deklariert */
	private int mana;

	/** Konstruktor initialisiert icon */
	public Shopmana() {
		bild = ICONSHOPMANA;
	}

	/**
	 * Getter f�r mana
	 * 
	 * @return mana
	 */
	public int getMana() {
		return mana;
	}

	/**
	 * Setter f�r mana
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
