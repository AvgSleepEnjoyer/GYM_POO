package org.example.gym_poo.controllers;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import javafx.event.ActionEvent;

import org.example.gym_poo.MainApp;
import org.example.gym_poo.models.Equipo;
import org.example.gym_poo.service.EquipoService;

import java.io.IOException;

public class InventarioEquipoController {

    @FXML
    private TableView<Equipo> tablaEquipos;

    @FXML
    private TableColumn<Equipo,Integer> colId;

    @FXML
    private TableColumn<Equipo,String> colNombre;

    @FXML
    private TableColumn<Equipo,Integer> colCantidad;

    @FXML
    private TableColumn<Equipo,String> colEstado;

    private final EquipoService service =
            new EquipoService();

    @FXML
    public void initialize() {

        colId.setCellValueFactory(
                new javafx.scene.control.cell.PropertyValueFactory<>("id"));

        colNombre.setCellValueFactory(
                new javafx.scene.control.cell.PropertyValueFactory<>("nombre"));

        colCantidad.setCellValueFactory(
                new javafx.scene.control.cell.PropertyValueFactory<>("cantidad"));

        colEstado.setCellValueFactory(
                new javafx.scene.control.cell.PropertyValueFactory<>("estado"));

        actualizarTabla();
    }

    private void actualizarTabla() {

        tablaEquipos.setItems(
                FXCollections.observableArrayList(
                        MainApp.getGym().getEquipos()
                )
        );
    }

    @FXML
    private void agregarEquipo() {

        TextInputDialog nombreDialog = new TextInputDialog();

        nombreDialog.setHeaderText("Nombre del equipo");

        nombreDialog.showAndWait();

        if (nombreDialog.getResult() == null)
            return;

        TextInputDialog cantidadDialog = new TextInputDialog();

        cantidadDialog.setHeaderText("Cantidad");

        cantidadDialog.showAndWait();

        if (cantidadDialog.getResult() == null)
            return;

        ChoiceDialog<String> estadoDialog = new ChoiceDialog<>("Bueno","Bueno","Regular","Mantenimiento");

        estadoDialog.setHeaderText("Estado");

        estadoDialog.showAndWait();

        if (estadoDialog.getResult() == null)
            return;

        Equipo equipo = new Equipo(

                MainApp.getGym().getEquipos().size() + 1,

                nombreDialog.getResult(),

                Integer.parseInt(cantidadDialog.getResult()),

                estadoDialog.getResult()
        );

        MainApp.getGym().getEquipos().add(equipo);

        service.guardarEquipos(MainApp.getGym().getEquipos());

        actualizarTabla();
    }

    @FXML
    private void eliminarEquipo() {

        Equipo seleccionado = tablaEquipos.getSelectionModel().getSelectedItem();

        if (seleccionado == null) {
            return;
        }

        MainApp.getGym().getEquipos().remove(seleccionado);

        service.guardarEquipos(MainApp.getGym().getEquipos());

        actualizarTabla();
    }

    @FXML
    private void volverMain(ActionEvent event)
            throws IOException {

        Parent root = FXMLLoader.load(
                getClass().getResource("/org/example/gym_poo/views/MainView.fxml"));

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