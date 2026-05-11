package org.example.gym_poo.models;

import java.util.ArrayList;

public class Gym {

    private static ArrayList<Cliente> clientes = new ArrayList<>();

    public static ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public static void setClientes(ArrayList<Cliente> clientes) {
        Gym.clientes = clientes;
    }
}