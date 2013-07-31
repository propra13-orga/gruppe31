package game;

import game.figuren.Bossgegner;
import game.figuren.Gegner;
import game.figuren.Spieler;
import game.icons.Barriere;
import game.icons.Carlos;
import game.icons.Checkpoint;
import game.icons.Falle;
import game.icons.Grenze;
import game.icons.Huette;
import game.icons.Jauch;
import game.icons.JauchNetzerk;
import game.icons.Laser;
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
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JOptionPane;

/** ist f�r den jeweiligen Raum zust�ndig. das Spielfeld wird erstellt */
public class Spielfeld implements Serializable {

	/** Speichert die Objekte auf diesem Spielfeld */
	public final GameObject[][] feld;

	/** Speichert die Groesse des Spielfelds */
	private int zeilen;
	private int spalten;

	/** Deklaration von Feldern */
	private Spiel spiel;
	private NPC npc;
	private Musik musik;
	private GewonnenVerloren gewonnenVerloren;
	private Jauch jauch;
	private JauchNetzerk jauchNetzwerk;
	private GameFrame gameFrame;

	/** Deklaration der Punkte f�r Weiter- und Zuruckfelder */
	private Point weiter;
	private Point zurueck;

	/** Deklaration von String, die mehrmals verwendet */
	private String name = "Erna's Adventure";
	private String verloren = "verloren";
	private String attention = "Achtung";
	private String autsch = "/src/game/Sound/Hit.wav";
	private String wuff = "/src/game/Sound/Wuff.wav";
	private String klimper = "/src/game/Sound/Ching.wav";
	private String huhu = "/src/game/Sound/huhu.wav";
	private String noMana = "Sie haben kein Mana!";
	private String gewonnen = "gewonnen";
	private String step = "/src/game/Sound/Schritt.wav";
	private String carlos = "Carlos";
	private String luke = "Luke";

	/** Deklaration von int zum Z�hlen */
	private int raum = 0;

	/** Deklaration Boolean, ob Spiel gespeichert */
	private Boolean checkpoint = false;

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
		this.spiel = spiel;
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
	 * @param spieler
	 *            Spielfigur wird �bergeben
	 * @param pilze
	 *            Pilze-List wird �bergeben
	 * @param bienen
	 *            Bienen-List wird �bergeben
	 * @param keyCode
	 *            KeyCode wird �bergeben
	 * @param barriere
	 *            barriere wird �bergeben
	 * @param gameFrame
	 *            Kommandozeilenparameter
	 * @param bossgegner
	 *            Kommandozeilenparameter
	 */
	public void aktion(Spieler spieler, ArrayList<Gegner> pilze,
			ArrayList<Gegner> bienen, int keyCode, Barriere barriere,
		GameFrame gameFrame, ArrayList<Bossgegner> bossgegner) {

		aktionSpieler(spieler, barriere, keyCode, gameFrame, bossgegner);

		/* Gegner werden bewegt */
		aktionGegner(pilze.get(spiel.getAktuellesSpielfeldNumber()), keyCode, spieler);

	}

	/**
	 * Gegnerfigur wird bewegt
	 * 
	 * @param aktGegner
	 *            Kommandozeilenparameter
	 * @param keyCode
	 *            Kommandozeilenparameter
	 */
	private void aktionGegner(Gegner aktGegner, int keyCode, Spieler spielfigur) {

		/* Alte und neue Position f�r Spieler festlegen. */
		Point aktGegPos = aktGegner.getPosition();
		Point neuGegPos = new Point(aktGegPos);

		if (keyCode == KeyEvent.VK_LEFT) {
			neuGegPos.x++;
		} else if (keyCode == KeyEvent.VK_RIGHT) {
			neuGegPos.x--;
		} else if (keyCode == KeyEvent.VK_UP) {
			neuGegPos.y++;
		} else if (keyCode == KeyEvent.VK_DOWN) {
			neuGegPos.y--;
		}

		GameObject obj = this.gibObjekt(neuGegPos);

		boolean gegSollBewegtWerden = false;

		/* Spielfigur: Objekte drum herum pr�fen */
		if (obj instanceof Rasen) {
			gegSollBewegtWerden = true;
		} else {
			// nothing to do here
		}

		if (gegSollBewegtWerden) {
			/* setzt Rasen an die alte Position und en Gegner auf die neue */
			this.setzeObjekt(obj, aktGegPos);
			this.setzeObjekt(aktGegner, neuGegPos);
			/* setzt die neue Position */
			aktGegner.setPosition(neuGegPos);
		}
		if (spielfigur.getRuestung() >= Konstanten.LEERR) {
			spielfigur.setHalsband(false);
		}

		aktGegner.setzeBildPilz();
		aktGegner.getPicture();
	}


