package Mindhub.RaspCash.models;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public @Data class Transaccion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    private TipoDeTransaccion tipo;
    private double amount;
    private String description;
    private LocalDateTime date;
    private NombreCriptomoneda nombresCriptomoneda;

    // Declaro la relacion Muchos a uno, quiere decir que una cuenta puede de una a muchas transacciones
    @ManyToOne(fetch = FetchType.EAGER)
    //Le agrego una fila a la base de datos de transacciones, que se va a llamar accounnt_id, el cual es un identificador unico para la cuenta
    @JoinColumn(name = "id_dueño_billetera")
    private Billetera billetera;

    public Transaccion() {
    }

    public long getId() {
        return id;
    }
}

