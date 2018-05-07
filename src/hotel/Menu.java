/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;

import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Danniela Renderos 
 */
public class Menu {

    private static Menu menu;

    private Menu() {
    }

    public static Menu getInstance() {
        if (menu == null) {
            menu = new Menu();
        }
        return menu;
    }

    public void opciones() {

        System.out.println("----- Bienvenido al Hotel Viña Raffiña -----");
        System.out.println("");
        System.out.println("----- Menu Hotel Viña Raffiña -----");
        System.out.println("");
        System.out.println("1. Reservaciones");
        System.out.println("2. Pisos");
        System.out.println("3. Habitaciones");
        System.out.println("4. Paquetes");
        System.out.println("5. Inventario");
        System.out.println("6. Salir");
        System.out.println("");

    }

    public void mostrar() throws ParseException {
        int opcion = 0, opcionInterna = 0;
        Scanner leer = new Scanner(System.in);
        ListaReservaciones listaReserva = new ListaReservaciones();
        ListaPaquete listaPack = new ListaPaquete();

        int ascii;
        String letra;
        int cantHab = 10, cantPiso = 6;
        float precioBase = 100;
        ListaPisos listaPisos = new ListaPisos();

        for (int i = 1; i <= cantPiso; i++) {
            Piso piso = new Piso();
            if (i >= 1 && i <= 26) {
                ascii = 64 + i;
                letra = Character.toString((char) ascii);
                piso.add(cantHab, letra, precioBase);
                piso.setLetra(letra);
            }
            piso.setNumero(i);
            piso.setEstado("disponible");
            //piso.setPrecioPiso(precioBase);
            //piso.precioBase(precioBase);
            listaPisos.add(piso);
            //listaPisos.precioBaseHotel(precioBase);
        }
        listaPisos.precioBaseHotel(precioBase);

        while (opcion != 6) {
            opciones();
            try {
                opcion = leer.nextInt();

                switch (opcion) {
                    case 1:

                        while (opcionInterna != 4) {
                            try {
                                System.out.println("1. -----RESERVACIONES-----");
                                System.out.println("1. Ver reservaciones activas");
                                System.out.println("2. Agregar Reservacion");
                                System.out.println("3. Eliminar reservacion");
                                System.out.println("4. Volver al menu principal");
                                System.out.println("");
                                opcionInterna = leer.nextInt();
                                switch (opcionInterna) {
                                    case 1:
                                        System.out.println(" Reservaciones activas");
                                        System.out.println("");

                                        listaReserva.mostrar();
                                        break;
                                    case 2:
                                        System.out.println(" Agregar nueva reservacion");
                                        System.out.println("");

                                        System.out.println("Que paquete elegira?");
                                        listaPack.mostrarPaquetes();
                                        Scanner leer2 = new Scanner(System.in);
                                        int n = leer2.nextInt();

                                        System.out.println("Ingrese el numero del piso que quiere reservar");
                                        int numpiso1 = leer.nextInt();
                                        System.out.println("Ingrese el numero de la habitacion que quiere reservar");
                                        int numhab1 = leer.nextInt();
                                        Piso piso = listaPisos.listaPisos.get(numpiso1 - 1);
                                        Habitacion hab = piso.piso.get(numhab1 - 1);

                                        Fecha fecha = new Fecha(hab.getPrecioHab());
                                        Gastos gasto = new Gastos(listaPack.get(n), fecha);
                                        listaReserva.annadir(listaPack, fecha, n, gasto, hab, piso);
                                        break;
                                    case 3:
                                        System.out.println(" Eliminar Reservacion ");
                                        System.out.println("");
                                        listaReserva.eliminarReservacion();

                                        break;                                     
                                }                          
                                
                            }                            
                            catch (InputMismatchException e) {
                                System.err.println("Por favor, Ingrese un número del 1 al 3");
                                leer.nextLine();
                            }
                        }

                    
                        
//Resto de cases                  
                        
                   
                        
                        
                        
                        
                }
            } catch (InputMismatchException e) {
                System.err.println("Por favor, Ingrese un número");
                leer.nextLine();
            }

        }
    }
}
