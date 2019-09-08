/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.antecedentesfinancieros;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author michl
 */
public class Logica {
    
    Persona persona;
    HashMap<Long,Persona> usuario;
    Scanner teclado;
    byte opcion;
    
    public Logica() {
        usuario = new HashMap<>();
        teclado = new Scanner(System.in);
        opcion = 0;
    }
    
    public void menu(){
        while(opcion!=3){
            System.out.println("\t Antecedentes financieros \t");
            System.out.println("Seleccione...");
            System.out.println("1.Registrarse");
            System.out.println("2. Ingresar");
            System.out.println("3. Salir");
            opcion = teclado.nextByte();
            
           if(opcion==1) registro();
                else if(opcion==2) ingreso();
                    else {
                    opcion = 3;
                }
        }
        imprimir();
    }
    
    private void registro(){
        persona = new Persona();
        System.out.println("Apellido: ");
        persona.setApellido(teclado.next());
        System.out.println("Nombre: ");
        persona.setNombre(teclado.next());
        System.out.println("Edad: ");
        persona.setEdad(teclado.nextByte());
        System.out.println("Seleccione genero : 1=Masculino 2=Femenino");
        opcion = teclado.nextByte();
        if(opcion==1) persona.setGenero('M');
        else persona.setGenero('F');
        System.out.println("Cedula: ");
        persona.setCedula(teclado.nextLong());

        usuario.put(persona.getCedula(),persona);
    }
    
    public void imprimir(){
        for (Map.Entry<Long, Persona> entrySet : usuario.entrySet()) {
            Persona value = entrySet.getValue();
            System.out.println("Nombre: " + value.getNombre() + " Edad: " + value.getEdad());
        }
    }
    
    private void ingreso(){
        if(usuario.isEmpty()){
            System.out.println("DEBE HABER AL MENOS UN USUARIO REGISTRADO");
            menu();
        }
            boolean resultado;
            System.out.println("Digite su numero de cedula");
            persona.setCedula(teclado.nextLong());
            resultado = validarUsuarios(persona.getCedula());
            if(resultado==true) menuUsuario();
            if(resultado==false) System.out.println("NO ESTA REGISTRADO");
    }
    
    private boolean validarUsuarios(long cedula){
        for (Map.Entry<Long, Persona> entrySet : usuario.entrySet()) {
            Long key = entrySet.getKey();
            if(key.equals(cedula))
                return true;
        }
        return false;
    }
    
    private void menuUsuario(){
        System.out.println("\t Bienvenido(a) \t");
        System.out.println("1. Registrar antecedente");
        System.out.println("2. Eliminar antecedente");
        System.out.println("3. Ver antecedentes");
        System.out.println("4. Editar datos personales");
        System.out.println("5. Salir");
        opcion = teclado.nextByte();
        switch(opcion){
            case 1:
                registrarAntecedentes();
                break;
            case 2:
                eliminarAntecedentes();
                break;
            case 3:
                toString();
                break;
            case 4:
                editarDatosPersonales(persona.getCedula());
                break;
            default:
                menu();
                break;
        }
    }
    
    private void registrarAntecedentes(){
        
    }
    
    private void eliminarAntecedentes(){
        
    }

    @Override
    public String toString() {
        return "";
    }
    
    private void editarDatosPersonales(long cedula){
        
        System.out.println("Nombre: ");
        persona.setNombre(teclado.next());
        System.out.println("Apellido: ");
        persona.setApellido(teclado.next());
        System.out.println("Edad: ");
        persona.setEdad(teclado.nextByte());
        
        usuario.replace(cedula, persona);
        System.out.println("ACTUALIZADO CORRECTAMENTE");
    }
}
