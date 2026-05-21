package org.example.gym_poo.service;

import org.example.gym_poo.models.Acceso;

import java.io.*;
import java.util.ArrayList;

public class AccesoService {

    private final String ARCHIVO = "accesos.dat";

    public void guardarAccesos(ArrayList<Acceso> accesos) {

        try (ObjectOutputStream out =
                     new ObjectOutputStream(new FileOutputStream(ARCHIVO))) {

            out.writeObject(accesos);

            System.out.println("Accesos guardados correctamente");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Acceso> cargarAccesos() {

        File file = new File(ARCHIVO);

        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (ObjectInputStream in =
                     new ObjectInputStream(new FileInputStream(file))) {

            return (ArrayList<Acceso>) in.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}