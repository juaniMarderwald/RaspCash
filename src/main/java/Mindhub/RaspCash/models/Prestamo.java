package Mindhub.RaspCash.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Prestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id ;

    private String nombre;
    private double interes;
    private double montoMaximo;

    @OneToMany(mappedBy = "duenioPrestamo", fetch = FetchType.EAGER)
    Set<PrestamoUsuario> prestamoUsuario = new HashSet<>();


    public Prestamo() {
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Prestamo(String nombre, double interes, double montoMaximo) {
        this.nombre = nombre;
        this.interes = interes;
        this.montoMaximo = montoMaximo;
    }

}
