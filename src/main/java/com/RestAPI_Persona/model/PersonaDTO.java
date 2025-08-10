package com.RestAPI_Persona.model;

import jakarta.persistence.Column;

public class PersonaDTO {

    @Column
    private String nombre;

    @Column
    private String telefono;

    @Column
    private String ubicacion;

    public PersonaDTO(String nombre, String telefono, String ubicacion) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.ubicacion = ubicacion;
    }

    public PersonaDTO() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
}
