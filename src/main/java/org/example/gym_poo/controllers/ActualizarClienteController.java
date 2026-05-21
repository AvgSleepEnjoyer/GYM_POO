package org.example.gym_poo.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import org.example.gym_poo.MainApp;
import org.example.gym_poo.models.Cliente;

import java.io.IOException;

public class ActualizarClienteController {

    @FXML
    private TextField txtIdBuscar;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtTelefono;

    @FXML
    private TextField txtCorreo;

    @FXML
    private TextField txtPuntos;

    @FXML
    private SplitMenuButton btnMembresia;

    @FXML
    private SplitMenuButton btnActiva;

    private String membresiaSeleccionada = "";
    private String activaSeleccionada = "";

    private Cliente clienteSeleccionado;

    @FXML
    private void buscarCliente() {

        if (txtIdBuscar.getText().trim().isEmpty()) {
            mostrarAlerta(
                    Alert.AlertType.WARNING,
                    "Error",
                    "Ingrese un ID."
            );
            return;
        }

        try {

            int idBuscado =
                    Integer.parseInt(
                            txtIdBuscar.getText()
                    );

            clienteSeleccionado = null;

            for (Cliente cliente : MainApp.getClientes()) {

                if (cliente.getId() == idBuscado) {

                    clienteSeleccionado = cliente;

                    txtNombre.setText(
                            cliente.getNombre()
                    );

                    txtTelefono.setText(
                            cliente.getTelefono()
                    );

                    txtCorreo.setText(
                            cliente.getCorreo()
                    );

                    txtPuntos.setText(
                            String.valueOf(
                                    cliente.getPuntos()
                            )
                    );

                    btnMembresia.setText(
                            cliente.getMembresia()
                    );

                    btnActiva.setText(
                            cliente.getActiva()
                    );

                    membresiaSeleccionada =
                            cliente.getMembresia();

                    activaSeleccionada =
                            cliente.getActiva();

                    break;
                }
            }

            if (clienteSeleccionado == null) {

                mostrarAlerta(
                        Alert.AlertType.INFORMATION,
                        "Cliente",
                        "No se encontró un cliente con ese ID."
                );
            }

        } catch (NumberFormatException e) {

            mostrarAlerta(
                    Alert.AlertType.ERROR,
                    "Error",
                    "El ID debe ser numérico."
            );
        }
    }

    @FXML
    private void guardarCambios() {

        if (clienteSeleccionado == null) {

            mostrarAlerta(
                    Alert.AlertType.WARNING,
                    "Error",
                    "Primero debe buscar un cliente."
            );

            return;
        }

        if (txtNombre.getText().trim().isEmpty() ||
                txtTelefono.getText().trim().isEmpty() ||
                txtCorreo.getText().trim().isEmpty() ||
                txtPuntos.getText().trim().isEmpty()) {

            mostrarAlerta(
                    Alert.AlertType.WARNING,
                    "Campos incompletos",
                    "Debe llenar todos los campos."
            );

            return;
        }

        try {

            int puntos =
                    Integer.parseInt(
                            txtPuntos.getText()
                    );

            clienteSeleccionado.setNombre(
                    txtNombre.getText().trim()
            );

            clienteSeleccionado.setTelefono(
                    txtTelefono.getText().trim()
            );

            clienteSeleccionado.setCorreo(
                    txtCorreo.getText().trim()
            );

            clienteSeleccionado.setMembresia(
                    membresiaSeleccionada
            );

            clienteSeleccionado.setActiva(
                    activaSeleccionada
            );

            clienteSeleccionado.setPuntos(
                    puntos
            );

            mostrarAlerta(
                    Alert.AlertType.INFORMATION,
                    "Éxito",
                    "Cliente actualizado correctamente."
            );

        } catch (NumberFormatException e) {

            mostrarAlerta(
                    Alert.AlertType.ERROR,
                    "Error",
                    "Los puntos deben ser un número."
            );
        }
    }

    @FXML
    private void seleccionarBasica() {

        membresiaSeleccionada = "Basica";
        btnMembresia.setText("Basica");
    }

    @FXML
    private void seleccionarPlus() {

        membresiaSeleccionada = "Plus";
        btnMembresia.setText("Plus");
    }

    @FXML
    private void seleccionarPremium() {

        membresiaSeleccionada = "Premium";
        btnMembresia.setText("Premium");
    }

    @FXML
    private void seleccionarActivaSi() {

        activaSeleccionada = "Si";
        btnActiva.setText("Si");
    }

    @FXML
    private void seleccionarActivaNo() {

        activaSeleccionada = "No";
        btnActiva.setText("No");
    }

    @FXML
    private void volverMain(ActionEvent event)
            throws IOException {

        Parent root =
                FXMLLoader.load(
                        getClass().getResource(
                                "/org/example/gym_poo/views/MainView.fxml"
                        )
                );

        Stage stage =
                (Stage) ((javafx.scene.Node)
                        event.getSource())
                        .getScene()
                        .getWindow();

        stage.setScene(
                new Scene(root)
        );

        stage.show();
    }

    private void mostrarAlerta(
            Alert.AlertType tipo,
            String titulo,
            String mensaje) {

        Alert alert = new Alert(tipo);

        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);

        alert.showAndWait();
    }
}