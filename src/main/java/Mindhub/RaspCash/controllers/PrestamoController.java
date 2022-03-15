package Mindhub.RaspCash.controllers;

import Mindhub.RaspCash.dtos.AplicacionPrestamoUsuarioDTO;
import Mindhub.RaspCash.dtos.PrestamoDTO;
import Mindhub.RaspCash.dtos.PrestamoUsuarioDTO;
import Mindhub.RaspCash.models.*;
import Mindhub.RaspCash.respositories.*;
import Mindhub.RaspCash.servicios.ServicioPrestamo;
import Mindhub.RaspCash.servicios.ServicioPrestamoUsuario;
import Mindhub.RaspCash.servicios.ServicioTransaccion;
import Mindhub.RaspCash.servicios.ServicioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class PrestamoController {

    @Autowired
    ServicioPrestamo servicioPrestamo;

    @Autowired
    ServicioUsuario servicioUsuario;

    @Autowired
    ServicioTransaccion servicioTransaccion;

    @Autowired
    ServicioPrestamoUsuario servicioPrestamoUsuario;

    @GetMapping("/prestamos")
    public List<PrestamoDTO> obtenerPrestamos(){
        return servicioPrestamo.obtenerPrestamos();
    }

    @Transactional
    @PostMapping("/prestamo")
    public ResponseEntity<Object> asignarPrestamo(@RequestBody AplicacionPrestamoUsuarioDTO aplicacionPrestamoUsuarioDTO, Authentication authentication){

        Prestamo prestamo = servicioPrestamo.encontrarPrestamoPorNombre(aplicacionPrestamoUsuarioDTO.getNombrePrestamo());
        Usuario usuario = servicioUsuario.encontrarUsuarioPorEmail(authentication.getName());
        Billetera billetera= usuario.getBilletera();

        //Compruebo que exista el prestamo solicitado, en teoria nunca tendria que entrar a esta comprobación, ya que lo corroboro en el front que esto no suceda
        if(Objects.isNull(prestamo)){
            return new ResponseEntity<>("El tipo de prestamo solicitado no existe", HttpStatus.FORBIDDEN);
        }

        //Parseo el amoun y cuotas a los tipos correctos, ya que traigo String desde el front
        double monto = Double.parseDouble(aplicacionPrestamoUsuarioDTO.getMonto());
        Integer cuotas = aplicacionPrestamoUsuarioDTO.getCuotas();
        //Compruebo que el monto ingresado no sea negativo
        if(monto<=0){
            return new ResponseEntity<>("El monto ingresado para el préstamo es inválido", HttpStatus.FORBIDDEN);
        }

        if (cuotas==0){
            return new ResponseEntity<>("La cantidad de cuotas ingresado es 0, por favor elija una cantidad de cuotas válida", HttpStatus.FORBIDDEN);
        }

        if(billetera.getMontoBTC()<prestamo.getGarantia()){
            return new ResponseEntity<>("No posee el monto necesario en BTC para validar la garantia del prestamo", HttpStatus.FORBIDDEN);
        }

        //Le sumo 1 al interés del préstamo para sacar el monto final a pagar.
        double interes = 1+ prestamo.getInteres();
        double montoFinalPrestamo = monto * interes;

        String description = "Prestamo de tipo: "+prestamo.getNombre()+" otorgado a la billetera: "+aplicacionPrestamoUsuarioDTO.getCuentaDestino();

        Transaccion transaccion=new Transaccion(TipoDeTransaccion.CREDITO,monto,description,LocalDateTime.now(),TipoDeMoneda.BITCOIN,billetera);
        billetera.agregarTransaccion(transaccion);

        PrestamoUsuario prestamoUsuario = new PrestamoUsuario(montoFinalPrestamo, aplicacionPrestamoUsuarioDTO.getCuotas(),usuario,prestamo);

        usuario.agregarPrestamo(prestamoUsuario);

        servicioPrestamoUsuario.guardarPrestamoUsuario(prestamoUsuario);
        servicioTransaccion.guardarTransaccion(transaccion);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
