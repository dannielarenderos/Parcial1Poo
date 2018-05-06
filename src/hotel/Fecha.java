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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

class Fecha {

    int dias;
    float PrecioTemporada;
    Date fechaInicial;
    Date fechaFinal;

    public Fecha(float PrecioBaseHabitacion) throws ParseException {
        int flag=1;
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese la fecha inicial de reserva en formato YYYY-MM-DD");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String fechaIni = entrada.nextLine();
        System.out.println("Ingrese la fecha final de reserva en formato YYYY-MM-DD");
        String fechaFin = entrada.nextLine();

        Date fechaInicial = dateFormat.parse(fechaIni);
        Date fechaFinal = dateFormat.parse(fechaFin);

        int dias = (int) ((fechaFinal.getTime() - fechaInicial.getTime()) / 86400000);
        int mes = fechaInicial.getMonth() + 1;
        while (flag==1) {
            if (dias <= 7) {
                float PrecioTemporada = 0;
                switch (mes) {
                    case 1:
                    case 2:
                    case 5:
                    case 8:
                    case 11:
                    case 12:
                        System.out.println("Este pertenece a la temporada Alta");
                        PrecioTemporada = PrecioBaseHabitacion + 50;
                        break;
                    case 3:
                    case 4:
                    case 6:
                    case 7:
                    case 9:
                    case 10:
                        System.out.println("Este pertenece a la temporada Baja");
                        PrecioTemporada = PrecioBaseHabitacion;
                        break;
                    default:
                        System.out.println("El mes ingresado no es válido");
                }
                flag=0;
                this.dias = dias;
                this.PrecioTemporada = PrecioTemporada;
                this.fechaFinal = fechaFinal;
                this.fechaInicial = fechaInicial;
            } else {
                System.out.println("La reservacion tiene que ser menor a 7 dias ");
                System.out.println("Ingrese la fecha inicial de reserva en formato YYYY-MM-DD");
                fechaIni = entrada.nextLine();
                System.out.println("Ingrese la fecha final de reserva en formato YYYY-MM-DD");
                fechaFin = entrada.nextLine();
                fechaInicial = dateFormat.parse(fechaIni);
                fechaFinal = dateFormat.parse(fechaFin);
                dias = (int) ((fechaFinal.getTime() - fechaInicial.getTime()) / 86400000);
                mes = fechaInicial.getMonth() + 1;
            }
        }
    }

    public int getDias() {
        return dias;
    }

    public float getPrecioTemporada() {
        return PrecioTemporada;
    }

    public Date getFechaInicial() {
        return fechaInicial;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    @Override
    public String toString() {
        return "Fecha{" + "dias=" + dias + ", fechaInicial=" + fechaInicial + ", fechaFinal=" + fechaFinal + '}';
    }

}
