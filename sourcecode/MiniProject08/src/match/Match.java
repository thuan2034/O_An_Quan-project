package match;

import java.util.ArrayList;
import java.util.Scanner;

import boardgame.BoardGame;
import player.Player;
import squares.*;

public class Match {
	public static Scanner scanner = new Scanner(System.in);
    private ArrayList<Player> player = new ArrayList<Player>();
    private int turn=1;
    private int direction;
    private BoardGame board = new BoardGame();
    private int squareId=0;
	public Match() {
		Player player1= new Player(1);
		Player player2= new Player(2);
		player.add(player1);
		player.add(player2);
		}
	public void spreadGems(int id,int direction,Player player) {
		
		NormalSquare square=(NormalSquare) board.getSquare(id);
		int gemInHand = square.getNumberOfSmallGems();
		square.resetNumberOfGems();
		for(int i=1;i<=gemInHand;i++) {
		id+=direction;
		id=convertSquareId(id);
		System.out.print(id+" ");
		board.getSquare(id).spreadGems();
		}
		System.out.println("");
		if(stopSpreadGem(id,direction,player)==false) {
			id+=direction;
			id=convertSquareId(id);
			spreadGems(id,direction,player);};
	}
	    
	public boolean stopSpreadGem(int id,int direction,Player player) {
		id+=direction;
		id=convertSquareId(id);
		if(board.getSquare(id) instanceof HalfCircle) return true;
	    if(board.getSquare(id).getPoint()!=0) return false;
	    id-=direction;
	    id=convertSquareId(id);
		while (true){
		id+=2*direction;
		id=convertSquareId(id);
		if(board.getSquare(id).getPoint()==0)
			return true;
		id-=direction;
		id=convertSquareId(id);
		if(board.getSquare(id).getPoint()!=0)
		return true;
		else 
		{   id+=direction;
		    id=convertSquareId(id);
		    int pointEarn=board.getSquare(id).getPoint();
			player.increScore(pointEarn);
			board.getSquare(id).resetNumberOfGems();
			if(id==7||id==1) {
				HalfCircle halfcircle = (HalfCircle) board.getSquare(id);
				halfcircle.resetNumberOfGems();
			}
			System.out.println("Earn "+pointEarn+" points");
		}
		}	
	}
	public int convertSquareId(int id) {
		if(id==13) return 1;
		if(id==0)  return 12;
		return id;
	}
	public void selectSquare()
	{   do
		{System.out.println("Choose square: ");
		int choice = scanner.nextInt();
	     if(turn==1)
			{if(choice>1&&choice<7)
				{
					squareId=choice;
					if(board.getSquare(squareId).getPoint()==0)
					{
						System.out.println("Square empty, Pick again:");
						squareId=0;
					}
				}
			else System.out.println("Player 1 must pick a square from 2 - 6");  
			}
	     if(turn==2)
	     {
	    	 if(choice>7&&choice<13)
	    		 {squareId=choice;
	    		 if(board.getSquare(squareId).getPoint()==0)
					{
						System.out.println("Square empty, Pick again:");
						squareId=0;
					}
	    		 }
	    	 else System.out.println("Player 2 must pick a square from 8 - 12");
	     }
         
	     }while(squareId==0);
	    	 }
	public void selectDirection() {
		 System.out.println("Select direction: (1: phải |-1:trái)");
		 int choice = scanner.nextInt();
		 direction=choice;
	}
	public boolean stopMatch() {
		return board.rowNoBigGem();
	}
	public void newTurn() {
		if(turn==1)
			turn = 2;
		else turn = 1;
	}
	public void showResult() {
		System.out.println("");
		System.out.println("player 1 score: "+ player.get(0).getScore());
		System.out.println("player 2 score: "+ player.get(1).getScore());
	}
	public void begin() {
		while(true)
		{   System.out.println("************** Player 1 turn: **************");
		    if (board.rowNoSmallGem(turn)==true) {
		    	player.get(1).decreScore(5);
		    	for(int i=2;i<=6;i++) {
		    		board.getSquare(i).spreadGems();
		    	}
		    }
			selectSquare();
			selectDirection();
			spreadGems(squareId,direction,player.get(0));
			newTurn();
			showResult();
			squareId=0;
			if(stopMatch()==true) break;
			System.out.println("************** Player 2 turn: **************");
			 if (board.rowNoSmallGem(turn)==true) {
				 	player.get(1).decreScore(5);
			    	for(int i=8;i<=12;i++) {
			    		board.getSquare(i).spreadGems();
			    	}
			    }
			selectSquare();
			selectDirection();
			spreadGems(squareId,direction,player.get(1));
			newTurn();
			showResult();
			squareId=0;
			if(stopMatch()==true) break;
			
		}
	}


		public static void main(String[] args) {
			Match match=new Match();
			match.begin();
		}

	}



