package Mindhub.RaspCash.dtos;

import Mindhub.RaspCash.models.Billetera;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;

@Getter
public class BilleteraDTO {

    private long id;
    private String direccion;
    //private UsuarioDTO usuarioDTO;
    private double montoPesos;
    private double montoBTC;

    public BilleteraDTO(Billetera billetera) {
        this.id= billetera.getId();
        this.direccion= billetera.getDireccion();
       // this.usuarioDTO=new UsuarioDTO(billetera.getUsuario());
        this.montoPesos=billetera.getMontoPesos();
        this.montoBTC= billetera.getMontoBTC();
    }

    public long getId() {
        return id;
    }

    public String getDireccion() {
        return direccion;
    }
    /*@JsonIgnore
    public UsuarioDTO getUsuarioDTO() {
        return usuarioDTO;
    }*/

    public double getMontoPesos() {
        return montoPesos;
    }

    public double getMontoBTC() {
        return montoBTC;
    }
}
