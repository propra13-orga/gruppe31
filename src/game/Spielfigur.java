package game;

/**
 * abstrakte Klasse, die untergeordneten Klassen haben gemein, dass ihre Objekte
 * bewaffne, schaden und gesundheit haben
 * 
 */
public abstract class Spielfigur extends GameObject {

	private int schaden; // wieviel Schaden kann ausgeteilt werden
	private int bewaffnet; // 1 oder 0
	private int gesundheit; // wie hoch ist der Lebensbalken

	/**
	 * Getter
	 * 
	 * @return
	 */
	public int getBewaffnet() {
		return bewaffnet;
	}

	/**
	 * Setter
	 * 
	 * @param bewaffnet
	 */
	public void setBewaffnet(int bewaffnet) {
		this.bewaffnet = bewaffnet;
	}

	/**
	 * Getter
	 * 
	 * @return
	 */
	public int getGesundheit() {
		return gesundheit;
	}

	/**
	 * Setter
	 * 
	 * @param gesundheit
	 */
	public void setGesundheit(int gesundheit) {
		this.gesundheit = gesundheit;
	}

	/**
	 * Methode prüft, ob an abgefragter Stelle nichts (also Rasen) ist, wenn ja
	 * kann sich Figur bewegen, wenn nicht Weiterleitung
	 * 
	 * @param ziel
	 * @return
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
	 * @return
	 */
	protected abstract boolean internalTryMove(GameObject ziel);

}
