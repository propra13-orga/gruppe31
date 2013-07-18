package game;

import game.figuren.Gegner;
import game.figuren.Spieler;
import game.icons.Barriere;
import game.icons.Carlos;
import game.icons.Checkpoint;
import game.icons.Grenze;
import game.icons.Huette;
import game.icons.Jauch;
import game.icons.Luke;
import game.icons.Rasen;
import game.icons.SchalterAuf;
import game.icons.SchalterZu;
import game.icons.Weiter;
import game.icons.Ziel;
import game.icons.Zurueck;
import game.items.Brille;
import game.items.Gold;
import game.items.Health;
import game.items.Mana;
import game.items.Ruestung;
import game.items.Schwert;
import game.items.Shophealth;
import game.items.Shopmana;
import game.items.Shopruestung;

import java.awt.Point;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;

/** ist f�r den jeweiligen Raum zust�ndig. das Spielfeld wird erstellt */
public class Spielfeld {

	/** Speichert die Objekte auf diesem Spielfeld */
	public final GameObject[][] feld;

	/** Speichert die Groesse des Spielfelds */
	private int zeilen;
	private int spalten;

	/** Deklaration von Feldern */
	private Spiel spiel;
	private NPC npc;
	private NPC2 npc2;

	private Musik musik;
	private Barriere barriere;
	private GewonnenVerloren gewonnenVerloren;
	private Jauch jauch;

	/** Deklaration des Fenstertitels */
	private String name = "Erna's Adventure";

	/**
	 * erstellt ein Array feld, das nur aus GameObjects bestehen kann f�r jeden
	 * case wird ein Objekt der jeweiligen Klasse erstellt, welches den case
	 * �berschreibt
	 * 
	 * @param spiel
	 *            Kommandozeilenparameter
	 * @param hoehe
	 *            hoehe des Spielfeldes
	 * @param breite
	 *            breite des Spielfeldes
	 * @throws SpielfeldException
	 *             wirft eine Exception
	 */
	public Spielfeld(Spiel spiel, int hoehe, int breite)
			throws SpielfeldException {
		// spiel = new Spiel();
		this.spalten = hoehe;
		this.zeilen = breite;
		this.feld = new GameObject[breite][hoehe];
	}

	/**
	 * Gibt die Breite dieses Spielfelds zurueck.
	 * 
	 * @return Die Breite dieses Spielfelds.
	 */
	public int gibBreite() {
		return this.spalten;
	}

	/**
	 * Gibt die Hoehe dieses Spielfelds zurueck.
	 * 
	 * @return Die Hoehe dieses Spielfelds.
	 */
	public int gibHoehe() {
		return this.zeilen;
	}

	/**
	 * setzt das GameObject an die gew�nschte Position
	 * 
	 * @param objekt
	 *            Das Objekt, welches bewegt werden soll
	 * @param position
	 *            Angabe der Position des Objektes
	 */
	public void setzeObjekt(GameObject objekt, Point position) {
		this.feld[position.x][position.y] = objekt;
	}

	/**
	 * gibt das GameObject an Postion wieder Achtung: position.x ist die
	 * y-Position und andersrum
	 * 
	 * @param position
	 *            Position des GameObjects
	 * @return position
	 */
	public GameObject gibObjekt(Point position) {
		return this.feld[position.x][position.y];
	}

