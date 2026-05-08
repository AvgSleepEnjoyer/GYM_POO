package org.example.gym_poo.models;

public class Cliente {
    private int id;
    private String nombre;
    private String telefono;
    private String correo;
    private String membresia;
    private int puntos;

    // Contructor
    public Cliente(int id, String nombre, String telefono, String correo, String membresia, int puntos){
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.membresia = membresia;
        this.puntos = puntos;
    }

    // Setters
    public void setId(int id) {this.id = id;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public void setTelefono(String telefono) {this.telefono = telefono;}
    public void setCorreo(String correo) {this.correo = correo;}
    public void setMembresia(String membresia) {this.membresia = membresia;}
    public void setPuntos(int puntos) {this.puntos = puntos;}

    // Getters
    public int getId() {return id;}
    public String getNombre() {return nombre;}
    public String getTelefono() {return telefono;}
    public String getCorreo() {return correo;}
    public String getMembresia() {return membresia;}
    public int getPuntos() {return puntos;}

    @Override
    public String toString() {
        return nombre;
    }
}
