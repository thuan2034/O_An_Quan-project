package screen;

import java.io.IOException;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;

public class MenuScreenController { 
	public static final double WIDTH = 1100;
	public static final double HEIGHT = 700;
	
	public static double width, height;
    @FXML
    private Button playBtn;

    @FXML
    private Button ruleBtn;

    @FXML
    private Button quitBtn;
	@FXML
	AnchorPane rootAnchorPane;
	@FXML
	AnchorPane playAnchorPane;
	
	public MenuScreenController() {	
		
	}
		
	@FXML		
		private void initialize() {
			
		}
		
	      
	      private void setScene(Stage stage, String fxml) throws IOException {
	    	  stage.setMinWidth(150.0);
				stage.setMinHeight(150.0);
				
				Parent root = FXMLLoader.load(getClass().getResource(fxml));

				Scene scene = new Scene(root, WIDTH, HEIGHT);

				width = scene.getWidth()/600.0;
				height = scene.getHeight()/400.0;
				
				Scale scale = new Scale(width, height, 0, 0);
				
				
				scene.widthProperty().addListener(new ChangeListener<Number>() {
					@Override
					public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
						width = scene.getWidth()/600.0;
						if(width>1) scale.setX(width);
						
					}
					
				});
				
				scene.heightProperty().addListener(new ChangeListener<Number>() {
					@Override
					public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
						height = scene.getHeight()/400.0;
						if(height>1) scale.setY(height);
					}
					
				});

				scene.getRoot().getTransforms().setAll(scale);
				stage.setScene(scene);
	      }
}
