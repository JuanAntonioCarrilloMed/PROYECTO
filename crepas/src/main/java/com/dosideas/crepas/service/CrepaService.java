

package com.dosideas.crepas.service;

import com.dosideas.crepas.domain.Crepa;
import com.dosideas.crepas.repository.CrepaRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CrepaService {
    private final CrepaRepository crepaRepository;
    
    public CrepaService(CrepaRepository crepaRepository){
        this.crepaRepository = crepaRepository;
    }

    public List<Crepa> buscarDestacadas() {
        return crepaRepository.findAll();
    }

    public Crepa buscarPorId(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Crepa obtenerPorId(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
        
    public Crepa buscarPorId(int id){
        return crepaRepository.findById(id).orElse(null);
    }

    public List<Crepa> listarTodas() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    /**
     * retorna una lista de crepas por id. de la Categoria 
     * @param catdescripcion
     * @return
     */
   //* public List<Crepa>buscarPorCategoria(int catdescripcion){
      //  return CrepaRepository.buscarPorCategoria(catdescripcion);
    //}

}