	/**
	 * Spielfigur wird bewegt
	 * 
	 * @param spielfigur
	 *            Kommandozeilenparameter
	 * @param keyCode
	 *            Kommandozeilenparameter
	 * @param gameFrame
	 *            Kommandozeilenparameter
	 * @param bossgegner
	 *            Kommandozeilenparameter
	 * @param barriere
	 *            Kommandozeilenparameter
	 */
	private void aktionSpieler(Spieler spielfigur, Barriere barriere,
			int keyCode, GameFrame gameFrame, ArrayList<Bossgegner> bossgegner) {

		/* �berpr�ft erneut, ob spielfigur = Erna */
		if (spielfigur == spiel.spieler.get(0)) {

			/* Alte und neue Position f�r Spieler festlegen. */
			Point aktPos = spielfigur.getPosition();
			Point neuPos = new Point(aktPos);

			if (keyCode == KeyEvent.VK_LEFT || keyCode == KeyEvent.VK_RIGHT
					|| keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_DOWN) {
				pfeiltasten(keyCode, spielfigur, neuPos, aktPos, gameFrame,
						barriere, bossgegner);
			} else if (keyCode == KeyEvent.VK_SPACE) {
				lasere(spielfigur, gameFrame);
			} else if (keyCode == KeyEvent.VK_X) {
				schlage(spielfigur, bossgegner);
			} else if (keyCode == KeyEvent.VK_CONTROL) {
				zaubere1(spielfigur);
			} else if (keyCode == KeyEvent.VK_SHIFT) {
				zaubere2(spielfigur);
			} else {
				/* Andere Tasten wollen wir nicht beruecksichtigen. */
				return;
			}

			/* oder ob spielfigur = Luke */
		} else if (spielfigur == spiel.spieler.get(1)) {

			/* Alte und neue Position f�r Spieler festlegen. */
			Point aktPos = spielfigur.getPosition();
			Point neuPos = new Point(aktPos);

			if (keyCode == KeyEvent.VK_W || keyCode == KeyEvent.VK_A
					|| keyCode == KeyEvent.VK_S || keyCode == KeyEvent.VK_D) {
				wasd(keyCode, spielfigur, neuPos, aktPos, gameFrame, barriere,
						bossgegner);
			} else if (keyCode == KeyEvent.VK_J) {
				lasere(spielfigur, gameFrame);
			} else if (keyCode == KeyEvent.VK_K) {
				schlage(spielfigur, bossgegner);
			} else if (keyCode == KeyEvent.VK_N) {
				zaubere1(spielfigur);
			} else if (keyCode == KeyEvent.VK_M) {
				zaubere2(spielfigur);
			} else {
				/* Andere Tasten wollen wir nicht beruecksichtigen. */
				return;
			}
		}
	}

