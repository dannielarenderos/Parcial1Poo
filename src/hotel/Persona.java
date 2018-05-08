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

public class Persona {
    public String nombre;
    public String dui;
    public String telefono;
    public String email;
/** 
 * Metodos setters & getters
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

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }
/**
 * Funcion equal para comparar la instancia de una persona con otra instancia de persona tomando en cuenta solo los atributos nombre y dui
 * @return True: Si los objetos son identicos, False: Cualquier otro caso.
 */
    @Override
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
}
