package org.example.gym_poo.models;

import java.io.Serializable;

public class ClaseGrupal implements Serializable {

    private int id;
    private String nombre;
    private String dia;
    private String hora;
    private int cupo;

    public ClaseGrupal(
            int id,
            String nombre,
            String dia,
            String hora,
            int cupo) {

        this.id = id;
        this.nombre = nombre;
        this.dia = dia;
        this.hora = hora;
        this.cupo = cupo;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDia() {
        return dia;
    }

    public String getHora() {
        return hora;
    }

    public int getCupo() {
        return cupo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setCupo(int cupo) {
        this.cupo = cupo;
    }
}