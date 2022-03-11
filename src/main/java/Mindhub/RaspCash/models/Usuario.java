package Mindhub.RaspCash.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;
    private String correo;
    private String contraseña;



    @OneToOne
    private Carrito carrito;

    @OneToOne
    private Billetera billetera;

    @OneToMany(mappedBy = "duenioPrestamo", fetch = FetchType.EAGER)
    private List<PrestamoUsuario> prestamo;

    private List<Producto> productos;

    @OneToMany(mappedBy = "", fetch = FetchType.EAGER)
    private Set<Producto> NFTs= new HashSet<>();

    public Usuario() {
    }


    public Usuario(long id, String correo, String contraseña, Carrito carrito) {
        this.id = id;
        this.correo = correo;
        this.contraseña = contraseña;
        this.carrito = carrito;
    }

    public long getId() {
        return id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
