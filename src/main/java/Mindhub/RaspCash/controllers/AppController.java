package Mindhub.RaspCash.controllers;

import Mindhub.RaspCash.models.Billetera;
import Mindhub.RaspCash.utilidades.Utilidades;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import Mindhub.RaspCash.respositories.UsuarioRepositorio;
import Mindhub.RaspCash.servicios.ServicioUsuario;

@RestController
public class AppController {

    @Autowired 
    ServicioUsuario servicioUsuario;
    
    @PostMapping("/api/usuarios")
    public ResponseEntity<Object> register(
            @RequestParam String nombre, @RequestParam String apellido, @RequestParam String apodo,
            @RequestParam String correo, @RequestParam String password) {

        return servicioUsuario.registro(nombre, apellido, apodo, correo, password);
    }
}
