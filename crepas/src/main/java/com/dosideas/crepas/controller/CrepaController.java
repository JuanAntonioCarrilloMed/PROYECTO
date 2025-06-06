package com.dosideas.crepas.controller;

import com.dosideas.crepas.domain.Categoria;
import com.dosideas.crepas.service.CategoriaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author juana
 */
@Controller
public class CrepaController {

    @Autowired
    private CategoriaService categoriaService;

  


}
