package game;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * 
 * ein Objekt dieser Klasse ist die Musik, welche eine Musikdatei abspielt
 * 
 * @author Denise
 * 
 */
public class Musik {

	/**
	 * Konstruktor öffnet Thread und spielt einen Clip ein
	 * 
	 * @param fileName
	 *            Parameter für Dateinamen
	 */
	public Musik(final String fileName) {
		new Thread(new Runnable() {
			public void run() {
				try {
					Clip clip = AudioSystem.getClip();
					AudioInputStream inputStream = AudioSystem
							.getAudioInputStream(new File(fileName));
					clip.open(inputStream);
					clip.start();
					//clip.loop(Konstanten.LOOP);
				} catch (Exception e) {
					System.out.println("play sound error: " + e.getMessage()
							+ " for " + fileName);
				}
			}
		}).start();
	}
}