	/**
	 * Arbeitet die KeyEvents von WASD ab
	 * 
	 * @param keyCode
	 *            Kommandozeilenparameter
	 * @param spielfigur
	 *            Kommandozeilenparameter
	 * @param neuPos
	 *            Kommandozeilenparameter
	 * @param aktPos
	 *            Kommandozeilenparameter
	 * @param gameFrame
	 *            Kommandozeilenparameter
	 * @param barriere
	 *            Kommandozeilenparameter
	 * @param bossgegner
	 *            Kommandozeilenparameter
	 */
	private void wasd(int keyCode, Spieler spielfigur, Point neuPos,
			Point aktPos, GameFrame gameFrame, Barriere barriere,
			ArrayList<Bossgegner> bossgegner) {
		if (keyCode == KeyEvent.VK_A) {
			neuPos.x--;
		} else if (keyCode == KeyEvent.VK_D) {
			neuPos.x++;
		} else if (keyCode == KeyEvent.VK_W) {
			neuPos.y--;
		} else if (keyCode == KeyEvent.VK_S) {
			neuPos.y++;
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
		} else if (obj instanceof Gegner) {
			gegnerAngriff(spielfigur, gameFrame);
		} else if (obj instanceof Spieler) {
			gegnerAngriff(spielfigur, gameFrame);
		} else if (obj instanceof Falle) {
			spielfigur.setLebenMinus(1);
			musik = new Musik(Konstanten.DIRECTION + autsch);
		} else if (obj instanceof Bossgegner) {
			bossAngriff(spielfigur, gameFrame);
		} else if (obj instanceof Huette) {
			/* Bewegung ignorieren. */
		} else if (obj instanceof Carlos) {
			npc = new NPC(carlos);
			musik = new Musik(Konstanten.DIRECTION + wuff);
			/* Bewegung igorieren */
		} else if (obj instanceof Checkpoint) {
			checkpoint(gameFrame);
			einsammeln = true;
		} else if (obj instanceof Weiter) {
			if (spiel.getAktuellesSpielfeldNumber() <= Konstanten.RAUM8) {
				/* aktuelle Position auf Rasen setzen */
				this.setzeObjekt(new Rasen(), aktPos);
				/* Ueber das Spiel in den naechsten Raum wechseln. */
				spiel.levelWeiter(spielfigur);
			}
		} else if (obj instanceof Zurueck) {
			if (spiel.getAktuellesSpielfeldNumber() > 0) {
				/* aktuelle Position auf Rasen setzen */
				this.setzeObjekt(new Rasen(), aktPos);
				/* Ueber das Spiel in den letzten Raum wechseln. */
				spiel.levelZurueck(spielfigur);
			}
		} else if (obj instanceof Ziel) {
			gewonnenVerloren = new GewonnenVerloren(gewonnen);
			gameFrame.dispose();
		} else if (obj instanceof Brille) {
			spielfigur.setBewaffnet(true);
			einsammeln = true;
		} else if (obj instanceof Gold) {
			spielfigur.setGoldPlus(Konstanten.GOLD50);
			einsammeln = true;
		} else if (obj instanceof Health) {
			spielfigur.setGesundheit(Konstanten.VOLLH);
			einsammeln = true;
		} else if (obj instanceof Mana) {
			spielfigur.setMana(Konstanten.VOLLM);
			einsammeln = true;
		} else if (obj instanceof Ruestung) {
			spielfigur.setHalsband(true);
			spielfigur.setRuestung(Konstanten.VOLLR);
			einsammeln = true;
		} else if (obj instanceof Schwert) {
			spielfigur.setBeschwertet(true);
			einsammeln = true;
		} else if (obj instanceof Shophealth) {
			if (spielfigur.getGold() >= Konstanten.GOLD50) {
				musik = new Musik(Konstanten.DIRECTION + klimper);
				spielfigur.setGoldMinus(Konstanten.GOLD50);
				spielfigur.setGesundheit(Konstanten.VOLLH);
			} else {
				// nothing to do here
			}
			/* Bewegung ignorieren. */
		} else if (obj instanceof Shopmana) {
			if (spielfigur.getGold() >= Konstanten.GOLD50) {
				musik = new Musik(Konstanten.DIRECTION + klimper);
				spielfigur.setGoldMinus(Konstanten.GOLD50);
				spielfigur.setMana(Konstanten.VOLLM);
			} else {
				// nothing to do here
			}
			/* Bewegung ignorieren. */
		} else if (obj instanceof Shopruestung) {
			if (spielfigur.getGold() >= Konstanten.GOLD50) {
				musik = new Musik(Konstanten.DIRECTION + klimper);
				spielfigur.setGoldMinus(Konstanten.GOLD50);
				spielfigur.setHalsband(true);
				spielfigur.setRuestung(Konstanten.VOLLR);
			} else {
				// nothing to do here
			}
			/* Bewegung ignorieren. */
		} else if (obj instanceof Luke) {
			npc = new NPC(luke);
			musik = new Musik(Konstanten.DIRECTION + wuff);
			/* Bewegung ignorieren. */
		} else if (obj instanceof SchalterZu) {
			umlegen = true;
			/* Bewegung ignorieren */
		} else if (obj instanceof SchalterAuf) {
			/* Bewegung ignorieren */
		} else if (obj instanceof Jauch) {
			jauch = new Jauch();
			jauch.raetsel(spielfigur, spiel);
			this.setzeObjekt(new Rasen(), neuPos);
			/* Bewegung ignorieren */
		} else if (obj instanceof JauchNetzerk) {
			jauchNetzwerk = new JauchNetzerk();
			boolean jauchWeg = jauchNetzwerk.raetsel(spielfigur);
			if (jauchWeg) {
				this.setzeObjekt(new Rasen(), neuPos);
			}
			/* Bewegung ignorieren */
		}

		if (sollBewegtWerden) {
			musik = new Musik(Konstanten.DIRECTION + step);
			/* setzt Rasen an die alte Position und die Spielfigur auf die neue */
			this.setzeObjekt(obj, aktPos);
			this.setzeObjekt(spielfigur, neuPos);
			/* setzt die neue Position */
			spielfigur.setPosition(neuPos);
		}

		if (einsammeln) {
			musik = new Musik(Konstanten.DIRECTION + "/src/game/Sound/Item.wav");
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
			this.setzeObjekt(new Rasen(), barriere.getPosition());
			/* setzt die neue Position */
			spielfigur.setPosition(aktPos);

			musik = new Musik(Konstanten.DIRECTION
					+ "/src/game/Sound/Schalter.wav");
		}
		if (spielfigur.getErna()) {
			spielfigur.setzeBildErna();
		} else if (spielfigur.getLuke()) {
			spielfigur.setzeBildLuke();
		}
		spielfigur.getPicture();

	}

