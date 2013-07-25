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

	ObjectOutputStream ausgehendOOS;

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

		/*
		 * richtet ObjectInputStream für Eingabestrom ein:Ein ObjectInputStream
		 * liest (deserialisiert) Daten primitiven Datentyps und Objekte, die
		 * früher mittels eines ObjectOutputStream geschrieben (serialisiert)
		 * wurden.
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
			frame = new ChatFrame("Client", null, this, Konstanten.XCLIENT, Konstanten.YSERVERCLIENT);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * liest die ankommenden Zeichen und leitet sie an das Fenster weiter
	 */
	public void run() {
		
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
	
	public void versende(Object object) {
		
		try {
			this.ausgehendOOS.writeObject(object);
			this.ausgehendOOS.flush();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}