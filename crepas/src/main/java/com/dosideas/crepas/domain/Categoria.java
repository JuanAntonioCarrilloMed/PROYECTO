/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dosideas.crepas.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Clase que representa una categoría en la base de datos.
 * Cada categoría puede estar asociada a una o varias crepas.
 * 
 * Está anotada con @Entity para ser reconocida como entidad JPA.
 * 
 * Ejemplo: categoría "Dulce", "Salada", "Especial", etc.
 * 
 * @author juana
 */
@Entity
public class Categoria {

    /**
     * Identificador único de la categoría. Se genera automáticamente.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Descripción de la categoría (por ejemplo: "Salada", "Dulce").
     */
    private String catdescripcion;

    // Getter y Setter del ID
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    // Getter y Setter de la descripción
    public String getCatdescripcion() {
        return catdescripcion;
    }

    public void setCatdescripcion(String catdescripcion) {
        this.catdescripcion = catdescripcion;
    }
}
