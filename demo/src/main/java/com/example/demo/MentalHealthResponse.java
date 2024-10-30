package com.example.demo;

public class MentalHealthResponse {
    private String nombre;
    private String posicion;
    private String mensaje;
    private boolean contactarPsicologo; // Nuevo atributo para indicar si se debe contactar a un psicólogo

    // Constructor actualizado
    public MentalHealthResponse(String nombre, String posicion, String mensaje, boolean contactarPsicologo) {
        this.nombre = nombre;
        this.posicion = posicion;
        this.mensaje = mensaje;
        this.contactarPsicologo = contactarPsicologo;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public boolean isContactarPsicologo() {
        return contactarPsicologo;
    }

    public void setContactarPsicologo(boolean contactarPsicologo) {
        this.contactarPsicologo = contactarPsicologo;
    }
}
