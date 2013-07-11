package game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * 
 * @author Denise
 * 
 */
public class Chatter extends Thread {
	/** Deklaration des Feldes */
	NetzwerkFrame frame;
	/** Deklaration von Socket */
	Socket socket = null;
	/** Deklaration von PrintWriter */
	PrintWriter ausgehendPr = null;
	/** Deklaration von BufferedReader */
	BufferedReader eintreffendBr = null;
	/** Deklaration von Scanner */
	Scanner tasten = new Scanner(System.in);

	/**
	 * Konstruktor initialisiert Socket, PrintWriterm BufferedReader und ein
	 * Frame fuer den Client
	 */
	Chatter() {
		try {
			socket = new Socket("localhost", 4711);
			ausgehendPr = new PrintWriter(socket.getOutputStream(), true);
			eintreffendBr = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			frame = new NetzwerkFrame("Client", ausgehendPr, eintreffendBr, 100, 100);
		} catch (Exception e) {
			frame.dispose();
		}
	}

	/**
	 * liest die ankommenden Zeichen und leitet sie an das Fenster weiter
	 */
	public void run() {
		while (true) {
			String eintreffend;
			try {
				eintreffend = eintreffendBr.readLine();
				frame.addAusgabe(eintreffend);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}