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
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilidades.MyObjectOutputStream;
import utilidades.Utilidades;

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
    public void crearEnunciado(Enunciado enun, File convocatoria) {
        ObjectInputStream ois = null;
        ObjectOutputStream oos = null;
        File convoAux = new File("convoAux.obj");
        Convocatoria conv;
        boolean existe = false;

        try {
            ois = new ObjectInputStream(new FileInputStream(convocatoria));
            oos = new ObjectOutputStream(new FileOutputStream(convoAux));

            int calculoFich = Utilidades.calculoFichero(convocatoria);
            for (int i = 0; i < calculoFich; i++) {
                conv = (Convocatoria) ois.readObject();
                if (conv.getConvocatoria().equals(enun.getConvocatoria())) {

                    conv.setIdEnunciado(enun.getId());
                    existe = true;
                }

                oos.writeObject(conv);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DaoImplementacionFichero.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DaoImplementacionFichero.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoImplementacionFichero.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ois.close();
                oos.flush();
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (existe) {
            convocatoria.delete();
            convoAux.renameTo(convocatoria);
        } else {
            convoAux.delete();
        }
    }

    @Override
    public List<Enunciado> consultarEnunciadosPorUnidad(String unidad) {
        return null;
    }

    @Override
    public List<Convocatoria> consultarConvoPorEnun(int enunciado, File convocatoria) {
        ObjectInputStream ois = null;
        Convocatoria conv;
        List<Convocatoria> convocatorias = new ArrayList<>();
        try {
            ois = new ObjectInputStream(new FileInputStream(convocatoria));

            int calculoFich = Utilidades.calculoFichero(convocatoria);
            for (int i = 0; i < calculoFich; i++) {
                conv = (Convocatoria) ois.readObject();
                if (conv.getIdEnunciado() == enunciado) {
                    convocatorias.add(conv);
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DaoImplementacionFichero.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DaoImplementacionFichero.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoImplementacionFichero.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ois.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return convocatorias;
    }

    @Override
    public String consultarEnunciado(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int ultimoId(String tipo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<UnidadDidactica> sacarUnidades(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
