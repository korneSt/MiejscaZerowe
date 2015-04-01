import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.text.Text;

/**
 * Created by Kornel on 2015-03-31.
 */
public class Main extends Application {

    @FXML private Text wynikObliczen;
    @FXML private TextField zmiennaA;
    @FXML private TextField zmiennaB;
    @FXML private TextField zmiennaC;
    @FXML protected void handleObliczButtonAction(ActionEvent event){
        Wynik.wykonaj(zmiennaA, zmiennaB, zmiennaC, wynikObliczen);
    }

    Stage windows;
    public static void main(String[] args){launch(args);}

    @Override
    public void start(Stage primaryStage) throws Exception {
        windows = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("style.fxml"));
        windows.setTitle("Miejsca zerowe");

        Scene scene = new Scene(root,400,400);
        windows.setScene(scene);
        windows.show();

        windows.setOnCloseRequest(e -> {
            e.consume();
            closeProgram();
        });
    }

    private void closeProgram() {
        Boolean answer = ConfirmBox.display("Zamknij", "");
        if (answer) {
            windows.close();
        }
    }
}

