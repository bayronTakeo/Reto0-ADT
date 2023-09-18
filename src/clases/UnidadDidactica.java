/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

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
    public UnidadDidactica(Integer id, String acronimo, String titulo, String evaluacion, String descripcion) {
        this.id = id;
        this.acronimo = acronimo;
        this.titulo = titulo;
        this.evaluacion = evaluacion;
        this.descripcion = descripcion;
    }

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
}
