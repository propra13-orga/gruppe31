package game.figuren;

import game.Konstanten;
import game.Spiel;
import game.Spielfeld;

import java.awt.Point;

/**
 * ein Objekt dieser Klasse ist der Spieler
 * 
 */
public class Spieler extends Spielfigur {

	/** Icons f�r den Spieler werden deklariert */
	private static final String ICONPUDEL = Konstanten.DIRECTION
			+ "/src/game/Images/Pudel1.jpg";
	private static final String ICONAGGROERNA = Konstanten.DIRECTION
			+ "/src/game/Images/PudelWaffe1.png";
	private static final String ICONSCHWERTERNA = Konstanten.DIRECTION
			+ "/src/game/Images/PudelSchwert.png";
	private static final String ICONTERMINATORERNA = Konstanten.DIRECTION
			+ "/src/game/Images/PudelAllesan.png";
	private static final String ICONPUDELBEIDES = Konstanten.DIRECTION
			+ "/src/game/Images/PudelBeides.png";
	private static final String ICONVOLLERNA = Konstanten.DIRECTION
			+ "/src/game/Images/PudelBrilleSchwert.png";
	private static final String ICONPUDELHALSBAND = Konstanten.DIRECTION
			+ "/src/game/Images/PudelHalsband.png";
	private static final String ICONPUDELSCHWERTHALSBAND = Konstanten.DIRECTION
			+ "/src/game/Images/Pudelschwerthals.png";

	/** bild vom Typ String wird deklariert */
	private String bild;

	/** Deklaration der Felder */
	private Spiel spiel;

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

	/** Die Position dieser Figur in der xy-Ebene. */
	private Point position;

	/** Deklaration der Felder */
	private Spielfeld spielfeld;

	/**
	 * Konstruktor weist Icon das richtige Icon zu
	 */
	public Spieler() {

		setBewaffnet(false);
		setGesundheit(Konstanten.VOLLH);
		setBeschwertet(0);
		setHalsband(0);
		setMana(0);
		setGold(0);
		setRuestung(0);

		if (getBewaffnet() == true) {
			if (beschwertet == 1) {
				if (halsband == 1) {
					bild = ICONTERMINATORERNA;
				} else if (halsband == 0) {
					bild = ICONVOLLERNA;
				}
			} else if (beschwertet == 0) {
				if (halsband == 1) {
					bild = ICONPUDELBEIDES;
				} else if (halsband == 0) {
					bild = ICONAGGROERNA;
				}
			}
		} else if (getBewaffnet() == false) {
			if (beschwertet == 1) {
				if (halsband == 1) {
					bild = ICONPUDELSCHWERTHALSBAND;
				} else if (halsband == 0) {
					bild = ICONSCHWERTERNA;
				}
			} else if (beschwertet == 0) {
				if (halsband == 1) {
					bild = ICONPUDELHALSBAND;
				} else if (halsband == 0) {
					bild = ICONPUDEL;
				}
			}
		}
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
	public String getPicture() {
		return bild;
	}

	/**
	 * Gibt die aktuelle Position dieser Figur zur�ck.
	 * 
	 * @return Die aktuelle Position der Figur.
	 */
	public Point getPosition() {

		return position;
	}

	/**
	 * Setzt die aktuelle Position dieser Figur.
	 * 
	 * @param neuePosition
	 *            Die neue Position der Figur.
	 */
	public void setPosition(Point neuePosition) {

		this.position = neuePosition;
	}
}