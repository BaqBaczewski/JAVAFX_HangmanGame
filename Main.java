package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main extends Application {

    static ArrayList<String> wordBank = new ArrayList<String>();
    public static Stage primaryStage;

// initializing first stage (title screen)
    @Override
    public void start(Stage primaryStage) throws Exception{
        Main.primaryStage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("TitleScreen.fxml"));
        primaryStage.setTitle("Welcome to Hangman");
        primaryStage.setScene(new Scene(root, 620, 430));
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
