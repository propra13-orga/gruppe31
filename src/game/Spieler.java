package game;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * ein Objekt dieser Klasse ist der Spieler
 * 
 */
public class Spieler extends Spielfigur {

	/** Icons für den Spieler werden deklariert */
	private static final Icon ICONPUDEL = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Pudel1.jpg");
	private static final Icon ICONAGGROERNA = new ImageIcon(
			Konstanten.direction + "/src/game/Images/PudelWaffe1.png");
	private static final Icon ICONSCHWERTERNA = new ImageIcon(
			Konstanten.direction + "/src/game/Images/PudelSchwert.png");
	private static final Icon ICONTERMINATORERNA = new ImageIcon(
			Konstanten.direction + "/src/game/Images/PudelAllesan.png");
	private static final Icon ICONPUDELBEIDES = new ImageIcon(
			Konstanten.direction + "/src/game/Images/PudelBeides.png");
	private static final Icon ICONVOLLERNA = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/PudelBrilleSchwert.png");
	private static final Icon ICONPUDELHALSBAND = new ImageIcon(
			Konstanten.direction + "/src/game/Images/PudelHalsband.png");
	private static final Icon ICONPUDELSCHWERTHALSBAND = new ImageIcon(
			Konstanten.direction + "/src/game/Images/Pudelschwerthals.png");

	/** icon vom Typ Icon wird deklariert */
	private Icon icon;

	/**
	 * Variablen für leben, beschwertet, halsband, mana, gold, ruestung werden
	 * deklariert
	 */
	private int leben;
	private int beschwertet;
	private int halsband;
	private int mana;
	private int gold;
	private int ruestung;

	/** Konstruktor weist Icon das richtige Icon zu */
	public Spieler() {
		if (getBewaffnet() == true) {
			if (beschwertet == 1) {
				if (halsband == 1) {
					icon = ICONTERMINATORERNA;
				} else if (halsband == 0) {
					icon = ICONVOLLERNA;
				}
			} else if (beschwertet == 0) {
				if (halsband == 1) {
					icon = ICONPUDELBEIDES;
				} else if (halsband == 0) {
					icon = ICONAGGROERNA;
				}
			}
		} else if (getBewaffnet() == false) {
			if (beschwertet == 1) {
				if (halsband == 1) {
					icon = ICONPUDELSCHWERTHALSBAND;
				} else if (halsband == 0) {
					icon = ICONSCHWERTERNA;
				}
			} else if (beschwertet == 0) {
				if (halsband == 1) {
					icon = ICONPUDELHALSBAND;
				} else if (halsband == 0) {
					icon = ICONPUDEL;
				}
			}
		}
	}

	/**
	 * Getter für beschwertet
	 * 
	 * @return
	 */
	public int getBeschwertet() {
		return beschwertet;
	}

	/**
	 * Setter für beschwertet
	 * 
	 * @param beschwertet
	 */
	public void setBeschwertet(int beschwertet) {
		this.beschwertet = beschwertet;
	}

	/**
	 * Getter für halsband
	 * 
	 * @return
	 */
	public int getHalsband() {
		return halsband;
	}

	/**
	 * Setter für halsband
	 * 
	 * @param halsband
	 */
	public void setHalsband(int halsband) {
		this.halsband = halsband;
	}

	/**
	 * Getter für mana
	 * 
	 * @return
	 */
	public int getMana() {
		return mana;
	}

	/**
	 * Setter für mana
	 * 
	 * @param mana
	 */
	public void setMana(int mana) {
		this.mana = mana;
	}

	/**
	 * Getterfür leben
	 * 
	 * @return
	 */
	public int getLeben() {
		return leben;
	}

	/**
	 * Setter für leben
	 * 
	 * @param leben
	 */
	public void setLeben(int leben) {
		this.leben = leben;
	}

	/**
	 * Getter für ruestung
	 * 
	 * @return
	 */
	public int getRuestung() {
		return ruestung;
	}

	/**
	 * Setter für ruestung
	 * 
	 * @param ruestung
	 */
	public void setRuestung(int ruestung) {
		this.ruestung = ruestung;
	}

	/**
	 * Getter für gold
	 * 
	 * @return
	 */
	public int getGold() {
		return gold;
	}

	/**
	 * Setter für gold
	 * 
	 * @param gold
	 */
	public void setGold(int gold) {
		this.gold = gold;
	}

	@Override
	public Icon getIcon() {
		return icon;
	}

	@Override
	protected boolean internalTryMove(GameObject ziel) {
		// darf ich dahin oder nicht
		return false;
	}
}