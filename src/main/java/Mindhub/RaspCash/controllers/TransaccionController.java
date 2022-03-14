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
        //Las transacciones son de billetera a billetera

        //Faltan agregar los if de las comprobaciones, y en la billetera, resolveer el metodo agregarTransaccion, ahi está toda la logica
        TipoDeMoneda tipoDeMonedatransaccion=TipoDeMoneda.valueOf(tipoDeMoneda);
        double montoTransaccion = Double.parseDouble(monto);

        if(montoTransaccion<=0){
            return new ResponseEntity<>("El monto de la transferencia no puede ser 0 o negativo", HttpStatus.FORBIDDEN);
        }

        if (direccionBilleteraEmisora.equals("")){
            return new ResponseEntity<>("La Direccion de billetera emisora del pago se encuentra vacía", HttpStatus.FORBIDDEN);
        }

        if(direccionBilleteraReceptora.equals("")){
            return new ResponseEntity<>("La Direccion de billetera receptora del pago se encuentra vacía", HttpStatus.FORBIDDEN);
        }

        //Si pasa las condiciones iniciales para la transferencia, rescatamos las billeteras de la Base de datos.
        Billetera billeteraEmisora = servicioBilletera.encontrarPorDireccion(direccionBilleteraEmisora);
        Billetera billeteraReceptora= servicioBilletera.encontrarPorDireccion(direccionBilleteraReceptora);

        //Chequeo si el monto en pesos o el monto en BTC de la cuenta emisora es suficiente para realizar la transferencia
        if (tipoDeMonedatransaccion.equals(TipoDeMoneda.PESOS)){
            if (billeteraEmisora.getMontoPesos()<0){
                return new ResponseEntity<>("El monto en pesos de la cuenta emisora es insuficiente para realizar la transacciòn", HttpStatus.FORBIDDEN);
            }
        }
        if (tipoDeMonedatransaccion.equals(TipoDeMoneda.BITCOIN)){
            if (billeteraEmisora.getMontoBTC()<0){
                return new ResponseEntity<>("El monto en pesos de la cuenta emisora es insuficiente para realizar la transacciòn", HttpStatus.FORBIDDEN);
            }
        }

        Transaccion transaccionDebito=new Transaccion(TipoDeTransaccion.DEBITO,montoTransaccion,descripcion, LocalDateTime.now(),tipoDeMonedatransaccion,billeteraEmisora);
        Transaccion transaccionCredito=new Transaccion(TipoDeTransaccion.CREDITO,montoTransaccion,descripcion,LocalDateTime.now(),tipoDeMonedatransaccion,billeteraReceptora);

        billeteraEmisora.agregarTransaccion(transaccionDebito);
        billeteraReceptora.agregarTransaccion(transaccionCredito);

        servicioTransaccion.guardarTransaccion(transaccionDebito);
        servicioTransaccion.guardarTransaccion(transaccionCredito);

        return new ResponseEntity<>(HttpStatus.CREATED);

    }

}
