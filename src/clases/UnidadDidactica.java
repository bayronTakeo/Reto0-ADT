/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import utilidades.Utilidades;

/**
 *
 * @author 2dam
 */
public class UnidadDidactica {
     private Integer id;
    private String acronimo;
    private String titulo;
    private String evaluacion;
    private String descripcion;

    // Constructor
  

    // Métodos getter y setter para cada atributo
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAcronimo() {
        return acronimo;
    }

    public void setAcronimo(String acronimo) {
        this.acronimo = acronimo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEvaluacion() {
        return evaluacion;
    }

    public void setEvaluacion(String evaluacion) {
        this.evaluacion = evaluacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    //Metodos
    
    public void setDatos() { 
        acronimo = Utilidades.introducirCadena("Introduce el acronimo de la unidad didactica");
        titulo = Utilidades.introducirCadena("Introduce el titulo de la unidad didactica");
        evaluacion = Utilidades.introducirCadena("Introduce a que evaluacion pertenece la unidad didactica");
        descripcion = Utilidades.introducirCadena("Introduce la descripcion de la unidad didactica");
    }
}
