package Mindhub.RaspCash.servicios;

import Mindhub.RaspCash.dtos.ProductoDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ServicioProducto {

    public List<ProductoDTO> obtenerTodosLosProductosDTO();
}
