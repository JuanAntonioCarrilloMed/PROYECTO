/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dosideas.crepas.repository;

import com.dosideas.crepas.domain.Carrito;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para la entidad Carrito.
 * 
 * Extiende JpaRepository para proporcionar operaciones CRUD automáticas 
 * (guardar, buscar, eliminar, actualizar).
 * 
 * También define una consulta personalizada para obtener todos los elementos del carrito ordenados por ID.
 * 
 * Autor: juana
 */
@Repository
public interface CarritoRepository extends JpaRepository<Carrito, Integer> {

    /**
     * Consulta personalizada que obtiene la lista de todos los elementos del carrito,
     * ordenados por su identificador (id).
     * 
     * @return Lista de objetos Carrito ordenados por id.
     */
    @Query("SELECT car FROM Carrito car ORDER BY car.id")
    List<Carrito> buscarList();
}
