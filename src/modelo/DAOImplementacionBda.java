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
import java.util.ArrayList;
import java.util.List;
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
    final private String unir_unidad_enunciado = "INSERT INTO unidad_enunciado VALUES (?, ?)";
    final private String sacar_id_unidad = "SELECT id from unidad where titulo = ?";
    final private String sacar_enunciado_unidad = "SELECT * from unidad_enunciado where unidads_id = ?";
    final private String sacar_unidad_enunciado = "SELECT * from unidad_enunciado where enunciados_id = ?";
    final private String sacar_enunciados = "SELECT * from enunciado where id = ?";
    final private String sacar_unidades = "SELECT * from unidad where id = ?";
    final private String ultimo_id = "SELECT * FROM enunciado ORDER BY id desc LIMIT 1;";

    public void abrirConexion() {

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
        boolean introducido = false;
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

        this.cerrarConexion();

    }

    @Override
    public void crearConvocatoria(Convocatoria convo, File convocatoria) {

    }

    public void crearEnunciado(Enunciado enun, File convocatoria) {

        // TODO Auto-generated method stub
        this.abrirConexion();

        boolean introducido = false;
        try {
            stmt = con.prepareStatement(crear_enunciado);
            stmt.setInt(1, enun.getId());
            stmt.setString(2, enun.getDescripcion());
            stmt.setInt(3, enun.getNivel());
            stmt.setBoolean(4, enun.isDisponible());
            stmt.setString(5, enun.getRuta());

            if (stmt.executeUpdate() == 1) {
                List<String> titulos = enun.getUnidadesDidacticas();
                for (String titu : titulos) {
                    stmt = con.prepareStatement(sacar_id_unidad);
                    stmt.setString(1, titu);

                    ResultSet rs = stmt.executeQuery();

                    if (rs.next()) {
                        stmt = con.prepareStatement(unir_unidad_enunciado);
                        stmt.setInt(1, rs.getInt("id"));
                        stmt.setInt(2, enun.getId());
                        stmt.execute();

                    }
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAOImplementacionBda.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.cerrarConexion();

    }

    @Override
    public List<Enunciado> consultarEnunciadosPorUnidad(String unidad) {
        this.abrirConexion();
        int id;
        List<Integer> ids = new ArrayList<>();
        List<Enunciado> enunciados = new ArrayList<>();
        try {
            stmt = con.prepareStatement(sacar_id_unidad);
            stmt.setString(1, unidad);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                id = rs.getInt("id");
                PreparedStatement stmt2 = con.prepareStatement(sacar_enunciado_unidad);
                stmt2.setInt(1, id);

                ResultSet rs2 = stmt2.executeQuery();
                while (rs2.next()) {
                    int idEnun = rs2.getInt(2);

                    ids.add(idEnun);

                }
                for (Integer i : ids) {
                    PreparedStatement stmt3 = con.prepareStatement(sacar_enunciados);
                    stmt3.setInt(1, i);
                    ResultSet rs3 = stmt3.executeQuery();

                    if (rs3.next()) {
                        Enunciado enun = new Enunciado();
                        enun.setId(rs3.getInt(1));
                        enun.setDescripcion(rs3.getString(2));
                        enun.setNivel(rs3.getInt(3));
                        enun.setDisponible(rs3.getBoolean(4));
                        enun.setRuta(rs3.getString(5));

                        enunciados.add(enun);
                    }
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOImplementacionBda.class.getName()).log(Level.SEVERE, null, ex);
        }
        return enunciados;
    }

    @Override
    public List<Convocatoria> consultarConvoPorEnun(int enunciado, File convocatoria) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String consultarEnunciado(int id) {
        this.abrirConexion();
        String ruta = null;

        try {
            stmt = con.prepareStatement(sacar_enunciados);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                ruta = rs.getString("ruta");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOImplementacionBda.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ruta;
    }

    @Override
    public int ultimoId(String tipo) {
        this.abrirConexion();
        int id = 0;

        try {
            stmt = con.prepareStatement(ultimo_id);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOImplementacionBda.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    @Override
    public List<UnidadDidactica> sacarUnidades(int id) {
         this.abrirConexion();
        int idUnidades;
        List<Integer> ids = new ArrayList<>();
        List<UnidadDidactica> unidades = new ArrayList<>();
        try {
            stmt = con.prepareStatement(sacar_unidad_enunciado);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                idUnidades = rs.getInt("id");
                ids.add(idUnidades);
            }
            for (Integer i : ids) {
                UnidadDidactica uni = new UnidadDidactica();
                PreparedStatement stmt2 = con.prepareStatement(sacar_unidades);
                stmt2.setInt(1, id);

                ResultSet rs2 = stmt2.executeQuery();
                if(rs2.next()) { 
                    uni.setId(rs2.getInt(1));
                    uni.setAcronimo(rs.getString(2));
                    uni.setTitulo(rs.getString(3));
                    uni.setEvaluacion(rs.getString(4));
                    uni.setDescripcion(rs.getString(5));
                    unidades.add(uni);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOImplementacionBda.class.getName()).log(Level.SEVERE, null, ex);
        }
        return unidades;
    }

}
