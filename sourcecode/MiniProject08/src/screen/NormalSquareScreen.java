package screen;

import controller.PlayScreenController;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import match.Match;
import squares.NormalSquare;

public class NormalSquareScreen extends AnchorPane implements SquareInterface{
    private Rectangle rec = new Rectangle();
    private Label point = new Label();
    private AnchorPane squareAnchorPane = new AnchorPane();
    private AnchorPane lrPane = new AnchorPane();
    private FlowPane squarePane = new FlowPane();
    private VBox vbox = new VBox();
    private VBox vboxSquare = new VBox();
    private HBox hbox = new HBox();
    private ImageView imaVLeft = new ImageView(new Image(getClass().getResourceAsStream("images\\lrArrow.png")));
    private ImageView imaVRight = new ImageView(new Image(getClass().getResourceAsStream("images\\lrArrow.png")));
    private NormalSquare square = new NormalSquare();
    private boolean isClicked = false;
    private Match match = PlayScreenController.match;
    private PlayScreenController playController = new PlayScreenController();
    private int numberOfSmallGem = 0;
    
    public NormalSquareScreen(NormalSquare square, PlayScreenController playController) {
    	this.square = square;
    
    	this.playController = playController;
    	
    	rec.setWidth(73);
    	rec.setHeight(73);
    	rec.setFill(Color.rgb(205, 161, 128));
    	rec.setStrokeWidth(5);
    	rec.setStroke(Color.rgb(102, 66, 40));
    	
    	point.setFont(Font.font("System", FontWeight.BOLD, 15));
    	point.setTextFill(Color.rgb(102, 66, 40));
    	point.setText(""+square.getPoint());
    	
    	squarePane.setPrefWidth(60.0);
    	squarePane.setPrefHeight(60.0);
    	squarePane.setHgap(0.5); squarePane.setVgap(0.5);
    	
    	for(int i=0; i<square.getNumberOfSmallGems(); i++) {
    		numberOfSmallGem++;
    		squarePane.getChildren().add(new Circle(4.0));
    	}
    	vboxSquare.getChildren().add(squarePane);
    	vboxSquare.getChildren().add(point);
    	vboxSquare.setAlignment(Pos.CENTER);
    	vboxSquare.setMaxWidth(60.0);
    	vboxSquare.setMaxHeight(60.0);
    	//vboxSquare.setStyle ("-fx-background-color: blue");
    	
    	squareAnchorPane.setLeftAnchor(vboxSquare, 10.0);
    	squareAnchorPane.setRightAnchor(vboxSquare, 10.0);
    	squareAnchorPane.setTopAnchor(vboxSquare, 10.0);
    	squareAnchorPane.setBottomAnchor(vboxSquare, 5.0);

    	resetCursor();
    	squareAnchorPane.setPrefSize(73.0, 73.0);
    	squareAnchorPane.getChildren().add(rec);
    	squareAnchorPane.getChildren().add(vboxSquare);
    	
    	squareAnchorPane.setOnMouseClicked(event -> {
        	if(squareAnchorPane.cursorProperty().getValue() == Cursor.HAND) {	
    		if(!isClicked) {
    			rec.setFill(Color.rgb(139, 90, 54));
    			point.setTextFill(Color.WHITE);
    			lrPane.setVisible(true);	
    			playController.resetToDefaultSquare();
    			isClicked = true;
    		}
    		else {
    			resetToDefault();
    		}
        	}
    	});

    	imaVLeft.setCursor(Cursor.HAND);
    	imaVLeft.setFitWidth(25.0);
    	imaVLeft.setFitHeight(20.0);
    	imaVLeft.setOnMouseClicked(event -> {
    		this.match.selectDirection(-1);
    		this.getGemsToSpreadG();
    	});
    	
    	imaVRight.setCursor(Cursor.HAND);
    	imaVRight.setRotate(180.0);
    	imaVRight.setFitWidth(25.0);
    	imaVRight.setFitHeight(20.0);
    	imaVRight.setOnMouseClicked(event -> {
    		this.match.selectDirection(1);
    		this.getGemsToSpreadG();
    	});
    	
    	hbox.getChildren().add(imaVLeft);
    	hbox.getChildren().add(imaVRight);
    	hbox.setAlignment(Pos.CENTER);
    	hbox.setSpacing(15.0);
    	
    	lrPane.getChildren().add(hbox);
    	lrPane.setVisible(false);
    	lrPane.setTranslateX(4);
    	
    	if(square.getId()>=1 && square.getId()<=5) {
    		vbox.getChildren().add(squareAnchorPane);
    		vbox.getChildren().add(lrPane);
    	}
    	else if(square.getId()>=7 && square.getId()<=11) {
    		vbox.getChildren().add(lrPane);
    		vbox.getChildren().add(squareAnchorPane);	
    		hbox.setRotate(180);
    	}
    	
    	this.getChildren().add(vbox);
    	
    }
    
    @Override
    public void resetToDefault() {
    	rec.setFill(Color.rgb(205, 161, 128));
		point.setTextFill(Color.rgb(102, 66, 40));
		lrPane.setVisible(false);
		isClicked = false;
    }
    
    @Override
    public void isSpreaded() {
    	rec.setFill(Color.rgb(139, 90, 54));
		point.setTextFill(Color.WHITE);
    }
    
    
    public void getGemsToSpreadG() {
    	match.selectSquare(square.getId());
    	match.getGemsInSquare(square.getId());
    	resetAfterGetG();
		resetToDefault();
		playController.speardGems();
    }
    
    public void resetCursor() {
    	if(square.getPoint() == 0) {
    		squareAnchorPane.setCursor(Cursor.DEFAULT);
    		return;
    	}
    	if(match.getTurn().get() == 1) {
    		if(this.square.getId() >=1 && this.square.getId() <= 5 ) {
    			squareAnchorPane.setCursor(Cursor.HAND);
    		}else squareAnchorPane.setCursor(Cursor.DEFAULT);
    	}else if(match.getTurn().get()  == 2) {
    		if(this.square.getId() >=7 && this.square.getId() <= 11 ) {
    			squareAnchorPane.setCursor(Cursor.HAND);
    		}else squareAnchorPane.setCursor(Cursor.DEFAULT);
    	}
    }
    
    @Override
    public void spreadGems() {
    	for(int i=0; i<square.getNumberOfSmallGems()-numberOfSmallGem; i++) {
    		squarePane.getChildren().add(new Circle(4.0));
    		numberOfSmallGem++;
    	}
    	point.setText(""+square.getPoint());
    }
    
    @Override
    public void resetAfterGetG() {
    	squarePane.getChildren().clear();
    	numberOfSmallGem=0;
    	point.setText(""+square.getPoint());
	}

	public boolean isClicked() {
		return isClicked;
	}
    
    
}
