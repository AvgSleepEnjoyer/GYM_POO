package org.example.gym_poo.service;

import org.example.gym_poo.models.Cliente;
import org.example.gym_poo.models.Gym;


import java.io.*;
import java.util.ArrayList;

public class ClienteService {

    private final String ARCHIVO = "clientes.dat";

    public void guardarClientes(ArrayList<Cliente> clientes) {

        try (ObjectOutputStream oos =
                     new ObjectOutputStream(
                             new FileOutputStream(ARCHIVO))) {

            oos.writeObject(clientes);

            System.out.println("Clientes guardados en: " + ARCHIVO);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Cliente> cargarClientes() {

        try (ObjectInputStream ois =
                     new ObjectInputStream(
                             new FileInputStream(ARCHIVO))) {

            return (ArrayList<Cliente>) ois.readObject();

        } catch (IOException | ClassNotFoundException e) {

            return new ArrayList<>();
        }
    }
}