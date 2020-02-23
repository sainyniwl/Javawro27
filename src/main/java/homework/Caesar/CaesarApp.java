package homework.Caesar;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static javafx.application.Application.launch;
import static javafx.fxml.FXMLLoader.load;

public class CaesarApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = load(getClass()
                .getResource("/encryption.fxml"));
        primaryStage.setTitle("CeaserEncryption");
        Scene scene = new Scene(root, primaryStage.getWidth(),
                primaryStage.getHeight());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}