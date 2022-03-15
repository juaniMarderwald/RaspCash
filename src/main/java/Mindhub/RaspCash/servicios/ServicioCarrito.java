package Mindhub.RaspCash.servicios;

import Mindhub.RaspCash.models.Carrito;
import org.springframework.stereotype.Service;

@Service
public interface ServicioCarrito {

    public Carrito obtenerCarritoPorId(long id);
}
