package game;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.PrintWriter;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * erstellt die n�tige GUI f�r das Netzwerk
 * 
 * @author Denise
 * 
 */
public class NetzwerkFrame extends JFrame {

	/** Platzhalter f�r Spieldeld */
	private static final Icon SPIELFELD = new ImageIcon(Konstanten.DIRECTION
			+ "/src/game/Images/Spielfeld.jpg");

	/** Labelf�r Platzhalter */
	private JLabel feld = new JLabel(SPIELFELD);

	/** Textareas im Fenster */
	TextArea eingabe;
	TextArea ausgabe;
	/** Button im Fenster */
	JButton btSende;
	/** deklariert PrintWriter, BufferedReader und ActionListener */
	PrintWriter ausgehend;
	BufferedReader eintreffend;
	ActionListener sende;

	/**
	 * Konstruktor ruft die Initialisierungsmethode auf
	 * 
	 * @param titel
	 *            erwartet Titel f�r Fenster
	 * @param out
	 *            Kommandozeilenparamter
	 * @param in
	 *            Kommandozeilenparamter
	 */
	NetzwerkFrame(String titel, PrintWriter out, BufferedReader in, int x, int y) {
		ausgehend = out;
		eintreffend = in;
		init(titel, x, y);
	}

	/**
	 * initialisiert das Fenster
	 * 
	 * @param titel
	 *            fordert Titel f�r Fenster
	 */
	void init(String titel, int x, int y) {
		setLocation(x, y);
		setSize(Konstanten.BREITECHAT, Konstanten.HOEHECHAT);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		this.setTitle(titel);

		/* initialisert TextAreas */
		eingabe = new TextArea();
		ausgabe = new TextArea();

		/* initialisiert Button */
		btSende = new JButton();

		/* ActionListener wird erzeugt */
		sende = new Action(ausgehend, eintreffend, eingabe);
		btSende.setText("Abschicken");
		btSende.setActionCommand("Send");
		btSende.addActionListener(sende);

		this.setLayout(new BorderLayout());

		/* Container f�r alle Fragmente im unteren Teil des Fensters */
		Container unten = new Container();
		unten.setLayout(new BorderLayout());

		/*
		 * im unteren Bereich werden das Eingabefenster und der Sendebutton
		 * angesiedelt
		 */
		unten.add(ausgabe, BorderLayout.EAST);
		unten.add(eingabe, BorderLayout.WEST);
		unten.add(btSende, BorderLayout.SOUTH);

		/* unten und Ausgabefenster werden auf Frame gesetzt */
		this.add(unten, BorderLayout.SOUTH);
		this.add(feld, BorderLayout.CENTER);
	}

	/**
	 * verkettet die einzelnen Ausgaben miteinander und setzt den Text in die
	 * Ausgabe
	 * 
	 * @param neu
	 *            Kommandozeilenparameter
	 */
	public void addAusgabe(String neu) {
		String text = ausgabe.getText();
		text = text + neu;
		ausgabe.setText(text);
	}
}

/**
 * 
 * @author Denise
 * 
 */
class Action implements ActionListener {
	/**
	 * Deklaration von PrintWriter, BufferedReader und TextArea
	 */
	PrintWriter ausgehendPr;
	BufferedReader eintreffendBr;
	TextArea eingabeTa;

	/**
	 * 
	 * @param out
	 *            Kommandozeilenparamter
	 * @param in
	 *            Kommandozeilenparamter
	 * @param text
	 *            Kommandozeilenparamter
	 */
	Action(PrintWriter out, BufferedReader in, TextArea text) {
		ausgehendPr = out;
		eintreffendBr = in;
		eingabeTa = text;
	}

	/**
	 * 
	 */
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getActionCommand().equals("Send")) {
			String ausgabe = eingabeTa.getText() + "\n";
			ausgehendPr.print(ausgabe);
			ausgehendPr.flush();
			eingabeTa.setText(" ");
		}
	}
}