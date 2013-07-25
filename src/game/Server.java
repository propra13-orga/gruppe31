package game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
	private ChatFrame frame;
	/** Deklaration von ServerSocket */
	private ServerSocket serverSocket = null;
	/** Deklaration von ClientSocket */
	private Socket clientSocket = null;
	private ObjectOutputStream ausgehendOOS;
	/** Deklaration von ObjectInputStream */
	private ObjectInputStream eintreffendOIS;
	/** Deklaration von BufferedReader */

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
	 * Eingabestrom ein. �ffnet ein eigenes Fenster und wartet auf eintreffende
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


			/* Eingabestrom */
			try {
				eintreffendOIS = new ObjectInputStream(clientSocket.getInputStream());
				ausgehendOOS = new ObjectOutputStream(clientSocket.getOutputStream());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			/* erzeugt neues Fenster */
			try {
				frame = new ChatFrame("Server", this, null, Konstanten.XSERVER, Konstanten.YSERVERCLIENT);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			/* wartet in Endlosschleife auf Eingabestrom */
			while (true) {
				
				Object obj = null;
				
				try {
					obj = eintreffendOIS.readObject();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				if (obj instanceof String) {
					
					frame.addAusgabe((String) obj);
				} else {
					
					frame.verarbeiteObjekt(obj); 
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

	public void versende(Object object) {
		
		try {
			this.ausgehendOOS.writeObject(object);
			this.ausgehendOOS.flush();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}