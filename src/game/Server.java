package game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/** Server erzeugt ServerSocket und verbindet mit Client, wenn dieser 'anklopft' */
class Server extends Thread {
	
	/** Deklaration des Feldes */
	NetzwerkFrame frame;
	/** Deklaration von ServerSocket */
	ServerSocket serverSocket = null;
	/** Deklaration von ClientSocket */
	Socket clientSocket = null;
	/** Deklaration von PrintWriter */
	PrintWriter ausgehendPr = null;
	/** Deklaration von BufferedReader */
	BufferedReader eintreffendBr = null;
	/** Deklaration von Scanner */
	Scanner tasten = new Scanner(System.in);

	/**
	 * erstellt neuen Socket
	 * 
	 * @throws Exception
	 *             wirft Exception
	 */
	Server() throws Exception {
		serverSocket = new ServerSocket(4711);
	}

	/**
	 * 
	 */
	public void run() {
		while (true) {
			try {
				/* Wartet auf Verbindung */
				clientSocket = serverSocket.accept();
				/* Ausgabestrom */
				ausgehendPr = new PrintWriter(clientSocket.getOutputStream(), true);
				eintreffendBr = new BufferedReader(new InputStreamReader(
				/* Eingabestrom */
				clientSocket.getInputStream()));
				frame = new NetzwerkFrame("Server", ausgehendPr, eintreffendBr, 600, 100);
				while (true) {
					String incoming = eintreffendBr.readLine();
					frame.addAusgabe(incoming);
				}
			} catch (IOException e) {
				System.out.println("Fehler - ServerSocket.accept()");
			}
		}
	}
}