/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import clases.Convocatoria;
import clases.Enunciado;
import clases.UnidadDidactica;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.DAOImplementacionBda;
import modelo.DaoImplementacionFichero;
import modelo.Factoria;
import utilidades.MyObjectOutputStream;
import utilidades.Utilidades;

/**
 *
 * @author 2dam
 */
public class Controlador {

    DAOImplementacionBda dao = (DAOImplementacionBda) Factoria.getDaoBDA();
     DaoImplementacionFichero daoFile = (DaoImplementacionFichero) Factoria.getDaoFile();
    UnidadDidactica unidad = Factoria.getUnidadDidactica();
    Convocatoria convo = Factoria.getConvocatoria();
    File convocatoria = new File("convocatoria.obj");
    Enunciado enun = Factoria.getEnunciado();

    public void crearUnidadDidactica() {
        unidad.setDatos();

        dao.crearUnidadDidactica(unidad);
    }

    public void crearConvocatoria() {
        daoFile.crearConvocatoria(convo, convocatoria);

    }

    public void crearEnunciado() {
        int id = dao.ultimoId("ti") + 1;
        System.out.println("este es id:" + id);
        enun.setDatos(id);

        dao.crearEnunciado(enun, convocatoria);
        daoFile.crearEnunciado(enun, convocatoria);
    }

    public void consultarEnunciado() {
        String unidadDidactica = Utilidades.introducirCadena("Que unidad didactica quieres consultar?");
        List<Enunciado> enunciados = new ArrayList<>();

        enunciados = dao.consultarEnunciadosPorUnidad(unidadDidactica);
        
        for (Enunciado enunci : enunciados) {
            enunci.getDatos();
        }

    }

    public void consultarConvocatoria() {
        int id = Utilidades.leerInt("Introduce el id del enunciado");
        List<Convocatoria> convocatorias = new ArrayList<>();
        convocatorias = daoFile.consultarConvoPorEnun(id, convocatoria);
    }

    public void verEnunciado() {
        String ruta = dao.consultarEnunciado(0);
    }
}
