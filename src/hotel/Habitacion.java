package hotel;

import java.util.Date;

/**
 *
 * @author Cesar Rosales <00060917@uca.edu.sv>
 */
public class Habitacion {

    public int numero;
    public String piso;
    public String codigo;
    public String tipo;
    public String estado;
    public float precioHab;
    public Date fechaFinal;

    public Habitacion() {
    }

    public Habitacion(int numero, String piso, String codigo, String tipo, String estado, float precioHab) {
        this.numero = numero;
        this.piso = piso;
        this.codigo = codigo;
        this.tipo = tipo;
        this.estado = estado;
        this.precioHab = precioHab;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public float getPrecioHab() {
        return precioHab;
    }

    public void setPrecioHab(float precioHab) {
        this.precioHab = precioHab;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    /**
     * Sobreescribe el toString para mostrar los elementos de una habitacion
     * @return 
     */
    @Override
    public String toString() {
        return "Habitacion{" + "numero=" + numero + " piso=" + piso + " codigo=" + codigo + " tipo=" + tipo + " estado=" + estado + " precio=" + precioHab + '}';
    }
    /**
     * Muestra los datos de una habitacion en especifico
     * @param habitacion 
     */
    public void mostrar(Habitacion habitacion) {
        System.out.println(habitacion.toString());
    }
    
}
