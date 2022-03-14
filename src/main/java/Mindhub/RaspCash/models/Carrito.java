package Mindhub.RaspCash.models;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
public @Data class Carrito {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    @OneToOne
    private Usuario usuario;

    //private List<Producto> productos;

    private  double total;

    public Carrito() {
    }

    public Usuario getUsuario() {
        return usuario;
    }

   /* public void agregarProductoAlCarrito(Producto producto){
        this.productos.add(producto);
    }*/


}
