package controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import screen.MenuScreen;

public class RuleController {
    @FXML
    private Button ruleplayBtn;

    @FXML
    private Button backBtn;

    @FXML
    private void ruleplayBtnClicked(ActionEvent event) throws IOException {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/screen/play.fxml"));
            Parent playScreen = loader.load();
            
            double height = ruleplayBtn.getScene().getWindow().getHeight();
            double width = ruleplayBtn.getScene().getWindow().getWidth();

            Stage stage = (Stage) ruleplayBtn.getScene().getWindow();
            MenuScreen.setScene(stage, playScreen, width, height);
            stage.show();
            
    }
    @FXML
    private void backBtnClicked(ActionEvent event) throws IOException {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/screen/menu.fxml"));
            Parent menuScreen = loader.load();
         
            double height = backBtn.getScene().getWindow().getHeight();
            double width = backBtn.getScene().getWindow().getWidth();

            Stage stage = (Stage) backBtn.getScene().getWindow();
            MenuScreen.setScene(stage, menuScreen, width, height);
            stage.show();
            
    } 
}
