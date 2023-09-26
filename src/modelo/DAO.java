/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import clases.Convocatoria;
import clases.Enunciado;
import clases.UnidadDidactica;
import java.io.File;
import java.util.List;

/**
 *
 * @author 2dam
 */
public interface DAO {

    public void crearUnidadDidactica(UnidadDidactica uni);

    public void crearConvocatoria(Convocatoria convo, File convocatoria);

    public void crearEnunciado(Enunciado enun, File convocatoria);

    public List<Enunciado> consultarEnunciadosPorUnidad(String unidad);

    public List<Convocatoria> consultarConvoPorEnun(int enunciado, File convocatoria);

    public String consultarEnunciado(int id);
    
    public int ultimoId(String tipo);
    
    public List<UnidadDidactica> sacarUnidades (int id);
}
