package game.icons;

import game.GameObject;
import game.Konstanten;
import game.Musik;
import game.figuren.Spieler;

import javax.swing.JOptionPane;

/**
 * ein Objekt dieser Klasse ist der Quizmaster auf dem Spielfeld
 * 
 * @author Denise
 * 
 */
public class Jauch extends GameObject {

	/** Icon f�r Checkpoint wird deklariert */
	private static final String ICONJAUCH = Konstanten.DIRECTION
			+ "/src/game/Images/Jauch.png";

	/** bild vom Typ String wird deklariert */
	private String bild;
	
	/** Deklaration von Feldern */
	private Musik musik;

	/** Konstruktor initialisiert icon */
	public Jauch() {
		bild = ICONJAUCH;
	}

	@Override
	public String getPicture() {
		return bild;
	}

	/**
	 * ruft den Dialog des ersten R�tsels auf
	 * 
	 * @param spielfigur
	 *            Kommandozeilenparameter
	 */
	public void raetsel1(Spieler spielfigur) {
		
		musik = new Musik(Konstanten.DIRECTION + "/src/game/Sound/WWM.wav");
		
		Object[] options = { "Wei� ich nicht", "Fliegenpilze", "Steinpilze",
				"Pfifferling", };

		int selected = JOptionPane.showOptionDialog(null,
				"Vor welchen von diesen Pilzen hast du am meisten Angst?",
				"50 Taler Frage", JOptionPane.DEFAULT_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

		if (selected == Konstanten.SELECTEDNULL) {
			JOptionPane
					.showMessageDialog(
							null,
							"Oh, das ist aber schade! Pass das n�chste Mal in der Hundeschule besser auf !",
							"Ach Gottchen", JOptionPane.PLAIN_MESSAGE);
		}
		if (selected == Konstanten.SELECTEDEINS) {
			JOptionPane
					.showMessageDialog(
							null,
							"Gut gemacht, Erna! Die Fliegenpilze sind giftig und rauben dir wertvolle Energie! "
									+ "Zur Belohnung bekommst du 50 Taler.",
							"Richtig", JOptionPane.PLAIN_MESSAGE);
			spielfigur.setGoldPlus(Konstanten.GOLD50);
		} else if (selected == Konstanten.SELECTEDZWEI) {
			JOptionPane
					.showMessageDialog(
							null,
							"So ein Quatsch! Steinpilze sind super lecker, die tun doch keinem Pudel was !",
							"Das ist leider nicht richtig !",
							JOptionPane.PLAIN_MESSAGE);
		} else if (selected == Konstanten.SELECTEDDREI) {
			JOptionPane
					.showMessageDialog(
							null,
							"Hat deine Mama denn nie mit dir Pilze gesammelt? Pfifferlinge schmecken toll zu Trockenfutter! ",
							"Leider falsch", JOptionPane.PLAIN_MESSAGE);
		}
		JOptionPane.showMessageDialog(null,
				"Na gut, ich bin dann mal wieder in meinem Baumhaus.",
				"Tsch��chen", JOptionPane.PLAIN_MESSAGE);

	}
}
