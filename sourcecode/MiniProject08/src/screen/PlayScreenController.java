package screen;

import java.util.ArrayList;



import boardgame.BoardGame;
import javafx.animation.PauseTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import match.Match;
import squares.*;

public class PlayScreenController {
	@FXML
    private HBox hBox1;
	@FXML
    private HBox hBox2;
	@FXML
    private AnchorPane sPRAncPane;

	    @FXML
	    private ImageView imageView1;
	    
	    @FXML
	    private ImageView imageView2;
	    
	    @FXML
	    private ImageView imageView3;

	    @FXML
	    private AnchorPane hfCircleAncPane0;

	    @FXML
	    private AnchorPane hfCircleAncPane6;

	    @FXML
	    private HBox boardHbox;
	    @FXML
	    private Label player1TurnLabel;
	    @FXML
	    private Label player2TurnLabel;
	    @FXML
	    private Label point1Label;
	    @FXML
	    private Label point2Label;
	    @FXML
	    private Label turnLabel;
	    @FXML
	    private Label winnerLabel;
	    @FXML
	    private Label winScore1;
	    @FXML
	    private Label winScore2;
	    @FXML
	    private AnchorPane pauseAncPane0;
	    @FXML
	    private AnchorPane pauseAncPane1;
	    @FXML
	    private AnchorPane playAncPane;
	    @FXML
	    private AnchorPane winAncPane1;
	    @FXML
	    private AnchorPane resultAncPane0;
	    @FXML
	    private AnchorPane turnAncPane;
	    @FXML
	    private HBox hboxSPR2;
	    @FXML
	    private HBox hboxSPR1;

	public static Match match = new Match();
	private BoardGame board = match.getBoard();
	
	private static ArrayList<AnchorPane> row = new ArrayList<>();
	
	@FXML
	private void initialize() {
		//set turn
		setTurn((int)(Math.random() * 2) + 1);
		
		//set boardgame
		row.add(new HalfCircleScreen( (HalfCircle) board.getSquare(0)));
		hfCircleAncPane0.getChildren().add(row.get(0));
		for(int i=1; i<=5; i++) {
			row.add(new NormalSquareScreen( (NormalSquare) board.getSquare(i)));
			hBox1.getChildren().add(row.get(i));
		}

		row.add(new HalfCircleScreen( (HalfCircle) board.getSquare(6)));
		hfCircleAncPane6.getChildren().add(row.get(6));
		for(int i=7; i<=11; i++) {
			row.add(new NormalSquareScreen( (NormalSquare) board.getSquare(i)));
			hBox2.getChildren().add(0, row.get(i));
		}	
		//set player "Your turn"'s visible
		newTurn();
		match.getTurn().addListener((observable, oldValue, newValue) -> {
			if(match.getTurn().get()!=0) newTurn();
			else {
				int winner=0;
				if(match.getPlayerPoint(1) > match.getPlayerPoint(2)) {
					winner = 1;
				}else if(match.getPlayerPoint(1) < match.getPlayerPoint(2)) {
					winner = 2;
				}else if(match.getPlayerPoint(1) == match.getPlayerPoint(2)) {
					winner = 0;
				}
				if(winner!=0) winnerLabel.setText("Player " + winner);
				else //
				winScore1.setText(""+match.getPlayerPoint(1));
				winScore2.setText(""+match.getPlayerPoint(2));
				
				playAncPane.setEffect(new GaussianBlur());
				resultAncPane0.setVisible(true);
			}
        });
		
		
		resultAncPane0.setBorder(new Border(new BorderStroke(Color.rgb(102, 66, 40), 
	            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(5.0))));
		
		pauseAncPane1.setBorder(new Border(new BorderStroke(Color.rgb(102, 66, 40), 
	            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(5.0))));
		
		//playAncPane.setEffect(new GaussianBlur());
		sPRAncPane.setVisible(false);
	}
	
	public void resetToDefaultSquare() {
		for(int i=0; i < row.size(); i++) {
			if(row.get(i) instanceof NormalSquareScreen) {
				NormalSquareScreen squareScreen = (NormalSquareScreen) row.get(i);
				if( squareScreen.isClicked) {
					squareScreen.resetToDefault();
				}
			}
		}
	}
	
