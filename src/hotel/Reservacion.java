/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;
import java.util.Objects;

/**
 *
 * @author Danniela Renderos
 */
public class Reservacion {
       
    Cliente cliente;
    Paquete paquete;
    Fecha fecha;
    Gastos gasto;
    Habitacion habitacion;
    Piso piso;
    int n;
    
    public Reservacion() {

    }
    public Reservacion(Cliente cliente, Paquete paquete, Fecha fecha,int n, Gastos gasto ,Habitacion habitacion, Piso piso){
        this.cliente=cliente;
        this.paquete=paquete;
        this.habitacion = habitacion;
        this.piso = piso;
        this.fecha = fecha;
        this.gasto=gasto;
        this.n=n;
    }
    
    
   
//

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Paquete getPaquete() {
        return paquete;
    }

    public void setPaquete(Paquete paquete) {
        this.paquete = paquete;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }
    



    void getPiso(String next) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    } 

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public String toString() {
        return "Reservacion{" + "cliente=" + cliente.toString() + ", paquete=" + paquete.toString() + '}';
    }

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
        final Reservacion other = (Reservacion) obj;
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        if (!Objects.equals(this.paquete, other.paquete)) {
            return false;
        }
        return true;
    }


   
}
