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
    private String email, contraseña, nombre, apellido, apodo;

    @OneToOne
    @JoinColumn(name = "carrito_id")
    private Carrito carrito;

    @OneToOne
    @JoinColumn(name = "billetera_id")
    private Billetera billetera;

    @OneToMany(mappedBy = "duenioPrestamo", fetch = FetchType.EAGER)
    private List<PrestamoUsuario> prestamo;

    @OneToMany(mappedBy = "usuario" , fetch = FetchType.EAGER)
    private Set<Producto> nfts= new HashSet<>();

    public Usuario() {
    }

    public Usuario(String correo, String contraseña, String nombre, String apellido, String apodo) {
        this.email = correo;
        this.contraseña = contraseña;
        this.nombre = nombre;
        this.apellido = apellido;
        this.apodo = apodo;
    }

    public String getCorreo() {
        return email;
    }

    public String getContraseña() {
        return contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getApodo() {
        return apodo;
    }

    public Carrito getCarrito() {
        return carrito;
    }

    public Billetera getBilletera() {
        return billetera;
    }

    public List<PrestamoUsuario> getPrestamo() {
        return prestamo;
    }

    public Set<Producto> getNfts() {
        return nfts;
    }

    public void addNft(Producto producto){

    }
}
