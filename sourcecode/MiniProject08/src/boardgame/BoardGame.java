package boardgame;

import java.util.ArrayList;
import gem.BigGem;
import gem.SmallGem;
import squares.*;

public class BoardGame {
	private ArrayList<Squares> boardgame = new ArrayList<Squares>();
	private int playerId = 0;
	//which player is playing
	
	public BoardGame() {
		//prepare gems to play
		HalfCircle halfCircle0 = new HalfCircle(0);
		HalfCircle halfCircle6 = new HalfCircle(6);
		NormalSquare normalSquare1 = new NormalSquare(1);
		NormalSquare normalSquare2 = new NormalSquare(2);
		NormalSquare normalSquare3 = new NormalSquare(3);
		NormalSquare normalSquare4 = new NormalSquare(4);
		NormalSquare normalSquare5 = new NormalSquare(5);
		NormalSquare normalSquare7 = new NormalSquare(7);
		NormalSquare normalSquare8 = new NormalSquare(8);
		NormalSquare normalSquare9 = new NormalSquare(9);
		NormalSquare normalSquare10 = new NormalSquare(10);
		NormalSquare normalSquare11 = new NormalSquare(11);
		boardgame.add(halfCircle0);
		boardgame.add(normalSquare1);
		boardgame.add(normalSquare2);
		boardgame.add(normalSquare3);
		boardgame.add(normalSquare4);
		boardgame.add(normalSquare5);
		boardgame.add(halfCircle6);
		boardgame.add(normalSquare7);
		boardgame.add(normalSquare8);
		boardgame.add(normalSquare9);
		boardgame.add(normalSquare10);
		boardgame.add(normalSquare11);
		
		BigGem bigGem = new BigGem();
		boardgame.get(0).addGem(bigGem);
		boardgame.get(6).addGem(bigGem);
		SmallGem smallGem = new SmallGem();
		
		for (int i = 1; i <= 5; i++) {
			normalSquare1.addGem(smallGem);
			normalSquare2.addGem(smallGem);
			normalSquare3.addGem(smallGem);
			normalSquare4.addGem(smallGem);
			normalSquare5.addGem(smallGem);
			normalSquare7.addGem(smallGem);
			normalSquare8.addGem(smallGem);
			normalSquare9.addGem(smallGem);
			normalSquare10.addGem(smallGem);
			normalSquare11.addGem(smallGem);
		}
		
        setInitialPlayerId();

	}
	
	public Squares getSquare(int id) {
		while (id < 0) {
			id += 12;
		}
		while (id >= 12) {
			id -= 12;
		}
		return boardgame.get(id);
	}

    private void setInitialPlayerId() {
        // Check square indices to set the initial playerId
        int squareIndex = 1; // Start from the first normal square index

        while (squareIndex <= 5) {
            if (boardgame.get(squareIndex) instanceof NormalSquare) {
                playerId = 1; // Set playerId to 1 if the index is between 1 and 5
              
            }
            squareIndex++;
        }

        squareIndex = 7; // Start from the seventh normal square index

        while (squareIndex <= 11) {
            if (boardgame.get(squareIndex) instanceof NormalSquare) {
                playerId = 2; // Set playerId to 2 if the index is between 7 and 11
            
            }
            squareIndex++;
        }
    }
    
    
	public void print() {
		for (Squares square: boardgame) {
			
			System.out.println("Square " + boardgame.indexOf(square) + ":" + square.getPoint());
		}
	}
}