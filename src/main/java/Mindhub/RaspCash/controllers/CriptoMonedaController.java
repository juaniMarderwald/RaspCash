package Mindhub.RaspCash.controllers;

import Mindhub.RaspCash.dtos.CriptoMonedaDTO;
import Mindhub.RaspCash.models.CriptoMoneda;
import Mindhub.RaspCash.servicios.ServicioCriptomoneda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CriptoMonedaController {

    @Autowired
    ServicioCriptomoneda servicioCriptomoneda;

    @GetMapping("/criptomonedas")
    public List<CriptoMonedaDTO> obtenerTodasLasCriptomonedas(){
        return servicioCriptomoneda.obtenerTodasLasCriptomonedas();
    }

}
