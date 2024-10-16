package com.example.demo;

public class MentalHealthResponse {
    private String nombre;
    private String posicion;
    private String mensaje;

    // Constructor
    public MentalHealthResponse(String nombre, String posicion, String mensaje) {
        this.nombre = nombre;
        this.posicion = posicion;
        this.mensaje = mensaje;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getPosicion() {
        return posicion;
    }

    public String getMensaje() {
        return mensaje;
    }
}
