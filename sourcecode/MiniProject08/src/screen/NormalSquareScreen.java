package screen;

import boardgame.BoardGame;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.*;
import squares.NormalSquare;

public class NormalSquareScreen extends AnchorPane{
    private Rectangle rec = new Rectangle();
    private Label label = new Label();
    private AnchorPane squareAnchorPane = new AnchorPane();
    private AnchorPane lrPane = new AnchorPane();
    private FlowPane squarePane = new FlowPane();
    private VBox vbox = new VBox();
    private VBox vboxSquare = new VBox();
    private HBox hbox = new HBox();
    private ImageView imaVLeft = new ImageView(new Image(getClass().getResourceAsStream("lrArrow.png")));
    private ImageView imaVRight = new ImageView(new Image(getClass().getResourceAsStream("lrArrow.png")));
    private NormalSquare square = new NormalSquare();
    
    public NormalSquareScreen(NormalSquare square) {
    	this.square = square;
    	
    	rec.setWidth(73);
    	rec.setHeight(73);
    	rec.setFill(Color.rgb(205, 161, 128));
    	rec.setStrokeWidth(5);
    	rec.setStroke(Color.rgb(102, 66, 40));
    	
    	label.setFont(Font.font("System", FontWeight.BOLD, 15));
    	label.setTextFill(Color.rgb(102, 66, 40));
    	int n = square.getNumberOfSmallGems();
    	label.setText(""+n);
    	
    	squarePane.setPrefWidth(60.0);
    	squarePane.setPrefHeight(60.0);
    	for(int i=0; i<n; i++) {
    		squarePane.getChildren().add(new Circle(3.0));
    	}
    	vboxSquare.getChildren().add(squarePane);
    	vboxSquare.getChildren().add(label);
    	vboxSquare.setAlignment(Pos.CENTER);
    	vboxSquare.setMaxWidth(60.0);
    	vboxSquare.setMaxHeight(60.0);
    	//vboxSquare.setStyle ("-fx-background-color: blue");
    	
    	squareAnchorPane.setLeftAnchor(vboxSquare, 10.0);
    	squareAnchorPane.setRightAnchor(vboxSquare, 10.0);
    	squareAnchorPane.setTopAnchor(vboxSquare, 10.0);
    	squareAnchorPane.setBottomAnchor(vboxSquare, 5.0);
    	//squareAnchorPane.setStyle ("-fx-background-color: red");
    	squareAnchorPane.setPrefSize(73.0, 73.0);
    	squareAnchorPane.getChildren().add(rec);
    	squareAnchorPane.getChildren().add(vboxSquare);
    	squareAnchorPane.setCursor(Cursor.HAND);
    	squareAnchorPane.setOnMouseClicked(event -> {
    		rec.setFill(Color.rgb(139, 90, 54));
    		label.setTextFill(Color.WHITE);
    	});
    	
    	imaVLeft.setCursor(Cursor.HAND);
    	imaVLeft.setFitWidth(25.0);
    	imaVLeft.setFitHeight(20.0);
    	
    	imaVRight.setCursor(Cursor.HAND);
    	imaVRight.setRotate(180.0);
    	imaVRight.setFitWidth(25.0);
    	imaVRight.setFitHeight(20.0);
    	
    	hbox.getChildren().add(imaVLeft);
    	hbox.getChildren().add(imaVRight);
    	hbox.setAlignment(Pos.CENTER);
    	hbox.setSpacing(15.0);
    	
    	lrPane.getChildren().add(hbox);
    	lrPane.setVisible(false);
    	
    	if(square.getId() == 1) {
    		vbox.getChildren().add(squareAnchorPane);
    		vbox.getChildren().add(lrPane);
    	}
    	else if(square.getId() == 2) {
    		vbox.getChildren().add(lrPane);
    		vbox.getChildren().add(squareAnchorPane);	
    	}
    	
    	this.getChildren().add(vbox);
    	this.setOnMouseEntered(event -> {
    		lrPane.setVisible(true);
    	});
    	this.setOnMouseExited(event -> {
    		lrPane.setVisible(false);
    	});
    	
    }
}
