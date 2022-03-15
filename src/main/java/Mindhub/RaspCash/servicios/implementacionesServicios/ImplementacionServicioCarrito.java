package Mindhub.RaspCash.servicios.implementacionesServicios;

import Mindhub.RaspCash.models.Carrito;
import Mindhub.RaspCash.respositories.CarritoRepositorio;
import Mindhub.RaspCash.servicios.ServicioCarrito;
import org.springframework.beans.factory.annotation.Autowired;

public class ImplementacionServicioCarrito implements ServicioCarrito {

    @Autowired
    CarritoRepositorio carritoRepositorio;

    @Override
    public Carrito obtenerCarritoPorId(long id) {
        return carritoRepositorio.getById(id);
    }
}
