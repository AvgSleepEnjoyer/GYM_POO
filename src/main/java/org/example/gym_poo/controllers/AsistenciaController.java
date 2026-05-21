package org.example.gym_poo.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.example.gym_poo.MainApp;
import org.example.gym_poo.models.Acceso;
import org.example.gym_poo.models.Cliente;
import org.example.gym_poo.service.AccesoService;

import java.io.IOException;

public class AsistenciaController {

    @FXML
    private TextField txtIdBuscar;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtPuntos;

    @FXML
    private TextField txtPuntosAsistencia;

    private Cliente clienteSeleccionado;

    @FXML
    private TextField txtIdSalida;

    @FXML
    private TextField txtNombreSalida;

    @FXML
    private TextField txtSalidaManual;

    @FXML
    private TextField txtEntrada;

    private Cliente clienteSalida;
    private Acceso accesoActual;

    @FXML
    private void buscarCliente() {

        try {

            int id =
                    Integer.parseInt(
                            txtIdBuscar.getText()
                    );

            clienteSeleccionado = null;

            for (Cliente cliente : MainApp.getGym().getClientes()) {

                if (cliente.getId() == id) {

                    clienteSeleccionado = cliente;

                    txtNombre.setText(cliente.getNombre());

                    txtPuntos.setText(
                            String.valueOf(cliente.getPuntos())
                    );

                    break;
                }
            }

            if (clienteSeleccionado == null) {

                mostrarMensaje(
                        "Cliente no encontrado."
                );
            }

        } catch (Exception e) {

            mostrarMensaje(
                    "ID inválido."
            );
        }
    }
    @FXML
    private void registrarAsistencia() {

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        if (clienteSeleccionado == null) {
            mostrarMensaje("Primero busque un cliente.");
            return;
        }

        // VALIDAR MEMBRESÍA ACTIVA
        if (clienteSeleccionado.getActiva() != null &&
                clienteSeleccionado.getActiva().equalsIgnoreCase("No")) {

            Alert alert = new Alert(Alert.AlertType.WARNING);

            alert.setTitle("Membresía inactiva");
            alert.setHeaderText(null);
            alert.setContentText(
                    "Este cliente tiene la membresía inactiva y no puede registrar asistencia."
            );

            alert.showAndWait();
            return;
        }

        try {

            int puntos =
                    Integer.parseInt(
                            txtPuntosAsistencia.getText()
                    );

            // sumar puntos
            clienteSeleccionado.setPuntos(
                    clienteSeleccionado.getPuntos() + puntos
            );

            txtPuntos.setText(
                    String.valueOf(
                            clienteSeleccionado.getPuntos()
                    )
            );

            Acceso acceso = new Acceso(
                    MainApp.getGym().getAccesos().size() + 1,
                    clienteSeleccionado.getId(),
                    clienteSeleccionado.getNombre(),
                    LocalDateTime.now().format(formatter),
                    ""
            );

            MainApp.getGym().getAccesos().add(acceso);

            // guardar accesos
            new AccesoService().guardarAccesos(
                    MainApp.getGym().getAccesos()
            );

            mostrarMensaje(
                    "Asistencia registrada correctamente"
            );

        } catch (NumberFormatException e) {

            mostrarMensaje(
                    "Ingrese una cantidad válida."
            );
        }
    }

    @FXML
    private void buscarClienteSalida() {

        try {

            int id = Integer.parseInt(txtIdSalida.getText());

            clienteSalida = null;
            accesoActual = null;

            for (Cliente cliente : MainApp.getGym().getClientes()) {

                if (cliente.getId() == id) {
                    clienteSalida = cliente;
                    txtNombreSalida.setText(cliente.getNombre());
                    break;
                }
            }

            if (clienteSalida == null) {
                mostrarMensaje("Cliente no encontrado");
                return;
            }

            // buscar acceso abierto
            for (Acceso acceso : MainApp.getGym().getAccesos()) {

                if (acceso.getIdCliente() == id &&
                        (acceso.getHoraSalida() == null ||
                                acceso.getHoraSalida().isEmpty())) {

                    accesoActual = acceso;
                    txtEntrada.setText(acceso.getHoraEntrada());
                    break;
                }
            }

            if (accesoActual == null) {
                mostrarMensaje("No hay entrada registrada");
            }

        } catch (Exception e) {
            mostrarMensaje("ID inválido");
        }
    }

    @FXML
    private void registrarSalida() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        if (accesoActual == null) {
            mostrarMensaje("No hay acceso activo");
            return;
        }

        String horaSalida = txtSalidaManual.getText().trim();

        // si no escriben nada → usa hora actual
        if (horaSalida.isEmpty()) {
            horaSalida = LocalDateTime.now().format(formatter);
        }

        accesoActual.setHoraSalida(horaSalida);

        txtSalidaManual.clear();
        txtEntrada.clear();
        txtNombreSalida.clear();
        txtIdSalida.clear();

        mostrarMensaje("Salida registrada correctamente");
    }

    @FXML
    private void volverMain(ActionEvent event)
            throws IOException {

        Parent root = FXMLLoader.load(
                getClass().getResource(
                        "/org/example/gym_poo/views/MainView.fxml"));

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

    private void mostrarMensaje(String mensaje) {

        Alert alert =
                new Alert(Alert.AlertType.INFORMATION);

        alert.setHeaderText(null);
        alert.setContentText(mensaje);

        alert.showAndWait();
    }
}