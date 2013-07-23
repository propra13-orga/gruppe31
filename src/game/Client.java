package game;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
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
	/** Deklaration von BufferedReader */
	InputStreamReader eintreffendBr = null;
	/** Deklaration von Scanner */
	Scanner tasten = new Scanner(System.in);

	/**
	 * Konstruktor initialisiert Socket, PrintWriterm BufferedReader und ein
	 * Frame fuer den Client
	 * 
	 * @param ip
	 *            erwartet ip Parameter
	 * @throws Exception
	 *             wirft Exception
	 */
	Client(String ip) throws Exception {
		/* Host-Adresse, Port */
		socket = new Socket(ip, Konstanten.PORT);
		ausgehendPr = new PrintWriter(socket.getOutputStream(), true);
		eintreffendBr = new InputStreamReader(socket.getInputStream());
		frame = new ChatFrame("Client", ausgehendPr, eintreffendBr,
				Konstanten.XCLIENT, Konstanten.YSERVERCLIENT);
	}

	/**
	 * liest die ankommenden Zeichen und leitet sie an das Fenster weiter
	 */
	public void run() {
		while (true) {
			String eintreffend;
			try {
				eintreffend = String.valueOf(eintreffendBr.read());
				frame.addAusgabe(eintreffend);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}