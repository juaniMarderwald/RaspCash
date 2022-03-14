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

    public Usuario(String correo, String contrasenia, String nombre, String apellido, String apodo,Billetera billetera) {
        this.email = correo;
        this.password = contrasenia;
        this.nombre = nombre;
        this.apellido = apellido;
        this.apodo = apodo;
        this.billetera=billetera;
    }

    public void addNft(Producto producto){
        this.nfts.add(producto);
    }

	public String getEmail() {
		return this.email;
	}

	public String getPassword() {
		return this.password;
	}

	public long getId() {
		return id;
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

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    public void setCarrito(Carrito carrito) {
        this.carrito = carrito;
    }

    public void setBilletera(Billetera billetera) {
        billetera.setUsuario(this);
        this.billetera = billetera;
    }

    public void setPrestamo(List<PrestamoUsuario> prestamo) {
        this.prestamo = prestamo;
    }

    public void setNfts(Set<Producto> nfts) {
        this.nfts = nfts;
    }


}
