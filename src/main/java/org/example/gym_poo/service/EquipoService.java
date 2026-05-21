package org.example.gym_poo.service;

import org.example.gym_poo.models.Equipo;

import java.io.*;
import java.util.ArrayList;

public class EquipoService {

    private static final String ARCHIVO =
            "equipos.dat";

    public void guardarEquipos(
            ArrayList<Equipo> equipos) {

        try (ObjectOutputStream out =
                     new ObjectOutputStream(
                             new FileOutputStream(ARCHIVO))) {

            out.writeObject(equipos);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Equipo> cargarEquipos() {

        File archivo = new File(ARCHIVO);

        if (!archivo.exists()) {
            return new ArrayList<>();
        }

        try (ObjectInputStream in =
                     new ObjectInputStream(
                             new FileInputStream(ARCHIVO))) {

            return (ArrayList<Equipo>)
                    in.readObject();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }
}