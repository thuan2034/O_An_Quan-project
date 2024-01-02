package screen;

import java.util.ArrayList;

import boardgame.BoardGame;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.shape.Rectangle;
import match.Match;
import squares.*;

public class PlayScreenController {
	@FXML
    private HBox hBox1;
	
	@FXML
    private HBox hBox2;
	 @FXML
	    private AnchorPane sprAnchorPane;

	    @FXML
	    private Rectangle recSPR1;

	    @FXML
	    private Rectangle recSPR2;

	    @FXML
	    private Rectangle recSPR3;

	    @FXML
	    private Rectangle recSPR4;

	    @FXML
	    private Rectangle recSPR5;

	    @FXML
	    private Rectangle recSPR6;

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
	    private Label player1PointLabel;
	    @FXML
	    private Label player2PointLabel;
	    
	private boolean player1, player2;
	
	private int scissor = 1, paper = 2, rock = 3;
	
	public static Match match = new Match();
	private BoardGame board = match.getBoard();
	
	private static ArrayList<AnchorPane> row = new ArrayList<>();
	
	@FXML
	private void initialize() {
		//set turn
		match.newTurn((int)(Math.random() * 2) + 1);
		
		//set player "Your turn"'s visible
		checkTurn();
		
		//set player's point
		player1PointLabel.setText(""+match.getPlayerPoint(1));
		player2PointLabel.setText(""+match.getPlayerPoint(2));
		
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
		
		for(int i = 0; i < 3; i++ ) {
		int rand = (int)(Math.random() * 3) + 1;
	       if (rand == 1){
	    	   imageView1.setImage(new Image(getClass().getResourceAsStream("scissor.png")));
	            } else if (rand == 2){
	            	imageView2.setImage(new Image(getClass().getResourceAsStream("paper.png")));  
	            } else if (rand == 3){
	            	imageView3.setImage(new Image(getClass().getResourceAsStream("rock.png")));
	            } 
		}
	}
	
	public static void resetToDefaultSquare() {
		for(int i=0; i < row.size(); i++) {
			if(row.get(i) instanceof NormalSquareScreen) {
				NormalSquareScreen squareScreen = (NormalSquareScreen) row.get(i);
				if( squareScreen.isClicked) {
					squareScreen.resetToDefault();
				}
			}
		}
	}
	
	public static void getGemsInSquare(int i) {
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
	
	public static void newTurn() {
		match.newTurn();
		//set lại cursor trong normalsquarescreen
		//set lại player point và turn
	}
	
	public void checkTurn() {
		if(match.getTurn() == 1) {
			player1TurnLabel.setVisible(true);
			player2TurnLabel.setVisible(false);
		}
		else if(match.getTurn() == 2) {
			player2TurnLabel.setVisible(true);
			player1TurnLabel.setVisible(false);
		}
	}
	
	public static void speardGems(int n) {
		//gọi speardGems trong match
		//for(0-n){
			//gọi speardGems trong normalsquarescreen
		//}
    }
	    @FXML
	    void recSPR1Pressed(MouseEvent event) {
	    	recSPR1.setVisible(false);
	    	player1 = true;
	    }

	    @FXML
	    void recSPR2Pressed(MouseEvent event) {
	    	recSPR2.setVisible(false);
	    	player1 = true;
	    }

	    @FXML
	    void recSPR3Pressed(MouseEvent event) {
	    	recSPR3.setVisible(false);
	    	player1 = true;
	    }

	    @FXML
	    void recSPR4Pressed(MouseEvent event) {
	    	recSPR4.setVisible(false);
	    	player2 = true;
	    }

	    @FXML
	    void recSPR5Pressed(MouseEvent event) {
	    	recSPR5.setVisible(false);
	    	player2 = true;
	    }

	    @FXML
	    void recSPR6Pressed(MouseEvent event) {
	    	recSPR6.setVisible(false);
	    	player2 = true;
	    }

}
