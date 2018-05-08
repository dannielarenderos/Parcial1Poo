/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;

import java.util.Objects;

/**
 *
 * @author OLMEDO <00097017@uca.edu.sv>
 */
public class Cliente extends Persona {

/**
 * Constructor vacio
 */
    public Cliente() {
    }
    /**
     * Constructor solamente con atributo Dui(usado para pruebas)
     * @param dui 
     */
    public Cliente(String dui) {
        this.dui = dui;
    }
/**
 * Constructor sobrecargado con todos los atributos heredados de la clase Persona
 * @param nombre
 * @param dui
 * @param telefono
 * @param email 
 */
    public Cliente(String nombre, String dui, String telefono, String email) {
        this.dui = dui;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email= email;
    }
/**
 * Metodos Setters & Getters
 * @return 
 */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * Metodo hashacode usado para comparar dos objetos de la clase Cliente
     * @return 
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.dui);
        return hash;
    }
    /**
     * Metodo equals usado para comparar dos objetos Cliente tomando solo en cuenta el atributo Dui
     * @param obj
     * @return 
     */
    
    public boolean equals2(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Persona other = (Persona) obj;

        if (!Objects.equals(this.dui, other.dui)) {
            return false;
        }
        return true;
    }
    /**
     * Metodo equals usado para comparar dos objetos Cliente tomando solo en cuenta el atributo Dui y Nombre
     * @param obj
     * @return 
     */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Persona other = (Persona) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.dui, other.dui)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "\nDatos del cliente:\n" + "+Nombre:" + nombre + ", +Dui:" + dui + ", +Telefono:"+telefono+", +Email: "+email+"\n";
    }
}
