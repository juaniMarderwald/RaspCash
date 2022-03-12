package Mindhub.RaspCash.servicios;

import Mindhub.RaspCash.dtos.UsuarioDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ServicioUsuario {

    public List<UsuarioDTO> obtenerUsuarios();
    
    public ResponseEntity<Object> registro(String nombre, String apellido, String apodo, String correo, String password);
}
