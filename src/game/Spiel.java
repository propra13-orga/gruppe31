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
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 * diese Klasse repräsentiert das komplette Spiel, welches aus verschiedenen
 * Spielfelder besteht. Das Spiel wird aus einer Textdatei eingelesen
 */
public class Spiel implements Serializable {

	/** Liste von Spielfeldern wird deklariert */
	private ArrayList<Spielfeld> levels;

	/** Zeiger auf das aktuelle Spielfeld */
	private int aktSpielfeld;

	/** Deklarierung der Felder */
	private Bossgegner bossgegner;
	private Barriere barriere;
	private Spiel spiel;

	/** Deklaration von ArrayListen */
	private ArrayList<Gegner> pilze;
	private ArrayList<Gegner> bienen;
	protected ArrayList<Spieler> spieler;

	private String invalid = "Ungültig";

	private int jauchBesucht;

	/**
	 * Konstruktor erzeugt ArrayList, welche Spielfelder beinhaltet
	 */
	public Spiel() {
		levels = new ArrayList<Spielfeld>();
		spieler = new ArrayList<Spieler>();
		this.pilze = new ArrayList<Gegner>();
		this.bienen = new ArrayList<Gegner>();
		this.aktSpielfeld = -1;
		this.jauchBesucht = 1;
	}

