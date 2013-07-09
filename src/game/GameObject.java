package game;

import javax.swing.Icon;

/**
 * abstrakte Klasse GameObject, alle untergeordneten Klassen benötigen ein Icon,
 * daher hier der getter
 * 
 */
public abstract class GameObject {

	/**
	 * wird auf alle Unterklassen vererbt, gibt das jeweilige Bild wieder
	 * 
	 * @return
	 */
	public abstract String getPicture();
}
