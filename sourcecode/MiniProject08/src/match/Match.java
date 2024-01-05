package match;

import java.util.ArrayList;
import java.util.Scanner;

import boardgame.BoardGame;
import javafx.beans.property.SimpleIntegerProperty;
import player.Player;
import squares.*;

public class Match {
	public static Scanner scanner = new Scanner(System.in);
    private ArrayList<Player> player = new ArrayList<Player>();
    private SimpleIntegerProperty turn = new SimpleIntegerProperty(0);
    private int direction;
    private BoardGame board = new BoardGame();
    private int gemInHand;
    private int squareId;
    
    public int getSquareId() {
    	return squareId;
    }
    public int getDirection() {
    	return direction;
    }
    public SimpleIntegerProperty getTurn() {
    	return turn;
    }
    public SimpleIntegerProperty getPlayerPoint(int id) {
    	return player.get(id-1).getScore();
    }
    public int getGemInHand() {
    	return gemInHand;
    }
	public Match() {
		initPlayer();
	}
	
	public void initPlayer() {
		Player player1= new Player(1);
		Player player2= new Player(2);
		player.add(player1);
		player.add(player2);
	}
	
	public void getGemsInSquare(int squareId) {
		NormalSquare square=(NormalSquare) board.getSquare(squareId);
		gemInHand = square.getNumberOfSmallGems();
		square.resetNumberOfGems();
	}
	
	public void getGemsToPoint(int squareId) {
		board.getSquare(squareId).resetNumberOfGems();
		
		if(squareId==6||squareId==0) {
			HalfCircle halfcircle = (HalfCircle) board.getSquare(squareId);
			halfcircle.resetNumberOfGems();
		}
	}
	
	public void spreadGems(int squareId) {
		board.getSquare(squareId).spreadGems();
	}
	
	public int stopSpreadGem(int squareId) {
		
		if(board.getSquare(squareId) instanceof HalfCircle) return -1;	//stop true 		//ô liền cuối là ô Quan
	    if(board.getSquare(squareId).getPoint()!=0) return 0;			//stop false		//ô liền cuối có Dân

	    if(board.getSquare(squareId).getPoint()==0 && board.getSquare(convertSquareId(squareId+direction)).getPoint()==0 ) return -1; //2 ô trống liền kề

	    //Ô liền cuối trống
	    return 1; //player get point
	}
	
	public void getPoint(int squareId, int playerId) {
		
		int pointEarn=board.getSquare(squareId).getPoint();
		if(playerId > 0) player.get(playerId-1).increScore(pointEarn);
	
		getGemsToPoint(squareId);
	}
	
	public int convertSquareId(int id) {
		if(id==12) return 0;
		if(id==-1)  return 11;
		return id;
	}
	public void selectSquare(int id) {   
	  squareId = id;
	}
	
	public boolean rowNoGem(int turn) { 
		if(board.rowNoSmallGem(turn)) player.get(turn-1).decreScore(5);
		return board.rowNoSmallGem(turn);
	}
	
	public void selectDirection(int choice) {
		 this.direction=choice;
	}
	public boolean stopMatch() {
		return board.rowNoBigGem();
	}
	public void newTurn(int turn) {
		this.turn.set(turn); 
	}
	public void newTurn() {
		if(turn.get()==1)
			turn.set(2); 
		else turn.set(1);
	}
	public void showResult() {
		System.out.println("");
		System.out.println("player 1 score: "+ player.get(0).getScore());
		System.out.println("player 2 score: "+ player.get(1).getScore());
	}
	public void begin() {
		while(true)
		{   System.out.println("************** Player 1 turn: **************");
		    if (board.rowNoSmallGem(turn.get())==true) {
		    	player.get(1).decreScore(5);
		    	for(int i=2;i<=6;i++) {
		    		board.getSquare(i).spreadGems();
		    	}
		    }
			//selectSquare();
			//selectDirection();
		    //spreadGems();//spreadGems(squareId, player.get(0));
			newTurn();
			showResult();
			squareId=0;
			if(stopMatch()==true) break;
			System.out.println("************** Player 2 turn: **************");
			 if (board.rowNoSmallGem(turn.get())==true) {
				 	player.get(1).decreScore(5);
			    	for(int i=8;i<=12;i++) {
			    		board.getSquare(i).spreadGems();
			    	}
			    }
			//selectSquare();
			//selectDirection();
			//spreadGems();//spreadGems(squareId, player.get(1));
			newTurn();
			showResult();
			squareId=0;
			if(stopMatch()==true) break;
			
		}
	}

	public BoardGame getBoard() {
		return board;
	}
	
	public void resetAndInitBoard() {
		board.resetBoard();
		board.initBoard();
		player.clear();
		initPlayer();
	}
	
		public static void main(String[] args) {
			Match match=new Match();
			match.begin();
		}

	}



