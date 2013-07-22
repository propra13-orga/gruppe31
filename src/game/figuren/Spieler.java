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

	/** Icon f�r den zweiten Spieler werden deklariert */
	private static final String ICONLUKE = Konstanten.DIRECTION
			+ "/src/game/Images/Luke.png";

	/** bild vom Typ String wird deklariert */
	private String bild;

	/** Deklaration der Felder */
	private Spiel spiel;

	/**
	 * Variablen f�r leben, beschwertet, halsband, mana, gold, ruestung und
	 * Spielfigur Koordinaten werden deklariert
	 */
	private int leben;
	private boolean beschwertet;
	private boolean halsband;
	private boolean bewaffnet;
	private int mana;
	private int gold;
	private int ruestung;

	/** Die Position dieser Figur in der xy-Ebene. */
	private Point position;

	/** Deklaration der Felder */
	private Spielfeld spielfeld;

	/**
	 * Konstruktor weist Icon das richtige Icon zu
	 * 
	 * @param art
	 *            erwartet String, um richtiges Bild auszuw�hlen
	 */
	public Spieler(String art) {

		if ("Erna".equals(art)) {
			setzeBildErna();
		} else if ("Luke".equals(art)) {
			setzeBildLuke();
		}
	}

	/**
	 * w�hlt das Icon des Spielers, der Luke steuert
	 */
	public void setzeBildLuke() {
		bild = ICONLUKE;
		
	}

	/**
	 * w�hlt das Icon des Spielers, der Erna steuert
	 */
	public void setzeBildErna() {
			if (getBewaffnet()) {
				if (beschwertet) {
					if (halsband) {
						bild = ICONTERMINATORERNA;
					} else if (!halsband) {
						bild = ICONVOLLERNA;
					}
				} else if (!beschwertet) {
					if (halsband) {
						bild = ICONPUDELBEIDES;
					} else if (!halsband) {
						bild = ICONAGGROERNA;
					}
				}
			} else if (!getBewaffnet()) {
				if (beschwertet) {
					if (halsband) {
						bild = ICONPUDELSCHWERTHALSBAND;
					} else if (!halsband) {
						bild = ICONSCHWERTERNA;
					}
				} else if (!beschwertet) {
					if (halsband) {
						bild = ICONPUDELHALSBAND;
					} else if (!halsband) {
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
	public boolean getBeschwertet() {
		return beschwertet;
	}

	/**
	 * Setter f�r beschwertet
	 * 
	 * @param b
	 *            Kommandozeilenparameter
	 */
	public void setBeschwertet(boolean b) {
		this.beschwertet = b;
	}

	/**
	 * Getter f�r halsband
	 * 
	 * @return halsband Gibt an, ob Spieler ber�stet ist, oder nicht
	 */
	public boolean getHalsband() {
		return halsband;
	}

	/**
	 * Setter f�r halsband
	 * 
	 * @param b
	 *            Kommandozeilenparameter
	 */
	public void setHalsband(boolean b) {
		this.halsband = b;
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
	public void setManaPlus(int mana) {
		this.mana = getMana() + mana;
	}

	/**
	 * Setter f�r mana
	 * 
	 * @param mana
	 *            Kommandozeilenparameter
	 */
	public void setManaMinus(int mana) {
		this.mana = getMana() - mana;
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
	public void setLebenMinus(int leben) {
		this.leben = getLeben() - leben;
	}

	/**
	 * Setter f�r leben
	 * 
	 * @param leben
	 *            Kommandozeilenparameter
	 */
	public void setLebenPlus(int leben) {
		this.leben = getLeben() + leben;
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

	/**
	 * /**
	 * Setter f�r gold
	 * 
	 * @param gold
	 *            Kommandozeilenparameter
	 */
	public void setGoldPlus(int gold) {
		this.gold = getGold() + gold;

	}

	/**
	 * Setter f�r gold
	 * 
	 * @param gold
	 *            Kommandozeilenparameter
	 */
	public void setGoldMinus(int gold) {
		this.gold = getGold() - gold;
	}
}