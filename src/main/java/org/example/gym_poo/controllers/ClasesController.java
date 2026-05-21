package org.example.gym_poo.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.*;

import javafx.scene.control.cell.PropertyValueFactory;

import javafx.stage.Stage;

import org.example.gym_poo.MainApp;
import org.example.gym_poo.models.ClaseGrupal;
import org.example.gym_poo.service.ClaseService;

import java.io.IOException;

public class ClasesController {

    @FXML
    private TableView<ClaseGrupal> tablaClases;

    @FXML
    private TableColumn<ClaseGrupal,Integer> colId;

    @FXML
    private TableColumn<ClaseGrupal,String> colNombre;

    @FXML
    private TableColumn<ClaseGrupal,String> colDia;

    @FXML
    private TableColumn<ClaseGrupal,String> colHora;

    @FXML
    private TableColumn<ClaseGrupal,Integer> colCupo;

    private ObservableList<ClaseGrupal> clases =
            FXCollections.observableArrayList();

    @FXML
    public void initialize() {

        colId.setCellValueFactory(
                new PropertyValueFactory<>("id"));

        colNombre.setCellValueFactory(
                new PropertyValueFactory<>("nombre"));

        colDia.setCellValueFactory(
                new PropertyValueFactory<>("dia"));

        colHora.setCellValueFactory(
                new PropertyValueFactory<>("hora"));

        colCupo.setCellValueFactory(
                new PropertyValueFactory<>("cupo"));

        tablaClases.setItems(clases);

        clases.addAll(
                MainApp.getGym()
                        .getClases()
        );
    }

    @FXML
    private void agregarClase() {

        TextInputDialog nombreDialog =
                new TextInputDialog();

        nombreDialog.setHeaderText(
                "Nombre de la clase");

        nombreDialog.showAndWait();

        if (nombreDialog.getResult() == null) {
            return;
        }

        TextInputDialog diaDialog =
                new TextInputDialog();

        diaDialog.setHeaderText(
                "Día");

        diaDialog.showAndWait();

        if (diaDialog.getResult() == null) {
            return;
        }

        TextInputDialog horaDialog =
                new TextInputDialog();

        horaDialog.setHeaderText(
                "Hora");

        horaDialog.showAndWait();

        if (horaDialog.getResult() == null) {
            return;
        }

        TextInputDialog cupoDialog =
                new TextInputDialog();

        cupoDialog.setHeaderText(
                "Cupo");

        cupoDialog.showAndWait();

        if (cupoDialog.getResult() == null) {
            return;
        }

        ClaseGrupal nuevaClase =
                new ClaseGrupal(
                        clases.size() + 1,
                        nombreDialog.getResult(),
                        diaDialog.getResult(),
                        horaDialog.getResult(),
                        Integer.parseInt(
                                cupoDialog.getResult())
                );

        clases.add(nuevaClase);
        MainApp.getGym()
                .getClases()
                .add(nuevaClase);

        new ClaseService()
                .guardarClases(
                        MainApp.getGym().getClases()
                );
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
}