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
 * Menú principal
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

        System.out.println("----- BIENVENIDO AL HOTEL VIÑA RAFFIÑA -----");
        System.out.println("");
        System.out.println("----- MENÚ -----");
        System.out.println("");
        System.out.println("1. Reservaciones");
        System.out.println("2. Paquetes");
        System.out.println("3. Habitaciones");
        System.out.println("4. Pisos");
        System.out.println("5. Inventario");
        System.out.println("6. Salir");
        System.out.println("");
        System.out.print("¿Qué opción desea? ");

    }

    public void mostrar() throws ParseException {
        int opcion = 0, opcionInterna = 0;
        Scanner leer = new Scanner(System.in);
        ListaReservaciones listaReserva = new ListaReservaciones();
        ListaPaquete listaPack = new ListaPaquete();

        int ascii = 64;
        String letra, letraPrim, letraSeg;
        int cantHab = 10, cantPiso = 6;
        int parteEnt = cantPiso / 26;
        int residuo = cantPiso % 26;
        float precioBase = 100;
        ListaPisos listaPisos = new ListaPisos();

        if (parteEnt == 0) {
            for (int i = 1; i <= cantPiso; i++) {
                Piso piso = new Piso();
                letra = Character.toString((char) (ascii + i));
                piso.add(cantHab, letra, precioBase);
                piso.setLetra(letra);
                piso.setNumero(i);
                piso.setEstado("disponible");
                listaPisos.add(piso);
            }
        } else {
            for (int i = 1; i <= 26; i++) {
                Piso piso = new Piso();
                letra = Character.toString((char) (ascii + i));
                piso.add(cantHab, letra, precioBase);
                piso.setLetra(letra);
                piso.setNumero(i);
                piso.setEstado("disponible");
                listaPisos.add(piso);
            }

            if (cantPiso > 26) {
                for (int j = 1; j < parteEnt; j++) {
                    //Piso piso = new Piso();
                    letraPrim = Character.toString((char) (ascii + j));

                    for (int k = 1; k <= 26; k++) {
                        Piso piso = new Piso();
                        letraSeg = Character.toString((char) (ascii + k));
                        letra = letraPrim + letraSeg;
                        piso.add(cantHab, letra, precioBase);
                        piso.setLetra(letra);
                        piso.setNumero((26 * j) + k);
                        piso.setEstado("disponible");
                        listaPisos.add(piso);
                    }
                }
                if (residuo != 0) {
                    for (int m = 1; m <= 1; m++) {
                        letraPrim = Character.toString((char) (ascii + parteEnt));
                        for (int n = 1; n <= residuo; n++) {
                            Piso piso = new Piso();
                            letraSeg = Character.toString((char) (ascii + n));
                            letra = letraPrim + letraSeg;
                            piso.add(cantHab, letra, precioBase);
                            piso.setLetra(letra);
                            piso.setNumero((26 * parteEnt) + n);
                            piso.setEstado("disponible");
                            listaPisos.add(piso);
                        }
                    }
                }
            }
        }
        listaPisos.precioBaseHotel(precioBase);

        while (opcion != 6) {
            opciones();
            try {
                opcion = leer.nextInt();

                switch (opcion) {
                    case 1:
                        opcionInterna = 0;
                        while (opcionInterna != 5) {
                            try {
                                System.out.println("-----RESERVACIONES-----");
                                System.out.println("1. Ver reservaciones activas");
                                System.out.println("2. Agregar Reservacion");
                                System.out.println("3. Eliminar reservacion");
                                System.out.println("4. Ver ganancias por hospedaje");
                                System.out.println("5. Volver al menu principal");
                                System.out.println("");
                                System.out.print("¿Qué opción desea? ");
                                System.out.println("");

                                opcionInterna = leer.nextInt();
                                switch (opcionInterna) {
                                    case 1:
                                        System.out.println("Reservaciones activas");
                                        System.out.println("");
                                        listaReserva.mostrar();
                                        System.out.println("");

                                        break;
                                    case 2:
                                        System.out.println(" Agregar nueva reservacion");
                                        System.out.println("");

                                        int n = listaPack.NumPack();
                                        System.out.println("Ingrese el numero del piso que quiere reservar");
                                        int numpiso1 = leer.nextInt();
                                        if (numpiso1 <= listaPisos.listaPisos.size()) {
                                            System.out.println("Ingrese el numero de la habitacion que quiere reservar");
                                            System.out.println("");

                                            int numhab1 = leer.nextInt();
                                            Piso piso = listaPisos.listaPisos.get(numpiso1 - 1);
                                            if (numhab1 <= piso.piso.size()) {
                                                Habitacion hab = piso.piso.get(numhab1 - 1);
                                                Fecha fecha = new Fecha(hab.getPrecioHab());
                                                Gastos gasto = new Gastos(listaPack.get(n), fecha);
                                                listaReserva.annadir(listaPack, fecha, n, gasto, hab, piso);
                                            } else {
                                                System.err.println("El numero de habitacion ingresado no existe, intente con otro");
                                            }
                                        } else {
                                            System.err.println("El numero de piso ingresado no existe");
                                        }
                                        break;
                                    case 3:
                                        System.out.println(" Eliminar Reservacion ");
                                        System.out.println("");
                                        listaReserva.eliminarReservacion();
                                        break;
                                    case 4:
                                        listaReserva.mostrarGanancias();
                                        break;
                                }

                            } catch (InputMismatchException e) {
                                System.err.println("Por favor, Ingrese un número del 1 al 5");
                                leer.nextLine();
                            }
                        }
                        break;

                    case 2:
                        opcionInterna = 0;
                        while (opcionInterna != 5) {

                            try {
                                System.out.println("-----PAQUETES-----");
                                System.out.println("1. Ver paquetes disponibles");
                                System.out.println("2. Modificar paquetes");
                                System.out.println("3. Agregar paquete");
                                System.out.println("4. Eliminar paquete");
                                System.out.println("5. Volver al menu principal");
                                System.out.println("");
                                System.out.print("¿Qué opción desea? ");
                                System.out.println("");

                                opcionInterna = leer.nextInt();
                                switch (opcionInterna) {
                                    case 1:
                                        System.out.println(" Paquetes disponibles ");
                                        System.out.println("");
                                        listaPack.mostrarPaquetes();
                                        System.out.println("");

                                        break;
                                    case 2:
                                        System.out.println(" Modificar paquete");
                                        System.out.println("");
                                        listaPack.mostrarPaquetes();
                                        System.out.println("");

                                        listaPack.modificarPaquete();

                                        break;
                                    case 3:
                                        System.out.println(" Agregar paquete ");
                                        System.out.println("");
                                        listaPack.agregarPaquete();
                                        System.out.println("");

                                        break;
                                    case 4:
                                        System.out.println(" Eliminar paquete ");
                                        System.out.println("");
                                        listaPack.eliminarPaquete();
                                        System.out.println("");

                                        break;
                                }
                            } catch (InputMismatchException e) {
                                System.err.println("Por favor, Ingrese un número del 1 al 5");
                                leer.nextLine();
                            }
                        }
                        break;
                    case 3:
                        opcionInterna = 0;
                        while (opcionInterna != 5) {
                            try {

                                System.out.println("-----HABITACIONES-----");
                                System.out.println("1. Ver habitaciones");
                                System.out.println("2. Ver habitaciones por estado");
                                System.out.println("3. Modificar precio de habitaciones");
                                System.out.println("4. Modificar estado de habitaciones");
                                System.out.println("5. Volver al menu principal");
                                System.out.println("");
                                System.out.print("¿Qué opción desea? ");
                                System.out.println("");

                                opcionInterna = leer.nextInt();
                                switch (opcionInterna) {
                                    case 1:
                                        System.out.println(" Habitaciones disponibles ");
                                        System.out.println("");
                                        listaPisos.mostrar();
                                        break;
                                    case 2:
                                        System.out.println(" Habitaciones por estado");
                                        System.out.println("");
                                        try {
                                            System.out.print("Ingrese el numero de piso: ");
                                            int numPisoVer = leer.nextInt();
                                            if (numPisoVer <= listaPisos.listaPisos.size()) {
                                                System.out.print("Ingrese el estado de las habitaciones a mostrar: ");
                                                String estado = leer.next();
                                                Piso pisoV = listaPisos.listaPisos.get(numPisoVer - 1);
                                                pisoV.mostrarHabitacionesPisoEstado(estado, 0);
                                            } else {
                                                System.err.println("El numero de piso ingresado no existe");
                                            }
                                        } catch (InputMismatchException e) {
                                            System.err.println("Por favor, Ingrese un número");
                                            leer.nextLine();
                                        }
                                        break;
                                    case 3:
                                        try {
                                            System.out.println(" Modificar precio de habitacion");
                                            System.out.println("");
                                            System.out.println("Ingrese el nuevo precio base de la habitacion");
                                            float precioB = leer.nextFloat();
                                            listaPisos.precioBaseHotel(precioB);
                                        } catch (InputMismatchException e) {
                                            System.err.println("Por favor, Ingrese un número");
                                            leer.nextLine();
                                        }
                                        break;
                                    case 4:
                                        try {
                                            System.out.println(" Modificar estado de habitacion ");
                                            System.out.println("");
                                            System.out.println("Ingrese el numero del piso que quiere modificar");
                                            int numPiso2 = leer.nextInt();
                                            if (numPiso2 <= listaPisos.listaPisos.size()) {
                                                System.out.println("Ingrese el numero de la habitacion que quiere modificar");
                                                int numHab = leer.nextInt();
                                                Piso piso = listaPisos.listaPisos.get(numPiso2 - 1);
                                                if (numHab <= piso.piso.size()) {
                                                    Habitacion hab = piso.piso.get(numHab - 1);
                                                    hab.mostrar(hab);
                                                    hab.setEstado("mantenimiento");
                                                    hab.mostrar(hab);
                                                    System.out.println("Estado modificado con exito");
                                                } else {
                                                    System.err.println("El numero de habitacion no existe");
                                                }
                                            } else {
                                                System.err.println("El numero de piso no existe");
                                            }
                                        } catch (InputMismatchException e) {
                                            System.err.println("Por favor, Ingrese un número");
                                            leer.nextLine();
                                        }
                                        break;

                                }
                            } catch (InputMismatchException e) {
                                System.err.println("Por favor, Ingrese un número del 1 al 5");
                                leer.nextLine();
                            }
                        }
                        break;

                    case 4:
                        opcionInterna = 0;
                        while (opcionInterna != 5) {
                            try {
                                System.out.println("-----PISOS-----");
                                System.out.println("1. Ver pisos activos");
                                System.out.println("2. Ver pisos por estado");
                                System.out.println("3. Modificar estado de piso");
                                System.out.println("4. Ampliar hotel: Agregar piso");
                                System.out.println("5. Volver al menu principal");
                                System.out.println("");
                                System.out.print("¿Qué opción desea? ");
                                System.out.println("");

                                opcionInterna = leer.nextInt();
                                switch (opcionInterna) {
                                    case 1:
                                        System.out.println(" Pisos activos ");
                                        System.out.println("");
                                        listaPisos.mostrarPisos();
                                        break;
                                    case 2:
                                        System.out.println(" Pisos por estados ");
                                        System.out.println("");
                                        System.out.print("Ingrese el estado de los pisos a mostrar: ");
                                        String estadoV = leer.next();
                                        listaPisos.mostrarPisosEstado(estadoV);
                                        break;
                                    case 3:
                                        try {
                                            System.out.println(" Modificar estado de piso ");
                                            System.out.println("");
                                            System.out.println("Ingrese el numero del piso que quiere modificar");
                                            int numpiso = leer.nextInt();
                                            if (numpiso <= listaPisos.listaPisos.size()) {
                                                Piso floor = listaPisos.listaPisos.get(numpiso - 1);
                                                floor.setEstado("mantenimiento");
                                                System.out.println("Estado modificado con exito");
                                            } else {
                                                System.err.println("El piso ingresado no existe");
                                            }
                                        } catch (InputMismatchException e) {
                                            System.err.println("Por favor, Ingrese un número");
                                            leer.nextLine();
                                        }
                                        break;
                                    case 4:
                                        try {
                                            System.out.println(" Agregar nuevo piso ");
                                            System.out.println("");
                                            System.out.println("Cuantos pisos desea ingresar");
                                            int pisoExtra = leer.nextInt();
                                            parteEnt = pisoExtra / 26;
                                            residuo = pisoExtra % 26;
                                            System.out.println("Cuantas habitaciones desea ingresar");
                                            int habExtra = leer.nextInt();

                                            if (parteEnt == 0) {
                                                for (int i = 1; i <= pisoExtra; i++) {
                                                    Piso piso = new Piso();
                                                    letra = Character.toString((char) (ascii + i + cantPiso));
                                                    System.out.println(letra);
                                                    System.out.println("1");

                                                    piso.add(cantHab, letra, precioBase);
                                                    piso.setLetra(letra);
                                                    piso.setNumero(i + cantPiso);
                                                    piso.setEstado("disponible");
                                                    listaPisos.add(piso);
                                                }
                                            } else {
                                                for (int i = 1; i <= 26; i++) {
                                                    Piso piso = new Piso();
                                                    letra = Character.toString((char) (ascii + i + cantPiso));
                                                    System.out.println(letra);
                                                    System.out.println("2");

                                                    piso.add(cantHab, letra, precioBase);
                                                    piso.setLetra(letra);
                                                    piso.setNumero(i + cantPiso);
                                                    piso.setEstado("disponible");
                                                    listaPisos.add(piso);
                                                }

                                                if (pisoExtra > 26) {
                                                    for (int j = 1; j < parteEnt; j++) {
                                                        letraPrim = Character.toString((char) (ascii + j));

                                                        for (int k = 1; k <= 26; k++) {
                                                            Piso piso = new Piso();
                                                            letraSeg = Character.toString((char) (ascii + k));
                                                            letra = letraPrim + letraSeg;
                                                            System.out.println(letra);
                                                            System.out.println("3");

                                                            piso.add(cantHab, letra, precioBase);
                                                            piso.setLetra(letra);
                                                            piso.setNumero((26 * j) + k);
                                                            piso.setEstado("disponible");
                                                            listaPisos.add(piso);
                                                        }
                                                    }
                                                    if (residuo != 0) {
                                                        for (int m = 1; m <= 1; m++) {
                                                            letraPrim = Character.toString((char) (ascii + parteEnt));
                                                            for (int n = 1; n <= residuo; n++) {
                                                                Piso piso = new Piso();
                                                                letraSeg = Character.toString((char) (ascii + n));
                                                                letra = letraPrim + letraSeg;
                                                                System.out.println(letra);
                                                                System.out.println("4");

                                                                piso.add(cantHab, letra, precioBase);
                                                                piso.setLetra(letra);
                                                                piso.setNumero((26 * parteEnt) + n);
                                                                piso.setEstado("disponible");
                                                                listaPisos.add(piso);
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                            listaPisos.precioBaseHotel(precioBase);

//                                            for (int i = 1; i <= pisoExtra; i++) {
//                                                Piso floor2 = new Piso();
//                                                if (i >= 1 && i <= 26) {
//                                                    ascii = 64 + i + cantPiso;
//                                                    letra = Character.toString((char) ascii);
//                                                    floor2.add(habExtra, letra, precioBase);
//                                                    floor2.setLetra(letra);
//                                                }
//                                                floor2.setNumero(i + cantPiso);
//                                                floor2.setEstado("disponible");
//                                                //floor2.precioBase(precioBase);
//                                                listaPisos.add(floor2);
//                                                listaPisos.precioBaseHotel(precioBase);
//                                            }
                                            cantPiso += pisoExtra;
                                        } catch (InputMismatchException e) {
                                            System.err.println("Por favor, Ingrese un número");
                                            leer.nextLine();
                                        }
                                        break;
                                }
                            } catch (InputMismatchException e) {
                                System.err.println("Por favor, Ingrese un número del 1 al 5");
                                leer.nextLine();
                            }
                        }
                        break;
                    case 5:
                        opcionInterna = 0;
                        while (opcionInterna != 2) {
                            try {
                                System.out.println(" -----INVENTARIO-----");
                                System.out.println("1. Ver inventario  ");
                                System.out.println("2. Volver al menu principal");
                                System.out.println("");
                                opcionInterna = leer.nextInt();
                                switch (opcionInterna) {
                                    case 1:
                                        System.out.println(" Regristo de ganancias ");
                                        System.out.println("");
                                        listaReserva.mostrarGanancias();
                                        break;

                                }
                            } catch (InputMismatchException e) {
                                System.err.println("Por favor, Ingrese un numero del 1 al 2 ");
                                leer.nextLine();
                            }
                        }
                        break;
                }
                System.out.println("");

            } catch (InputMismatchException e) {
                System.err.println("Por favor, Ingrese un número");
                leer.nextLine();
            }

        }
        System.out.println("Que tenga un buen dia :)");
    }
}
