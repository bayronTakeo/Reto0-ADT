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
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 2dam
 */
public class DAOImplementacionBda implements DAO {

        private Connection con = null;
        private PreparedStatement stmt;
    
        final private String crear_unidad = "INSERT INTO unidad VALUES (?, ?, ?, ?, ?)";
        final private String crear_enunciado = "INSERT INTO enunciado VALUES (?, ?, ?, ?, ?)";
       public void abrirConexion()  {
           
        try {
            Properties configBDA = new Properties();
            String rutaProyecto = System.getProperty("user.dir");
            FileInputStream fis = new FileInputStream(rutaProyecto + "\\src\\configBDA.properties");
            configBDA.load(fis);

            final String URL = configBDA.getProperty("url");
            final String USER = configBDA.getProperty("user");
            final String PASSWORD = configBDA.getProperty("password");

            con = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DAOImplementacionBda.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DAOImplementacionBda.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAOImplementacionBda.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void cerrarConexion() {
        try {
            if (con != null) {
                con.close();
            }
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void crearUnidadDidactica(UnidadDidactica uni) {

        // TODO Auto-generated method stub
        this.abrirConexion();
        ResultSet rs;
        boolean introducido = false ;
        try {
            stmt = con.prepareStatement(crear_unidad);
            stmt.setInt(1, 5);
            stmt.setString(2, uni.getAcronimo());
            stmt.setString(3, uni.getTitulo());
            stmt.setString(4, uni.getEvaluacion());
            stmt.setString(5, uni.getDescripcion());

            if (stmt.executeUpdate() == 1) {
                introducido = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAOImplementacionBda.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(introducido) { 
            System.out.println("prueba");
        }
        this.cerrarConexion();

    }

    @Override
    public void crearConvocatoria(Convocatoria convo, File convocatoria) {
       
    }

    public void crearEnunciado(Enunciado enun) {

        // TODO Auto-generated method stub
        this.abrirConexion();
        ResultSet rs;
        boolean introducido = false ;
        try {
            stmt = con.prepareStatement(crear_enunciado);
            stmt.setInt(1, 3);
            stmt.setString(2, enun.getDescripcion());
            stmt.setInt(3, enun.getNivel());
            stmt.setBoolean(4, enun.isDisponible());
            stmt.setString(5, enun.getRuta());

            if (stmt.executeUpdate() == 1) {
                introducido = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAOImplementacionBda.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(introducido) { 
            System.out.println("prueba");
        }
        this.cerrarConexion();

    }
    
    
}
