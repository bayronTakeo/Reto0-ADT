/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import clases.Convocatoria;
import clases.Enunciado;
import clases.UnidadDidactica;
import controlador.Controlador;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilidades.MyObjectOutputStream;

/**
 *
 * @author 2dam
 */
public class DaoImplementacionFichero implements DAO {

    @Override
    public void crearUnidadDidactica(UnidadDidactica uni) {
       
    }

    @Override
    public void crearConvocatoria(Convocatoria convo, File convocatoria) {
        ObjectOutputStream oos = null;

        try {
            if (convocatoria.exists()) {
                oos = new MyObjectOutputStream(new FileOutputStream(convocatoria, true));
            } else {
                oos = new ObjectOutputStream(new FileOutputStream(convocatoria));
            }
            convo.setDatos();
            oos.writeObject(convo);
            
        } catch (IOException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                oos.close();
                oos.flush();
            } catch (IOException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void crearEnunciado(Enunciado enun) {
        
    }
    
}
