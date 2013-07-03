package game;

/** ist für den jeweiligen Raum zuständig. das Spielfeld wird erstellt */
public class Spielfeld extends Spiel {

	/** Deklaration eines GameObject Arrays */
	public final GameObject[][] feld;

	/**
	 * erstellt ein Array feld, das nur aus GameObjects bestehen kann für jeden
	 * case wird ein Objekt der jeweiligen Klasse erstellt, welches den case
	 * überschreibt
	 * 
	 * @param feld
	 * @throws SpielfeldException
	 */
	public Spielfeld(Integer[][] feld) throws SpielfeldException {
		this.feld = new GameObject[Konstanten.SPALTEN][Konstanten.ZEILEN];

		for (int x = 0; x < Konstanten.SPALTEN; x++) {
			for (int y = 0; y < Konstanten.ZEILEN; y++) {
				GameObject gameObject;
				switch (feld[x][y]) {
				case Konstanten.RASEN:
					gameObject = new Rasen();
					break;
				case Konstanten.GRENZE:
					gameObject = new Grenze();
					break;
				case Konstanten.PUDEL:
					gameObject = new Spieler(x, y);
					break;
				case Konstanten.GEGNER:
					gameObject = new Gegner();
					break;
				case Konstanten.FALLE:
					gameObject = new Falle();
					break;
				case Konstanten.WEITER:
					gameObject = new Weiter();
					break;
				case Konstanten.BOSS:
					gameObject = new Bossgegner();
					break;
				case Konstanten.ZURUECK:
					gameObject = new Zurueck();
					break;
				case Konstanten.CARLOS:
					gameObject = new Carlos();
					break;
				case Konstanten.CUPCAKE:
					gameObject = new Ziel();
					break;
				case Konstanten.HUETTE:
					gameObject = new Huette();
					break;
				case Konstanten.WAFFE:
					gameObject = new Brille();
					break;
				case Konstanten.GOLD:
					gameObject = new Gold();
					break;
				case Konstanten.MANA:
					gameObject = new Mana();
					break;
				case Konstanten.HEALTH:
					gameObject = new Health();
					break;
				case Konstanten.RUESTUNG:
					gameObject = new Ruestung();
					break;
				case Konstanten.CHECKPOINT:
					gameObject = new Checkpoint();
					break;
				case Konstanten.SCHWERT:
					gameObject = new Schwert();
					break;
				case Konstanten.SHOPMANA:
					gameObject = new Shopmana();
					break;
				case Konstanten.SHOPHEALTH:
					gameObject = new Shophealth();
					break;
				case Konstanten.SHOPRUESTUNG:
					gameObject = new Shopruestung();
					break;
				default:
					throw new SpielfeldException("Unbekannter GameObject Typ");
				}
				this.feld[x][y] = gameObject;
			}
		}
	}
}
