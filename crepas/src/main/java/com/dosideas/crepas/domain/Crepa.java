package com.dosideas.crepas.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/**
 * Entidad que representa una crepa en el sistema.
 * 
 * Cada crepa tiene una descripción, precio, imagen y pertenece a una categoría.
 */
@Entity
public class Crepa {

    /**
     * Identificador único de la crepa. Se genera automáticamente.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JoinColumn(name = "id")

    /**
     * Descripción o nombre de la crepa (ej. "Crepa de Nutella con Fresas").
     */
    private String credescripcion;

    /**
     * Precio de la crepa.
     */
    private Double creprecio;

    /**
     * Ruta o nombre del archivo de imagen de la crepa.
     */
    private String creimagen;

    /**
     * Categoría a la que pertenece la crepa (por ejemplo: Dulce, Salada).
     * Relación muchos-a-uno: muchas crepas pueden pertenecer a una categoría.
     */
    @ManyToOne
    private Categoria categoria;

    // Getters y Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCredescripcion() {
        return credescripcion;
    }

    public void setCredescripcion(String credescripcion) {
        this.credescripcion = credescripcion;
    }

    public Double getCreprecio() {
        return creprecio;
    }

    public void setCreprecio(Double creprecio) {
        this.creprecio = creprecio;
    }

    public String getCreimagen() {
        return creimagen;
    }

    public void setCreimagen(String creimagen) {
        this.creimagen = creimagen;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    
}