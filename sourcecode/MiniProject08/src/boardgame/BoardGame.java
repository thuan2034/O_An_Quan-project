package boardgame;

import java.util.ArrayList;
import squares.*;

public class BoardGame {
	private ArrayList<Squares> row = new ArrayList<Squares>();
	
	public BoardGame() {
		//prepare gems to play
		HalfCircle halfCircle1 = new HalfCircle(1);
		HalfCircle halfCircle7 = new HalfCircle(7);
		NormalSquare normalSquare2 = new NormalSquare(2);
		NormalSquare normalSquare3 = new NormalSquare(3);
		NormalSquare normalSquare4 = new NormalSquare(4);
		NormalSquare normalSquare5 = new NormalSquare(5);
		NormalSquare normalSquare6 = new NormalSquare(6);
		NormalSquare normalSquare8 = new NormalSquare(8);
		NormalSquare normalSquare9 = new NormalSquare(9);
		NormalSquare normalSquare10 = new NormalSquare(10);
		NormalSquare normalSquare11 = new NormalSquare(11);
		NormalSquare normalSquare12 = new NormalSquare(12);
		row.add(halfCircle1);
		row.add(normalSquare2);
		row.add(normalSquare3);
		row.add(normalSquare4);
		row.add(normalSquare5);
		row.add(normalSquare6);
		row.add(halfCircle7);
		row.add(normalSquare8);
		row.add(normalSquare9);
		row.add(normalSquare10);
		row.add(normalSquare11);
		row.add(normalSquare12);

	}
	
	

	public boolean rowNoSmallGem(int turn) {
		if (turn == 1) {
			int sum=0;
			for (int i=2; i<=6; ++i) {
				sum+=row.get(i).getPoint();
			}
			if (sum==0) return true;
		}
		else {
			
		int sum=0;
		for (int i=8; i<=12; ++i) {
			sum+=row.get(i).getPoint();
		}
		if (sum==0) return true;
		}
		return false;
	}
    
    public boolean rowNoBigGem() {
    	if ((row.get(1).getPoint()==0) && (row.get(7).getPoint()==0))
    		return true;
    	return false;
    }
    
    public Squares getSquare(int id) {
    	return row.get(id);
    }
}