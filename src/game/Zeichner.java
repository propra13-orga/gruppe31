package game;

import java.awt.*;
import java.awt.event.KeyEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * diese Klasse ist für alles zuständig, was auf dem GameFrame Fenster für das
 * Spielfeld gezeichnet wird
 */
public class Zeichner extends Canvas {

	private static final Icon iconRasen = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Rasen1.jpg");
	private static final Icon iconBombe = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Peng.png");
	private static final Icon iconBaum1 = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Baum1.jpg");
	private static final Icon iconPudel = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Pudel1.jpg");
	private static final Icon iconGegner = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Gegner1.png");
	private static final Icon iconFalle = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Falle.png");
	private static final Icon iconWeiter = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Weiter1.jpg");
	private static final Icon iconBoss1v = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Boss1voll.png");
	private static final Icon iconBoss1m = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Boss1mitte.png");
	private static final Icon iconBoss1w = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Boss1wenig.png");
	private static final Icon iconBoss2v = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Boss2voll.png");
	private static final Icon iconBoss2m = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Boss2mitte.png");
	private static final Icon iconBoss2w = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Boss2wenig.png");
	private static final Icon iconBoss3v = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Boss3voll.png");
	private static final Icon iconBoss3m = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Boss3mitte.png");
	private static final Icon iconBoss3w = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Boss3wenig.png");
	private static final Icon iconZurueck = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Zurueck1.jpg");
	private static final Icon iconCarlos = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Carlos.png");
	private static final Icon iconCupcake = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Cupcake.jpg");
	private static final Icon iconShop = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Shop.png");
	private static final Icon iconWaffe = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Waffe1.png");
	private static final Icon iconAggroErna = new ImageIcon(
			Konstanten.direction + "/src/game/Images/PudelWaffe1.png");
	private static final Icon iconSchwertErna = new ImageIcon(
			Konstanten.direction + "/src/game/Images/PudelSchwert.png");
	private static final Icon iconTerminatorErna = new ImageIcon(
			Konstanten.direction + "/src/game/Images/PudelAllesan.png");
	private static final Icon iconPudelBeides = new ImageIcon(
			Konstanten.direction + "/src/game/Images/PudelBeides.png");
	private static final Icon iconVollErna = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/PudelBrilleSchwert.png");
	private static final Icon iconPudelHalsband = new ImageIcon(
			Konstanten.direction + "/src/game/Images/PudelHalsband.png");
	private static final Icon iconPudelSchwertHals = new ImageIcon(
			Konstanten.direction + "/src/game/Images/Pudelschwerthals.png");
	private static final Icon iconGold = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Gold1.png");
	private static final Icon iconMana = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Mana1.png");
	private static final Icon iconHealth = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Heiltrank1.png");
	private static final Icon iconRuestung = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/HalsbandRasen.png");
	private static final Icon iconLaser = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Laser1.png");
	private static final Icon iconGegnertot = new ImageIcon(
			Konstanten.direction + "/src/game/Images/Gegnertot1.png");
	private static final Icon iconCheckpoint = new ImageIcon(
			Konstanten.direction + "/src/game/Images/Save.png");
	private static final Icon iconSchwert = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Schwertrasen.png");
	private static final Icon iconDefault = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Default.png");

	Integer[][] Spielfeld;

	private GameFrame gameFrame;
	
	public Zeichner(GameFrame pGameFrame) throws Exception {
		gameFrame = pGameFrame;
	}
	
	/**
	 * für jedes Feld im Array Spielfeld kann ein Icon gesetzt werden, welches
	 * anschließend gezeichnet wird
	 */
	public void paint(Graphics g) {
		
		for (int i = 0; i < Spielfeld.length; i++) {
			for (int j = 0; j < Spielfeld[i].length; j++) {

				Icon icon;

			switch (Spielfeld[i][j]) {
			case Konstanten.RASEN:
				icon = iconRasen;
				break;
			case Konstanten.GRENZE:
				icon = iconBaum1;
				break;
			case Konstanten.GEGNER:
				icon = iconGegner;
				break;
			case Konstanten.FALLE:
				icon = iconFalle;
				break;
			case Konstanten.BOMBE:
				icon = iconBombe;
				break;
			case Konstanten.WEITER:
				icon = iconWeiter;
				break;
			case Konstanten.BOSS1v:
				icon = iconBoss1v;
				break;
			case Konstanten.BOSS1m:
				icon = iconBoss1m;
				break;
			case Konstanten.BOSS1w:
				icon = iconBoss1w;
				break;
			case Konstanten.BOSS2v:
				icon = iconBoss2v;
				break;
			case Konstanten.BOSS2m:
				icon = iconBoss2m;
				break;
			case Konstanten.BOSS2w:
				icon = iconBoss2w;
				break;
			case Konstanten.BOSS3v:
				icon = iconBoss3v;
				break;
			case Konstanten.BOSS3m:
				icon = iconBoss3m;
				break;
			case Konstanten.BOSS3w:
				icon = iconBoss3w;
				break;
			case Konstanten.ZURUECK:
				icon = iconZurueck;
				break;
			case Konstanten.CARLOS:
				icon = iconCarlos;
				break;
			case Konstanten.CUPCAKE:
				icon = iconCupcake;
				break;
			case Konstanten.HUETTE:
				icon = iconShop;
				break;
			case Konstanten.WAFFE:
				icon = iconWaffe;
				break;
			case Konstanten.GOLD:
				icon = iconGold;
				break;
			case Konstanten.MANA:
				icon = iconMana;
				break;
			case Konstanten.SCHWERT:
				icon = iconSchwert;
				break;
			case Konstanten.RUESTUNG:
				icon = iconRuestung;
				break;
			case Konstanten.HEALTH:
				icon = iconHealth;
				break;
			case Konstanten.LASER:
				icon = iconLaser;
				break;
			case Konstanten.GEGNERTOT:
				icon = iconGegnertot;
				break;
			case Konstanten.CHECKPOINT:
				icon = iconCheckpoint;
				break;
			case Konstanten.PUDEL:
				icon = iconPudel;
				if (gameFrame.getBewaffnet() == 1){
					if (gameFrame.getBeschwertet() == 1){
						if (gameFrame.getHalsband() == 1){
							icon = iconTerminatorErna;
							}
						else if (gameFrame.getHalsband() == 0){
							icon = iconVollErna;
							}
					}
					else if (gameFrame.getBeschwertet() == 0){
						if (gameFrame.getHalsband() ==1){
							icon = iconTerminatorErna;
							}
						else if (gameFrame.getHalsband() == 0){
							icon = iconAggroErna;
							}
					}
				}
				else if (gameFrame.getBewaffnet() == 0){
					if (gameFrame.getBeschwertet() == 1){
						if (gameFrame.getHalsband() == 1){
							icon = iconPudelSchwertHals;
						} else if (gameFrame.getHalsband() ==0){
							icon = iconSchwertErna;
						} 
					} else if (gameFrame.getBeschwertet() == 0){
						if (gameFrame.getHalsband() ==1){
							icon = iconPudelHalsband;
						} else if (gameFrame.getHalsband() ==0){
							icon = iconPudel;
						}
					}
				}
				break;
			default:
				icon = iconDefault;
				break;
			}
			icon.paintIcon(this, g, i * Konstanten.SIZE, j * Konstanten.SIZE);
			}
		}
	}

	/** zeichnet das Spielfeld (erneut) */
	public void zeichneSpielfeld(Integer[][] feld) {
		Spielfeld = feld;
		repaint();
	}
}
