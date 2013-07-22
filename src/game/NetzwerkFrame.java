package game;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.PrintWriter;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 * erstellt die nötige GUI für das Netzwerk
 * 
 * @author Denise
 * 
 */
public class NetzwerkFrame extends JFrame implements KeyListener {

	/** deklariert PrintWriter, BufferedReader und ActionListener */
	private PrintWriter ausgehend;
	private BufferedReader eintreffend;
	private ActionListener sende;

	/** Textareas im Fenster */
	private TextArea eingabe;
	private TextArea ausgabe;

	/** Deklaration der Felder */
	private Musik musik;
	private Spiel spiel;
	private GameFrame gameFrame;

	/** Button im Fenster */
	private JButton btSende;
	private JButton btStart;

	/** Deklaration für Text für Button */
	private String stSende = "Send";

	/** Panel für Anzeigenleiste deklariert */
	private JPanel panelAnzeige = new JPanel();
	private JPanel panelSpielfeld = new JPanel();
	private JPanel panelButtons = new JPanel();

	/**
	 * 
	 * Konstruktor ruft die Initialisierungsmethode auf und spielt Musik ab
	 * 
	 * @param titel
	 *            erwartet Titel für Fenster
	 * @param out
	 *            Kommandozeilenparamter
	 * @param in
	 *            Kommandozeilenparamter
	 * @param x
	 *            Angabe für x-Position
	 * @param y
	 *            Angabe für y-Position
	 * @throws Exception
	 *             wirft Exception
	 */
	NetzwerkFrame(String titel, PrintWriter out, BufferedReader in, int x, int y)
			throws Exception {

		ausgehend = out;
		eintreffend = in;
		init(titel, x, y);

		musik = new Musik(Konstanten.DIRECTION + "/src/game/Sound/Wald.wav");
	}

	/**
	 * * initialisiert das Fenster
	 * 
	 * @param titel
	 *            fordert Titel für Fenster
	 * @param x
	 *            x-Position des Fensters
	 * @param y
	 *            y-Position des Fensters
	 * @throws Exception
	 *             wirft Exception
	 */
	void init(String titel, int x, int y) throws Exception {
		this.setLocation(x, y);
		this.setSize(Konstanten.BREITECHAT, Konstanten.HOEHECHAT);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
		this.setTitle(titel);

		/* initialisert TextAreas */
		eingabe = new TextArea();
		ausgabe = new TextArea();

		/* initialisiert Button */
		btSende = new JButton();
		btStart = new JButton("Lass uns spielen");

		/* ActionListener für sende wird erzeugt */
		sende = new Action(ausgehend, eintreffend, eingabe);
		btSende.setText("Abschicken");
		btSende.setActionCommand(stSende);
		btSende.addActionListener(sende);
		
		ActionListener alstart = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					gameFrame = new GameFrame("Netzwerk", Konstanten.XGF, Konstanten.YGF);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		};
		btStart.addActionListener(alstart);

		this.setLayout(new BorderLayout());

		/* Container für alle Fragmente im unteren Teil des Fensters */
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
		this.add(btStart, BorderLayout.CENTER);
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
		text = text + neu + Konstanten.ZEILENUMBRUCH;
		ausgabe.setText(text);
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}
}

/**
 * verarbeitet alle Aktionen auf den Netzwerkfenstern
 * 
 * @author Denise
 * 
 */
class Action implements ActionListener {

	/** Deklaration von PrintWriter, BufferedReader und TextArea */
	PrintWriter ausgehendPr;
	BufferedReader eintreffendBr;
	TextArea eingabeTa;

	/** Deklaration für Text für Button */
	private String stSende = "Send";

	/**
	 * weist PrintWriter, Buffered Reader und TextArea die entsprechenden
	 * Parameter zu
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
	 * dem PrintWriter wird der Text aus der TextArea übergeben und gesendet
	 * 
	 * @param f
	 *            Paramter für ActionEvent
	 */
	public void actionPerformed(ActionEvent f) {
		if (f.getActionCommand().equals(stSende)) {
			String ausgabe = eingabeTa.getText() + "\n";
			ausgehendPr.print(ausgabe);
			ausgehendPr.flush();
			eingabeTa.setText(" ");
		}
	}
}