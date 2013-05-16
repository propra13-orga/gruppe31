package game;
 

import java.applet.Applet;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Listener extends Applet implements Runnable, KeyListener {


	public void init() {
		
		//Hintergrund und Spielflaeche
		setSize(800, 480);
		setBackground(Color.GREEN);
		setFocusable(true);
		addKeyListener(this);
		Frame frame = (Frame) this.getParent().getParent();
	    frame.setTitle("Spielfeld");
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		Thread thread = new Thread(this);
		thread.start();
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		 while (true) {
		      repaint();

		         try {
					Thread.sleep(17);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		   }
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// Beim Taste Drücken

		   switch (e.getKeyCode()) {
		   case KeyEvent.VK_UP:
			   System.out.println("Bewegung nach Oben");
		   break;

		   case KeyEvent.VK_DOWN:
			   System.out.println("Bewegung nach Unten");
		   break;

		   case KeyEvent.VK_LEFT:
			   System.out.println("Bewegung nach Links");
		   break;

		   case KeyEvent.VK_RIGHT:
			   System.out.println("Bewegung nach Rechts");
		   break;
		   }
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// Nach Taste loslassen
		switch (e.getKeyCode()) {
		   case KeyEvent.VK_UP:
			   System.out.println("Nichtmehr nach Oben");
		      break;

		   case KeyEvent.VK_DOWN:
			   System.out.println("Nichtmehr nach Unten");
		      break;

		   case KeyEvent.VK_LEFT:
			   System.out.println("Nichtmehr nach Links");
		      break;

		   case KeyEvent.VK_RIGHT:
			   System.out.println("Nichtmehr nach Rechts");
		      break;
		   }
	}
}