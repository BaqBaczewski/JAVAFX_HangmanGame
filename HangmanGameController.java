package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.control.*;
import javafx.scene.effect.Glow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.text.TabExpander;
import java.util.ArrayList;

public class HangmanGameController {
// parameters
    private Game hangmanGame;
    @FXML
    public Label password;
    @FXML
    public Circle head;
    @FXML
    private Line body;
    @FXML
    private Line rightArm;
    @FXML
    private Line rightLeg;
    @FXML
    private Line leftArm;
    @FXML
    private Line leftLeg;
    @FXML
    private ArrayList<Shape> bodyH;

// Event to run game sequence
    @FXML
    public void run(ActionEvent event) {
        hangmanGame = new Game();
        password.setText(hangmanGame.getUserWord());
        updateImage(6);
    }
// Event for selecting letter, change used letter to "-"
    @FXML
    public void letterClick(ActionEvent event) throws Exception {
        Button changeLetter = (Button) event.getSource();
        String newWords = hangmanGame.letterMatch(changeLetter.getText().charAt(0));
        password.setText(newWords);
        System.out.println(changeLetter.getText().charAt(0));         // for checking proper code actions
        System.out.println("Lives" + hangmanGame.getHangmanLives());  // for checking proper code actions
        updateImage(hangmanGame.getHangmanLives());
        changeLetter.setText("-"); // this line changing selected letter into "-"
    }
// update images for hangman body parts
    private void updateImage(int lives){
        if (lives == 6){

        }
        if (lives == 5 ){
            head.setVisible(true);
        }
        if (lives == 4){
            body.setVisible(true);
        }
        if (lives == 3) {
            rightArm.setVisible(true);
        }
        if (lives == 2) {
            rightLeg.setVisible(true);
        }
        if (lives == 1) {
            leftArm.setVisible(true);
        }
        if (lives == 0) {
            leftLeg.setVisible(true);
        }
    }

// setting visibility for body parts,
    @FXML
    public void initialize(){
        System.out.println("goodbye");
        head.setVisible(false);
        body.setVisible(false);
        leftArm.setVisible(false);
        rightArm.setVisible(false);
        leftLeg.setVisible(false);
        rightLeg.setVisible(false);
    }
}
