package game;

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
	 * Methode prüft, ob an abgefragter Stelle nichts (also Rasen) ist, wenn ja
	 * kann sich Figur bewegen, wenn nicht Weiterleitung
	 * 
	 * @param ziel
	 *            Kommandozeilenparameter
	 * @return true
	 */
	public boolean tryMove(GameObject ziel) {
		if (ziel == null) {
			return true;
		} else
			return internalTryMove(ziel);
	}

	/**
	 * abstrakte Methode, um die anderen Möglichkeiten, was sich an der
	 * abgefragten Stelle befindet, abzufragen
	 * 
	 * @param ziel
	 *            Kommandozeilenparameter
	 * @return true
	 */
	protected abstract boolean internalTryMove(GameObject ziel);

}
