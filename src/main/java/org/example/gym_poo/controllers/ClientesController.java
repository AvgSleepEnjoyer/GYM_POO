package org.example.gym_poo.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import org.example.gym_poo.MainApp;
import org.example.gym_poo.models.Cliente;

import java.io.IOException;

public class ClientesController {

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtTelefono;

    @FXML
    private TextField txtCorreo;

    @FXML
    private SplitMenuButton btnMembresia;

    @FXML
    private SplitMenuButton btnMetodoPago;

    private String membresiaSeleccionada = "";
    private String metodoPagoSeleccionado = "";

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
    private void seleccionarEfectivo() {
        metodoPagoSeleccionado = "Efectivo";
        btnMetodoPago.setText("Efectivo");
    }

    @FXML
    private void seleccionarTarjeta() {
        metodoPagoSeleccionado = "Tarjeta";
        btnMetodoPago.setText("Tarjeta");
    }

    @FXML
    private void seleccionarTransferencia() {
        metodoPagoSeleccionado = "Transferencia";
        btnMetodoPago.setText("Transferencia");
    }

    @FXML
    private TextField txtIdEliminar;

    @FXML
    private TextField txtNombreEliminar;

    @FXML
    private TextField txtTelefonoEliminar;

    @FXML
    private TextField txtCorreoEliminar;

    private Cliente clienteEliminar;

    @FXML
    private void registrarCliente() {

        String nombre = txtNombre.getText().trim();
        String telefono = txtTelefono.getText().trim();
        String correo = txtCorreo.getText().trim();

        if (nombre.isEmpty() ||
                telefono.isEmpty() ||
                correo.isEmpty() ||
                membresiaSeleccionada.isEmpty() ||
                metodoPagoSeleccionado.isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.WARNING);

            alert.setTitle("Campos incompletos");
            alert.setHeaderText(null);
            alert.setContentText(
                    "Debes llenar todos los campos antes de registrar un cliente."
            );

            alert.showAndWait();

            return;
        }

        Cliente cliente = new Cliente(
                MainApp.getClientes().size() + 1,
                nombre,
                telefono,
                correo,
                membresiaSeleccionada,
                "Si", // Membresía activa por defecto
                metodoPagoSeleccionado,
                0,    // visitas iniciales
                0     // total pagado inicial
        );

        MainApp.getClientes().add(cliente);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("Cliente registrado");
        alert.setHeaderText(null);
        alert.setContentText("Cliente agregado correctamente.");

        alert.showAndWait();

        limpiarFormulario();
    }

    @FXML
    private void limpiarFormulario() {

        txtNombre.clear();
        txtTelefono.clear();
        txtCorreo.clear();

        membresiaSeleccionada = "";
        metodoPagoSeleccionado = "";

        btnMembresia.setText("--Ninguna--");
        btnMetodoPago.setText("--Ninguno--");

        txtNombre.requestFocus();
    }

    @FXML
    private void buscarClienteEliminar() {

        if (txtIdEliminar.getText().trim().isEmpty()) {

            mostrarAlerta(
                    Alert.AlertType.WARNING,
                    "Error",
                    "Ingrese un ID."
            );

            return;
        }

        try {

            int id =
                    Integer.parseInt(
                            txtIdEliminar.getText()
                    );

            clienteEliminar = null;

            for (Cliente cliente : MainApp.getClientes()) {

                if (cliente.getId() == id) {

                    clienteEliminar = cliente;

                    txtNombreEliminar.setText(
                            cliente.getNombre()
                    );

                    txtTelefonoEliminar.setText(
                            cliente.getTelefono()
                    );

                    txtCorreoEliminar.setText(
                            cliente.getCorreo()
                    );

                    break;
                }
            }

            if (clienteEliminar == null) {

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
    private void eliminarCliente() {

        if (clienteEliminar == null) {

            mostrarAlerta(
                    Alert.AlertType.WARNING,
                    "Error",
                    "Primero debe buscar un cliente."
            );

            return;
        }

        Alert confirmacion =
                new Alert(Alert.AlertType.CONFIRMATION);

        confirmacion.setTitle("Confirmar");
        confirmacion.setHeaderText(null);
        confirmacion.setContentText(
                "¿Desea eliminar este cliente?"
        );

        if (confirmacion.showAndWait().get()
                == ButtonType.OK) {

            MainApp.getClientes()
                    .remove(clienteEliminar);

            txtIdEliminar.clear();
            txtNombreEliminar.clear();
            txtTelefonoEliminar.clear();
            txtCorreoEliminar.clear();

            clienteEliminar = null;

            mostrarAlerta(
                    Alert.AlertType.INFORMATION,
                    "Éxito",
                    "Cliente eliminado correctamente."
            );
        }
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

    @FXML
    private void volverMain(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(
                getClass().getResource("/org/example/gym_poo/views/MainView.fxml")
        );

        Stage stage = (Stage) ((javafx.scene.Node)
                event.getSource()).getScene().getWindow();

        stage.setScene(new Scene(root));
        stage.show();
    }


}