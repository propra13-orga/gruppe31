package game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * öffnet den Client-Thread
 * 
 * @author Denise
 * 
 */
public class Client extends Thread {
	/** Deklaration des Feldes */
	ChatFrame frame;
	/** Deklaration von Socket */
	Socket socket = null;
	/** Deklaration von PrintWriter */
	PrintWriter ausgehendPr = null;
	/** Deklaration von ObjectInputStream */
	ObjectInputStream eintreffendOIS;
	/** Deklaration von BufferedReader */
	BufferedReader eintreffendBr = null;
	/** Deklaration von InputStreamReader */
	InputStreamReader eintreffendISR = null;
	/** Deklaration von Scanner */
	Scanner tasten = new Scanner(System.in);

	/**
	 * Konstruktor initialisiert Socket, PrintWriterm BufferedReader und ein
	 * Frame fuer den Client
	 * 
	 * @param ip
	 *            erwartet ip Parameter
	 */
	Client(String ip) {

		/* richtet Socket ein */
		try {
			socket = new Socket(ip, Konstanten.PORT);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		/* richtet PrintWriter für Ausgangsstrom ein */
		try {
			ausgehendPr = new PrintWriter(socket.getOutputStream(), true);
		} catch (IOException e) {
			e.printStackTrace();
		}

		/*
		 * richtet ObjectInputStream für Eingabestrom ein:Ein ObjectInputStream
		 * liest (deserialisiert) Daten primitiven Datentyps und Objekte, die
		 * früher mittels eines ObjectOutputStream geschrieben (serialisiert)
		 * wurden.
		 */
		try {
			eintreffendOIS = new ObjectInputStream(socket.getInputStream());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		/*
		 * richtet BufferedReader für Eingangsstrom ein: Reader, der
		 * zwischenspeichert, bevor er liest
		 */
		try {
			eintreffendBr = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}

		/*
		 * richtet InputStreamReader für Eingangsstrom ein: Basisklasse für alle
		 * Reader, die einen Byte-Stream in einen Zeichen-Stream umwandeln.
		 */
		try {
			eintreffendISR = new InputStreamReader(socket.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}

		/* erzeugt neues Fenster */
		try {
			frame = new ChatFrame("Client", ausgehendPr, eintreffendISR,
					Konstanten.XCLIENT, Konstanten.YSERVERCLIENT);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * liest die ankommenden Zeichen und leitet sie an das Fenster weiter
	 */
	public void run() {
		while (true) {
			String eintreffend;
			try {
				if (eintreffendOIS.readObject() instanceof String) {
					eintreffend = eintreffendBr.readLine();
					frame.addAusgabe(eintreffend);
				} else if (eintreffendOIS.readObject() instanceof Object) {
					eintreffend = String.valueOf(eintreffendISR.read());
					// an NetzwerkFrame leiten
				}
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
}