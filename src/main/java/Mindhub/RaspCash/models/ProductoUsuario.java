package Mindhub.RaspCash.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class ProductoUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    @ManyToOne
    @JoinColumn(name="producto_id")
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "usuario_dueño")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name="carrito_id")
    private Carrito carrito;

    public ProductoUsuario() {
    }




}
