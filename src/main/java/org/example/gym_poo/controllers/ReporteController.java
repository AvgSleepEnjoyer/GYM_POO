package org.example.gym_poo.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import org.example.gym_poo.MainApp;
import org.example.gym_poo.utils.ReporteAccesoTxt;
import org.example.gym_poo.utils.ReporteTxt;

import java.io.IOException;

public class ReporteController {

    public void reporteClientes() {

        ReporteTxt reporte =
                new ReporteTxt();

        reporte.guardarTxt(
                MainApp.getGym().getClientes()
        );
    }

    public void reporteAccesos() {

        ReporteAccesoTxt reporte =
                new ReporteAccesoTxt();

        reporte.guardarTxt(
                MainApp.getGym().getAccesos()
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