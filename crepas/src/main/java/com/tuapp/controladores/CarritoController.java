package com.tuapp.controladores;

import com.dosideas.crepas.domain.Carrito;
import com.dosideas.crepas.domain.Crepa;
import com.dosideas.crepas.repository.CarritoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CarritoController {

    @Autowired
    private CarritoRepository carritoRepository;

    @GetMapping("/carrito/listado")
public String mostrarCarrito(Model model) {
    List<Carrito> carritos = carritoRepository.findAll();
    model.addAttribute("carritos", carritos);
    return "carrito"; // Asegúrate que este sea tu carrito.html
}


    @GetMapping("/agregar-al-carrito/{id}")
    public String agregarAlCarrito(@PathVariable("id") Long id) {
        Crepa crepa = new Crepa(); // puedes usar un repositorio real aquí si lo tienes
        crepa.setId(id.intValue());

        Carrito nuevo = new Carrito();
        nuevo.setCrepa(crepa);
        carritoRepository.save(nuevo);

        return "redirect:/carrito/listado"; // redirige al carrito después de agregar
    }
    @GetMapping("/carrito/comprar")
public String comprar(Model model) {
    List<Carrito> carritos = carritoRepository.findAll();

    double total = carritos.stream()
            .mapToDouble(c -> c.getCrepa().getCreprecio())
            .sum();

    model.addAttribute("carritos", carritos);
    model.addAttribute("total", total);

    carritoRepository.deleteAll(); // Limpiar carrito después de comprar

    return "ticket";
}


}
