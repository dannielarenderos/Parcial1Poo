package hotel;

import java.util.ArrayList;

/**
 *
 * @author Cesar Rosales <00060917@uca.edu.sv>
 */
public class ListaPisos {

    public ArrayList<Piso> listaPisos;

    public ListaPisos() {
        listaPisos = new ArrayList<>();
    }

    public ListaPisos(ArrayList<Piso> listaPisos) {
        this.listaPisos = listaPisos;
    }

    /**
     * Agrega un piso (que ya tiene habitaciones) a la lista de pisos (hotel)
     *
     * @param piso
     */
    public void add(Piso piso) {
        listaPisos.add(piso);
    }

    /**
     * Muestra los datos de todos los pisos
     */
    public void mostrarPisos() {
        for (Piso p : listaPisos) {
            p.mostrar(p);
        }
    }

    /**
     * Muestra los datos de todas habitaciones del hotel
     */
    public void mostrar() {
        for (Piso p : listaPisos) {
            p.mostrar();
        }
    }
    /**
     * Asigna el precio a los pisos del hotel
     * Aumenta el precio de los dos ultimos pisos en un 10%
     * @param precio 
     */
    public void precioBaseHotel(float precio) {
        for (Piso p : listaPisos) {
            p.setPrecioPiso(precio);
            p.precioBase(precio);
        }
        int numPiso = listaPisos.size();

        Piso ultimoPiso = listaPisos.get(numPiso - 1);
        Piso penulPiso = listaPisos.get(numPiso - 2);
        listaPisos.get(numPiso - 2).setPrecioPiso((float) (precio * 1.1));
        listaPisos.get(numPiso - 1).setPrecioPiso((float) (precio * 1.1));
        for (Habitacion h : ultimoPiso.getPiso()) {
            h.setPrecioHab((float) (precio * 1.1));
        }
        for (Habitacion h : penulPiso.getPiso()) {
            h.setPrecioHab((float) (precio * 1.1));
        }
    }
    /**
     * Muestra los pisos que tienen un estado en especifico
     * @param estado 
     */
    public void mostrarPisosEstado(String estado) {
        int cont = 0;
        for (Piso p : listaPisos) {
            if (p.getEstado().equals(estado.toLowerCase())) {
                cont++;
                p.mostrar(p);
            }
        }
        if (cont == 0) {
            System.out.println("No hay pisos correspondientes al estado \"" + estado + "\"");
        }
    }
}
