/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.Enumeration;
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

    // Constructor
    public Enunciado() {

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
    
    //Metodos
    public void setDatos(){
        descripcion = Utilidades.introducirCadena("Introduce la Descripcion:");
        nivel = Utilidades.leerInt("Introudce el Nivel");
        disponible = Utilidades.esBoolean("Esta disponible");
        ruta = Utilidades.introducirCadena("Introoduce la ruta");
    }
}
