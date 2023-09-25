/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import clases.Convocatoria;
import clases.UnidadDidactica;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.DAOImplementacionBda;
import modelo.Factoria;
import utilidades.MyObjectOutputStream;

/**
 *
 * @author 2dam
 */
public class Controlador {
    DAOImplementacionBda dao = (DAOImplementacionBda) Factoria.getDaoBDA();
    UnidadDidactica unidad = Factoria.getUnidadDidactica();
    Convocatoria convo = Factoria.getConvocatoria();
    File convocatoria = new File("convocatoria.obj");
    
    public void crearUnidadDidactica() {
        unidad.setDatos();
        
        dao.crearUnidadDidactica(unidad);
    }
    
    public void crearConvocatoria() {
        dao.crearConvocatoria(convo, convocatoria);
        
    }
        
    
    
    
}