	/**
	 * Arbeitet die KeyEvents der Pfeiltasten ab
	 * 
	 * @param keyCode
	 *            Kommandozeilenparameter
	 * @param spielfigur
	 *            Kommandozeilenparameter
	 * @param neuPos
	 *            Kommandozeilenparameter
	 * @param aktPos
	 *            Kommandozeilenparameter
	 * @param gameFrame
	 *            Kommandozeilenparameter
	 * @param barriere
	 *            Kommandozeilenparameter
	 * @param bossgegner
	 *            Kommandozeilenparameter
	 * @throws Exception
	 */
	private void pfeiltasten(int keyCode, Spieler spielfigur, Point neuPos,
			Point aktPos, GameFrame gameFrame, Barriere barriere,
			ArrayList<Bossgegner> bossgegner) {
		if (keyCode == KeyEvent.VK_LEFT) {
			neuPos.x--;
		} else if (keyCode == KeyEvent.VK_RIGHT) {
			neuPos.x++;
		} else if (keyCode == KeyEvent.VK_UP) {
			neuPos.y--;
		} else if (keyCode == KeyEvent.VK_DOWN) {
			neuPos.y++;
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
			gegnerAngriff(spielfigur, gameFrame);
		} else if (obj instanceof Spieler) {
			gegnerAngriff(spielfigur, gameFrame);
		} else if (obj instanceof Falle) {
			spielfigur.setLebenMinus(1);
			musik = new Musik(Konstanten.DIRECTION + autsch);
		} else if (obj instanceof Bossgegner) {
			bossAngriff(spielfigur, gameFrame);
		} else if (obj instanceof Huette) {
			/* Bewegung ignorieren. */
		} else if (obj instanceof Carlos) {
			npc = new NPC(carlos);
			musik = new Musik(Konstanten.DIRECTION + wuff);
			/* Bewegung igorieren */
		} else if (obj instanceof Checkpoint) {
			checkpoint(gameFrame);
			einsammeln = true;
		} else if (obj instanceof Weiter) {
			if (spiel.getAktuellesSpielfeldNumber() <= Konstanten.RAUM8) {
				/* aktuelle Position auf Rasen setzen */
				this.setzeObjekt(new Rasen(), aktPos);
				/* Ueber das Spiel in den naechsten Raum wechseln. */
				spiel.levelWeiter(spielfigur);
			}
		} else if (obj instanceof Zurueck) {
			if (spiel.getAktuellesSpielfeldNumber() > 0) {
				/* aktuelle Position auf Rasen setzen */
				this.setzeObjekt(new Rasen(), aktPos);
				/* Ueber das Spiel in den letzten Raum wechseln. */
				spiel.levelZurueck(spielfigur);
			}
		} else if (obj instanceof Ziel) {
			gewonnenVerloren = new GewonnenVerloren(gewonnen);
			gameFrame.dispose();
		} else if (obj instanceof Brille) {
			spielfigur.setBewaffnet(true);
			einsammeln = true;
		} else if (obj instanceof Gold) {
			spielfigur.setGoldPlus(Konstanten.GOLD50);
			einsammeln = true;
		} else if (obj instanceof Health) {
			spielfigur.setGesundheit(Konstanten.VOLLH);
			einsammeln = true;
		} else if (obj instanceof Mana) {
			spielfigur.setMana(Konstanten.VOLLM);
			einsammeln = true;
		} else if (obj instanceof Ruestung) {
			spielfigur.setHalsband(true);
			spielfigur.setRuestung(Konstanten.VOLLR);
			einsammeln = true;
		} else if (obj instanceof Schwert) {
			spielfigur.setBeschwertet(true);
			einsammeln = true;
		} else if (obj instanceof Shophealth) {
			if (spielfigur.getGold() >= Konstanten.GOLD50) {
				musik = new Musik(Konstanten.DIRECTION + klimper);
				spielfigur.setGoldMinus(Konstanten.GOLD50);
				spielfigur.setGesundheit(Konstanten.VOLLH);
			} else {
				// nothing to do here
			}
			/* Bewegung ignorieren. */
		} else if (obj instanceof Shopmana) {
			if (spielfigur.getGold() >= Konstanten.GOLD50) {
				musik = new Musik(Konstanten.DIRECTION + klimper);
				spielfigur.setGoldMinus(Konstanten.GOLD50);
				spielfigur.setMana(Konstanten.VOLLM);
			} else {
				// nothing to do here
			}
			/* Bewegung ignorieren. */
		} else if (obj instanceof Shopruestung) {
			if (spielfigur.getGold() >= Konstanten.GOLD50) {
				musik = new Musik(Konstanten.DIRECTION + klimper);
				spielfigur.setGoldMinus(Konstanten.GOLD50);
				spielfigur.setHalsband(true);
				spielfigur.setRuestung(Konstanten.VOLLR);
			} else {
				// nothing to do here
			}
			/* Bewegung ignorieren. */
		} else if (obj instanceof Luke) {
			npc = new NPC(luke);
			musik = new Musik(Konstanten.DIRECTION + wuff);
			/* Bewegung ignorieren. */
		} else if (obj instanceof SchalterZu) {
			umlegen = true;
			/* Bewegung ignorieren */
		} else if (obj instanceof SchalterAuf) {
			/* Bewegung ignorieren */
		} else if (obj instanceof Jauch) {
			jauch = new Jauch();
			jauch.raetsel(spielfigur, spiel);
			this.setzeObjekt(new Rasen(), neuPos);
			/* Bewegung ignorieren */
		} else if (obj instanceof JauchNetzerk) {
			jauchNetzwerk = new JauchNetzerk();
			boolean jauchWeg = jauchNetzwerk.raetsel(spielfigur);
			if (jauchWeg) {
				this.setzeObjekt(new Rasen(), neuPos);
			}
			/* Bewegung ignorieren */
		}

		if (sollBewegtWerden) {
			musik = new Musik(Konstanten.DIRECTION + step);
			/* setzt Rasen an die alte Position und die Spielfigur auf die neue */
			this.setzeObjekt(obj, aktPos);
			this.setzeObjekt(spielfigur, neuPos);
			/* setzt die neue Position */
			spielfigur.setPosition(neuPos);
		}

		if (einsammeln) {
			musik = new Musik(Konstanten.DIRECTION + "/src/game/Sound/Item.wav");
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
			this.setzeObjekt(new Rasen(), barriere.getPosition());
			/* setzt die neue Position */
			spielfigur.setPosition(aktPos);

			musik = new Musik(Konstanten.DIRECTION
					+ "/src/game/Sound/Schalter.wav");
		}
		if (spielfigur.getErna()) {
			spielfigur.setzeBildErna();
		} else if (spielfigur.getLuke()) {
			spielfigur.setzeBildLuke();
		}
		spielfigur.getPicture();
	}

