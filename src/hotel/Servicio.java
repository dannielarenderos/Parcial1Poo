package hotel;

import java.util.Objects;

/**
 *
 * @author Jeniffer Merino
 */
public class Servicio {

    public String nombre;

    /**
     * constructor vacio
     */
    public Servicio() {

    }
/**
 * constructor con parametro
 * @param nombre 
 */
    public Servicio(String nombre) {
        this.nombre = nombre;
    }
/**
 * set y get
 * @return  nombre
 */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
/**
     * Metodo hashacode usado para comparar dos objetos de la clase Servicio
     * @return 
     */
    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }
/**
 * compara dos objetos para saber si son iguales tomando el atributo nombre
 * @param obj
 * @return boolean
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
        final Servicio other = (Servicio) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }

}
