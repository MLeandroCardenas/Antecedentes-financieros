/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.antecedentesfinancieros;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 *
 * @author Michael Cardenas
 * clase especial para que el archivo se sobreescriba correctamente
 */
public class MiObjectOutputStream extends ObjectOutputStream {
    
    /**
     * si ya hay una cabezera de archivo no la modifique
     * @throws IOException 
     */
    protected void writeStreamHeader() throws IOException{
        // No hacer nada.
    }
    /**
     * si hay una cabezera que la sobreescriba
     * @throws IOException 
     */
    public MiObjectOutputStream () throws IOException{
        super();
    }
    /**
     * se encarga de serializar el archivo correctamente
     * @param out
     * @throws IOException 
     */
    public MiObjectOutputStream(OutputStream out) throws IOException{
                super(out);
        }
}
