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
public class JauchNetzerk extends GameObject {

	/** Icon für Checkpoint wird deklariert */
	private static final String ICONJAUCH = Konstanten.DIRECTION
			+ "/src/game/Images/Jauch.png";

	/** bild vom Typ String wird deklariert */
	private String bild;

	/** Deklaration von Feldern */
	private Musik musik;

	/** Deklaration von Boolean, ob Jauch gehen muss */
	private Boolean weg;

	/** Konstruktor initialisiert icon */
	public JauchNetzerk() {
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
	 * @return weg
	 */
	public boolean raetsel(Spieler spielfigur) {

		musik = new Musik(Konstanten.DIRECTION + "/src/game/Sound/WWM.wav");

		Object[] options = { "Weiß ich nicht", "Luke", "Bert", "Jim", };

		int selected = JOptionPane.showOptionDialog(null,
				"Wie heißt dein Gegenspieler", "Co-Op-Frage",
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
				options, options[0]);

		if (selected == Konstanten.SELECTEDNULL) {
			JOptionPane
					.showMessageDialog(
							null,
							"Oh, das ist aber schade! Pass das nächste Mal in der Hundeschule besser auf !",
							"Ach Gottchen", JOptionPane.PLAIN_MESSAGE);
			weg = false;
		}
		if (selected == Konstanten.SELECTEDEINS) {
			JOptionPane.showMessageDialog(null,
					"Gut gemacht, Erna! Du spielst gegen Luke! ", "Richtig",
					JOptionPane.PLAIN_MESSAGE);
			JOptionPane
					.showMessageDialog(
							null,
							"Na gut, ich bin dann mal wieder in meinem Baumhaus. Viel Spaß im Netzwerkmodus!",
							"Tschüßchen", JOptionPane.PLAIN_MESSAGE);
			weg = true;
		} else if (selected == Konstanten.SELECTEDZWEI) {
			JOptionPane
					.showMessageDialog(null, "So ein Quatsch!",
							"Das ist leider nicht richtig !",
							JOptionPane.PLAIN_MESSAGE);
			weg = false;
		} else if (selected == Konstanten.SELECTEDDREI) {
			JOptionPane.showMessageDialog(null, "Nein nein nein ! ",
					"Leider falsch", JOptionPane.PLAIN_MESSAGE);
			weg = false;
		}
		return weg;
	}
}
