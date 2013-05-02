
//package pa_eingabe;					//Paketdefinition
//import java.util.Scanner;			// externe Java-Klasse fuer Einlesen der Tastatureingabe
//import java.util.ArrayList;			// externe Java-Klasse fuer ArrayList (Array dynamisch vergroessern/verkleinern

public class Dungeon {

	
	public static void main(String[] args) {
		//		Scanner input = new Scanner(System.in);		//Tastatureingabe nutzen
		feld1();
		//		input.close();			//Tastatureingabe beenden
	}
	
	public static void feld1() {
		int [][] feld1 = {{ 1,1,1,1,1,1},{1,0,0,0,0,1},{1,2,0,0,0,1},{1,0,0,0,0,3},{1,0,0,0,0,1},{ 1,1,1,1,1,1}} ;
		
		for (int i = 0; i < feld1.length; i++) {	
		    for (int j = 0; j < feld1[i].length; j++) {								//zu unterscheiden: feld1=Methode + Array
		        System.out.print(feld1[i][j] + "\t");				
		    }
		System.out.println("");
		}
	}


}
