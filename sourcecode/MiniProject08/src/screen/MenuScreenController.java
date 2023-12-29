package screen;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class MenuScreenController { 
	@FXML
	Button playBtn;
	@FXML
	AnchorPane rootAnchorPane;
	@FXML
	AnchorPane playAnchorPane;
	
	public MenuScreenController() {	  }
		@FXML		
		
		private void initialize() {

		}
		
	    @FXML
	    void playBtnClicked(ActionEvent event) {

	    }
	    
	    @FXML
	    void ruleBtnPressed(ActionEvent event) {
	    	Pane pane = new Pane();
	    	pane.getChildren().add(new Button("Bob"));
	    	pane.setVisible(true);
	    }
}
