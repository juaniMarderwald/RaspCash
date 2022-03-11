package Mindhub.RaspCash.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

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
    private List<Opinion> opiniones;
    private  String tipo;


}
