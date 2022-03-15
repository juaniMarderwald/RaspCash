package Mindhub.RaspCash.controllers;

import Mindhub.RaspCash.dtos.BilleteraDTO;
import Mindhub.RaspCash.models.Billetera;
import Mindhub.RaspCash.respositories.BilleteraRepositorio;
import Mindhub.RaspCash.servicios.ServicioBilletera;
import Mindhub.RaspCash.utilidades.Utilidades;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BilleteraController {

    @Autowired
    ServicioBilletera servicioBilletera;

    @GetMapping("/billeteras")
    public List<BilleteraDTO> obtenerTodasLasBilleteras(){
        return servicioBilletera.obtenerTodasLasBilleteras();
    }
}