	public void getGemsInSquare(int i) {
		if(row.get(i) instanceof NormalSquareScreen) {
			NormalSquareScreen squareScreen = (NormalSquareScreen) row.get(i);
				squareScreen.getGemsInSquare();
		}
		if(row.get(i) instanceof HalfCircleScreen) {
			HalfCircleScreen squareScreen = (HalfCircleScreen) row.get(i);
				squareScreen.getGemsInSquare();
		}
		//update player point
	}
	public void setTurn(int turn) {
		match.newTurn(turn);
	}
	public void turnAnnounce() {
		
		turnAncPane.setVisible(true);
		TranslateTransition translate = new TranslateTransition();
		translate.setNode(turnAncPane);
		translate.setDuration(Duration.millis(1500));
		translate.setFromX(-600);
		translate.setToX(0);
		translate.play();
		
		TranslateTransition translate2 = new TranslateTransition();
		translate2.setDelay(Duration.millis(1500));
		translate2.setNode(turnAncPane);
		translate2.setDuration(Duration.millis(1500));
		translate2.setFromX(0);
		translate2.setToX(600);
		translate2.play();
		
		translate2.setOnFinished(event -> {
			turnAncPane.setVisible(false);
		});
	}
	
	
	public void newTurn() {
		if(match.rowNoGem(match.getTurn().get()))
			spreadRowNoGem(match.getTurn().get());
		
		point1Label.setText(""+match.getPlayerPoint(1));
		point2Label.setText(""+match.getPlayerPoint(2));
		
		if(match.getTurn().get() == 1) {
			player1TurnLabel.setVisible(true);
			player2TurnLabel.setVisible(false);
			turnLabel.setText("PLAYER 1");	
		}  
		else if(match.getTurn().get() == 2) {
			player2TurnLabel.setVisible(true);
			player1TurnLabel.setVisible(false);
			turnLabel.setText("PLAYER 2");		
		}
		
		for(int i=1; i<=5; i++) {
			((NormalSquareScreen) row.get(i)).resetCursor();
		}
		for(int i=7; i<=11; i++) {
			((NormalSquareScreen) row.get(i)).resetCursor();
		}
		
		turnAnnounce();

	}
	
	public void speardGems() {
		int squareId = match.getSquareId();
		System.out.println(squareId);
		int direction = match.getDirection();
		
		System.out.println("Spread gems: ");
		
		for(int i=0; i<match.getGemInHand(); i++) {
			squareId += direction;
			squareId=convertSquareId(squareId);
			
			System.out.println(squareId);
			
			match.spreadGems(squareId);

			if(squareId == 0 || squareId == 6) {
				((HalfCircleScreen) row.get(squareId)).spreadGems();
			}else ((NormalSquareScreen) row.get(squareId)).spreadGems();
		}
		
		squareId+=direction;
		squareId=convertSquareId(squareId);
		
		System.out.print("Stop: ");
		System.out.println(squareId);
		
		if(match.stopSpreadGem(squareId)==0) {		//stop false
			((NormalSquareScreen) row.get(squareId)).getGemsInSquare();
		}
		else if(match.stopSpreadGem(squareId)==1) {//player get point
			
			squareId += direction;
			squareId=convertSquareId(squareId);
			match.getPoint(squareId);
			getGemsToPoint(squareId);
			System.out.print("Get: ");
			System.out.println(squareId);
			
			while (true){
				squareId+=direction;
				squareId=convertSquareId(squareId);
				squareId+=direction;
				squareId=convertSquareId(squareId);
				System.out.println("Stop" + squareId);
				if(board.getSquare(squareId).getPoint()==0)
					break;			//stop get point
				squareId-=direction;
				squareId=convertSquareId(squareId);
				
				if(board.getSquare(squareId).getPoint()!=0) break;		//stop true
				else 
				{
					squareId+=direction;
					squareId=convertSquareId(squareId);
					System.out.print(".Get: ");
					System.out.println(squareId);
					
					match.getPoint(squareId);//player get point
					getGemsToPoint(squareId);
				}
			}	
			if(!match.stopMatch()) match.newTurn();
			else setTurn(0);
		}else { 
			if(!match.stopMatch()) match.newTurn(); 
			else setTurn(0);
		}
    }
	
	public void spreadRowNoGem(int turn) {
		if(turn == 1) {
			for(int i=1; i<=5; i++) {
				match.spreadGems(i);
				((NormalSquareScreen) row.get(i)).spreadGems();
			}
		}  
		else if(turn == 2) {
			for(int i=7; i<=11; i++) {
				match.spreadGems(i);
				((NormalSquareScreen) row.get(i)).spreadGems();
			}	
		}
	}
	
	public void getGemsToPoint(int squareId) {
		match.getGemsToPoint(squareId);
		if(squareId == 0 || squareId == 6) {
			((HalfCircleScreen) row.get(squareId)).getGemsToPoint();
		}else {
			((NormalSquareScreen) row.get(squareId)).getGemsToPoint();
		}
	}

	public int convertSquareId(int squareId) {
		if(squareId==12) squareId = 0;
		if(squareId==-1)  squareId = 11;
		return squareId;
	}

}
