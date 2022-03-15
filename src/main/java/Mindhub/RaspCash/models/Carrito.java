package Mindhub.RaspCash.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
public class Carrito {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    @OneToMany(mappedBy = "carrito_id", fetch = FetchType.EAGER)
    private List<ProductoUsuario> productosEnCarrito=new ArrayList<>();

    private double total;

    public Carrito() {
        total=0;
    }

   // public Usuario getUsuario() {        return usuario;    }

    public void agregarProductoAlCarrito(ProductoUsuario productoUsuario){
        this.productosEnCarrito.add(productoUsuario);
        this.total+=productoUsuario.getPrecio();
    }

    public long getId() {
        return id;
    }

    public List<ProductoUsuario> getProductosEnCarrito() {
        return productosEnCarrito;
    }

    public double getTotal() {
        return total;
    }

    //public void setUsuario(Usuario usuario){        this.usuario=usuario;    }
}
