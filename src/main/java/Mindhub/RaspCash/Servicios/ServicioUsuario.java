package Mindhub.RaspCash.Servicios;

import Mindhub.RaspCash.dtos.UsuarioDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ServicioUsuario {
    public List<UsuarioDTO> obtenerUsuarios();
}
