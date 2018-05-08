
package hotel;

import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author Jeniffer Merino
 */
public class ListaServicios {

    Scanner entrada = new Scanner(System.in);

    ArrayList<Servicio> listaServicio = new ArrayList<>();

    public ListaServicios(String nombrePaquete) {
        if (nombrePaquete == "no") {

        }
        if (nombrePaquete == "Premium") {
            Servicio servicio1 = new Servicio("Buffet Desayuno");
            Servicio servicio2 = new Servicio("Acceso ilimitado a piscina");
            Servicio servicio3 = new Servicio("Servicio a la habitacion");
            Servicio servicio4 = new Servicio("Acceso ilimitado al minibar");
            Servicio servicio5 = new Servicio("internet ilimitado");

            listaServicio.add(servicio1);
            listaServicio.add(servicio2);
            listaServicio.add(servicio3);
            listaServicio.add(servicio4);
            listaServicio.add(servicio5);
        }
        if (nombrePaquete == "Basico") {

            Servicio servicio2 = new Servicio("Acceso ilimitado a piscina");
            Servicio servicio5 = new Servicio("internet ilimitado");

            listaServicio.add(servicio2);
            listaServicio.add(servicio5);

        }
        if (nombrePaquete == "custom") {
            Scanner entrada2 = new Scanner(System.in);
            System.out.println("Cuantos servicios quiere?");
            int n = entrada.nextInt();
            for (int i = 1; i <=n; i++) {
                System.out.println("Ingrese el nombre del servicio");
                String nuevoSer=entrada2.nextLine();
                Servicio servicio = new Servicio(nuevoSer);
                listaServicio.add(servicio);
                System.out.println("Se agrego con exito el servicio");
            }

        }

    }

/**
 * Permite  agregar un nuevo servicio a la listaServicio y al mismo tiempo valida si el servicio a ingresar ya existe o no
 */
public void AgregarNuevoServicio() {
        System.out.println("Ingrese el nombre del nuevo servicio");
        Servicio servicio = new Servicio(entrada.nextLine());
        for (Servicio ser : listaServicio) {
            if (ser.equals(servicio)) {
                System.out.println("Este servicio ya existe");
                return;
            }
        }
        listaServicio.add(servicio);
        System.out.println("Se agrego con exito el servicio");
    }
/**
 * muestra los servicios
 * @return servicio
 */
    public String mostrar() {
        String palabras = "";
        for (Servicio s : listaServicio) {
            palabras += ", " + s.getNombre();
        }
        return palabras;
    }
/**
 * elimina determinado servicio
 */
    public void eliminar() {
        System.out.println("que servicio desea eliminar");
        Servicio servicio = new Servicio(entrada.nextLine());
        int pos = 0;

        for (Servicio ser : listaServicio) {
            if (ser.equals(servicio)) {
                listaServicio.remove(pos);
                System.out.println("Servicio eliminado");
                return;
            }
            pos = pos + 1;

        }
        System.out.println("Servicio no encontrado");
    }
}

