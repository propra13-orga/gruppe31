package game;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.PrintWriter;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * erstellt die nötige GUI für das Netzwerk
 * 
 * @author Denise
 * 
 */
public class NetzwerkFrame extends JFrame {

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
	 *            erwartet Titel für Fenster
	 * @param out
	 *            Kommandozeilenparamter
	 * @param in
	 *            Kommandozeilenparamter
	 */
	NetzwerkFrame(String titel, PrintWriter out, BufferedReader in) {
		ausgehend = out;
		eintreffend = in;
		init(titel);
	}

	/**
	 * initialisiert das Fenster
	 * 
	 * @param titel
	 *            fordert Titel für Fenster
	 */
	void init(String titel) {
		setLocation(Konstanten.XCHAT, Konstanten.YCHAT);
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

		/* Container für alle Fragmente im unteren Teil des Fensters */
		Container unten = new Container();
		unten.setLayout(new BorderLayout());

		/*
		 * im unteren Bereich werden das Eingabefenster und der Sendebutton
		 * angesiedelt
		 */
		unten.add(eingabe, BorderLayout.CENTER);
		unten.add(btSende, BorderLayout.EAST);

		/* unten und Ausgabefenster werden auf Frame gesetzt */
		this.add(unten, BorderLayout.SOUTH);
		this.add(ausgabe, BorderLayout.CENTER);
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