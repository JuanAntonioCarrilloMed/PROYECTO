package com.dosideas.crepas.controller;

import com.dosideas.crepas.domain.Crepa;
import com.dosideas.crepas.service.CrepaService;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controlador que gestiona las vistas principales de la aplicación de crepas:
 * listado, detalle, carrito, login y formulario para agregar crepas.
 */
@Controller
public class ListadoController {

    private final CrepaService crepaService;

    /**
     * Constructor que inyecta el servicio de crepas.
     * @param crepaService Servicio para manejar la lógica de negocio de las crepas.
     */
    public ListadoController(CrepaService crepaService) {
        this.crepaService = crepaService;
    }

    /**
     * Muestra la página de listado solo si el usuario está autenticado.
     * @param session Sesión HTTP del usuario.
     * @return Vista de listado o redirección a login.
     */
    @GetMapping("/listado")
    public String mostrarListado(HttpSession session) {
        if (session.getAttribute("usuario") == null) {
            return "redirect:/login";
        }
        return "listado"; // Devuelve listado.html
    }

    /**
     * Ruta raíz que carga las crepas destacadas.
     * @param model Objeto para pasar datos a la vista.
     * @return Vista de listado con las crepas destacadas.
     */
    @RequestMapping("/")
    public String listarCrepas(Model model) {
        List<Crepa> destacadas = crepaService.buscarDestacadas();
        model.addAttribute("crepas", destacadas);
        return "listado";
    }

    /**
     * Muestra el detalle de una crepa específica por su ID.
     * @param id ID de la crepa.
     * @param model Objeto para pasar datos a la vista.
     * @return Vista de detalle o redirección si no se encuentra.
     */
    @RequestMapping("/detalle/{id}")
    public String verDetalle(@PathVariable int id, Model model) {
        Crepa crepa = crepaService.buscarPorId(id);
        if (crepa == null) {
            return "redirect:/listado";
        }
        model.addAttribute("crepa", crepa);
        return "detalle";
    }

    /**
     * Muestra una vista del carrito con una crepa seleccionada.
     * @param id ID de la crepa.
     * @param model Objeto para pasar datos a la vista.
     * @return Vista del carrito o redirección si no se encuentra la crepa.
     */
    @GetMapping("/carrito/{id}")
    public String vercrepa(@PathVariable int id, Model model) {
        Crepa crepa = crepaService.buscarPorId(id);
        if (crepa == null) {
            return "redirect:/listado";
        }
        model.addAttribute("crepa", crepa);
        return "carrito";
    }

    /**
     * Muestra la página de inicio de sesión.
     * @return Vista login.html.
     */
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    /**
     * Muestra el formulario para agregar una nueva crepa.
     * @param model Objeto para pasar una nueva instancia de Crepa.
     * @return Vista agregarcrepa.html.
     */
    @GetMapping("/agregarcrepa")
    public String mostrarFormularioAgregarCrepa(Model model) {
        model.addAttribute("crepa", new Crepa());
        return "agregarcrepa";
    }

    /**
     * Muestra otra vista detallada de una crepa, posiblemente para diseño diferente.
     * @param id ID de la crepa.
     * @param model Objeto para pasar datos a la vista.
     * @return Vista detalleCrepa.html o redirección.
     */
    @GetMapping("/crepa/detalle/{id}")
    public String detalleCrepa(@PathVariable Long id, Model model) {
        Crepa crepa = crepaService.buscarPorId(id);
        if (crepa == null) {
            return "redirect:/crepas";
        }
        model.addAttribute("crepa", crepa);
        return "detalleCrepa";
    }

}
