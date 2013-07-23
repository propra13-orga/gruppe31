package game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.Scanner;

import javax.swing.JOptionPane;

/** Server erzeugt ServerSocket und verbindet mit Client, wenn dieser 'anklopft' */
class Server extends Thread {

	/** Deklaration des Feldes */
	ChatFrame frame;
	/** Deklaration von ServerSocket */
	ServerSocket serverSocket = null;
	/** Deklaration von ClientSocket */
	Socket clientSocket = null;
	/** Deklaration von PrintWriter */
	PrintWriter ausgehendPr = null;
	/** Deklaration von BufferedReader */
	InputStreamReader eintreffendBr = null;
	/** Deklaration von Scanner */
	Scanner tasten = new Scanner(System.in);

	/**
	 * erstellt neuen Socket
	 * 
	 * @throws IOException
	 *             wirft Exception
	 */
	Server() throws IOException {
		serverSocket = new ServerSocket(Konstanten.PORT);
		ipErmitteln();
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
				ausgehendPr = new PrintWriter(clientSocket.getOutputStream(),
						true);
				eintreffendBr = new InputStreamReader(
				/* Eingabestrom */
				clientSocket.getInputStream());
				frame = new ChatFrame("Server", ausgehendPr, eintreffendBr,
						Konstanten.XSERVER, Konstanten.YSERVERCLIENT);
				while (true) {
					String incoming = String.valueOf(eintreffendBr.read());
					frame.addAusgabe(incoming);
				}
			} catch (Exception e) {
				System.out.println("Fehler - ServerSocket.accept()");
			}
		}
	}

	/**
	 * ermittelt die IP des Servers
	 * 
	 * @throws UnknownHostException
	 *             wirft Exception
	 */
	public void ipErmitteln() throws UnknownHostException {
		String ip = "Host Name/ Adresse: " + InetAddress.getLocalHost();
		JOptionPane.showMessageDialog(null, ip, "IP-Adresse des Servers",
				JOptionPane.INFORMATION_MESSAGE);
	}

}