/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import utilidades.Utilidades;

/**
 *
 * @author 2dam
 */
public class Enunciado {

    private Integer id;
    private String descripcion;
    private int nivel;
    private boolean disponible;
    private String ruta;
    private List<String> unidadesDidacticas;
    private String convocatoria;

    // Constructor
    public Enunciado() {
        unidadesDidacticas = new ArrayList<>();
    }

    // Métodos getter y setter para cada atributo
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public List<String> getUnidadesDidacticas() {
        return unidadesDidacticas;
    }

    public void setUnidadesDidacticas(List<String> unidadesDidacticas) {
        this.unidadesDidacticas = unidadesDidacticas;
    }

    public String getConvocatoria() {
        return convocatoria;
    }

    public void setConvocatoria(String convocatoria) {
        this.convocatoria = convocatoria;
    }

    //Metodos
    public void setDatos(int idCreado) {
        this.id = idCreado;
        boolean seguir = true;
        descripcion = Utilidades.introducirCadena("Introduce la Descripcion:");
        nivel = Utilidades.leerInt("Introudce el Nivel");
        disponible = Utilidades.esBoolean("Esta disponible");
        ruta = Utilidades.introducirCadena("Introoduce la ruta");
        while (seguir) {
            String titulo = Utilidades.introducirCadena("Introduce el titulo de la unidad didactica a la que pertenece este enunciado");
            unidadesDidacticas.add(titulo);
            seguir = Utilidades.esBoolean("Desea introducir mas unidades didacticas?");
        }
        convocatoria = Utilidades.introducirCadena("Introduce la convocatoria a la que pertenece");
    }
    public void getDatos(){
        System.out.println(id);
        System.out.println(descripcion);
        System.out.println(nivel);
        System.out.println(disponible);
        System.out.println(ruta);
     
    }
}
