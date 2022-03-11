package Mindhub.RaspCash.controllers;

import Mindhub.RaspCash.Servicios.ServicioUsuario;
import Mindhub.RaspCash.dtos.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
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


}
