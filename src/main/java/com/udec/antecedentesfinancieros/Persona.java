/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.antecedentesfinancieros;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Michael Cardenas
 * clase cascaron con los atributos de la persona
 */
public class Persona implements Serializable {

    /**
     * serial unico para la serializacion, un identificador
     */
    private static final long serialVersionUID = -2873344211410398459L;
    
    /**
     * atributos de la clase
     */
    private String apellido;
    private String nombre;
    private long cedula;
    private byte edad;
    private char genero;
    
    
    /**
     * constructor de la clase
     */
    public Persona() {
    }
    
    /**
     * metodos publicos para acceder a las variables privadas
     * @return 
     */
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
}
