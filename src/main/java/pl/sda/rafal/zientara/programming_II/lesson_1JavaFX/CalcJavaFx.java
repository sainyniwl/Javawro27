package pl.sda.rafal.zientara.programming_II.lesson_1JavaFX;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CalcJavaFx extends Application {

    //metoda do wyświetlania pliku calc.fxml który został utworzony w programie JavaFX Scene Builder

    //skrawek kodu do kopiowania
        @Override
        public void start(Stage primaryStage) throws Exception { // pierwsze okno - Stage, w jednym stage może być kilka różnych Scene
            Parent root = FXMLLoader.load(getClass() //czytanie z pliku fxml
                    .getResource("/calc.fxml"));
            primaryStage.setTitle("Calc");
            Scene scene = new Scene(root, primaryStage.getWidth(), // zawartość okna
                    primaryStage.getHeight());
            primaryStage.setScene(scene);
            primaryStage.show();
        }
        public static void main(String[] args) {
            launch(args); // metoda publiczna
        }
    }




