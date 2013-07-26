package game.icons;

import java.io.Serializable;

import game.GameObject;
import game.Spiel;
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
public class Jauch extends GameObject implements Serializable {

	/** Icon f�r Checkpoint wird deklariert */
	private static final String ICONJAUCH = Konstanten.DIRECTION
			+ "/src/game/Images/Jauch.png";

	/** bild vom Typ String wird deklariert */
	private String bild;

	/** Deklaration von Strings, die �fter vorkommen */
	private String ka = "Wei� ich nicht";
	private String yes = "Richtig!";
	private String nope = "Das ist leider nicht richtig !";
	private String falsch = "Leider falsch..";

	/** Deklaration von Feldern */
	private Musik musik;

	/**
	 * Konstruktor initialisiert icon
	 */
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
	public void raetsel(Spieler spielfigur, Spiel spiel) {
		
		musik = new Musik(Konstanten.DIRECTION + "/src/game/Sound/WWM.wav");

		if (spiel.getJauchBesucht() == Konstanten.BESUCH1) {
			Object[] options = { ka, "Fliegenpilze", "Steinpilze",
					"Pfifferling", };

			int selected = JOptionPane.showOptionDialog(null,
					"Vor welchen von diesen Pilzen hast du am meisten Angst?",
					"50 Taler Frage", JOptionPane.DEFAULT_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

			if (selected == Konstanten.SELECTEDNULL) {
				selectKa();
			}
			if (selected == Konstanten.SELECTEDEINS) {
				JOptionPane
						.showMessageDialog(
								null,
								"Gut gemacht, Erna! Die Fliegenpilze sind giftig und rauben dir wertvolle Energie! "
										+ "Zur Belohnung bekommst du 50 Taler.",
								yes, JOptionPane.PLAIN_MESSAGE);
				spielfigur.setGoldPlus(Konstanten.GOLD50);
			} else if (selected == Konstanten.SELECTEDZWEI) {
				JOptionPane
						.showMessageDialog(
								null,
								"So ein Quatsch! Steinpilze sind super lecker, die tun doch keinem Pudel was !",
								nope,
								JOptionPane.PLAIN_MESSAGE);
			} else if (selected == Konstanten.SELECTEDDREI) {
				JOptionPane
						.showMessageDialog(
								null,
								"Hat deine Mama denn nie mit dir Pilze gesammelt? Pfifferlinge schmecken toll zu Trockenfutter! ",
								falsch, JOptionPane.PLAIN_MESSAGE);
			}
		} else if (spiel.getJauchBesucht() == Konstanten.BESUCH2) {
			Object[] options = { ka, "lila", "schwarz", "gr�n", };

			int selected = JOptionPane.showOptionDialog(null,
					"Welche Farbe hat Carlos", "100 Taler Frage",
					JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
					null, options, options[0]);

			if (selected == Konstanten.SELECTEDNULL) {
				selectKa();
			}
			if (selected == Konstanten.SELECTEDEINS) {
				JOptionPane
						.showMessageDialog(
								null,
								"Nichts da, nicht alle Tiere sind hier so bunt wie du!",
								nope,
								JOptionPane.PLAIN_MESSAGE);
			} else if (selected == Konstanten.SELECTEDZWEI) {
				JOptionPane.showMessageDialog(null,
						"Gut gemacht, Erna! Carlos ist nat�rlich schwarz!"
								+ "Zur Belohnung bekommst du 100 Taler.", yes,
						JOptionPane.PLAIN_MESSAGE);
				spielfigur.setGoldPlus(Konstanten.GOLD100);

			} else if (selected == Konstanten.SELECTEDDREI) {
				JOptionPane
						.showMessageDialog(
								null,
								"Da werde ich aber nicht gr�n vor Neid, meine Liebe...",
								falsch, JOptionPane.PLAIN_MESSAGE);
			}

		} else if (spiel.getJauchBesucht() == Konstanten.BESUCH3) {
			Object[] options = { ka, "Cupcake", "Muffin", "T�rtchen", };

			int selected = JOptionPane.showOptionDialog(null,
					"Was wartet am Ende deiner langen Reise auf dich ?",
					"150 Taler Frage", JOptionPane.DEFAULT_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

			if (selected == Konstanten.SELECTEDNULL) {
				selectKa();
			}
			if (selected == Konstanten.SELECTEDEINS) {
				JOptionPane.showMessageDialog(null,
						"Das ist richtig ! Ich hoffe du freust dich schon auf den tollen Cupcake ! "
								+ "Zur Belohnung bekommst du 150 Taler",
						"Mjam !", JOptionPane.PLAIN_MESSAGE);
				spielfigur.setGoldPlus(Konstanten.GOLD150);
			} else if (selected == Konstanten.SELECTEDZWEI) {
				JOptionPane.showMessageDialog(null,
						"Muffins sind nur h�ssliche Cupcakes !",
						"Neneneneee...", JOptionPane.PLAIN_MESSAGE);

			} else if (selected == Konstanten.SELECTEDDREI) {
				JOptionPane
						.showMessageDialog(
								null,
								"Sowas majest�tisches nennst du T�rtchen? Also wirklich...",
								"Leider falsch", JOptionPane.PLAIN_MESSAGE);
			}

		}
		spiel.setJauchBesucht(1);
		JOptionPane.showMessageDialog(null,
				"Na gut, ich bin dann mal wieder in meinem Baumhaus.",
				"Tsch��chen", JOptionPane.PLAIN_MESSAGE);
	}

	/**
	 * zeigt MessageDialog
	 */
	private void selectKa() {
		JOptionPane
				.showMessageDialog(
						null,
						"Oh, das ist aber schade! Pass das n�chste Mal in der Hundeschule besser auf !",
						"Ach Gottchen", JOptionPane.PLAIN_MESSAGE);
	}
}
