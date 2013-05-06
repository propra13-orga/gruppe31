package game;

import javax.swing.JPanel;

public class Dungeon extends JPanel {
	
	public static void main(String[] args) {
		
		feld1();
	}
	
	
	public static void feld1() {
		int [][] feld1 = {{ 1,1,1,1,1,1},{1,0,0,0,0,1},{1,2,0,0,0,1},{1,0,0,0,0,3},{1,0,0,0,0,1},{ 1,1,1,1,1,1}} ;
		
		for (int i = 0; i < feld1.length; i++) {	
		    for (int j = 0; j < feld1[i].length; j++) {
		        System.out.print(feld1[i][j] + "\t");				
		    }
		System.out.println("");
		}
	}


}
