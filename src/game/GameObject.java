package game;

import javax.swing.Icon;

/**
 * abstrakte Klasse GameObject, alle untergeordneten Klassen ben�tigen ein Icon,
 * daher hier der getter
 * 
 */
public abstract class GameObject {

	/**
	 * abstrakte Methode, Getter des Icons
	 * 
	 * @return Icon gibt das Icon des GameObjektes zur�ck
	 */
	public abstract Icon getIcon();
}
