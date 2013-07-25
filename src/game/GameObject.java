package game;

import java.io.Serializable;

/**
 * abstrakte Klasse GameObject, alle untergeordneten Klassen benötigen ein Icon,
 * daher hier der getter
 * 
 */
public abstract class GameObject implements Serializable {

	/**
	 * wird auf alle Unterklassen vererbt, gibt das jeweilige Bild wieder
	 * 
	 * @return bild
	 */
	public abstract String getPicture();

	public void aktualisieren() {
		// TODO Auto-generated method stub
	}
}
