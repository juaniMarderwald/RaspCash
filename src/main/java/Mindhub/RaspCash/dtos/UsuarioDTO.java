package Mindhub.RaspCash.dtos;

import Mindhub.RaspCash.models.PrestamoUsuario;
import Mindhub.RaspCash.models.Usuario;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class UsuarioDTO {
    private long id;
    private String nombre;
    private String apellido;
    private String apodo;
    private String email;
    private BilleteraDTO billetera;
    private List<PrestamoUsuarioDTO> prestamos=new ArrayList<>();

    public UsuarioDTO(Usuario usuario) {
        this.id=usuario.getId();
        this.nombre = usuario.getNombre();
        this.apellido= usuario.getApellido();
        this.apodo= usuario.getApodo();
        this.email= usuario.getEmail();
        this.billetera=new BilleteraDTO(usuario.getBilletera());
        this.prestamos=usuario.getPrestamos().stream().map(PrestamoUsuarioDTO::new).collect(Collectors.toList());
    }

    public long getId() {
        return id;
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

    public String getEmail() {
        return email;
    }

    public BilleteraDTO getBilletera() {
        return billetera;
    }

    public List<PrestamoUsuarioDTO> getPrestamos() {
        return prestamos;
    }
}
