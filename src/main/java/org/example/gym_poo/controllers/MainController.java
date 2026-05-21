package org.example.gym_poo.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {

    private void cambiarVista(ActionEvent event,String fxml) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource(fxml));

        Scene scene = new Scene(root);

        scene.getStylesheets().add(getClass().getResource("/css/styles.css").toExternalForm());

        Stage stage = (Stage) ((javafx.scene.Node)
                event.getSource())
                .getScene()
                .getWindow();

        stage.setScene(scene);
        stage.show();
    }

    public void ingresarClientes(ActionEvent event) throws IOException {

        cambiarVista(event,"/org/example/gym_poo/views/IngresarCliente.fxml");
    }

    public void actualizarClientes(ActionEvent event)
            throws IOException {

        cambiarVista(
                event,
                "/org/example/gym_poo/views/ActualizarCliente.fxml"
        );
    }

    public void eliminarClientes(ActionEvent event)
            throws IOException {

        cambiarVista(
                event,
                "/org/example/gym_poo/views/EliminarCliente.fxml"
        );
    }

    public void generarReportes(ActionEvent event)
            throws IOException {

        cambiarVista(
                event,
                "/org/example/gym_poo/views/ReportesView.fxml"
        );
    }

    public void asistencia(ActionEvent event)
            throws IOException {

        cambiarVista(
                event,
                "/org/example/gym_poo/views/Asistencia.fxml"
        );
    }

    public void salida(ActionEvent event)
            throws IOException {

        cambiarVista(
                event,
                "/org/example/gym_poo/views/SalidaView.fxml"
        );
    }

    public void sistemaPuntos(ActionEvent event)
            throws IOException {

        cambiarVista(
                event,
                "/org/example/gym_poo/views/SistemaPuntos.fxml"
        );
    }

    public void clases(ActionEvent event)
            throws IOException {

        cambiarVista(
                event,
                "/org/example/gym_poo/views/ClasesView.fxml"
        );
    }

    public void equipo(ActionEvent event)
            throws IOException {

        cambiarVista(
                event,
                "/org/example/gym_poo/views/InventarioEquipoView.fxml"
        );
    }
}