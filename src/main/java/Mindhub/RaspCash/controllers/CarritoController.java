package Mindhub.RaspCash.controllers;

import Mindhub.RaspCash.models.Carrito;
import Mindhub.RaspCash.servicios.ServicioCarrito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CarritoController {

    @Autowired
    ServicioCarrito servicioCarrito;

    @GetMapping("/carrito/{id}")
    public Carrito obtenerCarritoPorId(@PathVariable long id){
        return servicioCarrito.obtenerCarritoPorId(id);
    }

}