	/**
	 * f�hrt die Aktionen durch, die n�tig sind, wenn die Spielfigur vom Gegner
	 * angegriffen wird
	 * 
	 * @param spielfigur
	 *            erwartet spielfigur
	 * @param gameFrame
	 *            erwartet GameFrame
	 */
	private void bossAngriff(Spieler spielfigur, GameFrame gameFrame) {
		if (spielfigur.getRuestung() >= Konstanten.HALBR) {
			spielfigur.setRuestungMinus(Konstanten.HALBH);
		} else {
			if (spielfigur.getLeben() >= Konstanten.EINLEBEN) {
				musik = new Musik(Konstanten.DIRECTION + autsch);
				if (spielfigur.getGesundheit() >= Konstanten.DREIVIERTELH) {
					spielfigur.setGesundheitMinus(Konstanten.HALBH);
				} else if (spielfigur.getGesundheit() >= Konstanten.EINVIERTELH) {
					spiel.init("Checkpoint.txt");
					spielfigur.setLebenMinus(1);
					spielfigur.setGesundheitPlus(Konstanten.VOLLH);
				}
			}
			if (spielfigur.getLeben() < Konstanten.EINLEBEN) {
				gewonnenVerloren = new GewonnenVerloren(verloren);
				gameFrame.dispose();
			}
		}
	}

