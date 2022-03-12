package Mindhub.RaspCash.models;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

import javax.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
public @Data class Usuario {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    private String email;
    private String password;
    private String nombre;
    private String apellido;
    private String apodo;

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

    public Usuario(String correo, String contrasenia, String nombre, String apellido, String apodo) {
        this.email = correo;
        this.password = contrasenia;
        this.nombre = nombre;
        this.apellido = apellido;
        this.apodo = apodo;
    }

    public void addNft(Producto producto){
    }

}
