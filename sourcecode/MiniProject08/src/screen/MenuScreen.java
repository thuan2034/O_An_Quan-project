package screen;

import java.io.IOException;

import javafx.application.Application;
import javafx.beans.value.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;

public class MenuScreen extends Application{

	public static final double WIDTH = 1100;
	public static final double HEIGHT = 700;
	
	public static double width, height;
	
	@Override
	public void start(Stage stage) throws Exception {
		try {
			
			Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));

			setScene(stage, root, WIDTH, HEIGHT);
			stage.show();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void quit(Stage stage) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Quit");
        alert.setHeaderText("You're about to quit");
        alert.setContentText("Do you want this ?");
        if (alert.showAndWait().get()== ButtonType.OK){
        	stage.close();
        }
	}
	
	 public static void setScene(Stage stage, Parent root, double w, double h) throws IOException {
   	  stage.setMinWidth(150.0);
			stage.setMinHeight(150.0);
			if(w!=WIDTH && h != HEIGHT) w-=15; h-=37;
			Scene scene = new Scene(root, w, h);

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
			stage.setOnCloseRequest(event -> {
				event.consume();
				quit(stage);
			});

     }
	
	public static void main (String[] arg) {
		launch(arg);
	}

}
