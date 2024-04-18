package src.GUI.java;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class VentanaPrincipal extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Inicio de sesión");

        // Cargar la ventana de inicio de sesión desde el archivo FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("interfazLogin.fxml"));
        Parent root = loader.load();

        // Establecer la escena con la raíz cargada desde el archivo FXML
        Scene scene = new Scene(root, 500, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
