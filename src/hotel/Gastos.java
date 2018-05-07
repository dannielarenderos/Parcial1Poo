/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;


/**
 *
 * @author Danniela Renderos
 */
public class Gastos {
    Paquete paquete;
    Fecha fecha;

    public Gastos() {
    }

    public Gastos(Paquete paquete, Fecha fecha) {
        this.paquete = paquete;
        this.fecha = fecha;
    }

    public float Total(){
        float total;
        total = (paquete.getPrecio()*fecha.getDias())+(fecha.getPrecioTemporada()*fecha.getDias());
        return total;
    }
    
}
