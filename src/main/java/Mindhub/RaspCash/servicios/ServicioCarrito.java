package Mindhub.RaspCash.servicios;

import Mindhub.RaspCash.dtos.CarritoDTO;
import Mindhub.RaspCash.models.Carrito;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ServicioCarrito {

    public CarritoDTO obtenerCarritoDTOPorId(long id);
    public Carrito obtenerCarritoPorId(long id);
    public List<CarritoDTO> obtenerTodosLosCarritos();
}
