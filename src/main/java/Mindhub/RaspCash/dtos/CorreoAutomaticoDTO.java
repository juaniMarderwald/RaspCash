package Mindhub.RaspCash.dtos;

import Mindhub.RaspCash.models.Usuario;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CorreoAutomaticoDTO {
    private String nombre;
    private String apellido;
    private String email;
    private Usuario usuario;

    public CorreoAutomaticoDTO(String nombre, String apellido, String email, Usuario usuario) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.usuario = usuario;
    }
}

