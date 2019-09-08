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
 * @author michl
 */
public class MiObjectOutputStream extends ObjectOutputStream {
    
    protected void writeStreamHeader() throws IOException{
        // No hacer nada.
    }
    
    public MiObjectOutputStream () throws IOException{
        super();
    }
    public MiObjectOutputStream(OutputStream out) throws IOException{
                super(out);
        }
}
