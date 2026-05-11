package org.example.gym_poo;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import org.example.gym_poo.models.Cliente;
import org.example.gym_poo.models.Gym;
import org.example.gym_poo.service.ClienteService;

import java.io.IOException;
import java.util.ArrayList;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/org/example/gym_poo/views/MainView.fxml"));
        Scene scene = new Scene(root);

        stage.setScene(scene);
        // Tamaño fijo
        stage.setWidth(1600);
        stage.setHeight(800);

        // Bloquear redimensionamiento
        stage.setResizable(false);

        // Centrar en pantalla
        stage.centerOnScreen();
        stage.show();
    }

    public static void main(String[] args) {

        launch();
    }
}