package hotel;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Cesar Rosales <00060917@uca.edu.sv>
 */
public class Piso {

    public String letra;
    public int numero;
    public String estado;
    public float precioPiso;
    public ArrayList<Habitacion> piso;

    public Piso() {
        piso = new ArrayList<>();
    }

    public Piso(String letra, int numero, String estado, float precioPiso) {
        this.letra = letra;
        this.numero = numero;
        this.estado = estado;
        this.precioPiso = precioPiso;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public float getPrecioPiso() {
        return precioPiso;
    }

    public void setPrecioPiso(float precioPiso) {
        this.precioPiso = precioPiso;
    }

    public ArrayList<Habitacion> getPiso() {
        return piso;
    }

    public void setPiso(ArrayList<Habitacion> piso) {
        this.piso = piso;
    }

    /**
     * Sobreescribe el toString para mostrar los elementos de un piso
     *
     * @return
     */
    @Override
    public String toString() {
        return "Piso{" + "Letra=" + letra + " Numero=" + numero + " Estado=" + estado + " Precio de piso=" + precioPiso + '}';
    }

    public void add(int cantHab, String letra,float precio) {
        for (int i = 1; i <= cantHab; i++) {
            String tipo;
            if (i % 2 == 0) {
                tipo = "doble";
            } else {
                tipo = "simple";
            }
            String codigo = letra + String.valueOf(i);
            Habitacion habitacion = new Habitacion(i, letra, codigo, tipo, "disponible", precio);
            piso.add(habitacion);
        }
    }

    /**
     * Agrega una habitacion a un piso en especifico
     *
     * @param habitacion
     */
    public void add(Habitacion habitacion) {
        //String codigo = "A" + String.valueOf(num);
        piso.add(habitacion);

    }

    /**
     * Muestra los datos de un piso que le mandemos como parametro
     *
     * @param piso
     */
    public void mostrar(Piso piso) {
        System.out.println(piso.toString());
    }

    /**
     * Muestra los datos de un piso que le mandemos como parametro
     */
    public void mostrar() {
        for (Habitacion h : piso) {
            System.out.println(h.toString());
        }
    }
    
    public void precioBase(float precio){
        for (Habitacion h : piso) {
            h.setPrecioHab(precio);
        }
    }
}
