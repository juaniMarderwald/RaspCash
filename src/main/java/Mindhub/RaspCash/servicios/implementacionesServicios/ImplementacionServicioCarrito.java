package Mindhub.RaspCash.servicios.implementacionesServicios;

import Mindhub.RaspCash.dtos.CarritoDTO;
import Mindhub.RaspCash.models.Carrito;
import Mindhub.RaspCash.respositories.CarritoRepositorio;
import Mindhub.RaspCash.servicios.ServicioCarrito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ImplementacionServicioCarrito implements ServicioCarrito {

    @Autowired
    CarritoRepositorio carritoRepositorio;

    @Override
    public CarritoDTO obtenerCarritoDTOPorId(long id) {
        //accountRepository.findById(id).map(AccountDTO::new).orElse(null);
        return carritoRepositorio.findById(id).map(CarritoDTO::new).orElse(null);
    }

    @Override
    public Carrito obtenerCarritoPorId(long id) {
        return carritoRepositorio.findById(id).orElse(null);
    }

    @Override
    public List<CarritoDTO> obtenerTodosLosCarritos() {
        return carritoRepositorio.findAll().stream().map(CarritoDTO::new).collect(Collectors.toList());
    }
}
