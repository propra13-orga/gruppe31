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

	/** Icon für Checkpoint wird deklariert */
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
	 * ruft den Dialog des ersten Rätsels auf
	 * 
	 * @param spielfigur
	 *            Kommandozeilenparameter
	 */
	public void raetsel(Spieler spielfigur, int jauchBesucht) {

		musik = new Musik(Konstanten.DIRECTION + "/src/game/Sound/WWM.wav");

		if (jauchBesucht == 1) {
			Object[] options = { "Weiß ich nicht", "Fliegenpilze",
					"Steinpilze", "Pfifferling", };

			int selected = JOptionPane.showOptionDialog(null,
					"Vor welchen von diesen Pilzen hast du am meisten Angst?",
					"50 Taler Frage", JOptionPane.DEFAULT_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

			if (selected == Konstanten.SELECTEDNULL) {
				JOptionPane
						.showMessageDialog(
								null,
								"Oh, das ist aber schade! Pass das nächste Mal in der Hundeschule besser auf !",
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
					"Tschüßchen", JOptionPane.PLAIN_MESSAGE);

		} else if (jauchBesucht == 2) {
			Object[] options = { "Weiß ich nicht", "lila", "schwarz", "grün", };

			int selected = JOptionPane.showOptionDialog(null,
					"Welche Farbe hat Carlos", "100 Taler Frage",
					JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
					null, options, options[0]);

			if (selected == Konstanten.SELECTEDNULL) {
				JOptionPane
						.showMessageDialog(
								null,
								"Oh, das ist aber schade! Pass das nächste Mal in der Hundeschule besser auf !",
								"Ach Gottchen", JOptionPane.PLAIN_MESSAGE);
			}
			if (selected == Konstanten.SELECTEDEINS) {
				JOptionPane
						.showMessageDialog(
								null,
								"Nichts da, nicht alle Tiere sind hier so bunt wie du!",
								"Das ist leider nicht richtig !",
								JOptionPane.PLAIN_MESSAGE);
			} else if (selected == Konstanten.SELECTEDZWEI) {
				JOptionPane.showMessageDialog(null,
						"Gut gemacht, Erna! Carlos ist natürlich schwarz!"
								+ "Zur Belohnung bekommst du 100 Taler.",
						"Richtig", JOptionPane.PLAIN_MESSAGE);
				spielfigur.setGoldPlus(Konstanten.GOLD100);

			} else if (selected == Konstanten.SELECTEDDREI) {
				JOptionPane
						.showMessageDialog(
								null,
								"Da werde ich aber nicht grün vor Neid, meine Liebe...",
								"Leider falsch", JOptionPane.PLAIN_MESSAGE);
			}
			JOptionPane.showMessageDialog(null,
					"Na gut, ich bin dann mal wieder in meinem Baumhaus.",
					"Tschüßchen", JOptionPane.PLAIN_MESSAGE);

		} else if (jauchBesucht == 3) {
			Object[] options = { "Weiß ich nicht", "Cupcake", "Muffin",
					"Törtchen", };

			int selected = JOptionPane.showOptionDialog(null,
					"Was wartet am Ende deiner langen Reise auf dich ?",
					"150 Taler Frage", JOptionPane.DEFAULT_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

			if (selected == Konstanten.SELECTEDNULL) {
				JOptionPane
						.showMessageDialog(
								null,
								"Oh, das ist aber schade! Pass das nächste Mal in der Hundeschule besser auf !",
								"Ach Gottchen", JOptionPane.PLAIN_MESSAGE);
			}
			if (selected == Konstanten.SELECTEDEINS) {
				JOptionPane.showMessageDialog(null,
						"Das ist richtig ! Ich hoffe du freust dich schon auf den tollen Cupcake ! "
								+ "Zur Belohnung bekommst du 150 Taler",
						"Mjam !", JOptionPane.PLAIN_MESSAGE);
				spielfigur.setGoldPlus(Konstanten.GOLD150);
			} else if (selected == Konstanten.SELECTEDZWEI) {
				JOptionPane.showMessageDialog(null,
						"Muffins sind nur hässliche Cupcakes !",
						"Neneneneee...", JOptionPane.PLAIN_MESSAGE);

			} else if (selected == Konstanten.SELECTEDDREI) {
				JOptionPane
						.showMessageDialog(
								null,
								"Sowas majestätisches nennst du Törtchen? Also wirklich...",
								"Leider falsch", JOptionPane.PLAIN_MESSAGE);
			}
			JOptionPane.showMessageDialog(null,
					"Na gut, ich bin dann mal wieder in meinem Baumhaus.",
					"Tschüßchen", JOptionPane.PLAIN_MESSAGE);

		}
	}
}
