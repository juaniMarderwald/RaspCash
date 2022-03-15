package Mindhub.RaspCash.servicios.implementacionesServicios;

import Mindhub.RaspCash.dtos.ProductoDTO;
import Mindhub.RaspCash.respositories.ProductoRepositorio;
import Mindhub.RaspCash.servicios.ServicioProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ImplementacionServicioProducto implements ServicioProducto {

    @Autowired
    ProductoRepositorio productoRepositorio;

    @Override
    public List<ProductoDTO> obtenerTodosLosProductosDTO() {
        return productoRepositorio.findAll().stream().map(ProductoDTO::new).collect(Collectors.toList());
    }


}
