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
	NetzwerkFrame frame;
	Socket _Socket = null;
	PrintWriter _out = null;
	BufferedReader _in = null;
	Scanner _keyboard = new Scanner(System.in);

	/**
	 * Konstruktor
	 */
	Chatter() {
		try {
			_Socket = new Socket("localhost", 4711);
			_out = new PrintWriter(_Socket.getOutputStream(), true);
			_in = new BufferedReader(new InputStreamReader(
					_Socket.getInputStream()));
			frame = new NetzwerkFrame("Chat :: Client", _out, _in);
		} catch (Exception e) {
			System.exit(1);
		}
	}

	/**
	 * liest die ankommenden Zeichen und leitet sie an das Fenster weiter
	 */
	public void run() {
		while (true) {
			String incoming;
			try {
				incoming = _in.readLine();
				frame.addAusgabe(incoming);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}