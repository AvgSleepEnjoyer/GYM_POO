package org.example.gym_poo.models;

import java.util.ArrayList;

public class Gym {

    private ArrayList<Cliente> clientes =
            new ArrayList<>();

    private ArrayList<Acceso> accesos =
            new ArrayList<>();

    private ArrayList<ClaseGrupal> clases =
            new ArrayList<>();


    // CLIENTES

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }


    // ACCESOS

    public ArrayList<Acceso> getAccesos() {
        return accesos;
    }

    public void setAccesos(ArrayList<Acceso> accesos) {
        this.accesos = accesos;
    }


    // CLASES

    public ArrayList<ClaseGrupal> getClases() {
        return clases;
    }

    public void setClases(ArrayList<ClaseGrupal> clases) {
        this.clases = clases;
    }

    // EQUIPO GYM

    private ArrayList<Equipo> equipos =
            new ArrayList<>();

    public ArrayList<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(ArrayList<Equipo> equipos) {
        this.equipos = equipos;
    }
}