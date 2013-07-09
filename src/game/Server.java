package game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/** Server erzeugt ServerSocket und verbindet mit Client, wenn dieser 'anklopft' */
class Server extends Thread {
	NetzwerkFrame frame;
	ServerSocket _ServerSocket = null;
	Socket _ClientSocket = null;
	PrintWriter _out = null;
	BufferedReader _in = null;

	/**
	 * erstellt neuen Socket
	 * 
	 * @throws Exception
	 *             wirft Exception
	 */
	Server() throws Exception {
		_ServerSocket = new ServerSocket(4711);
	}

	/**
	 * 
	 */
	public void run() {
		while (true) {
			try {
				/* Wartet auf Verbindung */
				_ClientSocket = _ServerSocket.accept();
				/* Ausgabestrom */
				_out = new PrintWriter(_ClientSocket.getOutputStream(), true);
				_in = new BufferedReader(new InputStreamReader(
				/* Eingabestrom */
				_ClientSocket.getInputStream()));
				frame = new NetzwerkFrame("Chat :: Server", _out, _in);
				while (true) {
					String incoming = _in.readLine();
					frame.addAusgabe(incoming);
				}
			} catch (IOException e) {
				System.out.println("Fehler - ServerSocket.accept()");
			}
		}
	}
}