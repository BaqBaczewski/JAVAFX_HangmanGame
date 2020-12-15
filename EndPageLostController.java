package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.text.TabExpander;

public class EndPageLostController {
// Event for Button "Play Again" - returning to TitleScreen
    @FXML
    public void playAgain (ActionEvent event) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("TitleScreen.fxml"));
        Parent TitleScreenLayout = loader.load();
        TitleScreenController TitleScreenController = loader.<TitleScreenController>getController();
//        Stage TitleScreenStage = new Stage();
        Main.primaryStage.setScene(new Scene(TitleScreenLayout, 620, 430));
//        TitleScreenStage.showAndWait();

    }
}
