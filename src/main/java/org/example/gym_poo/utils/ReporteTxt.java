package org.example.gym_poo.utils;
import org.example.gym_poo.models.Cliente;
import org.example.gym_poo.service.ClienteService;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ReporteTxt {

    private final String ARCHIVOTXT = "clientes.txt";

    public void guardarTxt(ArrayList<Cliente> clientes){

        try {

            FileWriter myWriter = new FileWriter(ARCHIVOTXT);

            for (Cliente cliente : clientes) {

                myWriter.write(cliente.toString() + "\n");

            }

            myWriter.close();

            System.out.println("Successfully wrote to the file to: " + ARCHIVOTXT);

        } catch (IOException e) {

            System.out.println("An error occurred.");
            e.printStackTrace();

        }
    }
}
