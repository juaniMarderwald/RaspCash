package Mindhub.RaspCash.controllers;

import Mindhub.RaspCash.models.*;
import Mindhub.RaspCash.respositories.BilleteraRepositorio;
import Mindhub.RaspCash.servicios.ServicioBilletera;
import Mindhub.RaspCash.servicios.ServicioTransaccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api")
public class TransaccionController {

    @Autowired
    ServicioTransaccion servicioTransaccion;

    @Autowired
    ServicioBilletera servicioBilletera;

    @PostMapping("transaction")
    public ResponseEntity<Object> hacerTransaccion(NombreCriptomoneda nombreCripto, String monto, String direccionBilleteraEmisora, String direccionBilleteraReceptora, String descripcion){
        //Faltan agregar los if de las comprobaciones, y en la billetera, resolveer el metodo agregarTransaccion, ahi está toda la logica

        double montoTransaccion = Double.parseDouble(monto);

        Billetera billeteraEmisora = servicioBilletera.encontrarPorDireccion(direccionBilleteraEmisora);
        Billetera billeteraReceptora= servicioBilletera.encontrarPorDireccion(direccionBilleteraReceptora);

        Transaccion transaccionDebito=new Transaccion(TipoDeTransaccion.DEBITO,montoTransaccion,descripcion, LocalDateTime.now(),nombreCripto,billeteraEmisora);
        Transaccion transaccionCredito=new Transaccion(TipoDeTransaccion.CREDITO,montoTransaccion,descripcion,LocalDateTime.now(),nombreCripto,billeteraReceptora);

        billeteraEmisora.agregarTransaccion(transaccionDebito);
        billeteraReceptora.agregarTransaccion(transaccionCredito);

        servicioTransaccion.guardarTransaccion(transaccionDebito);
        servicioTransaccion.guardarTransaccion(transaccionCredito);

        return new ResponseEntity<>(HttpStatus.CREATED);

    }

}
