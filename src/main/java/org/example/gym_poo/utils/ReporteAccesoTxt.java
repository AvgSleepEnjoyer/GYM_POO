package org.example.gym_poo.utils;

import org.example.gym_poo.models.Acceso;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ReporteAccesoTxt {

    private final String ARCHIVO = "accesos.txt";

    public void guardarTxt(ArrayList<Acceso> accesos) {

        try (FileWriter writer =
                     new FileWriter(ARCHIVO)) {

            writer.write("===== REPORTE DE ACCESOS =====\n\n");

            for (Acceso acceso : accesos) {

                writer.write(
                        "ID Acceso: "
                                + acceso.getId()
                                + "\n");

                writer.write(
                        "ID Cliente: "
                                + acceso.getIdCliente()
                                + "\n");

                writer.write(
                        "Nombre: "
                                + acceso.getNombreCliente()
                                + "\n");

                writer.write(
                        "Entrada: "
                                + acceso.getHoraEntrada()
                                + "\n");

                writer.write(
                        "Salida: "
                                + acceso.getHoraSalida()
                                + "\n");

                writer.write(
                        "---------------------------------\n");
            }

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}