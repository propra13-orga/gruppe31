package game;

/**
 * abstrakte Klasse GameObject, alle untergeordneten Klassen benötigen ein Icon,
 * daher hier der getter
 * 
 */
public abstract class GameObject {

	/**
	 * wird auf alle Unterklassen vererbt, gibt das jeweilige Bild wieder
	 * 
	 * @return bild
	 */
	public abstract String getPicture();
}
