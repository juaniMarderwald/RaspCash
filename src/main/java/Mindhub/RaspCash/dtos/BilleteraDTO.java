package Mindhub.RaspCash.dtos;

import Mindhub.RaspCash.models.Billetera;
import lombok.Getter;

@Getter
public class BilleteraDTO {

    private long id;
    private String direccion;
    private UsuarioDTO usuario;

    public BilleteraDTO(Billetera billetera) {
        this.id= billetera.getId();
        this.direccion= billetera.getDireccion();
        this.usuario=new UsuarioDTO(billetera.getUsuario());
    }

    public long getId() {
        return id;
    }

    public String getDireccion() {
        return direccion;
    }

    public UsuarioDTO getUsuario() {
        return usuario;
    }
}
