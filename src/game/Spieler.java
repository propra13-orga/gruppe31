package game;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * ein Objekt dieser Klasse ist der Spieler
 * 
 */
public class Spieler extends Spielfigur {

	/** Icons f�r den Spieler werden deklariert */
	private static final Icon ICONPUDEL = new ImageIcon(Konstanten.DIRECTION
			+ "/src/game/Images/Pudel1.jpg");
	private static final Icon ICONAGGROERNA = new ImageIcon(
			Konstanten.DIRECTION + "/src/game/Images/PudelWaffe1.png");
	private static final Icon ICONSCHWERTERNA = new ImageIcon(
			Konstanten.DIRECTION + "/src/game/Images/PudelSchwert.png");
	private static final Icon ICONTERMINATORERNA = new ImageIcon(
			Konstanten.DIRECTION + "/src/game/Images/PudelAllesan.png");
	private static final Icon ICONPUDELBEIDES = new ImageIcon(
			Konstanten.DIRECTION + "/src/game/Images/PudelBeides.png");
	private static final Icon ICONVOLLERNA = new ImageIcon(Konstanten.DIRECTION
			+ "/src/game/Images/PudelBrilleSchwert.png");
	private static final Icon ICONPUDELHALSBAND = new ImageIcon(
			Konstanten.DIRECTION + "/src/game/Images/PudelHalsband.png");
	private static final Icon ICONPUDELSCHWERTHALSBAND = new ImageIcon(
			Konstanten.DIRECTION + "/src/game/Images/Pudelschwerthals.png");

	/** icon vom Typ Icon wird deklariert */
	private Icon icon;

	/**
	 * Variablen f�r leben, beschwertet, halsband, mana, gold, ruestung und
	 * Spielfigur Koordinaten werden deklariert
	 */
	private int leben;
	private int beschwertet;
	private int halsband;
	private int mana;
	private int gold;
	private int ruestung;
	private int Spielfigurx;
	private int Spielfigury;

	/**
	 * Konstruktor weist Icon das richtige Icon zu
	 * 
	 * @param y
	 *            Kommandozeilenparameter
	 * @param x
	 *            Kommandozeilenparameter
	 */
	public Spieler(int x, int y) {

		Spielfigurx = x;
		Spielfigury = y;

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
	 * Getter f�r Spielfigurx
	 * 
	 * @return Spielfigurx Die X-Position des Spielers
	 */
	public int getSpielfigurx() {
		return Spielfigurx;
	}

	/**
	 * Setter f�r Spielfigurx
	 * 
	 * @param Spielfigurx
	 *            Kommandozeilenparameter
	 */
	public void setSpielfigurx(int Spielfigurx) {
		this.Spielfigurx = Spielfigurx;
	}

	/**
	 * Getter f�r Spielfigurx
	 * 
	 * @return Spielfigury Die Y-Position des Spielers
	 */
	public int getSpielfigury() {
		return Spielfigury;
	}

	/**
	 * Setter f�r Spielfigury
	 * 
	 * @param Spielfigury
	 *            Kommandozeilenparameter
	 */
	public void setSpielfigury(int Spielfigury) {
		this.Spielfigury = Spielfigury;
	}

	/**
	 * Getter f�r beschwertet
	 * 
	 * @return beschwertet Gibt an, ob Spieler beschwertet ist oder nicht
	 */
	public int getBeschwertet() {
		return beschwertet;
	}

	/**
	 * Setter f�r beschwertet
	 * 
	 * @param beschwertet
	 *            Kommandozeilenparameter
	 */
	public void setBeschwertet(int beschwertet) {
		this.beschwertet = beschwertet;
	}

	/**
	 * Getter f�r halsband
	 * 
	 * @return halsband Gibt an, ob Spieler ber�stet ist, oder nicht
	 */
	public int getHalsband() {
		return halsband;
	}

	/**
	 * Setter f�r halsband
	 * 
	 * @param halsband
	 *            Kommandozeilenparameter
	 */
	public void setHalsband(int halsband) {
		this.halsband = halsband;
	}

	/**
	 * Getter f�r mana
	 * 
	 * @return mana Gibt den Manawert des Spielers an
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

	/**
	 * Getterf�r leben
	 * 
	 * @return leben Gibt die verbleibenden Leben des Spielers an
	 */
	public int getLeben() {
		return leben;
	}

	/**
	 * Setter f�r leben
	 * 
	 * @param leben
	 *            Kommandozeilenparameter
	 */
	public void setLeben(int leben) {
		this.leben = leben;
	}

	/**
	 * Getter f�r ruestung
	 * 
	 * @return ruestung Gibt an, �ber wie viel R�stung der Spieler noch verf�gt
	 */
	public int getRuestung() {
		return ruestung;
	}

	/**
	 * Setter f�r ruestung
	 * 
	 * @param ruestung
	 *            Kommandozeilenparameter
	 */
	public void setRuestung(int ruestung) {
		this.ruestung = ruestung;
	}

	/**
	 * Getter f�r gold
	 * 
	 * @return gold Gibt den Goldwert des Spielers an
	 */
	public int getGold() {
		return gold;
	}

	/**
	 * Setter f�r gold
	 * 
	 * @param gold
	 *            Kommandozeilenparameter
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