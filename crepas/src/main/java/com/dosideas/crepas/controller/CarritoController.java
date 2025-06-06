// Paquete donde se ubican los controladores de la aplicación.
package com.dosideas.crepas.controller;

// Importaciones necesarias para manejar la lógica del carrito
import com.dosideas.crepas.domain.Carrito;
import com.dosideas.crepas.domain.Crepa;
import com.dosideas.crepas.repository.CarritoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Controlador que maneja las operaciones del carrito de compras. Permite
 * agregar, eliminar, mostrar y comprar crepas. Utiliza el patrón MVC con Spring
 * Boot.
 */
@Controller
public class CarritoController {

    @Autowired
    private CarritoRepository carritoRepository;

    /**
     * Muestra el listado de crepas agregadas al carrito.
     *
     * @param model objeto para enviar datos a la vista
     * @return nombre del template HTML que muestra el carrito (carrito.html)
     */
    @GetMapping("/carrito/listado")
    public String mostrarCarrito(Model model) {
        List<Carrito> carritos = carritoRepository.buscarList();
        model.addAttribute("carritos", carritos);
        return "carrito"; // Renderiza la vista carrito.html
    }

    /**
     * Agrega una crepa al carrito usando su ID. Crea un objeto Carrito con una
     * instancia mínima de Crepa con solo el ID.
     *
     * @param id ID de la crepa a agregar
     * @return redirige al listado del carrito
     */
    @GetMapping("/agregar-al-carrito/{id}")
    public String agregarAlCarrito(@PathVariable("id") Long id) {
        Crepa crepa = new Crepa();           // (opcional: se recomienda buscar la crepa real con un repositorio)
        crepa.setId(id.intValue());

        Carrito nuevo = new Carrito();
        nuevo.setCrepa(crepa);
        carritoRepository.save(nuevo);

        return "redirect:/carrito/listado"; // Redirige al carrito después de agregar
    }

    /**
     * Elimina un ítem del carrito por su ID.
     *
     * @param id ID del objeto Carrito a eliminar
     * @return redirige al listado del carrito actualizado
     */
    @GetMapping("/carrito/eliminar/{id}")
    public String eliminarDelCarrito(@PathVariable("id") int id) {
        carritoRepository.deleteById(id);
        return "redirect:/carrito/listado";
    }

    /**
     * Finaliza la compra: muestra ticket con total y limpia el carrito.
     *
     * @param model objeto para enviar datos (carritos y total) a la vista
     * @return vista del ticket de compra
     */
    @GetMapping("/carrito/comprar")
    public String comprar(Model model) {
        List<Carrito> carritos = carritoRepository.findAll();

        // Calcula el total sumando los precios de cada crepa
        double total = carritos.stream()
                .mapToDouble(c -> c.getCrepa().getCreprecio())
                .sum();

        model.addAttribute("carritos", carritos);
        model.addAttribute("total", total);

        carritoRepository.deleteAll(); // Limpia el carrito después de comprar

        return "ticket"; // Renderiza la vista ticket.html
    }

}
