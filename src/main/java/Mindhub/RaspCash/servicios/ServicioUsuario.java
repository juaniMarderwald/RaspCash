package Mindhub.RaspCash.servicios;

import Mindhub.RaspCash.dtos.UsuarioDTO;
import Mindhub.RaspCash.models.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ServicioUsuario {

    public List<UsuarioDTO> obtenerUsuarios();
    
    public ResponseEntity<Object> registro(String nombre, String apellido, String apodo, String correo, String password);
    
    public UsuarioDTO obtenerUsuarioPorId(long Id);

    public UsuarioDTO findByEmail(String email);

    public Usuario encontrarUsuarioPorEmail(String email);

}