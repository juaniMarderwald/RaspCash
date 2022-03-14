package Mindhub.RaspCash.servicios;

import Mindhub.RaspCash.models.Transaccion;
import Mindhub.RaspCash.servicios.implementacionesServicios.ImplementacionServicioTransaccion;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface ServicioTransaccion  {
    public void guardarTransaccion(Transaccion transaccion);
}
