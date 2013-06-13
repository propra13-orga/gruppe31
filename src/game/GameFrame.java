package game;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * GameFrame erzeugt das Spielfenster. Der KeyListener fragt die Werte der
 * umliegenden Felder ab und f�hrt das Programm entsprechend weiter.
 */
public class GameFrame extends JFrame implements KeyListener {
	
	private static final Icon icon50Gold = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/50Gold.png");
	private static final Icon icon100Gold = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/100Gold.png");
	private static final Icon icon150Gold = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/150Gold.png");
	private static final Icon icon200Gold = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/200Gold.png");
	private static final Icon icon250Gold = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/250Gold.png");
	private static final Icon icon300Gold = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/300Gold.png");
	private static final Icon icon350Gold = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/350Gold.png");
	
	private static final Icon iconKeinEq = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/KeinEq.png");
	private static final Icon iconKeineBrille = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/KeineBrille.png");
	private static final Icon iconKeinBand = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/KeinBand.png");
	private static final Icon iconAllesEq = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/AllesEq.png");
	
	private static final Icon iconHerz1 = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Herz1.png");
	private static final Icon iconHerz2 = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Herz2.png");
	private static final Icon iconHerz3 = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Herz3.png");
	
	private static final Icon iconAnzeige = new ImageIcon(Konstanten.direction
			+ "/src/game/Images/Anzeige.png");

	private JLabel Gold50 = new JLabel(icon50Gold);
	private JLabel Gold100 = new JLabel(icon100Gold);
	private JLabel Gold150 = new JLabel(icon150Gold);
	private JLabel Gold200 = new JLabel(icon200Gold);
	private JLabel Gold250 = new JLabel(icon250Gold);
	private JLabel Gold300 = new JLabel(icon300Gold);
	private JLabel Gold350 = new JLabel(icon350Gold);
	
	private JLabel KeinEq = new JLabel(iconKeinEq);
	private JLabel KeineBrille = new JLabel(iconKeineBrille);
	private JLabel KeinBand = new JLabel(iconKeinBand);
	private JLabel AllesEq = new JLabel(iconAllesEq);
	
	private JLabel Herz1 = new JLabel(iconHerz1);
	private JLabel Herz2 = new JLabel(iconHerz2);
	private JLabel Herz3 = new JLabel(iconHerz3);
	
	private JLabel Anzeige = new JLabel(iconAnzeige);

	private Panel Leiste = new Panel();

	private JButton GVschliessen;

	private LevelManager levelManager;
	private GameFrame gameFrame;
	private Carlos carlos;
	private Zeichner zeichner;
	private Shop shop;

	private Integer aktuellesSpielfeld[][] = new Integer[16][12];
	public Integer CheckSpielfeld[][] = new Integer[16][12];
	

	private int Spielfigurx;
	private int Spielfigury;
	private int Gegnerx;
	private int Gegnery;
	private int checkx;
	private int checky;

	public int bewaffnet = 0;
	public int gold = 0;
	public int health = 100;
	public int ruestung = 0;
	public int mana = 0;
	public int ko = 0;
	public int bosshealth = 300;
	public int leben = 3;
	

