package Mindhub.RaspCash.servicios.implementacionesServicios;

import Mindhub.RaspCash.servicios.ServicioUsuario;
import Mindhub.RaspCash.dtos.UsuarioDTO;
import Mindhub.RaspCash.respositories.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ImplementacionServicioUsuario implements ServicioUsuario {

    @Autowired
    UsuarioRepositorio usuarioRepositorio;

    @Override
    public List<UsuarioDTO> obtenerUsuarios() {
        return usuarioRepositorio.findAll().stream().map(UsuarioDTO::new).collect(Collectors.toList());
    }
}
