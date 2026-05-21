package org.example.gym_poo.controllers;
import org.example.gym_poo.MainApp;
import org.example.gym_poo.models.Gym;
import org.example.gym_poo.utils.ReporteTxt;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;


import java.io.IOException;

public class MainController {
    public void ingresarClientes(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/org/example/gym_poo/views/IngresarCliente.fxml"));
        Stage stage = (Stage) ((javafx.scene.Node)
                event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void actualizarClientes(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/org/example/gym_poo/views/ActualizarCliente.fxml"));
        Stage stage = (Stage) ((javafx.scene.Node)
                event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void eliminarClientes(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/org/example/gym_poo/views/EliminarCliente.fxml"));
        Stage stage = (Stage) ((javafx.scene.Node)
                event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void generarReportes(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(
                getClass().getResource("/org/example/gym_poo/views/ReporteCreado.fxml"));

        Stage stage = (Stage) ((javafx.scene.Node)
                event.getSource()).getScene().getWindow();

        stage.setScene(new Scene(root));

        stage.show();

        ReporteTxt reporteTxt = new ReporteTxt();

        reporteTxt.guardarTxt(MainApp.getClientes());

    }



}
