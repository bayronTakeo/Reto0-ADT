/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import controlador.Controlador;
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
        
        int opcion;
        Scanner scanner = new Scanner(System.in);
                 
        
        do{
            //Menu
            System.out.println("Bienvenido a la aplicacion" + "\n");

            System.out.println("Elija una de las siguientes opciones:");
            System.out.println("1. Crear unidad didactica");
            System.out.println("2. Crear convocatoria");
            System.out.println("3. Crear enunciado");
            System.out.println("4. Consultar enunciado");
            System.out.println("5. Consultar convocatoria");

           Controlador control = new Controlador();

            // Leer la respuesta del usuario
            opcion = scanner.nextInt();

            switch (opcion) {
               case 1:
                   control.crearUnidadDidactica();
                   break;
               case 2:
                   System.out.println("Ha seleccionado la Opción 2. Crear convocatoria");
                   // Coloca aquí el código correspondiente a la Opción 2
                   break;
               case 3:
                   System.out.println("Ha seleccionado la Opción 3. Crear enunciado");
                   // Coloca aquí el código correspondiente a la Opción 3
                   break;
                case 4:
                   System.out.println("Ha seleccionado la Opción 4. Consultar enunciado");

                   break;
                   case 5:
                   System.out.println("Ha seleccionado la Opción 5. Consultar convocatoria");
                   // Coloca aquí el código correspondiente a la Opción 3
                   break;
               default:
                   System.out.println("Opción no válida.");
                   opcion = -1;
                   break;
            }
           
            } while ( opcion == -1);

        // Cierra el Scanner
        scanner.close();
        
        
        DAO daobda = Factoria.getDaoBDA();
    }
    
}
