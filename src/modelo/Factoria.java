/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import clases.Convocatoria;
import clases.UnidadDidactica;
import controlador.Controlador;
import interfazUsuario.Menu;

/**
 *
 * @author 2dam
 */
public class Factoria {
    public static DAO getDaoBDA(){
        return new DAOImplementacionBda();
    }
    public static UnidadDidactica getUnidadDidactica() {
        return new UnidadDidactica();
    }
    
    public static Menu getMenu() {
        return new Menu();
    } 
    
    public static Controlador getControlador() {
        return new Controlador();
    }
    
    public static Convocatoria getConvocatoria() {
        return new Convocatoria();
    }
}
