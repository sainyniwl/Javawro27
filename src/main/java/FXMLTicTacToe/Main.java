package FXMLTikTakToe;

import FXMLTicTacToe.TicTacToeController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("\\FXML\\TicTacToe.fxml"));
        GridPane gridPane = loader.load();
        TicTacToeController controller = loader.getController();
        Scene scene = new Scene(gridPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("TIK TAK TOE");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}