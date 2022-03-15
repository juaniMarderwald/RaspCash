package Mindhub.RaspCash.controllers;

import Mindhub.RaspCash.dtos.CarritoDTO;
import Mindhub.RaspCash.models.*;
import Mindhub.RaspCash.respositories.UsuarioRepositorio;
import Mindhub.RaspCash.servicios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
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

    @Autowired
    ServicioTransaccion servicioTransaccion;

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
    @PostMapping("/carrito/realizarCompra")
    public ResponseEntity<Object> realizarCompra(Authentication authentication, @RequestParam long idCarrito){

        Usuario usuario= servicioUsuario.encontrarUsuarioPorEmail(authentication.getName());
        Billetera billetera =usuario.getBilletera();
        Carrito carrito = servicioCarrito.obtenerCarritoPorId(idCarrito);

        if (billetera.getMontoPesos()<carrito.getTotal()){
            return new ResponseEntity<>("No cuenta con fondos en pesos requeridos para esta compra",HttpStatus.FORBIDDEN);
        }

        if (carrito.getProductosEnCarrito().size()==0){
            return new ResponseEntity<>("El carrito se encuentra vacío",HttpStatus.FORBIDDEN);
        }

        if (carrito.getTotal()==0){
            return new ResponseEntity<>("El carrito se encuentra vacío",HttpStatus.FORBIDDEN);
        }

        String descripcionCompra = "Compra Carrito Id="+ carrito.getId()+" ,Por el monto de $"+carrito.getTotal();

        //Asigno todos los productos del carrito al usuario
        carrito.getProductosEnCarrito().forEach(productoUsuario -> {
            usuario.agregarProductoComprado(productoUsuario);
            productoUsuario.setUsuarioDuenio(usuario);
            productoUsuario.setEstadoProducto(EstadoProducto.VENDIDO);
            productoUsuario.setCarrito(carrito);
        });

        //Genero la transacción para cobrarle al usuario y le asigno la transaccion a la billetera
        Transaccion transaccion = new Transaccion(TipoDeTransaccion.DEBITO,carrito.getTotal(),descripcionCompra, LocalDateTime.now(),TipoDeMoneda.PESOS,billetera);
        billetera.agregarTransaccion(transaccion);

        servicioTransaccion.guardarTransaccion(transaccion);

        carrito.vaciarCarrito();

        return new ResponseEntity<>("La compra fue realizada con éxito",HttpStatus.CREATED);
    }

    @PostMapping("/carrito/vaciarCarrito")
    public ResponseEntity<Object> vaciarCarrito(long idCarrito){
        Carrito carrito = servicioCarrito.obtenerCarritoPorId(idCarrito);
        carrito.vaciarCarrito();
        return new ResponseEntity<>("El carrito se encuentra vacío nuevamente",HttpStatus.CREATED);
    }
}
