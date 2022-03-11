package Mindhub.RaspCash.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    private int stock;
    private String imagen;
    private double valor;
    private String descripcion;
    private String nombre;
    private  String tipo;

    @OneToMany(mappedBy = "opinion", fetch = FetchType.EAGER)
    private Set<Opinion> opiniones=new HashSet<>();




    public Producto() {
    }
}
