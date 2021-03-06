package game.figuren;

import game.GameObject;


import java.awt.event.KeyEvent;
import java.io.Serializable;

/**
 * abstrakte Klasse, die untergeordneten Klassen haben gemein, dass ihre Objekte
 * bewaffne, schaden und gesundheit haben
 * 
 */
public abstract class Spielfigur extends GameObject implements Serializable {

	/** int-Variablen f�r Spielfigur */
	private int schaden;
	private boolean bewaffnet;
	private int gesundheit;

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
