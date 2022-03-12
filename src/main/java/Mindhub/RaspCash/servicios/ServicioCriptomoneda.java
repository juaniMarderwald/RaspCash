package Mindhub.RaspCash.servicios;

import Mindhub.RaspCash.dtos.CriptoMonedaDTO;
import Mindhub.RaspCash.models.CriptoMoneda;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ServicioCriptomoneda {

    public List<CriptoMonedaDTO> obtenerTodasLasCriptomonedas();
    
    public List<CriptoMonedaDTO> obtenerCriptoMonedasPorNombre(String nombre);
}
