package Mindhub.RaspCash.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.*;

@Entity
public class Carrito {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    @OneToMany(mappedBy = "carrito_id", fetch = FetchType.EAGER)
    private Set<ProductoUsuario> productosEnCarrito=new HashSet<>();

    private double total;

    public Carrito() {
        total=0;
    }

    public void agregarProductoAlCarrito(ProductoUsuario productoUsuario){
        this.productosEnCarrito.add(productoUsuario);
        this.total+=productoUsuario.getPrecio();
    }

    public long getId() {
        return id;
    }

    public Set<ProductoUsuario> getProductosEnCarrito() {
        return productosEnCarrito;
    }

    public double getTotal() {
        return total;
    }

    public void vaciarCarrito(){
        this.total=0;
        this.productosEnCarrito=new HashSet<>();
    }
    //public void setUsuario(Usuario usuario){        this.usuario=usuario;    }
}
