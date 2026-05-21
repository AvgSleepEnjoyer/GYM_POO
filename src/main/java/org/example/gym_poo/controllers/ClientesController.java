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
import org.example.gym_poo.service.ClienteService;

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

    private final ClienteService clienteService =
            new ClienteService();

    // =========================
    // MEMBRESIAS
    // =========================

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

    // =========================
    // METODOS DE PAGO
    // =========================

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

    // =========================
    // ELIMINAR CLIENTE
    // =========================

    @FXML
    private TextField txtIdEliminar;

    @FXML
    private TextField txtNombreEliminar;

    @FXML
    private TextField txtTelefonoEliminar;

    @FXML
    private TextField txtCorreoEliminar;

    private Cliente clienteEliminar;

    // =========================
    // REGISTRAR CLIENTE
    // =========================

    @FXML
    private void registrarCliente() {

        String nombre = txtNombre.getText().trim();
        String telefono = txtTelefono.getText().trim();
        String correo = txtCorreo.getText().trim();

        if (nombre.isEmpty()
                || telefono.isEmpty()
                || correo.isEmpty()
                || membresiaSeleccionada.isEmpty()
                || metodoPagoSeleccionado.isEmpty()) {

            Alert alert =
                    new Alert(Alert.AlertType.WARNING);

            alert.setTitle("Campos incompletos");
            alert.setHeaderText(null);
            alert.setContentText(
                    "Debes llenar todos los campos antes de registrar un cliente."
            );

            alert.showAndWait();
            return;
        }

        Cliente cliente = new Cliente(
                generarNuevoId(),
                nombre,
                telefono,
                correo,
                membresiaSeleccionada,
                "Si",
                metodoPagoSeleccionado,
                0,
                0
        );

        MainApp.getGym()
                .getClientes()
                .add(cliente);

        clienteService.guardarClientesDat(
                MainApp.getGym().getClientes()
        );

        Alert alert =
                new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("Cliente registrado");
        alert.setHeaderText(null);
        alert.setContentText(
                "Cliente agregado correctamente."
        );

        alert.showAndWait();

        limpiarFormulario();

        // GUARDAR EN clientes.dat
        clienteService.guardarClientesDat(
                MainApp.getGym().getClientes()
        );
    }

    // =========================
    // GENERAR ID
    // =========================

    private int generarNuevoId() {

        int maxId = 0;

        for (Cliente cliente :
                MainApp.getGym().getClientes()) {

            if (cliente.getId() > maxId) {
                maxId = cliente.getId();
            }
        }

        return maxId + 1;
    }

    // =========================
    // LIMPIAR
    // =========================

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

    // =========================
    // BUSCAR CLIENTE
    // =========================

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

            for (Cliente cliente :
                    MainApp.getGym().getClientes()) {

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

    // =========================
    // ELIMINAR
    // =========================

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

        if (confirmacion.showAndWait().orElse(ButtonType.CANCEL)
                == ButtonType.OK) {

            MainApp.getGym()
                    .getClientes()
                    .remove(clienteEliminar);

            clienteService.guardarClientesDat(
                    MainApp.getGym().getClientes()
            );

            txtIdEliminar.clear();
            txtNombreEliminar.clear();
            txtTelefonoEliminar.clear();
            txtCorreoEliminar.clear();

            clienteEliminar = null;

            // GUARDAR EN clientes.dat
            clienteService.guardarClientesDat(
                    MainApp.getGym().getClientes()
            );


            mostrarAlerta(
                    Alert.AlertType.INFORMATION,
                    "Éxito",
                    "Cliente eliminado correctamente."
            );
        }
    }

    // =========================
    // ALERTAS
    // =========================

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

    // =========================
    // VOLVER AL MENU
    // =========================

    @FXML
    private void volverMain(ActionEvent event)
            throws IOException {

        Parent root =
                FXMLLoader.load(
                        getClass().getResource(
                                "/org/example/gym_poo/views/MainView.fxml"
                        )
                );

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
}