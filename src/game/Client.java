package game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * �ffnet den Client-Thread
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
	/** Deklaration von InputStreamReader */
	InputStreamReader eintreffendISR = null;
	/** Deklaration von BufferedReader */
	BufferedReader eintreffendBr = null;
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

		/* richtet PrintWriter f�r Ausgangsstrom ein */
		try {
			ausgehendPr = new PrintWriter(socket.getOutputStream(), true);
		} catch (IOException e) {
			e.printStackTrace();
		}

		/* richtet BufferedReader f�r Eingangsstrom ein */
		try {
			eintreffendBr = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}

		/* richtet InputStreamReader f�r Eingangsstrom ein */
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
				/* mit dem Br werden die Buchstaben gelesen: f�r Chat */
				eintreffend = eintreffendBr.readLine();
				/* mit dem ISR werden die Tastenwerte gelesen: f� Spielfeld */
				// eintreffend = String.valueOf(eintreffendISR.read());
				frame.addAusgabe(eintreffend);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}