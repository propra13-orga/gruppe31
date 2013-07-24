package game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
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
	/** Deklaration von ObjectInputStream */
	ObjectInputStream eintreffendOIS;
	/** Deklaration von BufferedReader */
	BufferedReader eintreffendBr = null;
	/** Deklaration von InputStreamReader */
	InputStreamReader eintreffendISR = null;
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
	 * startet den Server, verbindet mit Client, richtet Ausgabe- und
	 * Eingabestrom ein. Öffnet ein eigenes Fenster und wartet auf eintreffende
	 * Zeichen
	 */
	public void run() {
		while (true) {

			/* Wartet auf Verbindung */
			try {
				clientSocket = serverSocket.accept();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			/* Ausgabestrom */
			try {
				ausgehendPr = new PrintWriter(clientSocket.getOutputStream(),
						true);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			/* Eingabestrom */
			try {
				eintreffendOIS = new ObjectInputStream(clientSocket.getInputStream());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			try {
				eintreffendBr = new BufferedReader(new InputStreamReader(
						clientSocket.getInputStream()));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			try {
				eintreffendISR = new InputStreamReader(
						clientSocket.getInputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			/* erzeugt neues Fenster */
			try {
				frame = new ChatFrame("Server", ausgehendPr, eintreffendISR,
						Konstanten.XSERVER, Konstanten.YSERVERCLIENT);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			/* wartet in Endlosschleife auf Eingabestrom */
			while (true) {
				String incoming;

				try {
					/*
					 * hier eine Unterscheidung ob String oder Objekt, natürlich
					 * nicht so, weil ich dann ja direkt den richtigen Reader
					 * benutze, aber wie dann ? das selbe in Client (?)
					 */
					if (eintreffendOIS.readObject() instanceof String) {
						incoming = eintreffendBr.readLine();
						frame.addAusgabe(incoming);
					} else if (eintreffendOIS.readObject() instanceof Object) {
						incoming = String.valueOf(eintreffendISR.read());
						// an NetzwerkFrame leiten
					}

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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