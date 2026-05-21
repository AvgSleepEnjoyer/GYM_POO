package org.example.gym_poo;

import org.example.gym_poo.models.Cliente;
import org.example.gym_poo.service.ClienteService;
import org.example.gym_poo.utils.ReporteTxt;

import java.util.ArrayList;

public class TesteoIngresoAndLectura {

    public static void main(String[] args) {

        ClienteService clienteService = new ClienteService();

        ArrayList<Cliente> clientes = new ArrayList<>();

        clientes.add(new Cliente(1,"Diego","8123","diego@gmail.com","Plus", "Si" ,"Tarjeta",120,1500));
        clientes.add(new Cliente(2,"Ana","8111","ana@gmail.com","Premium", "No", "Efectivo",300,1000));
        clientes.add(new Cliente(3, "Luis", "8222", "luis@gmail.com", "Basica", "Si", "Transferencia", 50, 500));

        clienteService.guardarClientesDat(clientes); // Esto se guarda en .dat y se usa como base de datos


        ReporteTxt reporteTxt = new ReporteTxt();
        reporteTxt.guardarTxt(clientes);


        ArrayList<Cliente> cargados = clienteService.cargarClientes();

        System.out.println();

        for (Cliente cliente : cargados) {
            System.out.println(cliente.getNombre());
        }
    }
}