package pl.sda.rafal.zientara.programowanie2.lesson1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class HangmanJavaFx extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {

        Image image = new Image("Hangman.png");
        Parent root = FXMLLoader.load(getClass()
                .getResource("/hangman.fxml"));
        primaryStage.getIcons().add(image);
        primaryStage.setTitle("Hangman");
        Scene scene = new Scene(root, primaryStage.getWidth(),
                primaryStage.getHeight());
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}

