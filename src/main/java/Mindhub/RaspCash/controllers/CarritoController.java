package Mindhub.RaspCash.controllers;

import Mindhub.RaspCash.dtos.CarritoDTO;
import Mindhub.RaspCash.models.*;
import Mindhub.RaspCash.respositories.UsuarioRepositorio;
import Mindhub.RaspCash.servicios.ServicioCarrito;
import Mindhub.RaspCash.servicios.ServicioProducto;
import Mindhub.RaspCash.servicios.ServicioProductoUsuario;
import Mindhub.RaspCash.servicios.ServicioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api")
public class CarritoController {

    @Autowired
    ServicioCarrito servicioCarrito;

    @Autowired
    ServicioUsuario servicioUsuario;

    @Autowired
    ServicioProducto servicioProducto;

    @Autowired
    ServicioProductoUsuario servicioProductoUsuario;

    @GetMapping("/carritos")
    public List<CarritoDTO> obtenerCarritos(){
        return servicioCarrito.obtenerTodosLosCarritos();
    }

    @GetMapping("/carrito/{id}")
    public Carrito obtenerCarritoPorId(@PathVariable long id){
        return servicioCarrito.obtenerCarritoPorId(id);
    }

    @Transactional
    @PostMapping("/carrito/agregarproducto")
    public ResponseEntity<Object> agregarProductoAlcarrito(Authentication authentication,@RequestParam long idProducto,@RequestParam long idCarrito){

       // Usuario usuario= servicioUsuario.encontrarUsuarioPorEmail(authentication.getName());
        Carrito carrito=servicioCarrito.obtenerCarritoPorId(idCarrito);
        Producto producto=servicioProducto.obtenerProductoPorId(idProducto);

        if (Objects.isNull(producto)){
            return new ResponseEntity<>("No es posible encontrar el producto seleccionado",HttpStatus.FORBIDDEN);
        }

        if (producto.getStock()==0){
            return new ResponseEntity<>("No hay stock disponible para el producto que intenta añadir al carrito",HttpStatus.FORBIDDEN);
        }

        //No debería entrar nunca a este error
        if (Objects.isNull(carrito)){
            return new ResponseEntity<>("No es posible encontrar el carrito",HttpStatus.FORBIDDEN);
        }

        ProductoUsuario productoUsuarioAlCarrito= new ProductoUsuario(producto,carrito, EstadoProducto.EN_CARRITO);

        servicioProductoUsuario.guardarProductoUsuario(productoUsuarioAlCarrito);

        producto.disminuirStock(1);

        carrito.agregarProductoAlCarrito(productoUsuarioAlCarrito);

        return new ResponseEntity<>("Se agregó el producto al carrito",HttpStatus.CREATED);
    }

    @Transactional
    @PostMapping("carrito/realizarCompra")
    public ResponseEntity<Object> realizarCompra(Authentication authentication,@RequestParam long idCarrito){

        Usuario usuario= servicioUsuario.encontrarUsuarioPorEmail(authentication.getName());


        return new ResponseEntity<>("La compra fue realizada con éxito",HttpStatus.CREATED);
    }
}
