package Mindhub.RaspCash.models;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public @Data class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    private int stock;
    private String imagen;
    private double valor;
    private String descripcion;
    private String nombre;
    private  TipoProducto tipo;

    @OneToMany(mappedBy = "", fetch = FetchType.EAGER)
    private Set<Opinion> opiniones=new HashSet<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name ="usuario_id")
    private Usuario usuario;

    public Producto() {
    }
}
