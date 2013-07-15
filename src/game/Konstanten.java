package game;

/** eigene Klasse für Konstanten, die hier nur einmal deklariert werden müssen */
public final class Konstanten {

	/**
	 * String direction wird deklariert CheckStyle erwartet anderes Muster
	 * kleingeschrieben: selber Fehler
	 */
	public static final String DIRECTION = System.getProperty("user.dir");

	/** int-Varbiablen werden für txt-Zeichen deklariert */
	public static final int RASEN = (int) ' ';
	public static final int GRENZE = (int) '#';
	public static final int PUDEL = (int) 'P';
	public static final int GEGNER = (int) 'G';
	public static final int GEGNER2 = (int) 'J';
	public static final int FALLE = (int) 'U';
	public static final int WEITER = (int) 'W';
	public static final int BOSS = (int) 'B';
	public static final int ZURUECK = (int) 'Z';
	public static final int CARLOS = (int) 'C';
	public static final int CUPCAKE = (int) 'F';
	public static final int HUETTE = (int) 'E';
	public static final int WAFFE = (int) 'S';
	public static final int GOLD = (int) 'O';
	public static final int MANA = (int) 'M';
	public static final int HEALTH = (int) 'H';
	public static final int RUESTUNG = (int) 'R';
	public static final int CHECKPOINT = (int) 'D';
	public static final int BOMBE = (int) 'X';
	public static final int STUNK = (int) 'Y';
	public static final int LASER = (int) 'Ä';
	public static final int GEGNERTOT = (int) 'Ü';
	public static final int SCHWERT = (int) 'ß';
	public static final int SHOPMANA = (int) 'A';
	public static final int SHOPHEALTH = (int) 'Q';
	public static final int SHOPRUESTUNG = (int) 'Ü';
	public static final int BOSS1v = (int) '1';
	public static final int BOSS1m = (int) '(';
	public static final int BOSS1w = (int) ')';
	public static final int BOSS2v = (int) 'V';
	public static final int BOSS2m = (int) '[';
	public static final int BOSS2w = (int) ']';
	public static final int BOSS3v = (int) 'X';
	public static final int BOSS3m = (int) '{';
	public static final int BOSS3w = (int) '}';
	public static final int LUKE = (int) 'L';
	public static final int SCHALTERZU = (int) '&';
	public static final int SCHALTERAUF = (int) '%';

	/** die Größe eines Feldes wird deklariert */
	public static final int SIZE = 50;
	/** die Spalten werden deklariert */
	public static final int SPALTEN = 16;
	/** die Zeilen werden deklariert */
	public static final int ZEILEN = 12;

	/** die Level-Staffelungen werden deklariert */
	public static final int RAUMEINS = 1;
	public static final int RAUMZWEI = 2;
	public static final int RAUMDREI = 3;
	public static final int RAUMVIER = 4;
	public static final int RAUMFUENF = 5;
	public static final int RAUMSECHS = 6;
	public static final int RAUMSIEBEN = 7;
	public static final int RAUMACHT = 8;
	public static final int RAUMNEUN = 9;

	/** die Health Staffelungen werden deklariert */
	public static final int VOLLH = 100;
	public static final int DREIVIERTELH = 75;
	public static final int HALBH = 50;
	public static final int EINVIERTELH = 25;
	public static final int LEERH = 0;

	/** die Rüstungs Staffelungen werden deklariert */
	public static final int VOLLR = 50;
	public static final int HALBR = 25;
	public static final int LEERR = 0;

	/** die Mana Staffelungen werden deklariert */
	public static final int VOLLM = 2;
	public static final int HALBM = 1;
	public static final int LEERM = 0;

	/** die Leben Staffelungen werden deklariert */
	public static final int VOLLL = 3;
	public static final int ZWEIDRITTELL = 2;
	public static final int EINDRITTELL = 1;

	/** die Gold Staffelungen werden angezeigt */
	public static final int GOLD0 = 0;
	public static final int GOLD50 = 50;
	public static final int GOLD100 = 100;
	public static final int GOLD150 = 150;
	public static final int GOLD200 = 200;
	public static final int GOLD250 = 250;
	public static final int GOLD300 = 300;
	public static final int GOLD350 = 350;

	/** die Groessen fuer das MenuFrame */
	public static final int BREITEMF = 800;
	public static final int HOEHEMF = 600;

	/** die Groessen fuer das GameFrame */
	public static final int BREITE = 900;
	public static final int HOEHE = 700;

	/** die Position fuer das GameFrame */
	public static final int XGF = 900;
	public static final int YGF = 700;

	/** die Groessen für das Steuerungsfenster */
	public static final int BREITEST = 440;
	public static final int HOEHEST = 310;

	/** die Groessen für das Netzwerkfenster */
	public static final int BREITECHAT = 700;
	public static final int HOEHECHAT = 600;

	/** die Groessen für das NPCfenster */
	public static final int BREITENPC = 205;
	public static final int HOEHENPC = 600;

	/** Positionen fuer Hintergrund NPCfenster */
	public static final int POSXNPC = 0;
	public static final int POYNPC = -50;
	public static final int BREITENPCF = 200;
	public static final int HOEHENPCF = 600;

	/** Positionen für Button Weiter NPCfenster */
	public static final int XWEITER = 0;
	public static final int YWEITER = 500;
	public static final int BREITEWEITER = 200;
	public static final int HOEHEWEITER = 30;

	/** Positionen für Button Skip NPCfenster */
	public static final int XSKIP = 0;
	public static final int YSKIP = 532;
	public static final int BREITESKIP = 200;
	public static final int HOEHESKIP = 30;

	/** Postionen für Netzwerkfenster */
	public static final int XSERVER = 30;
	public static final int XCLIENT = 650;
	public static final int YSERVERCLIENT = 100;

	/** Postionen für Loadbutton */
	public static final int XLOAD = 750;
	public static final int YLOAD = 550;
	public static final int BREITELOAD = 100;
	public static final int HOEHELOAD = 25;

	/** Postionen für Savebutton */
	public static final int XSAVE = 750;
	public static final int YSAVE = 575;
	public static final int BREITESAVE = 100;
	public static final int HOEHESAVE = 25;

	/** Port für Netzwerk */
	public static final int PORT = 4711;

	/** Poistionen für gvschliessen */
	public static final int XGV = 550;
	public static final int YGV = 450;
	public static final int BREITEGV = 200;
	public static final int HOEHEGV = 45;
	
	/** Positionen für Buttons auf MenuFrame */
	public static final int XBUTTON = 350;
	public static final int BREITEBUTTON = 200;
	public static final int HOEHEBUTTON = 40;
	public static final int YSTART = 250;
	public static final int YSTART2 = 300;
	public static final int YLADEN = 350;
	public static final int YSTEUERUNG = 400;
	public static final int YENDE = 450;

	/** Positionen für Madeby-Label */
	public static final int XMB = 600;
	public static final int YMB = 500;
	public static final int BREITEMB = 200;
	public static final int HOEHEMB = 40;
	
	/** Loop Angabe für Musik */
	public static final int LOOP = 999;

	/**
	 * privater Konstruktor, der verhindert, dass von außen ein Exemplar dieser
	 * Klasse gebildet werden kann
	 */
	private Konstanten() {
		// nothing to do here
	}
}
