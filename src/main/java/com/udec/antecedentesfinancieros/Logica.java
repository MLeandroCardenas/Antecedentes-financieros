 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.antecedentesfinancieros;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Michael Cardenas
 * clase principal donde se piden datos y se arma todo el programa
 */
public class Logica {
    
    /**
     * atributos de la clase necesarios tipo clase
     */
    Persona persona;
    Antecedente antecedente;
    HashMap<Long,Persona> usuario; 
    List<Antecedente> listanueva;
    
    Scanner teclado;
    String[]tipoAntecedentes = {"Pago impuestos","Pago servicios","Prestamos bancarios","Pago al IVA"};
    byte opcion;
    
    /**
     * constructor de la clase para inicializar las variables
     */
    public Logica() {
        usuario = new HashMap<>();
        listanueva = new ArrayList<>();
        teclado = new Scanner(System.in);
        opcion = 0;
    }
    
    /**
     * metodo para el registro e ingreso al sistema
     */
    public void menu(){
        while(opcion!=3){
            System.out.println("\t Antecedentes financieros \t");
            System.out.println("Seleccione...");
            System.out.println("1.Registrarse");
            System.out.println("2. Ingresar");
            System.out.println("3. Salir");
            opcion = teclado.nextByte();
            
           if(opcion==1) {
               persona = new Persona();
               registro();
           }
                else if(opcion==2) ingreso();
                else{
                    //imprimir(persona.getCedula());
                    serializar(listanueva);
                    opcion = 3;
                } 
        }
    }
    
    /**
     * metodo para registrar la persona 
     */
    private void registro(){
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
        
        if(usuario.isEmpty()){
            usuario.put(persona.getCedula(),persona);
        }else{
            boolean resultado = validarUsuarios(persona.getCedula());
            if(resultado==true) System.out.println("El usuario ya existe");
            if(resultado==false) usuario.put(persona.getCedula(),persona);
        }
        serializar(usuario);
    }
    
    /**
     * metodo para imprimir usuarios se uso de prueba
     * @param cedula recibe la cedula para imprimir solo el usuario correspondiente a la cedula
     */
    public void imprimir(long cedula){
        if(usuario.isEmpty()){
            System.out.println("Salir");
        }
        else{
            for (Map.Entry<Long, Persona> entrySet : usuario.entrySet()) {
                Persona value = entrySet.getValue();
                Long key = entrySet.getKey();
                if(key==cedula)
                System.out.println("Nombre: " + value.getNombre() + " Edad: " + value.getEdad());
            }
        }
        
    }
    
    /**
     * metodo para ingresar al sistema una vez se registro
     */
    private void ingreso(){
        deserializar(usuario);
        
        if(usuario.isEmpty()){
            System.out.println("DEBE HABER AL MENOS UN USUARIO REGISTRADO");
            menu();
        }else{
            persona = new Persona();
            boolean resultado;
            System.out.println("Digite su numero de cedula");
            persona.setCedula(teclado.nextLong());
            resultado = validarUsuarios(persona.getCedula());
            if(resultado==true) menuUsuario();
            if(resultado==false) System.out.println("NO ESTA REGISTRADO");
        }    
    }
    
    /**
     * metodo para validar que los usuarios no se repitan
     * @param cedula se valida con la cedula ya que es un atributo unico de cada persona
     * @return devuelve verdadero si ya existe de lo contrario false
     */
    private boolean validarUsuarios(long cedula){
        for (Map.Entry<Long, Persona> entrySet : usuario.entrySet()) {
            Long key = entrySet.getKey();
            if(key.equals(cedula))
                return true;
        }
        return false;
    }
    
