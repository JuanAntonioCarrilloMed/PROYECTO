/*
 * Clase que representa un elemento en el carrito de compras.
 * Cada instancia de Carrito está asociada a una crepa específica.
 */

package com.dosideas.crepas.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/**
 * Entidad JPA que representa un ítem del carrito de compras.
 * Cada ítem está relacionado con una única crepa.
 * 
 * Autor: juana
 */
@Entity
public class Carrito {

    // Identificador único del ítem en el carrito (clave primaria)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Relación muchos-a-uno con la entidad Crepa
    // Cada ítem en el carrito se relaciona con una sola crepa
    @ManyToOne
    private Crepa crepa;

    /** 
     * Obtiene el ID del carrito.
     * @return id del carrito
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el ID del carrito.
     * @param id nuevo valor del ID
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene la crepa asociada al ítem del carrito.
     * @return objeto de tipo Crepa
     */
    public Crepa getCrepa() {
        return crepa;
    }

    /**
     * Establece la crepa asociada al ítem del carrito.
     * @param crepa objeto de tipo Crepa
     */
    public void setCrepa(Crepa crepa) {
        this.crepa = crepa;
    }
}
