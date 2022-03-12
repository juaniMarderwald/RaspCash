package Mindhub.RaspCash.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
public class Carrito {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @OneToMany(mappedBy = "", fetch = FetchType.EAGER)
    private List<Producto> productos;

    private  double total;

    public Usuario getUsuario() {
        return usuario;
    }

    public void agregarProductoAlCarrito(Producto producto){
        this.productos.add(producto);
    }

}
