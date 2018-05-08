/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;

import java.text.ParseException;

/**
 *
 * @author OLMEDO <00097017@uca.edu.sv>
 */
public class Hotel {
     
    public static void main(String[] args) throws ParseException {     

        int flag=1;
        ListaUsuarios listaU= ListaUsuarios.getInstance();
        while(flag==1){
            if(listaU.Login()){//TODO el funcionamiento parte luego del login USUARIOS POR DEFECTO : "Rafi","124raf" y "Guess","hotelR59"
                flag=0;
                System.out.println("Sesion iniciada!");
                Menu menu= Menu.getInstance();
                menu.mostrar();
            }else{
                System.err.println("Usuario o contrasennia invalido");
            }
        }
    }
}
