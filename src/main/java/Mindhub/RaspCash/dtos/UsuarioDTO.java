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
    //private BilleteraDTO billeteraDTO;

    public UsuarioDTO(Usuario usuario) {
        this.id=usuario.getId();
        this.nombre = usuario.getNombre();
        this.apellido= usuario.getApellido();
        this.apodo= usuario.getApodo();
        this.email= usuario.getEmail();
        //this.billeteraDTO=new BilleteraDTO(usuario.getBilletera());
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

//    public BilleteraDTO getBilleteraDTO() {
//        return billeteraDTO;
//    }
}
