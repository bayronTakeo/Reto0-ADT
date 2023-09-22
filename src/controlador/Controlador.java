/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import clases.UnidadDidactica;
import modelo.DAOImplementacionBda;
import modelo.Factoria;

/**
 *
 * @author 2dam
 */
public class Controlador {
    public void crearUnidadDidactica() {
        UnidadDidactica unidad = Factoria.getUnidadDidactica();
        DAOImplementacionBda dao = (DAOImplementacionBda) Factoria.getDaoBDA();
        
        unidad.setDatos();
        
        dao.crearUnidadDidactica(unidad);
    }
}
