package com.reyes.model;
// Generated 06-may-2016 10:26:29 by Hibernate Tools 4.3.1



/**
 * Persona generated by hbm2java
 */
public class Persona  implements java.io.Serializable {


     private Integer id;
     private String nombre;
     private String apellido;
     private String dui;

    public Persona() {
    }

    public Persona(String nombre, String apellido, String dui) {
       this.nombre = nombre;
       this.apellido = apellido;
       this.dui = dui;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return this.apellido;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getDui() {
        return this.dui;
    }
    
    public void setDui(String dui) {
        this.dui = dui;
    }




}

