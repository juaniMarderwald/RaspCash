package Mindhub.RaspCash.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Mindhub.RaspCash.models.Usuario;
import Mindhub.RaspCash.respositories.UsuarioRepositorio;

@RestController
public class AppController {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    UsuarioRepositorio usuarioRepositorio;

    @PostMapping("/api/usuarios")
    public ResponseEntity<Object> register(
            @RequestParam String nombre, @RequestParam String apellido, @RequestParam String apodo,
            @RequestParam String correo, @RequestParam String password) {
        if (correo.isEmpty() || nombre.isEmpty() || apellido.isEmpty() || password.isEmpty() || apodo.isEmpty()) {
            return new ResponseEntity<>("Complete los datos solicitados", HttpStatus.FORBIDDEN);
        }

        if (usuarioRepositorio.findByEmail(correo) != null) {
            return new ResponseEntity<>("Correo ya registrado", HttpStatus.FORBIDDEN);
        }

        if (password.length() < 8){
            return new ResponseEntity<>("La contraseña no puede tener menos de 8 caracteres", HttpStatus.FORBIDDEN);
        }

        if (!correo.contains("@") && !correo.contains(".")) {
            return new ResponseEntity<>("Ingrese una dirección de correo valida", HttpStatus.FORBIDDEN);
        }

        for(int i = 0; i < nombre.length(); i++){
            char c = nombre.charAt(i);
            if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == ' ')) {
                return new ResponseEntity<>("El nombre no puede tener números, ni caracteres especiales", HttpStatus.FORBIDDEN);
            }
        }
        for(int i = 0; i < apellido.length(); i++){
            char c = apellido.charAt(i);
            if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == ' ')) {
                return new ResponseEntity<>("El apellido no puede tener números, ni caracteres especiales", HttpStatus.FORBIDDEN);
            }
        }

		usuarioRepositorio.save(new Usuario(correo, passwordEncoder.encode(password), nombre, apellido, apodo));

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
