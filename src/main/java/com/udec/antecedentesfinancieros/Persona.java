/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.antecedentesfinancieros;

import java.io.Serializable;

/**
 *
 * @author michl
 */
public class Persona implements Serializable {

    private String apellido;
    private String nombre;
    private long cedula;
    private byte edad;
    private char genero;
    private TipoAntecedente antecedente;
    
    
    public Persona() {
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getCedula() {
        return cedula;
    }

    public void setCedula(long cedula) {
        this.cedula = cedula;
    }

    public byte getEdad() {
        return edad;
    }

    public void setEdad(byte edad) {
        this.edad = edad;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public TipoAntecedente getAntecedente() {
        return antecedente;
    }

    public void setAntecedente(TipoAntecedente antecedente) {
        this.antecedente = antecedente;
    }
    
    
    
    
    
}
