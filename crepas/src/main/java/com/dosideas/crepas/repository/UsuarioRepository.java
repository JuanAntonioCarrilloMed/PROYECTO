/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dosideas.crepas.repository;

import com.dosideas.crepas.domain.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author juana
 */
/* Extiende JpaRepository para proporcionar operaciones CRUD automáticas 
 * (guardar, buscar, eliminar, actualizar).
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
    Optional<Usuario> findByLogin (String nombre);
}
