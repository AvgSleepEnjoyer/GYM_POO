package org.example.gym_poo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import org.example.gym_poo.models.Cliente;
import org.example.gym_poo.service.ClienteService;

import java.io.IOException;
import java.util.ArrayList;

public class MainApp extends Application {

    private static ArrayList<Cliente> clientes;

    @Override
    public void start(Stage stage) throws IOException {

        ClienteService clienteService = new ClienteService();

        // Cargar clientes del .dat
        clientes = clienteService.cargarClientes();

        if (clientes == null) {
            clientes = new ArrayList<>();
        }

        System.out.println("Clientes cargados: " + clientes.size());

        // Cargar vista principal
        Parent root = FXMLLoader.load(
                getClass().getResource("/org/example/gym_poo/views/MainView.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);

        stage.setWidth(1600);
        stage.setHeight(800);


        stage.setResizable(false);

        stage.centerOnScreen();

        stage.show();
    }

    public static ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public static void main(String[] args) {
        launch();
    }
}