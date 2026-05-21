package org.example.gym_poo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import org.example.gym_poo.models.Gym;
import org.example.gym_poo.service.ClienteService;
import org.example.gym_poo.service.AccesoService;
import org.example.gym_poo.service.ClaseService;
import org.example.gym_poo.service.EquipoService;

import java.io.IOException;

public class MainApp extends Application {

    private static Gym gym;

    public static Gym getGym() {
        return gym;
    }

    @Override
    public void start(Stage stage) throws IOException {

        ClienteService clienteService = new ClienteService();
        AccesoService accesoService = new AccesoService();
        ClaseService claseService = new ClaseService();
        EquipoService equipoService = new EquipoService();

        gym = new Gym();


        gym.setClientes(clienteService.cargarClientes());

        if (gym.getClientes() == null) {
            gym.setClientes(new java.util.ArrayList<>());
        }

        gym.setAccesos(accesoService.cargarAccesos());

        if (gym.getAccesos() == null) {
            gym.setAccesos(new java.util.ArrayList<>());
        }

        gym.setClases(claseService.cargarClases());

        if (gym.getClases() == null) {
            gym.setClases(new java.util.ArrayList<>());
        }

        gym.setEquipos(equipoService.cargarEquipos());
        if (gym.getEquipos() == null) {
            gym.setEquipos(new java.util.ArrayList<>());
        }


        System.out.println("Clientes cargados: " + gym.getClientes().size());
        System.out.println("Accesos cargados: " + gym.getAccesos().size());
        System.out.println("Clases cargadas: "+ gym.getClases().size());
        System.out.println("Equipos cargados: "+ gym.getEquipos().size()
        );

        Parent root = FXMLLoader.load(getClass().getResource("/org/example/gym_poo/views/MainView.fxml"));

        Scene scene = new Scene(root);

        scene.getStylesheets().add(getClass().getResource("/css/styles.css").toExternalForm());

        stage.setScene(scene);
        stage.setWidth(1600);
        stage.setHeight(800);
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}