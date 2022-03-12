package Mindhub.RaspCash.models;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

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

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @OneToMany(mappedBy = "billeteraOwner",fetch = FetchType.EAGER)
    private Set<CriptomonedaUsuario> criptomonedaUsuarios = new HashSet<>();

    public Usuario getUsuario() {
        return usuario;
    }


    public Billetera() {
    }
}
