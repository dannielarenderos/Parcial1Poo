
package hotel;

import java.util.Objects;

/**
 *
 * @author Jeniffer Merino
 */
public class Paquete {

    public String tipo;
    public ListaServicios servicios;
    private float precio;
/**
 * constructor vacio 
 */
    public Paquete() {

    }
    /**
     * constructor que resive solo el parametro de tipo 
     * @param tipo 
     */
    public Paquete(String tipo){
        this.tipo=tipo;
    }
/**
 * constructor con sus parametros
 * @param tipo
 * @param servicios
 * @param precio 
 */
    public Paquete(String tipo, ListaServicios servicios, float precio) {
        this.precio = precio;
        this.servicios = servicios;
        this.tipo = tipo;

    }
/**
 * setters y getters
 * @param tipo
 * @param servicios
 * @param precio
 */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setServicios(ListaServicios servicios) {
        this.servicios = servicios;

    }
    
    public ListaServicios getServicios(){
        return servicios;
    }
    
    public void setPrecio(Float precio){
        this.precio=precio;
    }
    public float getPrecio(){
        return precio;
    }
/**
 * Sobreescribe el toString para mostrar los elementos de un paquete
 * @return todos los datos del paquete
 */
    @Override
    public String toString() {
        return "Datos del paquete:\n" + "+Nombre:" + tipo + ", +Servicios disponibles:" + servicios.mostrar() + ", +Precio diario:$" + precio + "\n";
    }
/**
     * Metodo hashacode usado para comparar dos objetos de la clase Paquete
     * @return 
     */
    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }
/**
 * compara dos objetos para saber si son iguales tomando el atributo tipo
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
        final Paquete other = (Paquete) obj;
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        return true;
    }
    
    

}
