/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author OLMEDO <00097017@uca.edu.sv>
 */

public class ListaUsuarios {
    private static ListaUsuarios lista;
    
    ArrayList<Usuario> listaUser = new ArrayList<>();
    /**
     * Constructor que creara los usuarios por defecto que podran iniciar sesion
     */
    
    private ListaUsuarios(){
        Usuario usuario1= new Usuario("Rafi","124raf");
        listaUser.add(usuario1);
        Usuario usuario2= new Usuario("Guess","hotelR59");
        listaUser.add(usuario2);
        //System.out.println(listaUser.get(0).getUsuario()+" "+listaUser.get(0).getPassword());
    }
    /**
     * Metodo estatico Singleton para asegurar solo una instanciacion de esta clase
     * @return lista: Lista de usuarios que podran logearse
     */
    public static ListaUsuarios getInstance() {
        if (lista == null) {
            lista = new ListaUsuarios();
        }
        return lista;
    }
    /**
     * Metodo usado al principio de la ejecucion para poder ingresar al sistema
     * @return 
     */
    public boolean Login(){
        Scanner leer = new Scanner(System.in);
        String user, pass;
        System.out.println("-----Por favor Inicie Sesion-----\nUsuario:");
        user=leer.nextLine();
        System.out.println("Contraseña");
        pass=leer.nextLine();
        return listaUser.stream().anyMatch((u) -> ((u.getUsuario().equals(user)) && (u.getPassword().equals(pass))));
    }
}
        
