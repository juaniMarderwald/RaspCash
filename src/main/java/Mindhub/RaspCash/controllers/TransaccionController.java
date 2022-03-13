package Mindhub.RaspCash.controllers;

import Mindhub.RaspCash.models.NombreCriptomoneda;
import Mindhub.RaspCash.models.Usuario;
import Mindhub.RaspCash.servicios.ServicioTransaccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TransaccionController {

    @Autowired
    ServicioTransaccion servicioTransaccion;

    @PostMapping("transaction")
    public ResponseEntity<Object> doTransaction(NombreCriptomoneda nombreCripto, double monto, String direccionBilleteraEmisora, String direccionBilleteraReceptora, String descripcion){
        return null;
    }

}
