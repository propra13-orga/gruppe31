package game.figuren;

import game.GameObject;


import java.awt.event.KeyEvent;

/**
 * abstrakte Klasse, die untergeordneten Klassen haben gemein, dass ihre Objekte
 * bewaffne, schaden und gesundheit haben
 * 
 */
public abstract class Spielfigur extends GameObject {

	/** int-Variablen für Spielfigur */
	private int schaden;
	private boolean bewaffnet;
	private int gesundheit;
	
	/** Deklaration der Felder*/
	private Spieler spieler;
	private Gegner gegner;

	/**
	 * Getter
	 * 
	 * @return bewaffnet gibt wieder, ob Spieler bewaffnet
	 */
	public boolean getBewaffnet() {
		return bewaffnet;
	}

	/**
	 * Setter
	 * 
	 * @param bewaffnet
	 *            Kommandozeilenparameter
	 */
	public void setBewaffnet(boolean bewaffnet) {
		this.bewaffnet = bewaffnet;
	}

	/**
	 * Getter
	 * 
	 * @return gesundheit gibt die Gesundheit des Spielers wieder
	 */
	public int getGesundheit() {
		return gesundheit;
	}
	
	/**
	 * Setter
	 * 
	 * @param gesundheit
	 *            Kommandozeilenparameter
	 */
	public void setGesundheit(int gesundheit) {
		this.gesundheit = gesundheit;
	}

	/**
	 * Setter
	 * 
	 * @param gesundheit
	 *            Kommandozeilenparameter
	 */
	public void setGesundheitPlus(int gesundheit) {
		this.gesundheit = getGesundheit() + gesundheit;
	}
	
	/** Getter
	 * 
	 * @param gesundheit
	 * Kommandozeilenparameter
	 */
	public void setGesundheitMinus(int gesundheit) {
		this.gesundheit = getGesundheit() - gesundheit;		
	}
	
	
}
