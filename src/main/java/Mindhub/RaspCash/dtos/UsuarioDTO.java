package Mindhub.RaspCash.dtos;

import Mindhub.RaspCash.models.Usuario;
import lombok.Getter;

@Getter
public class UsuarioDTO {
    private long id;
    private String nombre;
    private String apellido;
    private String apodo;
    private String email;

    public UsuarioDTO(Usuario usuario) {
        this.id=usuario.getId();
        this.nombre = usuario.getNombre();
        this.apellido= usuario.getApellido();
        this.apodo= usuario.getApodo();
        this.email= usuario.getEmail();
    }
}