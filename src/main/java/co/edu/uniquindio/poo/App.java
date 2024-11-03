package co.edu.uniquindio.poo;

import java.io.IOException;

import co.edu.uniquindio.poo.controller.reservaController;
import co.edu.uniquindio.poo.viewController.reservaViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        try {
            // Asegúrate de que la ruta al archivo FXML es correcta
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/reserva.fxml"));
            Scene scene = new Scene(loader.load());

            reservaViewController controller = loader.getController();
            controller.setApp(this); // Inyecta la referencia de App en el controlador

            primaryStage.setTitle("Sistema de Reservas");
            primaryStage.setScene(scene);
            primaryStage.setResizable(false); // Para no permitir redimensionar la ventana
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace(); // Imprime el error en la consola
            System.err.println("Error al cargar la interfaz: " + e.getMessage());
        }
    }

    

    public static void main(String[] args) {
        launch(args);
    }
}