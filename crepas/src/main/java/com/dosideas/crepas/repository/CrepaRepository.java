package com.dosideas.crepas.repository;

import com.dosideas.crepas.domain.Crepa;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author juana
 */
/* Extiende JpaRepository para proporcionar operaciones CRUD automáticas 
 * (guardar, buscar, eliminar, actualizar).
 */
public interface CrepaRepository extends JpaRepository<Crepa, Integer>  {
 
}