	/**
	 * Figuren werden bewegt
	 * 
	 * @param spielfigur
	 *            Spielfigur wird �bergeben
	 * @param gegner
	 *            Gegner wird �bergeben
	 * @param keyCode
	 *            KeyCode wird �bergeben
	 */
	public void aktion(Spieler spielfigur, Gegner gegner, int keyCode) {
		try {
			aktionSpieler(spielfigur, keyCode);
			// aktionGegner(gegner, keyCode);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void aktionGegner(Gegner gegner, int keyCode) {
		gegner.setzeBildPilz();
		gegner.getPicture();
	}

	/**
	 * Spieler wird Mana abgezogen, beschwertet und geheilt
	 * 
	 * @param spielfigur
	 *            Kommandozeilenparamter
	 */
	public void zaubere(Spieler spielfigur) {
		if (spielfigur.getMana() > Konstanten.LEERM) {
			spielfigur.setManaMinus(Konstanten.HALBM);
			spielfigur.setBeschwertet(true);
			spielfigur.setGesundheit(Konstanten.VOLLH);
		} else
			JOptionPane.showMessageDialog(null, "Sie haben kein Mana!",
					"Achtung", JOptionPane.WARNING_MESSAGE);
	}

	/**
	 * Spielfigur wird bewegt
	 * 
	 * @param spielfigur
	 *            Kommandozeilenparameter
	 * @param keyCode
	 *            Kommandozeilenparameter
	 * @throws Exception
	 *             wirft Exception
	 */
	private void aktionSpieler(Spieler spielfigur, int keyCode)
			throws Exception {
		/* Alte und neue Position f�r Spieler festlegen. */
		Point aktPos = spielfigur.getPosition();
		Point neuPos = new Point(aktPos);

		if (keyCode == KeyEvent.VK_LEFT) {
			neuPos.x--;
		} else if (keyCode == KeyEvent.VK_RIGHT) {
			neuPos.x++;
		} else if (keyCode == KeyEvent.VK_UP) {
			neuPos.y--;
		} else if (keyCode == KeyEvent.VK_DOWN) {
			neuPos.y++;
		} else if (keyCode == KeyEvent.VK_SPACE) {
			/* TODO */
		} else if (keyCode == KeyEvent.VK_X) {
			/* TODO */
		} else if (keyCode == KeyEvent.VK_CONTROL) {
			zaubere(spielfigur);
		} else {
			/* Andere Tasten wollen wir nicht beruecksichtigen. */
			return;
		}

		GameObject obj = this.gibObjekt(neuPos);

		boolean sollBewegtWerden = false;
		boolean einsammeln = false;
		boolean umlegen = false;

		/* Spielfigur: Objekte drum herum pr�fen */
		if (obj instanceof Rasen) {
			sollBewegtWerden = true;
		} else if (obj instanceof Grenze) {
			/* Bewegung ingorieren */
			/* TODO Health Anzeige verschwindet, wenn tot, das soll nicht */
		} else if (obj instanceof Gegner) {
			if (spielfigur.getLeben() >= Konstanten.EINLEBEN) {
				if (spielfigur.getGesundheit() >= Konstanten.HALBH) {
					spielfigur.setGesundheitMinus(Konstanten.EINVIERTELH);
				} else if (spielfigur.getGesundheit() >= Konstanten.EINVIERTELH) {
					spielfigur.setLebenMinus(1);
					spielfigur.setGesundheitPlus(Konstanten.VOLLH);
				}
			}
			if (spielfigur.getLeben() < Konstanten.EINLEBEN) {
				gewonnenVerloren = new GewonnenVerloren("verloren");
			}
		} else if (obj instanceof Huette) {
			/* Bewegung ignorieren. */
		} else if (obj instanceof Carlos) {
			npc = new NPC();
			/* Bewegung igorieren */
		} else if (obj instanceof Checkpoint) {
			/* TODO Checkpoint(); */
		} else if (obj instanceof Weiter) {
			/* TODO */
			spiel.levelWeiter();
		} else if (obj instanceof Zurueck) {
			/* TODO */
			spiel.levelZurueck();
		} else if (obj instanceof Ziel) {
			gewonnenVerloren = new GewonnenVerloren("gewonnen");
		} else if (obj instanceof Brille) {
			spielfigur.setBewaffnet(true);
			einsammeln = true;
		} else if (obj instanceof Gold) {
			spielfigur.setGoldPlus(Konstanten.GOLD50);
			einsammeln = true;
		} else if (obj instanceof Health) {
			spielfigur.setGesundheitPlus(Konstanten.VOLLH);
			einsammeln = true;
		} else if (obj instanceof Mana) {
			spielfigur.setManaPlus(Konstanten.VOLLM);
			einsammeln = true;
		} else if (obj instanceof Ruestung) {
			spielfigur.setHalsband(true);
			einsammeln = true;
		} else if (obj instanceof Schwert) {
			spielfigur.setBeschwertet(true);
			einsammeln = true;
		} else if (obj instanceof Shophealth) {
			if (spielfigur.getGold() >= Konstanten.GOLD50) {
				spielfigur.setGoldMinus(Konstanten.GOLD50);
				spielfigur.setGesundheitPlus(Konstanten.VOLLH);
			} else {
				// nothing to do here
			}
			/* Bewegung ignorieren. */
		} else if (obj instanceof Shopmana) {
			if (spielfigur.getGold() >= Konstanten.GOLD50) {
				spielfigur.setGoldMinus(Konstanten.GOLD50);
				spielfigur.setManaPlus(Konstanten.VOLLM);
			} else {
				// nothing to do here
			}
			/* Bewegung ignorieren. */
		} else if (obj instanceof Shopruestung) {
			if (spielfigur.getGold() >= Konstanten.GOLD50) {
				spielfigur.setGoldMinus(Konstanten.GOLD50);
				spielfigur.setHalsband(true);
			} else {
				// nothing to do here
			}
			/* Bewegung ignorieren. */
		} else if (obj instanceof Luke) {
			npc2 = new NPC2();
			/* Bewegung ignorieren. */
		} else if (obj instanceof SchalterZu) {
			umlegen = true;
			/* Bewegung ignorieren */
		} else if (obj instanceof SchalterAuf) {
			/* Bewegung ignorieren */
		} else if (obj instanceof Jauch) {
			jauch = new Jauch();
			jauch.r�tsel1(spielfigur);
			einsammeln = true;
			/* Bewegung ignorieren */
		}

		if (sollBewegtWerden) {
			musik = new Musik(Konstanten.DIRECTION
					+ "/src/game/Sound/Schritt.wav");

			/* setzt Rasen an die alte Position und die Spielfigur auf die neue */
			this.setzeObjekt(obj, aktPos);
			this.setzeObjekt(spielfigur, neuPos);

			/* setzt die neue Position */
			spielfigur.setPosition(neuPos);
		}

		if (einsammeln) {
			musik = new Musik(Konstanten.DIRECTION
					+ "/src/game/Sound/Schritt.wav");

			/* setzt Rasen an die alte Position und die Spielfigur auf die neue */
			this.setzeObjekt(new Rasen(), aktPos);
			this.setzeObjekt(spielfigur, neuPos);

			/* setzt die neue Position */
			spielfigur.setPosition(neuPos);
		}

		if (umlegen) {

			/* setzt Rasen an die alte Position und die Spielfigur auf die neue */
			this.setzeObjekt(spielfigur, aktPos);
			this.setzeObjekt(new SchalterAuf(), neuPos);

			/*
			 * TODO hier muss die Position der Barriere ausgemacht werden und
			 * dorthin Rasen gesetzt werden Point barrierePosition =
			 * this.barriere.getPosition(); this.setzeObjekt(new Rasen(),
			 * barrierePosition); funktioniert so nicht
			 */

			/* setzt die neue Position */
			spielfigur.setPosition(aktPos);

			musik = new Musik(Konstanten.DIRECTION
					+ "/src/game/Sound/Schalter.wav");
		}
		spielfigur.setzeBildErna();
		spielfigur.getPicture();
	}

	/*
	 * TODO Pr�fung ob Checkpoint besucht wurde und Zur�cksetzen des Spiels oder
	 * Ausgang Verloren
	 * 
	 * public void Checkpoint() { if (save == 1) { if (leben > 0) { health =
	 * 100; Spielfigurx = checkx; Spielfigury = checky;
	 * zeichner.zeichneSpielfeld(CheckSpielfeld); setzeAnzeige(); } else if
	 * (leben <= 0) { Verloren(); } } else if (save == 0) { Verloren(); } }
	 */
}
