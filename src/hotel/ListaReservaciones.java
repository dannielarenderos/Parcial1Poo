/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Danniela Renderos
 */
public class ListaReservaciones {

    private ArrayList<Reservacion> listaReserva= new ArrayList<>();   

    public ListaReservaciones() {
    }
        

    public void annadir(ListaPaquete listaPacks,Fecha fecha,int n, Gastos gasto, Habitacion habitacion, Piso piso) throws ParseException {
        Scanner leer = new Scanner(System.in);
        Scanner leer2 = new Scanner(System.in);
        System.out.println("Nombre del cliente ");
        String nombre= leer.nextLine();
        System.out.println("Dui del cliente");
        String dui=leer.nextLine();
        Cliente cliente = new Cliente(nombre,dui);  
        Paquete paquete= listaPacks.get(n);
        if(habitacion.getEstado()=="disponible"){
            Reservacion reserva = new Reservacion(cliente, paquete,fecha,n, gasto, habitacion, piso);
            for(Reservacion r: listaReserva){
                if(r.equals(reserva)){  //Se puede utilizar tambien hashcode para verificar solo por el dui
                    System.out.println("Esta reservacion se repite");
                    return;
                }
            }
            listaReserva.add(reserva);
            habitacion.setEstado("ocupado");
            System.out.println("Se annadio con exito");
        }else{
            System.out.println("Esta habitacion no esta disponible");
        }
        
    }
    public void mostrarGanancias(){
        int n=1;
        for (Reservacion r: listaReserva){
            System.out.println((n+1)+". "+r.cliente.getNombre()+", "+"ganancias: "+r.gasto.Total());
        }
    }
    public void eliminarReservacion(){
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese el dui del cliente");
        String dui= leer.next();
        Cliente cliente= new Cliente(dui);
        for (int i=0; i<listaReserva.size();i++){
            if(listaReserva.get(i).cliente.equals2(cliente)){
                listaReserva.get(i).habitacion.setEstado("disponible");
                listaReserva.remove(i);
                System.out.println("Reservacion eliminada");
                return;
            }
        }
        System.out.println("Esta reservacion no existe");
    }
     
    public void mostrar() {
        int n=1;
        for(Reservacion r: listaReserva){
            System.out.println(n+". "+r.cliente.toString()+" "+r.paquete.toString()+" "+r.fecha.toString()+"Habitacion: "+r.habitacion.getCodigo()+" TOTAL =$"+r.gasto.Total());
            n++;
        }
    }  
}
