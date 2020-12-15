package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EndPageWinController {
    // Event for Button "Play Again" - returning to TitleScreen
    @FXML
    public void playAgainWin (ActionEvent event) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("TitleScreen.fxml"));
        Parent TitleScreenLayout = loader.load();
        TitleScreenController TitleScreenController = loader.<TitleScreenController>getController();
//        Stage TitleScreenStage = new Stage();
        Main.primaryStage.setScene(new Scene(TitleScreenLayout, 620, 430));
//        Main.primaryStage.showAndWait();

    }
}
