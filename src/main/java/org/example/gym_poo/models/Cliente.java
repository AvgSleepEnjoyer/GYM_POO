package org.example.gym_poo.models;

import java.io.Serializable;

public class Cliente implements Serializable {
    private int id;
    private String nombre;
    private String telefono;
    private String correo;
    private String membresia;
    private String activa;
    private String metodoPago;
    private int puntos;
    private double dinero;

    // Contructor
    public Cliente(int id, String nombre, String telefono, String correo, String membresia, String activa, String metodoPago, int puntos, double dinero) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.membresia = membresia;
        this.activa = activa;
        this.metodoPago = metodoPago;
        this.puntos = puntos;
        this.dinero = dinero;
    }

    // Setters
    public void setId(int id) {this.id = id;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public void setTelefono(String telefono) {this.telefono = telefono;}
    public void setCorreo(String correo) {this.correo = correo;}
    public void setMembresia(String membresia) {this.membresia = membresia;}
    public void setActiva(String activa) {this.activa = activa;}
    public void setMetodoPago(String metodoPago) {this.metodoPago = metodoPago;}
    public void setPuntos(int puntos) {this.puntos = puntos;}
    public void setDinero(double dinero) {this.dinero = dinero;}

    // Getters
    public int getId() {return id;}
    public String getNombre() {return nombre;}
    public String getTelefono() {return telefono;}
    public String getCorreo() {return correo;}
    public String getMembresia() {return membresia;}
    public String getActiva() {return activa;}
    public String getMetodoPago() {return metodoPago;}
    public int getPuntos() {return puntos;}
    public double getDinero() {return dinero;}

    @Override
    public String toString() {
        return
                "ID: " + id + "\n" +
                        "Nombre: " + nombre + "\n" +
                        "Telefono: " + telefono + "\n" +
                        "Correo: " + correo + "\n" +
                        "Membresia: " + membresia + "\n" +
                        "Activa: " + activa + "\n" +
                        "Metodo de pago: " + metodoPago + "\n" +
                        "Puntos: " + puntos + "\n" +
                        "-----------------------------\n";
    }
}
