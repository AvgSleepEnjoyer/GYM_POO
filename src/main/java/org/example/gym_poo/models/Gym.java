package org.example.gym_poo.models;

import java.io.Serializable;
import java.util.ArrayList;

public class Gym implements Serializable {

    private static ArrayList<Cliente> clientes;

    public Gym() {
        clientes = new ArrayList<>();
    }

    public static ArrayList<Cliente> getClientes() {
        return clientes;
    }

}