	/**
	 * f�hrt die Aktionen durch, die n�tig sind, wenn die Spielfigur vom Gegner
	 * (sowohl Pilze, Bienen, als auch andere Spieler) angegriffen wird
	 * 
	 * @param spielfigur
	 *            erwartet spielfigur
	 * @param gameFrame
	 *            erwartet GameFrame
	 */
	private void gegnerAngriff(Spieler spielfigur, GameFrame gameFrame) {
		if (spielfigur.getRuestung() >= Konstanten.HALBR) {
			spielfigur.setRuestungMinus(Konstanten.HALBR);
		} else if (spielfigur.getRuestung() == Konstanten.LEERR) {
			if (spielfigur.getLeben() >= Konstanten.EINLEBEN) {
				musik = new Musik(Konstanten.DIRECTION + autsch);
				if (spielfigur.getGesundheit() >= Konstanten.HALBH) {
					spielfigur.setGesundheitMinus(Konstanten.EINVIERTELH);
				} else if (spielfigur.getGesundheit() >= Konstanten.EINVIERTELH) {
					spielfigur.setLebenMinus(1);
					spielfigur.setGesundheitPlus(Konstanten.VOLLH);
				}
			}
			if (spielfigur.getLeben() < Konstanten.EINLEBEN) {
				gewonnenVerloren = new GewonnenVerloren(verloren);
				gameFrame.dispose();
			}
		}
	}

