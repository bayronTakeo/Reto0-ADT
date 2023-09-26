/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.Serializable;
import java.time.LocalDate;
import utilidades.Utilidades;

/**
 *
 * @author 2dam
 */
public class Convocatoria implements Serializable {

    private String convocatoria;
    private String descripcion;
    private LocalDate fecha;
    private String curso;
    private int idEnunciado;

    // Constructor
    public Convocatoria() {
    }

    // Métodos getter y setter para cada atributo
    public String getConvocatoria() {
        return convocatoria;
    }

    public void setConvocatoria(String convocatoria) {
        this.convocatoria = convocatoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getIdEnunciado() {
        return idEnunciado;
    }

    public void setIdEnunciado(int idEnunciado) {
        this.idEnunciado = idEnunciado;
    }

    //Metodos
    public void setDatos() {
        convocatoria = Utilidades.introducirCadena("Introduce la Convocatoria:");
        descripcion = Utilidades.introducirCadena("Introduce la Descripcion:");
        fecha = Utilidades.introducirFecha("Introduce la fecha:");
        curso = Utilidades.introducirCadena("Introduce el Curso:");
    }
}
