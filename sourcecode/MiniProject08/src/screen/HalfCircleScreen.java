package screen;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import squares.HalfCircle;

public class HalfCircleScreen extends AnchorPane implements SquareInterface{
	private Arc arc = new Arc();
	private Label point = new Label();
	private VBox vbox = new VBox();
	private FlowPane flowPane = new FlowPane();
	private HalfCircle hfC = new HalfCircle();
	
	public HalfCircleScreen(HalfCircle hfC) {
		Group group = new Group();
		this.hfC = hfC;
		
		arc.setLength(180.0);
		arc.setRadiusX(75);
		arc.setRadiusY(77);
		arc.setFill(Color.rgb(205, 161, 128));
		arc.setStrokeWidth(5);
    	arc.setStroke(Color.rgb(102, 66, 40));
    	arc.setType(ArcType.ROUND);
    	
    	if(hfC.getId()==0) {
			arc.setStartAngle(90.0);
			point.setTranslateX(-68); point.setTranslateY(-10);
			flowPane.setTranslateX(-50); flowPane.setTranslateY(-40);
		}
		else if(hfC.getId()==6){
			arc.setStartAngle(270.0);
			point.setTranslateX(54); point.setTranslateY(-10);
			flowPane.setTranslateX(5); flowPane.setTranslateY(-40);
			flowPane.setAlignment(Pos.TOP_RIGHT);
		}
    	
    	point.setFont(Font.font("System", FontWeight.BOLD, 15));
    	point.setTextFill(Color.rgb(102, 66, 40));   
    	point.setText(""+hfC.getPoint());
    
    	flowPane.setPrefWidth(40.0);
    	flowPane.setPrefHeight(75.0);	
    	flowPane.setHgap(1); flowPane.setVgap(1);
    	
    	flowPane.getChildren().add(new Circle(8.0));

    	group.getChildren().add(arc);
    	group.getChildren().add(point);
    	group.getChildren().add(flowPane);
    	
    	vbox.setAlignment(Pos.CENTER);
    	vbox.setPrefSize(75.0, 200.0);
    	vbox.getChildren().add(group);
    	
    	this.getChildren().add(vbox);
	}
	
	@Override
	public void resetAfterGetG() {
		flowPane.getChildren().clear();
		point.setText(""+hfC.getPoint());
    }
	
	@Override
	public void spreadGems() {
		if(hfC.getId()==0) {
			flowPane.getChildren().add(new Circle(4.0));
		}
		else if(hfC.getId()==6) {
			flowPane.getChildren().add(0, new Circle(4.0));
		}
		point.setText(""+hfC.getPoint());
    }
	
	@Override
	public void isSpreaded() {
	    arc.setFill(Color.rgb(139, 90, 54));
		point.setTextFill(Color.WHITE);
	}
	 
	@Override
	public void resetToDefault() {
	    arc.setFill(Color.rgb(205, 161, 128));
		point.setTextFill(Color.rgb(102, 66, 40));
	}

}