	/**
	 * Spieler wird Mana abgezogen, beschwertet und entwaffnet
	 * 
	 * @param spielfigur
	 *            Kommandozeilenparamter
	 */
	public void zaubere1(Spieler spielfigur) {
		if (spielfigur.getMana() > Konstanten.LEERM) {
			spielfigur.setManaMinus(Konstanten.HALBM);
			spielfigur.setGesundheit(Konstanten.VOLLH);
			spielfigur.setBeschwertet(true);
			spielfigur.setBewaffnet(false);
		} else
			JOptionPane.showMessageDialog(null, noMana, attention,
					JOptionPane.WARNING_MESSAGE);
	}

	/**
	 * Spieler wird Mana abgezogen, bewaffnet und entschwertet
	 * 
	 * @param spielfigur
	 *            Kommandozeilenparamter
	 */
	public void zaubere2(Spieler spielfigur) {
		if (spielfigur.getMana() > Konstanten.LEERM) {
			spielfigur.setManaMinus(Konstanten.HALBM);
			spielfigur.setGesundheit(Konstanten.VOLLH);
			spielfigur.setBeschwertet(false);
			spielfigur.setBewaffnet(true);
		} else
			JOptionPane.showMessageDialog(null, noMana, attention,
					JOptionPane.WARNING_MESSAGE);
	}

	/**
	 * Laserbrille wird eingesetzt nur gegen Pilzgegner wirksam
	 * 
	 * @param spielfigur
	 *            Kommandozeilenparameter
	 * @param gameFrame
	 *            Kommandozeilenparameter
	 */
	private void lasere(Spieler spielfigur, GameFrame gameFrame) {
		if (spielfigur.getBewaffnet()) {

			Point neuSchussPos = spielfigur.getPosition();

			neuSchussPos.x++;

			GameObject obj = this.gibObjekt(neuSchussPos);

			while (obj instanceof Rasen || obj instanceof Gegner) {
				this.setzeObjekt(new Laser(), neuSchussPos);
				neuSchussPos.x++;
				obj = this.gibObjekt(neuSchussPos);
			}
			neuSchussPos.x--;
			obj = this.gibObjekt(neuSchussPos);
			while (obj instanceof Laser) {
				this.setzeObjekt(new Rasen(), neuSchussPos);
				neuSchussPos.x--;
				obj = this.gibObjekt(neuSchussPos);
			}
			musik = new Musik(Konstanten.DIRECTION
					+ "/src/game/Sound/Punch.wav");
		} else {
			JOptionPane.showMessageDialog(null,
					"Sie tragen keine Laserbrille!", attention,
					JOptionPane.WARNING_MESSAGE);
		}
	}

