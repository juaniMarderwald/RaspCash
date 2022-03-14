package Mindhub.RaspCash.controllers;

import Mindhub.RaspCash.dtos.PrestamoDTO;
import Mindhub.RaspCash.models.*;
import Mindhub.RaspCash.respositories.*;
import Mindhub.RaspCash.servicios.ServicioPrestamo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class PrestamoController {

    @Autowired
    ServicioPrestamo servicioPrestamo;

    @GetMapping("/prestamos")
    public List<PrestamoDTO> obtenerPrestamos(){
        return servicioPrestamo.obtenerPrestamos();
    }

}
