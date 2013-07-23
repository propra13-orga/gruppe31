package game;

import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.PrintWriter;

public class NetzwerkFrame extends GameFrame {
	
	private PrintWriter ausgehend;
	private BufferedReader eintreffend;

	public NetzwerkFrame(String titel, int x, int y, PrintWriter ausgehend, BufferedReader eintreffend) throws Exception {
		super(titel, x, y);
		
		this.ausgehend = ausgehend;
		this.eintreffend = eintreffend;
		
		
		// TODO Auto-generated constructor stub
	}
	
	
	public void keyReleased(KeyEvent arg0) {
		
		if (this.getTitle().equals("Server")) {
			
			/* Taste wurde gedrueckt, Bewegung ausfuehren. */
			
			ausgehend.print(this.spiel);
			ausgehend.flush();
		} else {
			
			ausgehend.println(this.spiel);
			ausgehend.flush();
		}
	}

}
