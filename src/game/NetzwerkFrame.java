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
	 * Konstruktor
	 * 
	 * @param Titel
	 *            erwartet Titel für Fenster
	 * @param out
	 *            Kommandozeilenparamter
	 * @param in
	 *            Kommandozeilenparamter
	 */
	NetzwerkFrame(String Titel, PrintWriter out, BufferedReader in) {
		ausgehend = out;
		eintreffend = in;
		init(Titel);
	}

	/**
	 * initialisiert das Fenster
	 * 
	 * @param titel
	 *            Kommandozeilenparamter
	 */
	void init(String titel) {
		setLocation(200, 100);
		setSize(Konstanten.BREITE, Konstanten.HOEHE - 100);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		this.setTitle(titel);

		/* initialisert TextAreass */
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
		unten.add(eingabe, BorderLayout.CENTER);
		unten.add(btSende, BorderLayout.EAST);

		this.add(unten, BorderLayout.SOUTH);
		this.add(ausgabe, BorderLayout.CENTER);
	}

	/**
	 * verkettet die einzelnen Ausgaben miteinander
	 * 
	 * @param add
	 *            Kommandozeilenparameter
	 */
	public void addAusgabe(String add) {
		String temp = ausgabe.getText();
		temp += add;
		ausgabe.setText(temp);
	}
}

/**
 * 
 * @author Denise
 * 
 */
class Action implements ActionListener {
	PrintWriter _out;
	BufferedReader _in;
	TextArea _Eingabe;

	/**
	 * 
	 * @param out
	 *            Kommandozeilenparamter
	 * @param in
	 *            Kommandozeilenparamter
	 * @param Text
	 *            Kommandozeilenparamter
	 */
	Action(PrintWriter out, BufferedReader in, TextArea Text) {
		_out = out;
		_in = in;
		_Eingabe = Text;
	}

	/**
	 * 
	 */
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getActionCommand().equals("Send")) {
			String Ausgabe = _Eingabe.getText() + "\n";
			_out.print(Ausgabe);
			_out.flush();
		}
	}
}