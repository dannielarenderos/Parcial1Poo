
package hotel;

import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author Jeniffer Merino
 */
public class ListaPaquete {
    Scanner entrada= new Scanner(System.in);
    ArrayList<Paquete> listaPaquetes = new ArrayList<>();

    public ListaPaquete() {
        ListaServicios sinservicios = new ListaServicios("No");
        Paquete sinpaquete = new Paquete("No", sinservicios, 0);
        ListaServicios serviciosBasicos = new ListaServicios("Basico");
        Paquete paqueteBasico = new Paquete("Basico", serviciosBasicos, 10);
        ListaServicios serviciosPremium = new ListaServicios("Premium");
        Paquete paquetePremium = new Paquete("Premium", serviciosPremium, 150);
        listaPaquetes.add(sinpaquete);
        listaPaquetes.add(paqueteBasico);
        listaPaquetes.add(paquetePremium);
    }
    
    
    public void mostrarPaquetes(){
        int n=0;
        for(Paquete pack: listaPaquetes){
            System.out.println(n+". "+pack.toString());
            n++;
        }
    }
    
    public void agregarPaquete (){
        System.out.println("Escriba el nombre del nuevo Paquete");
        String nombrePaquete=entrada.nextLine();
        System.out.println("Ingrese el precio del nuevo paquete");
        int precioPaquete=entrada.nextInt();
        ListaServicios listaServiciosNuevos= new ListaServicios("custom");
        Paquete paqueteNuevos= new Paquete(nombrePaquete,listaServiciosNuevos,precioPaquete);
        listaPaquetes.add(paqueteNuevos);
        
    }
    
    public void eliminarPaquete() {
        Scanner entrada3= new Scanner(System.in);
        System.out.println("que paquete desea eliminar");
        Paquete paquete = new Paquete (entrada3.nextLine());
        int pos = 0;

        for (Paquete pack : listaPaquetes) {
            if (pack.equals(paquete)) {
                listaPaquetes.remove(pos);
                System.out.println("Paquete  eliminado");
                return;
            }
            pos = pos + 1;

        }
        System.out.println("Paquete no encontrado");
    }
    public void modificarPaquete(){
        Scanner entrada3= new Scanner(System.in);
        System.out.println("Que paquete desea modificar(nombre)");
        Paquete paquete = new Paquete (entrada3.nextLine());
        for (Paquete pack : listaPaquetes) {
            if (pack.equals(paquete)) {
                Scanner entrada4= new Scanner(System.in);
                System.out.println("Que desea modificar?\n1.Nombre\n2.Servicios\n3.Precio");
                int n= entrada4.nextInt();
                switch(n){
                    case 1:
                        pack.setTipo(entrada3.nextLine());
                        break;
                    case 2:
                        ListaServicios listaServiciosNuevos= new ListaServicios("custom");
                        pack.setServicios(listaServiciosNuevos);
                        break;
                    case 3:
                        pack.setPrecio(entrada4.nextFloat());
                        break;
                    default:
                        System.out.println("Opcion no valida");
                }
                System.out.println("Paquete  modificado");
                return;
            }

        }
        System.out.println("Paquete no encontrado");
        
    }
    public Paquete get(int n){
        return listaPaquetes.get(n);
    }

}

