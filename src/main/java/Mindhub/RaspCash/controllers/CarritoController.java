package Mindhub.RaspCash.controllers;

import Mindhub.RaspCash.models.*;
import Mindhub.RaspCash.respositories.UsuarioRepositorio;
import Mindhub.RaspCash.servicios.ServicioCarrito;
import Mindhub.RaspCash.servicios.ServicioProducto;
import Mindhub.RaspCash.servicios.ServicioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/api")
public class CarritoController {

    @Autowired
    ServicioCarrito servicioCarrito;

    @Autowired
    ServicioUsuario servicioUsuario;

    @Autowired
    ServicioProducto servicioProducto;

    @GetMapping("/carrito/{id}")
    public Carrito obtenerCarritoPorId(@PathVariable long id){
        return servicioCarrito.obtenerCarritoPorId(id);
    }

    @Transactional
    @PostMapping("/carrito/agregarproducto/{id}")
    public ResponseEntity<Object> agregarProductoAlcarrito(Authentication authentication, @PathVariable long idProducto,@RequestParam long idCarrito){

        Usuario usuario= servicioUsuario.encontrarUsuarioPorEmail(authentication.getName());
        Carrito carrito=servicioCarrito.obtenerCarritoPorId(idCarrito);
        Producto producto=servicioProducto.obtenerProductoPorId(idProducto);
        ProductoUsuario productoUsuarioAlCarrito= new ProductoUsuario(producto,carrito, EstadoProducto.EN_CARRITO);

        carrito.agregarProductoAlCarrito(productoUsuarioAlCarrito);

        return new ResponseEntity<>("Se agregó el producto al carrito",HttpStatus.CREATED);
    }
}
