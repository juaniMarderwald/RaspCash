package Mindhub.RaspCash.models;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
public class Carrito {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    @OneToOne
    private Usuario usuario;

    private List<ProductoUsuario> productos;

    private  double total;

    public Carrito() {
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void agregarProductoAlCarrito(ProductoUsuario productoUsuario){
        this.productos.add(productoUsuario);
    }

    public long getId() {
        return id;
    }

    public List<ProductoUsuario> getProductos() {
        return productos;
    }

    public double getTotal() {
        return total;
    }

    public void setUsuario(Usuario usuario){
        this.usuario=usuario;
    }
}
