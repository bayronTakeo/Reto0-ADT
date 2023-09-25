/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import clases.Convocatoria;
import clases.UnidadDidactica;
import java.io.File;

/**
 *
 * @author 2dam
 */
public interface DAO {
    
    public void crearUnidadDidactica(UnidadDidactica uni);
    
    public void crearConvocatoria(Convocatoria convo, File convocatoria);
}
