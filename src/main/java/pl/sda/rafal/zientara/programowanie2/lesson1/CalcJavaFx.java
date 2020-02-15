package pl.sda.rafal.zientara.programowanie2.lesson1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CalcJavaFx extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception { //stage to nasze okienko. W środku rozgrywa się cała akcja, czyli mamy scenę
        Parent root = FXMLLoader.load(getClass()  //wczytuje plik
                .getResource("/calc.fxml"));
        primaryStage.setTitle("Calc");
        Scene scene = new Scene(root, primaryStage.getWidth(), //ustaw scenę na podstawie elementów widoku
                primaryStage.getHeight());
        primaryStage.setScene(scene);
        primaryStage.show(); //pokaż
    }
    public static void main(String[] args) {
        launch(args);
    }

}
