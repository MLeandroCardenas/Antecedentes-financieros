/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.antecedentesfinancieros;

/**
 *
 * @author michl
 */
public class TipoAntecedente extends Antecedente {

    
    private String nombreCaracteristico;
    private boolean calificacion;
    
     
     public TipoAntecedente() {
    }
    
   

    public String getNombreCaracteristico() {
        return nombreCaracteristico;
    }

    public void setNombreCaracteristico(String nombreCaracteristico) {
        this.nombreCaracteristico = nombreCaracteristico;
    }

    public boolean isCalificacion() {
        return calificacion;
    }

    public void setCalificacion(boolean calificacion) {
        this.calificacion = calificacion;
    }
    
    
    
}
