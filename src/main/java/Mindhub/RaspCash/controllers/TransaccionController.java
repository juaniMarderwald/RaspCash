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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api")
public class TransaccionController {

    @Autowired
    ServicioTransaccion servicioTransaccion;

    @Autowired
    ServicioBilletera servicioBilletera;

    @PostMapping("/transaccion")
    public ResponseEntity<Object> hacerTransaccion(@RequestParam String tipoDeMoneda, @RequestParam String monto, @RequestParam String direccionBilleteraEmisora,@RequestParam String direccionBilleteraReceptora,@RequestParam String descripcion){
        //Faltan agregar los if de las comprobaciones, y en la billetera, resolveer el metodo agregarTransaccion, ahi está toda la logica
        TipoDeMoneda tipoDeMonedatransaccion=TipoDeMoneda.valueOf(tipoDeMoneda);
        double montoTransaccion = Double.parseDouble(monto);

        Billetera billeteraEmisora = servicioBilletera.encontrarPorDireccion(direccionBilleteraEmisora);
        Billetera billeteraReceptora= servicioBilletera.encontrarPorDireccion(direccionBilleteraReceptora);
        System.out.println("**************************************");
        System.out.println(direccionBilleteraEmisora);
        System.out.println("**************************************");
        Transaccion transaccionDebito=new Transaccion(TipoDeTransaccion.DEBITO,montoTransaccion,descripcion, LocalDateTime.now(),tipoDeMonedatransaccion,billeteraEmisora);
        Transaccion transaccionCredito=new Transaccion(TipoDeTransaccion.CREDITO,montoTransaccion,descripcion,LocalDateTime.now(),tipoDeMonedatransaccion,billeteraReceptora);

        billeteraEmisora.agregarTransaccion(transaccionDebito);
        billeteraReceptora.agregarTransaccion(transaccionCredito);

        servicioTransaccion.guardarTransaccion(transaccionDebito);
        servicioTransaccion.guardarTransaccion(transaccionCredito);

        return new ResponseEntity<>(HttpStatus.CREATED);

    }

}
