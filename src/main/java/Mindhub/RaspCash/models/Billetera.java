package Mindhub.RaspCash.models;

import Mindhub.RaspCash.utilidades.Utilidades;
import org.hibernate.annotations.GenericGenerator;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public @Data class Billetera {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;
    private String direccion;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @OneToMany(mappedBy = "billeteraOwner",fetch = FetchType.EAGER)
    private Set<CriptomonedaUsuario> criptomonedaUsuarios = new HashSet<>();

    @OneToMany(mappedBy = "billetera", fetch = FetchType.EAGER)
    Set<Transaccion> transacciones=new HashSet<>();

    public Usuario getUsuario() {
        return usuario;
    }

    public Billetera() {
    }

    public Billetera(Usuario usuario, String direccion){
        this.direccion=direccion;
        this.usuario=usuario;
    }
    public void agregarTransaccion(Transaccion transaccion){
        //Agregar toda la logica de los montos, de si es credito o debito, y de que tipo de Cripto es la transaccion
        this.transacciones.add(transaccion);
    }
}
