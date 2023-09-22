/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import controlador.Controlador;
import interfazUsuario.Menu;
import java.util.Scanner;
import modelo.DAO;
import modelo.Factoria;

/**
 *
 * @author Bayron, Gaizka, Mikel
 */
public class Reto0ADT {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        
        Menu main = Factoria.getMenu();
        Controlador cont = Factoria.getControlador();
        
        main.menu(cont);
        
    }
    
}
