package game;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * erstellt die nötige GUI für das Netzwerk
 * 
 * @author Denise
 * 
 */
public class ChatFrame extends JFrame implements KeyListener, ActionListener {
	
	private Server server;
	private Client client;

	/** Textareas im Fenster */
	private TextArea eingabe;
	private TextArea ausgabe;

	/** Deklaration der Felder */
	private Musik musik;
	private NetzwerkFrame netzwerkFrame;

	/** Button im Fenster */
	private JButton btSende;
	private JButton btStart;

	/** Deklaration für Text für Button */
	private String stSende = "Send";

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
	ChatFrame(String titel, Server server, Client client, int x, int y)
			throws Exception {

		this.server = server;
		this.client = client;
		
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
		btSende.setText("Abschicken");
		btSende.setActionCommand(stSende);
		btSende.addActionListener(this);

		btStart.addActionListener(this);

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
	 * @param eingabeText
	 *            Kommandozeilenparameter
	 */
	public void addAusgabe(String eingabeText) {
		String text = ausgabe.getText();
		text = text + eingabeText + Konstanten.ZEILENUMBRUCH;
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

	/**
	 * verarbeitet die Klicks auf die beiden Buttons im Chatfenster
	 * 
	 * @param f
	 *            ActionEvent
	 */
	public void actionPerformed(ActionEvent f) {
		
		if (this.server != null) {
			
			if (f.getSource().equals(btSende)) {
				
				String eingabeText = eingabe.getText();
				this.addAusgabe(eingabeText);
				
				this.server.versende(eingabeText);
				
				eingabe.setText("");
			} else if (f.getSource().equals(btStart)) {
				
				try {
					netzwerkFrame = new NetzwerkFrame("Server-Spiel", Konstanten.XGF, Konstanten.YGF, this.server, this.client);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			
		} else {
			
			if (f.getSource().equals(btSende)) {
				
				String eingabeText = eingabe.getText();
				this.addAusgabe(eingabeText);
				
				this.client.versende(eingabeText);
				
				eingabe.setText("");
			} else if (f.getSource().equals(btStart)) {
				
				try {
					netzwerkFrame = new NetzwerkFrame("Client-Spiel", Konstanten.XGF, Konstanten.YGF, this.server, this.client);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	public void verarbeiteObjekt(Object obj) {
	
		this.netzwerkFrame.verarbeiteObjekt(obj);		
	}
}