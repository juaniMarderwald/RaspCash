package Mindhub.RaspCash.dtos;

import Mindhub.RaspCash.models.Usuario;

public class UsuarioDTO {
    private long id;
    private String nombre,apellido,apodo;

    public UsuarioDTO(Usuario usuario) {
        this.id=usuario.getId();
        this.nombre = usuario.getNombre();
        this.apellido= usuario.getApellido();
        this.apodo= usuario.getApodo();
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getApodo() {
        return apodo;
    }
}
