package org.example.gym_poo.models;

import java.io.Serializable;

public class Acceso implements Serializable {

    private int id;
    private int idCliente;
    private String cliente;
    private String horaEntrada;
    private String horaSalida;

    public Acceso(int id, int idCliente, String cliente, String horaEntrada, String horaSalida) {
        this.id = id;
        this.idCliente = idCliente;
        this.cliente = cliente;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
    }

    // getters y setters

    public int getId() {
        return id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public String getNombreCliente() {
        return cliente;
    }

    public String getHoraEntrada() {
        return horaEntrada;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    @Override
    public String toString() {

        return "Acceso{" +
                "id=" + id +
                ", idCliente=" + idCliente +
                ", nombre='" + cliente + '\'' +
                ", entrada='" + horaEntrada + '\'' +
                ", salida='" + horaSalida + '\'' +
                '}';
    }
}