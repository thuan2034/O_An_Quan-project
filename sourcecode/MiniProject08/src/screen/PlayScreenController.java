package screen;



import boardgame.BoardGame;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;
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
	private boolean player1, player2;
	
	private int scissor = 1, paper = 2, rock = 3;
	private BoardGame board = new BoardGame();
	@FXML
	private void initialize() {
		for(int i=1; i<=5; i++) {
			hBox1.getChildren().add(new NormalSquareScreen( (NormalSquare) board.getSquare(i)));
			hBox2.getChildren().add(new NormalSquareScreen( (NormalSquare) board.getSquare(i+6)));
		}
		
		hfCircleAncPane0.getChildren().add(new HalfCircleScreen( (HalfCircle) board.getSquare(0)));
		hfCircleAncPane6.getChildren().add(new HalfCircleScreen( (HalfCircle) board.getSquare(6)));
		
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
