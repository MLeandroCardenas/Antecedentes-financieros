/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.antecedentesfinancieros;

import java.io.Serializable;

/**
 *
 * @author Michael Cardenas
 * clase cascaron que guarda los datos de los antecedentes de cada persona
 * 
 */
public class Antecedente implements Serializable {
    
    /**
     * atributos del clase
     */
    private String fecha;
    private String descripcion;
    private String nombreCaracteristico;
    private String calificacion;
    private long identificador;
    
    
    /**
     * serial unico para la serializacion, un identificador
     */
    private static final long serialVersionUID = -2773344211410398459L;

    /**
     * constructor de la clase
     */
    public Antecedente() {
    }

    /**
     * metodos publicos para acceder a los atributos privados desde otro lado
     * @return 
     */
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombreCaracteristico() {
        return nombreCaracteristico;
    }

    public void setNombreCaracteristico(String nombreCaracteristico) {
        this.nombreCaracteristico = nombreCaracteristico;
    }

    public String getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(String calificacion) {
        this.calificacion = calificacion;
    }

    public long getIdentificador() {
        return identificador;
    }

    public void setIdentificador(long identificador) {
        this.identificador = identificador;
    } 
}
