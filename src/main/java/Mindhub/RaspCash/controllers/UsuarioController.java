package Mindhub.RaspCash.controllers;

import Mindhub.RaspCash.servicios.ServicioUsuario;
import Mindhub.RaspCash.dtos.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UsuarioController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    ServicioUsuario servicioUsuario;

    @GetMapping("/usuarios")
    public List<UsuarioDTO> obtenerUsuarios(){
        return servicioUsuario.obtenerUsuarios();
    }

    @GetMapping("/usuarios/{id}")
    public UsuarioDTO obtenerUsuarioPorId(@PathVariable long id) throws Exception {
    	return servicioUsuario.obtenerUsuarioPorId(id);
    }
}