	/**
	 * die Methode liest die einzelnen Räume ein und schreibt sie in die
	 * ArrayList array. Zusätzlich werden die Positionen der Spielfigur und der
	 * Gegner festgehalten
	 * 
	 * in Textdatei rechts=y-Achse (12 Zeichen) runter=x-Achse (16 Zeichen)
	 * 
	 * @param datei
	 *            Kommandozeilenparameter
	 * @throws Exception
	 *             Beschreibung der Exception, die von dieser Methode geworfen
	 *             werden kann
	 */
	public void init(String datei) {

		try {

			/* öffnet FileReader mit Textdatei */
			FileReader fr = new FileReader(Konstanten.DIRECTION
					+ "/src/game/Szenario/" + datei);
			/* öffnet BufferedReader und liest .txt hinein */
			BufferedReader br = new BufferedReader(fr);

			/* speichert die Eigenschaften, bis Spieler gelesen wurde */
			int saveGesundheit = Integer.parseInt(br.readLine());
			if (saveGesundheit > Konstanten.VOLLH) {
				JOptionPane.showMessageDialog(null,
						"In der Datei gibt es eine ungültige Healthanzahl",
						invalid, JOptionPane.ERROR_MESSAGE);
				System.exit(0);
			}
			int saveMana = Integer.parseInt(br.readLine());
			if (saveMana > Konstanten.VOLLM) {
				JOptionPane.showMessageDialog(null,
						"In der Datei gibt es eine ungültige Manaanzahl",
						invalid, JOptionPane.ERROR_MESSAGE);
				System.exit(0);
			}
			int saveRuestung = Integer.parseInt(br.readLine());
			if (saveRuestung > Konstanten.VOLLR) {
				JOptionPane.showMessageDialog(null,
						"In der Datei gibt es eine ungültige Ruestungsanzahl",
						invalid, JOptionPane.ERROR_MESSAGE);
				System.exit(0);
			}
			int saveLeben = Integer.parseInt(br.readLine());
			if (saveLeben > Konstanten.DREILEBEN) {
				JOptionPane.showMessageDialog(null,
						"In der Datei gibt es eine ungültige Lebenanzahl",
						invalid, JOptionPane.ERROR_MESSAGE);
				System.exit(0);
			}
			boolean saveBewaffnet = Boolean.parseBoolean(br.readLine());
			boolean saveBeschwertet = Boolean.parseBoolean(br.readLine());
			boolean saveHalsband = Boolean.parseBoolean(br.readLine());

			/* in line wird eine Zeile gespeichert */
			String line = br.readLine();
			do {
				/* ein neues Spielfeld wird initialisiert */
				Spielfeld spielfeld = new Spielfeld(this, Konstanten.ZEILEN,
						Konstanten.SPALTEN);

				/* die Zeilen werden gelesen, bis man bei der 16. angekommen ist */
				for (int i = 0; i < Konstanten.SPALTEN; i++, line = br
						.readLine()) {

					/* wenn mehr als 12 Zeichen gelesen werden, Fehlermeldung */
					if (line.length() != Konstanten.ZEILEN) {
						JOptionPane
								.showMessageDialog(
										null,
										"Die Anzahl der Zeichen in dieser Textdatei ist ungültig!",
										invalid, JOptionPane.ERROR_MESSAGE);
						System.exit(0);
					} else {
						/*
						 * die Zeichen einer Zeile werden gelesen und in das
						 * Array geparst
						 */
						for (int j = 0; j < Konstanten.ZEILEN; j++) {
							int pruefe;
							GameObject gameObject = null;
							pruefe = (int) line.charAt(j);

							if (pruefe == Konstanten.RASEN) {
								gameObject = new Rasen();
							} else if (pruefe == Konstanten.GRENZE) {
								gameObject = new Grenze();
							} else if (pruefe == Konstanten.PUDEL) {
								Spieler aktSpieler = new Spieler("Erna");
								aktSpieler.setPosition(new Point(i, j));
								gameObject = aktSpieler;
								/* setzt die Eigenschaften des Spielers */
								aktSpieler.setGesundheit(saveGesundheit);
								aktSpieler.setManaPlus(saveMana);
								aktSpieler.setRuestung(saveRuestung);
								aktSpieler.setLebenPlus(saveLeben);
								aktSpieler.setBewaffnet(saveBewaffnet);
								aktSpieler.setBeschwertet(saveBeschwertet);
								aktSpieler.setHalsband(saveHalsband);
								this.spieler.add(aktSpieler);
							} else if (pruefe == Konstanten.PUDEL2) {
								Spieler aktSpieler = new Spieler("Luke");
								aktSpieler.setPosition(new Point(i, j));
								gameObject = aktSpieler;
								/* setzt die Eigenschaften des Spielers */
								aktSpieler.setGesundheit(saveGesundheit);
								aktSpieler.setManaPlus(saveMana);
								aktSpieler.setRuestung(saveRuestung);
								aktSpieler.setLebenPlus(saveLeben);
								aktSpieler.setBewaffnet(saveBewaffnet);
								aktSpieler.setBeschwertet(saveBeschwertet);
								aktSpieler.setHalsband(saveHalsband);
								this.spieler.add(aktSpieler);
							} else if (pruefe == Konstanten.GEGNER) {
								Gegner aktGegner = new Gegner("Pilz");
								aktGegner.setPosition(new Point(i, j));
								this.pilze.add(aktGegner);
								gameObject = aktGegner;
							} else if (pruefe == Konstanten.GEGNER2) {
								Gegner aktGegner = new Gegner("Biene");
								aktGegner.setPosition(new Point(i, j));
								bienen.add(aktGegner);
								gameObject = aktGegner;
							} else if (pruefe == Konstanten.FALLE) {
								gameObject = new Falle();
							} else if (pruefe == Konstanten.WEITER) {
								gameObject = new Weiter();
								spielfeld.setWeiter(new Point(i, j));
							} else if (pruefe == Konstanten.ZURUECK) {
								gameObject = new Zurueck();
								spielfeld.setZurueck(new Point(i, j));
							} else if (pruefe == Konstanten.BOSS1V) {
								this.bossgegner = new Bossgegner(
										getAktuellesSpielfeldNumber());
								gameObject = this.bossgegner;
							} else if (pruefe == Konstanten.BOSS2V) {
								gameObject = new Bossgegner(
										getAktuellesSpielfeldNumber());
							} else if (pruefe == Konstanten.BOSS3V) {
								gameObject = new Bossgegner(
										getAktuellesSpielfeldNumber());
							} else if (pruefe == Konstanten.CARLOS) {
								gameObject = new Carlos();
							} else if (pruefe == Konstanten.CUPCAKE) {
								gameObject = new Ziel();
							} else if (pruefe == Konstanten.HUETTE) {
								gameObject = new Huette();
							} else if (pruefe == Konstanten.WAFFE) {
								gameObject = new Brille();
							} else if (pruefe == Konstanten.GOLD) {
								gameObject = new Gold();
							} else if (pruefe == Konstanten.MANA) {
								gameObject = new Mana();
							} else if (pruefe == Konstanten.LASER) {
								gameObject = new Laser();
							} else if (pruefe == Konstanten.HEALTH) {
								gameObject = new Health();
							} else if (pruefe == Konstanten.RUESTUNG) {
								gameObject = new Ruestung();
							} else if (pruefe == Konstanten.CHECKPOINT) {
								gameObject = new Checkpoint();
							} else if (pruefe == Konstanten.SCHWERT) {
								gameObject = new Schwert();
							} else if (pruefe == Konstanten.SHOPMANA) {
								gameObject = new Shopmana();
							} else if (pruefe == Konstanten.SHOPHEALTH) {
								gameObject = new Shophealth();
							} else if (pruefe == Konstanten.SHOPRUESTUNG) {
								gameObject = new Shopruestung();
							} else if (pruefe == Konstanten.LUKE) {
								gameObject = new Luke();
							} else if (pruefe == Konstanten.SCHALTERZU) {
								gameObject = new SchalterZu();
							} else if (pruefe == Konstanten.SCHALTERAUF) {
								gameObject = new SchalterAuf();
							} else if (pruefe == Konstanten.GUENTHERJAUCH) {
								gameObject = new Jauch();
							} else if (pruefe == Konstanten.JAUCHNETZWERK) {
								gameObject = new JauchNetzerk();
							} else if (pruefe == Konstanten.BARRIERE) {
								this.barriere = new Barriere();
								barriere.setPosition(new Point(i, j));
								gameObject = new Barriere();
							}

							spielfeld.setzeObjekt(gameObject, new Point(i, j));

						}
					}
				}

				/*
				 * Alle Zeilen eines Spielfelds gelesen, aktuelles Spielfeld
				 * speichern und neues Spielfeld erzeugen.
				 */
				this.levels.add(spielfeld);
				spielfeld = new Spielfeld(this, Konstanten.ZEILEN,
						Konstanten.SPALTEN);

				/* .. und die Leerzeile ueberspringen .. */
				line = br.readLine();

				/*
				 * und der komplette obere Block wird ausgeführt, bis der
				 * BufferedReader das Ende der Datei gefunden hat
				 */
			} while (line != null);
			fr.close();

			/*
			 * setzt das aktuelleSpielfeld wieder an den Anfang, damit der erste
			 * Raum angezeigt wird
			 */
			aktSpielfeld = 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Getter für aktuellesSpielfeld
	 * 
	 * @return array gibt das array dieser Klasse zurück
	 */
	public Spielfeld getAktuellesSpielfeld() {
		return this.levels.get(aktSpielfeld);
	}

	/**
	 * Geht ein Spielfeld weiter.
	 * 
	 * @param spielfigur
	 *            Die Spielfigur, die weiter bewegt werden soll.
	 */
	public void levelWeiter(Spieler spielfigur) {

		/* Naechstes Spielfeld */
		aktSpielfeld += 1;
		/* nächstes Spielfeld aus ArrayList levels */
		Spielfeld neuesSpielfeld = this.levels.get(aktSpielfeld);
		/* Position von Zurueckfeld auf neuem Spielfeld wird abgerufen */
		Point zurueck = neuesSpielfeld.getZurueck();

		Point figurPosNeu;

		/*
		 * Je nach Position des Zurueck-Feldes muss die Spielfigur auf das
		 * entsprechend benachbarte Feld gesetzt werden.
		 */
		if (zurueck.x == 0) {

			/* Erste Zeile, beliebige Spalte */
			figurPosNeu = new Point(zurueck.x + 1, zurueck.y);
		} else if (zurueck.x == Konstanten.ZEILEN - 1) {

			/* Letzte Zeile, beliebige Spalte. */
			figurPosNeu = new Point(zurueck.x - 1, zurueck.y);
		} else if (zurueck.y == 0) {

			/* Beliebige Zeile, erste Spalte. */
			figurPosNeu = new Point(zurueck.x, zurueck.y + 1);
		} else if (zurueck.y == Konstanten.SPALTEN - 1) {

			/* Beliebige Zeile, letzte Spalte. */
			figurPosNeu = new Point(zurueck.x, zurueck.y - 1);
		} else {

			/* Sollte nicht eintreten. */
			figurPosNeu = new Point();
		}
		neuesSpielfeld.setzeObjekt(spielfigur, figurPosNeu);
		/* Position der Spielfgur wird gesetzt */
		spielfigur.setPosition(figurPosNeu);
	}

	/**
	 * geht ein Spielfeld zurück
	 * 
	 * @param spielfigur
	 *            Kommandozeilenparameter
	 */
	public void levelZurueck(Spieler spielfigur) {
		/* Letztes Spielfeld */
		aktSpielfeld -= 1;
		/* letztes Spielfeld aus ArrayList levels */
		Spielfeld neuesSpielfeld = this.levels.get(aktSpielfeld);
		/* Position von Zurueckfeld auf neuem Spielfeld wird abgerufen */
		Point weiter = neuesSpielfeld.getWeiter();

		Point figurPosNeu;

		figurPosNeu = new Point(weiter.x - 1, weiter.y);

		/* Spielfigur wird auf Spielfeld (sichtbar) gesetzt */
		neuesSpielfeld.setzeObjekt(spielfigur, figurPosNeu);
		/* Position der Spielfgur wird gesetzt */
		spielfigur.setPosition(figurPosNeu);
	}

	/**
	 * Getter für den Spieler
	 * 
	 * @return spieler
	 */
	public ArrayList<Spieler> getSpieler() {
		return this.spieler;
	}

	/**
	 * Bewegung wird auf dem aktuellen Spielfeld durchgeführt
	 * 
	 * @param keyCode
	 *            Kommandozeilenparameter
	 * @param gameFrame
	 *            Kommandozeilenparameter
	 * @throws Exception
	 *             wirft Exception
	 */
	public void aktion(int keyCode, GameFrame gameFrame) {

		/* Pruefe ob Spieler1-Tasten gedrueckt wurden. */
		if (keyCode == KeyEvent.VK_LEFT || keyCode == KeyEvent.VK_RIGHT
				|| keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_DOWN
				|| keyCode == KeyEvent.VK_SPACE
				|| keyCode == KeyEvent.VK_CONTROL
				|| keyCode == KeyEvent.VK_SHIFT || keyCode == KeyEvent.VK_X) {

			levels.get(aktSpielfeld).aktion(spieler.get(0), this.pilze,
					this.bienen, keyCode, barriere, gameFrame, this.bossgegner);

			/* Pruefe ob Spieler2-Tasten gedrueckt wurden. */
		} else if (keyCode == KeyEvent.VK_W || keyCode == KeyEvent.VK_A
				|| keyCode == KeyEvent.VK_S || keyCode == KeyEvent.VK_D
				|| keyCode == KeyEvent.VK_J || keyCode == KeyEvent.VK_K
				|| keyCode == KeyEvent.VK_N || keyCode == KeyEvent.VK_M) {
			levels.get(aktSpielfeld).aktion(spieler.get(1), this.pilze,
					this.bienen, keyCode, barriere, gameFrame, this.bossgegner);
		}
	}

	/**
	 * gibt die Zahl des aktuellen Spielfeldes wieder
	 * 
	 * @return aktSpielfeld
	 */
	public int getAktuellesSpielfeldNumber() {
		return aktSpielfeld;
	}

	/**
	 * @return the jauchBesucht
	 */
	public int getJauchBesucht() {
		return jauchBesucht;
	}

	/**
	 * @param jauchBesucht
	 *            the jauchBesucht to set
	 */
	public void setJauchBesucht(int neu) {
		this.jauchBesucht = jauchBesucht + neu;
	}
}
