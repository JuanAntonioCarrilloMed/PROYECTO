/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dosideas.crepas.service;

import com.dosideas.crepas.domain.Carrito;
import com.dosideas.crepas.repository.CarritoRepository;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * Servicio que maneja la lógica de negocio relacionada con el carrito de compras.
 * 
 * Permite guardar, listar y eliminar productos del carrito mediante el repositorio.
 * 
 * Autor: juana
 */
@Service
public class CarritoService {

    /**
     * Repositorio que permite el acceso a los datos del carrito.
     */
    private final CarritoRepository carritoRepository;

    /**
     * Constructor que inyecta el repositorio del carrito.
     * 
     * @param carritoRepository Repositorio de carrito
     */
    public CarritoService(CarritoRepository carritoRepository){
        this.carritoRepository = carritoRepository;
    }

    /**
     * Guarda un nuevo producto en el carrito o actualiza uno existente.
     * 
     * @param carroCompras Objeto Carrito a guardar
     * @return El objeto Carrito guardado
     */
    public Carrito guardar(Carrito carroCompras){
        return carritoRepository.save(carroCompras);
    }

    /**
     * Devuelve una lista con todos los elementos del carrito.
     * 
     * @return Lista de objetos Carrito
     */
    public List<Carrito> buscarTodos(){
        return carritoRepository.buscarList();
    }

    /**
     * Elimina todos los elementos del carrito de compras.
     */
    public void eliminarTodos(){
        carritoRepository.deleteAll();
    }
}
