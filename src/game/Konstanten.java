package game;

/** eigene Klasse für Konstanten, die hier nur einmal deklariert werden müssen */
public final class Konstanten {

	public static final String direction = System.getProperty("user.dir");

	public static final int RASEN = (int) ' ';
	public static final int GRENZE = (int) '#';
	public static final int PUDEL = (int) 'P';
	public static final int GEGNER = (int) 'G';
	public static final int GEGNER2 = (int) 'J';
	public static final int FALLE = (int) 'U';
	public static final int WEITER = (int) 'W';
	public static final int BOSS1v = (int) 'B';
	public static final int BOSS1m = (int) '(';
	public static final int BOSS1w = (int) ')';
	public static final int BOSS2v = (int) 'V';
	public static final int BOSS2m = (int) '[';
	public static final int BOSS2w = (int) ']';
	public static final int BOSS3v = (int) 'X';
	public static final int BOSS3m = (int) '{';
	public static final int BOSS3w = (int) '}';
	public static final int ZURUECK = (int) 'Z';
	public static final int CARLOS = (int) 'C';
	public static final int CUPCAKE = (int) 'F';
	public static final int HUETTE = (int) 'E';
	public static final int WAFFE = (int) 'S';
	public static final int GOLD = (int) 'O';
	public static final int MANA = (int) 'M';
	public static final int HEALTH = (int) 'H';
	public static final int RUESTUNG = (int) 'R';
	public static final int LASER = (int) 'L';
	public static final int GEGNERTOT = (int) 'T';
	public static final int CHECKPOINT = (int) 'D';
	public static final int BOMBE = (int) '/';
	public static final int SCHWERT = (int) 'ß';
	public static final int SHOPMANA = (int) 'A';
	public static final int SHOPHEALTH = (int) 'Q';
	public static final int SHOPRUESTUNG = (int) 'Ü';
	public static final int STUNK = (int) 'Y';

	public static final int SIZE = 50;
	public static final int SPALTEN = 16;
	public static final int ZEILEN = 12;

	public static final int VOLLH = 100;
	public static final int DREIVIERTELH = 75;
	public static final int HALBH = 50;
	public static final int EINVIERTELH = 25;
	public static final int LEERH = 0;

	public static final int VOLLR = 50;
	public static final int HALBR = 25;
	public static final int LEERR = 0;

	public static final int VOLLM = 2;
	public static final int HALBM = 1;
	public static final int LEERM = 0;

	public static final int VOLLL = 3;
	public static final int ZWEIDRITTELL = 2;
	public static final int EINDRITTELL = 1;
	public static final int LEERL = 0;

	public static final int NULL = 0;
	public static final int EINS = 1;
	public static final int ZWEI = 2;

	public static final int GOLD0 = 0;
	public static final int GOLD50 = 50;
	public static final int GOLD100 = 100;
	public static final int GOLD150 = 150;
	public static final int GOLD200 = 200;
	public static final int GOLD250 = 250;
	public static final int GOLD300 = 300;
	public static final int GOLD350 = 350;

	/**
	 * privater Konstruktor, der verhindert, dass von außen ein Exemplar dieser
	 * Klasse gebildet werden kann
	 */
	private Konstanten() {
		// nothing to do here
	}
}
