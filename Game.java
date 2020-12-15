package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Game {
    // prameters
    private String secretWord;
    private String userWord;
    private int hangmanLives = 6;
//    private ArrayList initBody;

    public int getHangmanLives() {
        return hangmanLives;
    }

    public Game() {
        secretWord = getRandomWord();
        setPassword();
    }

    public String getSecretWord() {
        return secretWord;
    }

    public String getUserWord() {
        return userWord;
    }

    // hiding secretWord, using "-" to show how many letters are in the word
    public void setPassword() {

        char[] textArray = secretWord.toCharArray();
        char[] answers = new char[textArray.length];
        for (int i = 0; i < textArray.length; i++) {
            answers[i] = '-';

        }
        userWord = String.valueOf(answers);
    }
    // our WORD bank, containing words that are used by game
    static ArrayList<String> wordBank = new ArrayList<String>();

    public static String getRandomWord() {
        wordBank.add("COMPUTER");
        wordBank.add("DEVELOPER");
        wordBank.add("PROGRAMING");
        wordBank.add("QWERTY");

        Random randomNumGen = new Random();
        int randomWordIndex = randomNumGen.nextInt(wordBank.size()); // +0?

        return wordBank.get(randomWordIndex);
    }

    public static boolean[] checkArrayForMatches(String currentWord, char charToTest)//generates a boolean array in response to the user's guess against the current word
    {
//        String upperCaseCurrentWord = currentWord.toUpperCase();
//        char[] currentWordArray = upperCaseCurrentWord.toCharArray();
        char[] currentWordArray = currentWord.toCharArray();
        boolean[] returnArray = new boolean[currentWordArray.length];

        for (int x = 0; x < returnArray.length; x++) {
            char characterInArray = currentWordArray[x];
            if (characterInArray == charToTest) {
                returnArray[x] = true;
            } else {
                returnArray[x] = false;
            }
        }
        return returnArray;
    }

    public static boolean doesArrayContainATrue(boolean[] someBoolArray) {
        for (boolean x : someBoolArray) {
            if (x == true) {
                return true;
            }
        }
        return false;
    }

    public static boolean doesArrayContainUnderscores(char[] someCharArray) {
        for (char x : someCharArray) {
            if (x == '_') {
                return true;
            }
        }
        return false;
    }

    // method to check user selection with secretWord
    public String letterMatch(char letterClick) throws Exception {

        String newWord = "";
        boolean fail = true;
        for (int i = 0; i < secretWord.length(); i++) {
            if (secretWord.charAt(i) == letterClick) {
                newWord += secretWord.charAt(i);
                fail = false;
                if (newWord.equals(secretWord)) {
                    System.out.println("YOU WON");
                    youWon();
                }
            } else {
                newWord += userWord.charAt(i);
            }
        }

        if (fail == true) {
            hangmanLives--;
        }
        if (hangmanLives == 0) {
            System.out.println("GAME OVER - YOU ARE DEAD");
            gameOver();
        }
        userWord = newWord;
        System.out.println(hangmanLives);
        return newWord;

    }

    @FXML
    public void gameOver() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("EndPageLost.fxml"));
        Parent EndPageLostLayout = loader.load();
        EndPageLostController EndPageLostController = loader.<EndPageLostController>getController();
//        Stage EndPageLostStage = new Stage();

        Main.primaryStage.setTitle("YOU LOST");
        Main.primaryStage.setScene(new Scene(EndPageLostLayout, 620, 430));
//        EndPageLostStage.showAndWait();
    }

    @FXML
    public void youWon() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("EndPageWin.fxml"));
        Parent EndPageWinLayout = loader.load();
        EndPageWinController EndPageWinController = loader.<EndPageWinController>getController();
//        Stage EndPageWinStage = new Stage();
        Main.primaryStage.setTitle("YOU WON");
        Main.primaryStage.setScene(new Scene(EndPageWinLayout, 620, 430));
//        EndPageWinStage.showAndWait();
    }
}
