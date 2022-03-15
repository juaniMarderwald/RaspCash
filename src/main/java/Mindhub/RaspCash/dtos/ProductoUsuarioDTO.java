package Mindhub.RaspCash.dtos;

import Mindhub.RaspCash.models.EstadoProducto;
import Mindhub.RaspCash.models.ProductoUsuario;
import Mindhub.RaspCash.models.TipoProducto;

public class ProductoUsuarioDTO {

    private long id;
    private String nombre;
    private TipoProducto tipo;
    private String imagen;
    private String descripcion;
    private double valorPagado;
    private EstadoProducto estadoProducto;



    public ProductoUsuarioDTO(ProductoUsuario productoUsuario) {
        this.id= productoUsuario.getId();
        this.nombre= productoUsuario.getNombre();
        this.tipo=productoUsuario.getTipoProducto();
        this.imagen=productoUsuario.getImagen();
        this.descripcion=productoUsuario.getDescripcion();
        this.valorPagado=productoUsuario.getPrecio();
        this.estadoProducto=productoUsuario.getEstadoProducto();
    }

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public TipoProducto getTipo() {
        return tipo;
    }

    public String getImagen() {
        return imagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getValorPagado() {
        return valorPagado;
    }

    public EstadoProducto getEstadoProducto() {
        return estadoProducto;
    }
}
