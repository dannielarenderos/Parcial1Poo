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

public class Usuario {
    private String usuario;
    private String password;
    
    
    public Usuario() {
    }
/**
 * Constructor sobrecargado para clase Usuario
 * @param usuario Nombre de usuario usado para el login
 * @param password  Contrasennia usada para el login
 */
    public Usuario(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
