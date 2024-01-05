package boardgame;

import java.util.ArrayList;
import squares.*;

public class BoardGame {
	private ArrayList<Squares> row = new ArrayList<>();
	
	public BoardGame() {
		//prepare gems to play
		initBoard();
	}

	public boolean rowNoSmallGem(int turn) {
		if (turn == 1) {
			int sum=0;
			for (int i=1; i<=5; ++i) {
				sum+=row.get(i).getPoint();
			}
			if (sum==0) return true;
		}
		else if(turn == 2) {
			
		int sum=0;
		for (int i=7; i<=11; ++i) {
			sum+=row.get(i).getPoint();
		}
		if (sum==0) return true;
		}
		return false;
	}
    
    public boolean rowNoBigGem() {
    	if ((row.get(0).getPoint()==0) && (row.get(6).getPoint()==0))
    		return true;
    	return false;
    }
    
    public Squares getSquare(int id) {
    	return row.get(id);
    }
    
    public void resetBoard() {
    	row.clear();
    }
    
    public void initBoard() {
    	for (int i=0; i<12; i++){
			if (i == 0 || i == 6){
				row.add(new HalfCircle());
			}
			else row.add(new NormalSquare()); 
		}
    }
    
}