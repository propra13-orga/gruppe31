package game;

import java.io.IOException;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.net.Socket;
import java.net.UnknownHostException;

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
	/** Deklaration von ObjectInputStream */
	ObjectInputStream eintreffendOIS;
	/** Deklaration von ObjectOutputStream */
	ObjectOutputStream ausgehendOOS;

	/**
	 * richtet Socket, Ausgabe- und Eingabestrom ein. Öffnet ein eigenes Fenster
	 * und wartet auf eintreffende Zeichen und öffnet ein neues ChatFrame
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

		/*
		 * richtet ObjectInputStream(deseralisiert Daten) für Eingabestrom und
		 * ObjectOutputStream(serialisiert Daten) für Ausgabestrom
		 */
		try {
			ausgehendOOS = new ObjectOutputStream(socket.getOutputStream());
			eintreffendOIS = new ObjectInputStream(socket.getInputStream());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		/* erzeugt neues Fenster */
		try {
			frame = new ChatFrame("Client", null, this, Konstanten.XCLIENT,
					Konstanten.YSERVERCLIENT);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * wartet in Endlosschleife auf Eingabestrom und leitet diesen weiter
	 */
	public void run() {

		while (true) {

			Object obj = null;

			try {
				obj = eintreffendOIS.readObject();
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			/* entweder ist es ein String */
			if (obj instanceof String) {
				frame.addAusgabe((String) obj);
			/* oder ein Spiel */
			} else {
				frame.verarbeiteObjekt(obj);
			}
		}
	}

	/**
	 * sendet object
	 * 
	 * @param object
	 *            Kommandozeilenparameter
	 */
	public void versende(Object object) {

		try {
			this.ausgehendOOS.writeObject(object);
			this.ausgehendOOS.flush();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}