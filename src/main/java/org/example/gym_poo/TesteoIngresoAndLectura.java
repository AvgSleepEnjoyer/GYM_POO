package org.example.gym_poo;

import org.example.gym_poo.models.Cliente;
import org.example.gym_poo.service.ClienteService;

import java.util.ArrayList;

public class TesteoIngresoAndLectura {

    public static void main(String[] args) {

        ClienteService clienteService = new ClienteService();

        ArrayList<Cliente> clientes = new ArrayList<>();

        clientes.add(new Cliente(
                1,
                "Diego",
                "8123",
                "diego@gmail.com",
                "Plus",
                "Tarjeta",
                120
        ));

        clientes.add(new Cliente(
                2,
                "Ana",
                "8111",
                "ana@gmail.com",
                "Premium",
                "Efectivo",
                300
        ));

        clientes.add(new Cliente(
                3,
                "Luis",
                "8222",
                "luis@gmail.com",
                "Basica",
                "Transferencia",
                50
        ));

        clienteService.guardarClientes(clientes);

        System.out.println("Clientes guardados");

        ArrayList<Cliente> cargados =
                clienteService.cargarClientes();

        System.out.println();

        for (Cliente cliente : cargados) {

            System.out.println(cliente.getNombre());
        }
    }
}