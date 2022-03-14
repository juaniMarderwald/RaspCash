package Mindhub.RaspCash.models;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

import javax.persistence.*;

@Entity
public class PrestamoUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    private  String nombre;
    private double monto;

    @ManyToOne(fetch = FetchType.EAGER)// Declaro la relacion Muchos a uno, quiere decir que un tipo de prestamo puede lo puede tener mas de un cliente
    @JoinColumn(name = "usuario_id")//Le agrego una Columna a la base de datos de ClientLoan
    private  Usuario duenioPrestamo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "prestamo_id")
    private Prestamo prestamo;


    public PrestamoUsuario() {
    }


}

