package controller;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import screen.MenuScreen;
import javafx.fxml.FXMLLoader;

public class MenuScreenController {

	@FXML
    private Button quitBtn;

    @FXML
    private Button playBtn;

    @FXML
    private Button ruleBtn;

    @FXML
    void playBtnClicked(MouseEvent event) throws IOException {
 
        Stage stage = (Stage) playBtn.getScene().getWindow();
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/screen/play.fxml"));
        
        double height = playBtn.getScene().getWindow().getHeight();
        double width = playBtn.getScene().getWindow().getWidth();
        
        MenuScreen.setScene(stage, loader.load(), width, height);
        stage.show();
    }

    @FXML
    void ruleBtnClicked(MouseEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/screen/rule.fxml"));
        Parent ruleScreen = loader.load();
        
        double height = ruleBtn.getScene().getWindow().getHeight()-15;
        double width = ruleBtn.getScene().getWindow().getWidth()-37;
 
        Scene ruleScene = new Scene(ruleScreen, width, height);

        Stage stage = (Stage) ruleBtn.getScene().getWindow();

        stage.setScene(ruleScene);
        stage.show();
    }
   

    @FXML
    void quitBtnClicked(MouseEvent event) {
    	 Alert alert = new Alert(AlertType.CONFIRMATION);
         alert.setTitle("Quit");
         alert.setHeaderText("You're about to quit");
         alert.setContentText("Do you want this ?");
         if (alert.showAndWait().get()== ButtonType.OK){
         Stage stage = (Stage) quitBtn.getScene().getWindow();
         stage.close();
         }
    }
}
