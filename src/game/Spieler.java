package game;

import java.awt.Graphics;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * ein Objekt dieser Klasse ist der Spieler
 * 
 */
public class Spieler extends Spielfigur {
	
	private static final Icon iconPudel = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Pudel1.jpg");
	private static final Icon iconAggroErna = new ImageIcon(
			Konstanten.direction + "/src/game/Images/PudelWaffe1.png");
	private static final Icon iconSchwertErna = new ImageIcon(
			Konstanten.direction + "/src/game/Images/PudelSchwert.png");
	private static final Icon iconTerminatorErna = new ImageIcon(
			Konstanten.direction + "/src/game/Images/PudelAllesan.png");
	private static final Icon iconPudelBeides = new ImageIcon(
			Konstanten.direction + "/src/game/Images/PudelBeides.png");
	private static final Icon iconVollErna = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/PudelBrilleSchwert.png");
	private static final Icon iconPudelHalsband = new ImageIcon(
			Konstanten.direction + "/src/game/Images/PudelHalsband.png");
	private static final Icon iconPudelSchwertHals = new ImageIcon(
			Konstanten.direction + "/src/game/Images/Pudelschwerthals.png");
	
	private int leben;
	private int beschwertet;
	private int halsband;
	private int mana;
	private int gold;
	private int ruestung;

	public Spieler() {
		setLeben(3);
		setBeschwertet(0);
		setHalsband(0);
		setMana(0);
		setGold(0);
		setRuestung(0);
		setBewaffnet(0);
		setGesundheit(100);
		
	}

	public int getBeschwertet() {
		return beschwertet;
	}

	public void setBeschwertet(int beschwertet) {
		this.beschwertet = beschwertet;
	}

	public int getHalsband() {
		return halsband;
	}

	public void setHalsband(int halsband) {
		this.halsband = halsband;
	}

	public int getMana() {
		return mana;
	}

	public void setMana(int mana) {
		this.mana = mana;
	}

	public int getLeben() {
		return leben;
	}

	public void setLeben(int leben) {
		this.leben = leben;
	}
	
	public int getRuestung() {
		return ruestung;
	}

	public void setRuestung(int ruestung) {
		this.ruestung = ruestung;
	}
	
	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	@Override
	public Icon getIcon() {
		Icon icon = iconPudel;
		if (getBewaffnet() == 1) {
			if (beschwertet == 1) {
				if (halsband == 1) {
					icon = iconTerminatorErna;
				} else if (halsband == 0) {
					icon = iconVollErna;
				}
			} else if (beschwertet == 0) {
				if (halsband == 1) {
					icon = iconPudelBeides;
				} else if (halsband == 0) {
					icon = iconAggroErna;
				}
			}
		} else if (getBewaffnet() == 0) {
			if (beschwertet == 1) {
				if (halsband == 1) {
					icon = iconPudelSchwertHals;
				} else if (halsband == 0) {
					icon = iconSchwertErna;
				}
			} else if (beschwertet == 0) {
				if (halsband == 1) {
					icon = iconPudelHalsband;
				} else if (halsband == 0) {
					icon = iconPudel;
				}
			}
		}
		return icon;
	}

	@Override
	protected boolean internalTryMove(GameObject ziel) {
		// darf ich dahin oder nicht
		return false;
	}
}