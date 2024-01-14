package match;

import java.util.ArrayList;
import boardgame.BoardGame;
import exception.*;
import javafx.beans.property.SimpleIntegerProperty;
import player.Player;
import squares.*;

public class Match {
    private ArrayList<Player> player = new ArrayList<Player>();
    private SimpleIntegerProperty turn = new SimpleIntegerProperty(0);
    private int direction;
    private BoardGame board = new BoardGame();
    private int gemInHand;
    private int squareId;
    
    public Match() {
		initPlayer();
	}  
    
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
    
    public Squares getSquare(int id) {
		return board.getSquare(id);
	}
    
    public void selectSquare(int id) {   
    	squareId = id;
  	}
    
  	public void selectDirection(int direction) {
  		this.direction = direction;
  	}
	
	//khởi tạo player
	public void initPlayer() {
		player.add(new Player(1));
		player.add(new Player(2));
	}
	
	//lấy ra gem trong Normal Square để rải đá
	public void getGemsInSquare(int squareId) {
		try {
			NormalSquare square=(NormalSquare) board.getSquare(squareId);
			gemInHand = square.getNumberOfSmallGems();		
			square.resetNumberOfGems();
		}catch(ClassCastException e) {
			
		}
	}
	
	//reset số lượng đá trong Square sau khi ăn điểm
	public void resetNumberOfGem(int squareId) {
		board.getSquare(squareId).resetNumberOfGems();
		
	}
	
	public void spreadGems(int squareId) {
		board.getSquare(squareId).spreadGems();
	}
	
	public void stopSpreadGem(int squareId) throws Exception {
		
		//stop true 		//ô liền cuối là ô Quan
		if(board.getSquare(squareId) instanceof HalfCircle) throw new StopSpreadGemException();	
		if(board.getSquare(squareId).getPoint()==0 && board.getSquare(convertSquareId(squareId+direction)).getPoint()==0 )
			throw new StopSpreadGemException(); //2 ô trống liền kề
		
		//stop false		//ô liền cuối có Dân
	    if(board.getSquare(squareId).getPoint()!=0) throw new ContinueSpreadGemException();			

	    //Ô liền cuối trống
	    throw new GetPointException(); //player get point
	}
	
	public void getPoint(int squareId, int playerId) {
		try {
			int pointEarn=board.getSquare(squareId).getPoint();
			player.get(playerId-1).increScore(pointEarn);
		
			resetNumberOfGem(squareId);
		}catch(IndexOutOfBoundsException e) {
			
		}
		
	}
	
	public int convertSquareId(int id) {
		if(id==12) return 0;
		if(id==-1)  return 11;
		return id;
	}
	
	public boolean rowNoGem(int turn) { 
		return board.rowNoSmallGem(turn);
	}
	
	boolean decre = false;
	
	public void decrePlayerScore(int turn) {
		if(!decre) {
			player.get(turn-1).decreScore(5);
			decre = true;
		}
	}
	
	public boolean stopMatch() {
		return board.rowNoBigGem();
	}
	
	public void newTurn(int turn) {
		this.turn.set(turn); 
	}
	
	public void newTurn() {
		decre = false;
		if(turn.get()==1)
			turn.set(2); 
		else turn.set(1);
	}
	
	public void resetBoard() {
		board.resetBoard();	//reset board
		player.clear();		//reset player
	}
	
	public void initBoard() throws HaveBoardInGameException {
		try {
			board.initBoard();	//khởi tạo board
			initPlayer();		//khởi tạo player
		} catch (HaveBoardInGameException e) {
			throw e;
		}	
	}
}