    /**
     * menu del usuario que ya ingreso al sistema
     */
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
                registrarAntecedentes(persona.getCedula());
                break;
            case 2:
                eliminarAntecedentes(persona.getCedula());
                break;
            case 3:
                antecedentes(persona.getCedula());
                break;
            case 4:
                editarDatosPersonales(persona.getCedula());
                break;
            default:
                menu();
                break;
        }
    }
    
    /**
     * metoo para registrar los antecedentes
     * @param cedula para registrarselos a la persona con ese dato en especifico
     */
    private void registrarAntecedentes(long cedula){   
        Scanner sc  =new Scanner(System.in);
         antecedente = new Antecedente();
        System.out.println("Seleccione el tipo de antecedente");
        System.out.println("1. Pago impuestos");
        System.out.println("2. Pago servicios");
        System.out.println("3. Prestamos bancarios");
        System.out.println("4. Pago al IVA");
        opcion = teclado.nextByte();
        if(opcion==1) antecedente.setNombreCaracteristico(tipoAntecedentes[0]);
        else if(opcion ==2) antecedente.setNombreCaracteristico(tipoAntecedentes[1]);
        else if(opcion == 3) antecedente.setNombreCaracteristico(tipoAntecedentes[2]);
        else if(opcion == 4) antecedente.setNombreCaracteristico(tipoAntecedentes[3]);
        else{
            System.out.println("NO EXISTEN MAS TIPOS DE ANTECEDENTES"); menuUsuario();
        }
        System.out.println("Describa la transaccion: ");
        String transaccion = sc.nextLine();
        antecedente.setDescripcion(transaccion);
        System.out.println("Fecha de la transaccion: ");
        antecedente.setFecha(teclado.next());
        System.out.println("Considera usted su movimiento como un antecedente positivo:  1.SI  2.NO");
        opcion = teclado.nextByte();
        if(opcion==1) antecedente.setCalificacion("positivo");
        else antecedente.setCalificacion("negativo");
        antecedente.setIdentificador(cedula);
        listanueva.add(antecedente);
        int i = 0;
        serializar(listanueva);
        menuUsuario();
    }
    
    /**
     * elimina solo los antecedentes negativos
     * @param cedula para identificar el usuario
     */
    private void eliminarAntecedentes(long cedula){
        deserializar(listanueva);
        if(listanueva.isEmpty())
            System.out.println("NO TIENE ANTECEDENTES REGISTRADOS");
        else{
            System.out.println("Antecedentes negativos: seleccione uno para eliminar");
            byte contador = 0;
            Scanner sc2 = new Scanner(System.in);
            byte opcion;
            for (Antecedente i : listanueva) {
                if(i.getCalificacion().equals("negativo") & i.getIdentificador()==cedula){
                    contador++;
                    System.out.println("Numero " + contador + " Descripcion: " + i.getDescripcion() 
                            + " Fecha: " + i.getFecha() + " Calificacion: " + i.getCalificacion());
                }
            }
            opcion = sc2.nextByte();
            listanueva.remove(contador-1);
            serializar(listanueva);
        }
    }

    /**
     * mostrar los antecedentes
     * @param cedula  para identificar la persona
     */
    public void antecedentes(long cedula) {
        deserializar(listanueva);
        if(listanueva.isEmpty())
            System.out.println("NO TIENE ANTECEDENTES REGISTRADOS");
        else{
            System.out.println("Antecendentes de : " + persona.getNombre());
            for (Antecedente i : listanueva) {
                if(cedula==i.getIdentificador()){
                    System.out.println("Descripcion: " + i.getDescripcion() 
                            + " Fecha: " + i.getFecha() + " Calificacion: " + i.getCalificacion());
                }
            }
            menuUsuario();
        }
    }
    
    /**
     * edita los datos personales del usuario
     * @param cedula identificar la persona
     */
    private void editarDatosPersonales(long cedula){
        
        System.out.println("Nombre: ");
        persona.setNombre(teclado.next());
        System.out.println("Apellido: ");
        persona.setApellido(teclado.next());
        System.out.println("Edad: ");
        persona.setEdad(teclado.nextByte());
        
        usuario.replace(cedula, persona);
        System.out.println("ACTUALIZADO CORRECTAMENTE");
        menuUsuario();
    }
    
    /**
     * metodo para comprimir la lista y la guarda en un fichero
     * @param objeto recibe la lista de usuarios o se antecedentes
     */
    private void serializar(Object objeto){
        if(objeto.equals(usuario)){
            try{
                ObjectOutputStream serializando = new ObjectOutputStream(new FileOutputStream("C:\\Users\\michl\\OneDrive\\Documentos\\NetBeansProjects\\AntecedentesFinancieros\\src\\usuarios.txt"));
                serializando.writeObject(usuario);
                serializando.close();
            }catch(Exception ex){
            }
        }
        
        if(objeto.equals(listanueva)){
            try{
                ObjectOutputStream serializando = new ObjectOutputStream(new FileOutputStream("C:\\Users\\michl\\OneDrive\\Documentos\\NetBeansProjects\\AntecedentesFinancieros\\src\\antecedentes.txt"));
                serializando.writeObject(listanueva);
                serializando.close();
            }catch(Exception ex){
            }
        }
    }
    
    /**
     * metodo para recuperar la informacion de un fichero
     * @param objeto recibe la lista de usuarios o se antecedentes
     */
    private void deserializar(Object objeto){
        if(objeto.equals(usuario)){
            try{
                ObjectInputStream recuperar = new ObjectInputStream(new FileInputStream("C:\\Users\\michl\\OneDrive\\Documentos\\NetBeansProjects\\AntecedentesFinancieros\\src\\usuarios.txt"));
                usuario = (HashMap<Long,Persona>)recuperar.readObject();
                recuperar.close();   
            }catch(Exception ex){
            }
        }
        if(objeto.equals(listanueva)){
            try{
                ObjectInputStream recuperar = new ObjectInputStream(new FileInputStream("C:\\Users\\michl\\OneDrive\\Documentos\\NetBeansProjects\\AntecedentesFinancieros\\src\\antecedentes.txt"));
                listanueva = (ArrayList<Antecedente>)recuperar.readObject();
                recuperar.close();   
            }catch(Exception ex){
            }
        }
    }
}