	/**
	 * Schwert wird eingesetzt nur gegen Bossgegner einsetzbar
	 * 
	 * @param spielfigur
	 *            Kommandozeilenparameter
	 * @param bossgegner
	 *            Kommandozeilenparameter
	 */
	public void schlage(Spieler spielfigur, ArrayList<Bossgegner> bossgegner) {

		if (spielfigur.getBeschwertet()) {
			Point aktPos = spielfigur.getPosition();
			Point linksPos = new Point(aktPos);
			Point obenPos = new Point(aktPos);
			Point rechtsPos = new Point(aktPos);
			Point untenPos = new Point(aktPos);

			linksPos.x--;
			rechtsPos.x++;
			untenPos.y++;
			obenPos.y--;

			GameObject links = this.gibObjekt(linksPos);
			GameObject rechts = this.gibObjekt(rechtsPos);
			GameObject unten = this.gibObjekt(untenPos);
			GameObject oben = this.gibObjekt(obenPos);
			if (links instanceof Bossgegner || rechts instanceof Bossgegner
					|| oben instanceof Bossgegner
					|| unten instanceof Bossgegner) {
				if (links instanceof Bossgegner) {
					if (spiel.getBossgegner().get(0).getGesundheit() > Konstanten.BOSS33H) {
						spiel.getBossgegner().get(0).setGesundheitMinus(Konstanten.BOSS33H);
					} else if (spiel.getBossgegner().get(0).getGesundheit() == Konstanten.BOSS33H) {
						this.setzeObjekt(new Rasen(), linksPos);
				}
				musik = new Musik(Konstanten.DIRECTION + huhu);
				} else if (rechts instanceof Bossgegner) {
				if (spiel.getBossgegner().get(0).getGesundheit() > Konstanten.BOSS33H) {
						spiel.getBossgegner().get(0).setGesundheitMinus(Konstanten.BOSS33H);
					} else if (spiel.getBossgegner().get(0).getGesundheit() == Konstanten.BOSS33H) {
						this.setzeObjekt(new Rasen(), rechtsPos);
					}
					musik = new Musik(Konstanten.DIRECTION + huhu);
				} else if (oben instanceof Bossgegner) {
					if (spiel.getBossgegner().get(0).getGesundheit() > Konstanten.BOSS33H) {
						spiel.getBossgegner().get(0).setGesundheitMinus(Konstanten.BOSS33H);
					} else if (spiel.getBossgegner().get(0).getGesundheit() == Konstanten.BOSS33H) {
						this.setzeObjekt(new Rasen(), obenPos);
					}
					musik = new Musik(Konstanten.DIRECTION + huhu);
				} else if (unten instanceof Bossgegner) {
					if (spiel.getBossgegner().get(0).getGesundheit() > Konstanten.BOSS33H) {
						spiel.getBossgegner().get(0).setGesundheitMinus(Konstanten.BOSS33H);
					} else if (spiel.getBossgegner().get(0).getGesundheit() == Konstanten.BOSS33H) {
						this.setzeObjekt(new Rasen(), untenPos);
					}
					musik = new Musik(Konstanten.DIRECTION + huhu);
				}
			} else if (rechts instanceof Spieler || links instanceof Spieler
					|| unten instanceof Spieler || oben instanceof Spieler) {
				if (spielfigur == spiel.spieler.get(0)) {
					spiel.spieler.get(1).setGesundheitMinus(50);
					spiel.spieler.get(1).setzeBildLuke();
					spiel.spieler.get(1).getPicture();
				} else if (spielfigur == spiel.spieler.get(1)) {
					spiel.spieler.get(0).setGesundheitMinus(50);
					spiel.spieler.get(0).setzeBildErna();
					spiel.spieler.get(0).getPicture();
				}
			}
		} else {
			JOptionPane.showMessageDialog(null, "Sie tragen kein Schwert!",
					attention, JOptionPane.WARNING_MESSAGE);
		}
		
		spiel.getBossgegner().get(0).setzeBild(spiel.getAktuellesSpielfeldNumber());
			spiel.getBossgegner().get(0).getPicture();
		if (spielfigur.getErna()) {
			spielfigur.setzeBildErna();
		} else if (spielfigur.getLuke()) {
			spielfigur.setzeBildLuke();
		}
	spielfigur.getPicture();
	}

	/**
	 * @return weiter Position
	 */
	public Point getWeiter() {
		return weiter;
	}

	/**
	 * @param weiter
	 *            Kommandozeilenparameter
	 */
	public void setWeiter(Point weiter) {
		this.weiter = weiter;
	}

	/**
	 * @return zurueck
	 */
	public Point getZurueck() {
		return zurueck;
	}

	/**
	 * @param zurueck
	 *            Kommandozeilenparameter
	 */
	public void setZurueck(Point zurueck) {
		this.zurueck = zurueck;
	}

	/**
	 * speichert das Spiel, wenn man �ber einen Checkpoint l�uft
	 * 
	 */
	private void checkpoint(GameFrame gameFrame) {
		PrintWriter pWriter;
		try {
			pWriter = new PrintWriter(new FileWriter(Konstanten.DIRECTION
					+ "/src/game/Szenario/checkpoint.txt"));
			pWriter.println(gameFrame.getSave(spiel.getSpieler().get(0)));
			pWriter.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setCheckpoint(true);
	}

	/**
	 * @return the checkpoint
	 */
	public Boolean getCheckpoint() {
		return checkpoint;
	}

	/**
	 * @param checkpoint
	 *            the checkpoint to set
	 */
	public void setCheckpoint(Boolean checkpoint) {
		this.checkpoint = checkpoint;
	}
}
