package org.example.gym_poo.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import org.example.gym_poo.MainApp;
import org.example.gym_poo.models.Cliente;

import java.io.IOException;

public class SistemaPuntosController {

    @FXML
    private TextField txtIdBuscar;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtPuntosActuales;

    @FXML
    private TextField txtPuntosAgregar;

    private Cliente clienteSeleccionado;

    @FXML
    private void buscarCliente() {

        if (txtIdBuscar.getText().trim().isEmpty()) {

            mostrarMensaje(Alert.AlertType.WARNING,"Error","Ingrese un ID.");

            return;
        }

        try {

            int id =
                    Integer.parseInt(txtIdBuscar.getText());

            clienteSeleccionado = null;

            for (Cliente cliente : MainApp.getGym().getClientes()) {

                if (cliente.getId() == id) {

                    clienteSeleccionado = cliente;

                    txtNombre.setText(cliente.getNombre());

                    txtPuntosActuales.setText(String.valueOf(cliente.getPuntos()));

                    break;
                }
            }

            if (clienteSeleccionado == null) {

                mostrarMensaje(Alert.AlertType.INFORMATION,"Cliente","No se encontró un cliente con ese ID.");
            }

        } catch (NumberFormatException e) {

            mostrarMensaje(Alert.AlertType.ERROR,"Error","El ID debe ser numérico.");
        }
    }

    @FXML
    private void agregarPuntos() {

        if (clienteSeleccionado == null) {

            mostrarMensaje(Alert.AlertType.WARNING,"Error","Primero debe buscar un cliente.");

            return;
        }

        try {

            int puntosAgregar = Integer.parseInt(txtPuntosAgregar.getText());

            if (puntosAgregar <= 0) {

                mostrarMensaje(Alert.AlertType.WARNING,"Error","Los puntos deben ser mayores a cero.");

                return;
            }

            clienteSeleccionado.setPuntos(clienteSeleccionado.getPuntos() + puntosAgregar);

            txtPuntosActuales.setText(String.valueOf(clienteSeleccionado.getPuntos()));

            txtPuntosAgregar.clear();

            mostrarMensaje(Alert.AlertType.INFORMATION,"Éxito","Puntos agregados correctamente.");

        } catch (NumberFormatException e) {

            mostrarMensaje(Alert.AlertType.ERROR,"Error","Ingrese una cantidad válida.");
        }
    }

    @FXML
    private void volverMain(ActionEvent event)
            throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/org/example/gym_poo/views/MainView.fxml"));

        Scene scene = new Scene(root);

        scene.getStylesheets().add(
                getClass()
                        .getResource("/css/styles.css")
                        .toExternalForm()
        );

        Stage stage =
                (Stage) ((javafx.scene.Node)
                        event.getSource())
                        .getScene()
                        .getWindow();

        stage.setScene(scene);
        stage.show();
    }

    private void mostrarMensaje(
            Alert.AlertType tipo,
            String titulo,
            String mensaje) {

        Alert alert =
                new Alert(tipo);

        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);

        alert.showAndWait();
    }
}