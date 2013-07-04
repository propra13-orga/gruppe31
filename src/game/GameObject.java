package game;

import javax.swing.Icon;

/**
 * abstrakte Klasse GameObject, alle untergeordneten Klassen benötigen ein Icon,
 * daher hier der getter
 * 
 */
public abstract class GameObject {

	/**
	 * abstrakte Methode, Getter des Icons
	 * 
	 * @return Icon gibt das Icon des GameObjektes zurück
	 */
	public abstract Icon getIcon();
}
