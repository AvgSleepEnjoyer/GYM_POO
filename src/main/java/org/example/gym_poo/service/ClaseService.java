package org.example.gym_poo.service;

import org.example.gym_poo.models.ClaseGrupal;

import java.io.*;
import java.util.ArrayList;

public class ClaseService {

    private static final String ARCHIVO = "clases.dat";

    public void guardarClases(ArrayList<ClaseGrupal> clases) {

        try (ObjectOutputStream out =
                     new ObjectOutputStream(
                             new FileOutputStream(ARCHIVO))) {

            out.writeObject(clases);

            System.out.println("Clases guardadas correctamente.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public ArrayList<ClaseGrupal> cargarClases() {

        File archivo = new File(ARCHIVO);

        if (!archivo.exists()) {
            return new ArrayList<>();
        }

        try (ObjectInputStream in =
                     new ObjectInputStream(
                             new FileInputStream(archivo))) {

            return (ArrayList<ClaseGrupal>) in.readObject();

        } catch (IOException | ClassNotFoundException e) {

            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}