	/**
	 * Konstruktor, der die Eigenschaften des Spielfensters festsetzt. der
	 * Zeichner wird auf das Spielfenster gesetzt und der LevelManager wird
	 * aufgerufen. Das n�chste (hier: erste) Level wird aufgerufen und der
	 * Zeichner zeichnet das entsprechende Spielfeld
	 * 
	 * @throws Exception
	 */
	public GameFrame() throws Exception {
		this.setResizable(false);
		this.setTitle("Erna's Adventure");
		this.setSize(810, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setFocusable(true);
		this.addKeyListener(this);

		zeichner = new Zeichner();
		this.add(zeichner);

		this.setVisible(true);

		levelManager = new LevelManager();
		levelManager.init();

		getLevel();

		zeichner.zeichneSpielfeld(aktuellesSpielfeld);

		setzeAnzeige();

		getContentPane().add(Leiste, BorderLayout.SOUTH);

		this.requestFocus();
	}

	/* hier arbeitet Marcel */
	public void setzeAnzeige() {
		Leiste.add(Anzeige);
	}

	/**
	 * das aktuelle Spielfeld wird kopiert und die Position der Spielfigur wird
	 * festgehalten
	 * 
	 * M�glichkeit f�r Valentin: Checkpoints
	 */
	public void getLevel() {
		levelManager.kopiereAktuellesLevel(aktuellesSpielfeld);
		Spielfigurx = levelManager.getStartx();
		Spielfigury = levelManager.getStarty();
		Gegnerx = levelManager.getStartGegnerx();
		Gegnery = levelManager.getStartGegnery();
	}

	/**
	 * durch den KeyListener ausgel�st, wird hier ein neues Fenster mit dem
	 * Spielausgang Gewonnen aufgerufen
	 */
	public void Gewonnen() {
		getContentPane().removeAll();

		try {
			this.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File(
					Konstanten.direction + "/src/game/Images/Gewonnen.jpg")))));
		} catch (IOException a) {
			System.out.println("das Bild kann nicht gefunden werden");
		}

		this.setResizable(false);
		this.setSize(800, 600);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

		GVschliessen = new JButton("Dieses Fenster schlie�en");
		GVschliessen.setBounds(550, 450, 200, 40);
		this.add(GVschliessen);

		ActionListener alschliessen = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		};
		GVschliessen.addActionListener(alschliessen);
	}

	/**
	 * durch den KeyListener ausgel�st, wird hier ein neues Fenster mit dem
	 * Spielausgang Verloren aufgerufen
	 */
	public void Verloren() {
		if (leben <=0){
		getContentPane().removeAll();

		try {
			this.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File(
					Konstanten.direction + "/src/game/Images/GameOver.jpg")))));
		} catch (IOException a) {
			System.out.println("das Bild kann nicht gefunden werden");
		}

		this.setResizable(false);
		this.setSize(800, 600);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

		GVschliessen = new JButton("Dieses Fenster schlie�en");
		GVschliessen.setBounds(550, 450, 200, 40);
		this.add(GVschliessen);

		ActionListener alschliessen = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		};
		GVschliessen.addActionListener(alschliessen);
		}
		else if (leben > 0){
			health = 100;
			Spielfigurx = checkx;
			Spielfigury = checky;
			
			zeichner.zeichneSpielfeld(CheckSpielfeld);
		}
	} 

	/**
	 * der KeyListener reagiert, wenn eine Taste gedr�ckt wurde und f�hrt das
	 * Programm entsprechend weiter
	 */
	public void keyPressed(KeyEvent e) {

		int altx = Spielfigurx;
		int alty = Spielfigury;
		int altGegx = Gegnerx;
		int altGegy = Gegnery;
		int locx = Spielfigurx;

		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			Spielfigurx--;
			Gegnerx++;
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			Spielfigurx++;
			Gegnerx--;
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			Spielfigury--;
			Gegnery++;
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			Spielfigury++;
			Gegnery--;
		}
			if (ko == 0){
				if (aktuellesSpielfeld[Gegnerx][Gegnery] == Konstanten.RASEN) {
					aktuellesSpielfeld[Gegnerx][Gegnery] = Konstanten.GEGNER;
					aktuellesSpielfeld[altGegx][altGegy] = Konstanten.RASEN;
					zeichner.zeichneSpielfeld(aktuellesSpielfeld);
				}
				else if (aktuellesSpielfeld[Gegnerx][Gegnery] == Konstanten.GRENZE) {
					aktuellesSpielfeld[Gegnerx][Gegnery] = Konstanten.GRENZE;
					aktuellesSpielfeld[altGegx][altGegy] = Konstanten.GEGNER;
					Gegnerx = altGegx;
					Gegnery = altGegy;
				}	
				else if (aktuellesSpielfeld[Gegnerx][Gegnery] == Konstanten.PUDEL) {
					aktuellesSpielfeld[Gegnerx][Gegnery] = Konstanten.PUDEL;
					aktuellesSpielfeld[altGegx][altGegy] = Konstanten.GEGNER;
					Gegnerx = altGegx;
					Gegnery = altGegy;
				}
				else if (aktuellesSpielfeld[Gegnerx][Gegnery] == Konstanten.BOSS1) {
					aktuellesSpielfeld[Gegnerx][Gegnery] = Konstanten.BOSS1;
					aktuellesSpielfeld[altGegx][altGegy] = Konstanten.GEGNER;
					Gegnerx = altGegx;
					Gegnery = altGegy;
				}
				else if (aktuellesSpielfeld[Gegnerx][Gegnery] == Konstanten.BOSS2) {
					aktuellesSpielfeld[Gegnerx][Gegnery] = Konstanten.BOSS2;
					aktuellesSpielfeld[altGegx][altGegy] = Konstanten.GEGNER;
					Gegnerx = altGegx;
					Gegnery = altGegy;
				}
				else if (aktuellesSpielfeld[Gegnerx][Gegnery] == Konstanten.BOSS3) {
					aktuellesSpielfeld[Gegnerx][Gegnery] = Konstanten.BOSS3;
					aktuellesSpielfeld[altGegx][altGegy] = Konstanten.GEGNER;
					Gegnerx = altGegx;
					Gegnery = altGegy;
				}
				else if (aktuellesSpielfeld[Gegnerx][Gegnery] == Konstanten.CUPCAKE) {
					aktuellesSpielfeld[Gegnerx][Gegnery] = Konstanten.CUPCAKE;
					aktuellesSpielfeld[altGegx][altGegy] = Konstanten.GEGNER;
					Gegnerx = altGegx;
					Gegnery = altGegy;
				}
				else if (aktuellesSpielfeld[Gegnerx][Gegnery] == Konstanten.ZURUECK) {
					aktuellesSpielfeld[Gegnerx][Gegnery] = Konstanten.ZURUECK;
					aktuellesSpielfeld[altGegx][altGegy] = Konstanten.GEGNER;
					Gegnerx = altGegx;
					Gegnery = altGegy;
				}
				
				else if (ko != 0) {
					ko = 0;
				}
			}
		
		if (aktuellesSpielfeld[Spielfigurx][Spielfigury] == Konstanten.GEGNER) {
			health = health - 20;
			if (health + ruestung <= 0){
				aktuellesSpielfeld[altx][alty] = Konstanten.RASEN;
				aktuellesSpielfeld[checkx][checky] = Konstanten.PUDEL;
				leben = leben - 1;
				Verloren();
			}
			else if (health + ruestung > 0){
				aktuellesSpielfeld[altx][alty] = Konstanten.PUDEL;
				aktuellesSpielfeld[Spielfigurx][Spielfigury] = Konstanten.GEGNER;
				Spielfigurx = altx;
				Spielfigury = alty;
				
			}
		} else if (aktuellesSpielfeld[Spielfigurx][Spielfigury] == Konstanten.WEITER) {
			levelManager.LevelWeiter();
			bosshealth = 300;
			ko = 0;
			getLevel();
			zeichner.zeichneSpielfeld(aktuellesSpielfeld);
		} else if (aktuellesSpielfeld[Spielfigurx][Spielfigury] == Konstanten.BOSS1) {
			health = health - 34;
				if (health + ruestung <= 0){
					leben = leben - 1;
					aktuellesSpielfeld[altx][alty] = Konstanten.RASEN;
					aktuellesSpielfeld[checkx][checky] = Konstanten.PUDEL;
					Verloren();
				}
				else if (health + ruestung > 0){
					aktuellesSpielfeld[altx][alty] = Konstanten.PUDEL;
					aktuellesSpielfeld[Spielfigurx][Spielfigury] = Konstanten.BOSS1;
					Spielfigurx = altx;
					Spielfigury = alty;
				}
		} else if (aktuellesSpielfeld[Spielfigurx][Spielfigury] == Konstanten.BOSS2) {
			health = health - 50;
				if (health + ruestung <= 0){
					leben = leben - 1;
					aktuellesSpielfeld[altx][alty] = Konstanten.RASEN;
					aktuellesSpielfeld[checkx][checky] = Konstanten.PUDEL;
					Verloren();
				}
				else if (health + ruestung > 0){
					aktuellesSpielfeld[altx][alty] = Konstanten.PUDEL;
					aktuellesSpielfeld[Spielfigurx][Spielfigury] = Konstanten.BOSS2;
					Spielfigurx = altx;
					Spielfigury = alty;
				}
		} else if (aktuellesSpielfeld[Spielfigurx][Spielfigury] == Konstanten.BOSS3) {
			health = health - 100;
				if (health + ruestung <= 0){
					leben = leben - 1;
					aktuellesSpielfeld[altx][alty] = Konstanten.RASEN;
					aktuellesSpielfeld[checkx][checky] = Konstanten.PUDEL;
					Verloren();
				}
				else if (health + ruestung > 0){
					aktuellesSpielfeld[altx][alty] = Konstanten.PUDEL;
					aktuellesSpielfeld[Spielfigurx][Spielfigury] = Konstanten.BOSS3;
					Spielfigurx = altx;
					Spielfigury = alty;
				}
		} else if (aktuellesSpielfeld[Spielfigurx][Spielfigury] == Konstanten.ZURUECK) {
			aktuellesSpielfeld[Spielfigurx][Spielfigury] = Konstanten.ZURUECK;
			aktuellesSpielfeld[altx][alty] = Konstanten.PUDEL;
			Spielfigurx = altx;
			Spielfigury = alty;
		} else if (aktuellesSpielfeld[Spielfigurx][Spielfigury] == Konstanten.CARLOS) {
			carlos = new Carlos();
			aktuellesSpielfeld[altx][alty] = Konstanten.PUDEL;
			aktuellesSpielfeld[Spielfigurx][Spielfigury] = Konstanten.CARLOS;
			Spielfigurx = altx;
			Spielfigury = alty;
		} else if (aktuellesSpielfeld[Spielfigurx][Spielfigury] == Konstanten.HUETTE) {
			shop = new Shop();
			aktuellesSpielfeld[Spielfigurx][Spielfigury] = Konstanten.RASEN;
			aktuellesSpielfeld[altx][alty] = Konstanten.PUDEL;
			aktuellesSpielfeld[Spielfigurx][Spielfigury] = Konstanten.HUETTE;
			Spielfigurx = altx;
			Spielfigury = alty;
		} else if (aktuellesSpielfeld[Spielfigurx][Spielfigury] == Konstanten.CUPCAKE) {
			Gewonnen();
		} else if (aktuellesSpielfeld[Spielfigurx][Spielfigury] == Konstanten.GRENZE) {
			aktuellesSpielfeld[altx][alty] = Konstanten.PUDEL;
			aktuellesSpielfeld[Spielfigurx][Spielfigury] = Konstanten.GRENZE;
			Spielfigurx = altx;
			Spielfigury = alty;
		} else if (aktuellesSpielfeld[Spielfigurx][Spielfigury] == Konstanten.GOLD) {
			gold = gold + 100;
			aktuellesSpielfeld[Spielfigurx][Spielfigury] = Konstanten.PUDEL;
			aktuellesSpielfeld[altx][alty] = Konstanten.RASEN;
			zeichner.zeichneSpielfeld(aktuellesSpielfeld);
		} else if (aktuellesSpielfeld[Spielfigurx][Spielfigury] == Konstanten.MANA) {
			mana = mana + 10;
			aktuellesSpielfeld[Spielfigurx][Spielfigury] = Konstanten.PUDEL;
			aktuellesSpielfeld[altx][alty] = Konstanten.RASEN;
			zeichner.zeichneSpielfeld(aktuellesSpielfeld);
		} else if (aktuellesSpielfeld[Spielfigurx][Spielfigury] == Konstanten.RUESTUNG) {
			ruestung = 50;
			aktuellesSpielfeld[Spielfigurx][Spielfigury] = Konstanten.PUDEL;
			aktuellesSpielfeld[altx][alty] = Konstanten.RASEN;
			zeichner.zeichneSpielfeld(aktuellesSpielfeld);
		} else if (aktuellesSpielfeld[Spielfigurx][Spielfigury] == Konstanten.HEALTH) {
			health = 100;
			aktuellesSpielfeld[Spielfigurx][Spielfigury] = Konstanten.PUDEL;
			aktuellesSpielfeld[altx][alty] = Konstanten.RASEN;
			zeichner.zeichneSpielfeld(aktuellesSpielfeld);
		} else if (aktuellesSpielfeld[Spielfigurx][Spielfigury] == Konstanten.WAFFE) {
			bewaffnet = 1;
			aktuellesSpielfeld[Spielfigurx][Spielfigury] = Konstanten.PUDEL;
			aktuellesSpielfeld[altx][alty] = Konstanten.RASEN;
			zeichner.zeichneSpielfeld(aktuellesSpielfeld);
		} else if (aktuellesSpielfeld[Spielfigurx][Spielfigury] == Konstanten.GEGNERTOT) {;
			gold = gold + 10;
			aktuellesSpielfeld[Spielfigurx][Spielfigury] = Konstanten.PUDEL;
			aktuellesSpielfeld[altx][alty] = Konstanten.RASEN;
			zeichner.zeichneSpielfeld(aktuellesSpielfeld);
		} else if (aktuellesSpielfeld[Spielfigurx][Spielfigury] == Konstanten.RASEN) {
			aktuellesSpielfeld[Spielfigurx][Spielfigury] = Konstanten.PUDEL;
			aktuellesSpielfeld[altx][alty] = Konstanten.RASEN;
			zeichner.zeichneSpielfeld(aktuellesSpielfeld);
		} else if (aktuellesSpielfeld[Spielfigurx][Spielfigury] == Konstanten.CHECKPOINT) {
			aktuellesSpielfeld[Spielfigurx][Spielfigury] = Konstanten.PUDEL;
			aktuellesSpielfeld[altx][alty] = Konstanten.RASEN;
			CheckSpielfeld = aktuellesSpielfeld;
			checkx = Spielfigurx;
			checky = Spielfigury;
			zeichner.zeichneSpielfeld(aktuellesSpielfeld);
		}
		
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			if (bewaffnet == 0){
				// nothing to do here
			}
			else if (bewaffnet == 1){
				locx++;
				while (aktuellesSpielfeld[locx][Spielfigury] != Konstanten.GRENZE){
					if (aktuellesSpielfeld[locx][Spielfigury] == Konstanten.RASEN) {
						aktuellesSpielfeld[locx][Spielfigury] = Konstanten.LASER;
						zeichner.zeichneSpielfeld(aktuellesSpielfeld);
						locx++;
						try
			            {
			                Thread.sleep( 300 );
			            }
			            catch ( InterruptedException hj)
			            {
			                hj.printStackTrace();
			            }
						}
					else if (aktuellesSpielfeld[locx][Spielfigury] == Konstanten.GEGNER) {
						aktuellesSpielfeld[locx][Spielfigury] = Konstanten.GEGNERTOT;
						zeichner.zeichneSpielfeld(aktuellesSpielfeld);
						ko = 1;
						break;
					}
					else if (aktuellesSpielfeld[locx][Spielfigury] == Konstanten.BOSS1){
						bosshealth = bosshealth - 100;
							if (bosshealth <= 0){
								aktuellesSpielfeld[locx][Spielfigury] = Konstanten.RASEN;
								zeichner.zeichneSpielfeld(aktuellesSpielfeld);
								break;
							}
							else if (bosshealth > 0){							}
							aktuellesSpielfeld[locx][Spielfigury] = Konstanten.BOSS1;
							break;
							}
					else if (aktuellesSpielfeld[locx][Spielfigury] == Konstanten.BOSS2){
						bosshealth = bosshealth - 100;
							if (bosshealth <= 0){
								aktuellesSpielfeld[locx][Spielfigury] = Konstanten.RASEN;
								zeichner.zeichneSpielfeld(aktuellesSpielfeld);
								break;
							}
							else if (bosshealth > 0){							}
							aktuellesSpielfeld[locx][Spielfigury] = Konstanten.BOSS2;
							break;
							}
					else if (aktuellesSpielfeld[locx][Spielfigury] == Konstanten.BOSS3){
						bosshealth = bosshealth - 100;
							if (bosshealth <= 0){
								aktuellesSpielfeld[locx][Spielfigury] = Konstanten.RASEN;
								zeichner.zeichneSpielfeld(aktuellesSpielfeld);
								break;
							}
							else if (bosshealth > 0){							}
							aktuellesSpielfeld[locx][Spielfigury] = Konstanten.BOSS3;
							break;
							}
					else 
						break;
				
				} 
				
				locx = Spielfigurx;
				locx++;
				
				while (aktuellesSpielfeld[locx][Spielfigury] == Konstanten.LASER){
							aktuellesSpielfeld[locx][Spielfigury] = Konstanten.RASEN;
							zeichner.zeichneSpielfeld(aktuellesSpielfeld);
							locx++;
							try
				            {
								
				                Thread.sleep( 300 );
				            }
				            catch ( InterruptedException hj)
				            {
				                hj.printStackTrace();
				            }
					}
				}
	}
		if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
			if (mana == 0){
				// nothing to do here
			}
			else if (mana == 1) {
				bewaffnet = 1;
				health = 200;
			}
		}
		
	}


	public void keyReleased(KeyEvent e) {
		// nothing to do here
	}

	public void keyTyped(KeyEvent e) {
		// nothing to do here
	}
}