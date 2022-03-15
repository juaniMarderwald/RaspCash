package Mindhub.RaspCash.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

import java.util.ArrayList;
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

   /* @OneToOne
    @JoinColumn(name = "carrito_id")
    private Carrito carrito = new Carrito();*/

    @OneToOne
    @JoinColumn(name = "billetera_id")
    private Billetera billetera;

    @OneToMany(mappedBy = "duenioPrestamo", fetch = FetchType.EAGER)
    private List<PrestamoUsuario> prestamos =new ArrayList<>();

   /* @OneToMany(mappedBy = "usuario" , fetch = FetchType.EAGER)
    private List<ProductoUsuario> productos= new ArrayList<>();*/

    public Usuario() {
    }

    public Usuario(String correo, String contrasenia, String nombre, String apellido, String apodo) {
        this.email = correo;
        this.password = contrasenia;
        this.nombre = nombre;
        this.apellido = apellido;
        this.apodo = apodo;
    }

    public Usuario(String correo, String contrasenia, String nombre, String apellido, String apodo,Billetera billetera, Carrito carrito) {
        this.email = correo;
        this.password = contrasenia;
        this.nombre = nombre;
        this.apellido = apellido;
        this.apodo = apodo;
        this.billetera=billetera;
        billetera.setUsuario(this);
      //  this.carrito=carrito;
     //   carrito.setUsuario(this);
    }

    /*public void agregarProductoAdquirido(ProductoUsuario productoUsuario){
        this.productos.add(productoUsuario);
    }*/

  /*  public Carrito getCarrito() {
        return carrito;
    }*/

    /*public List<ProductoUsuario> getProductos() {
        return productos;
    }*/

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

	/*public Carrito getCarrito() {
		return carrito;
	}*/

	public Billetera getBilletera() {
		return billetera;
	}

	public List<PrestamoUsuario> getPrestamos() {
		return prestamos;
	}

	/*public Set<Producto> getNfts() {
		return nfts;
	}*/

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

    /*public void setCarrito(Carrito carrito) {
        this.carrito = carrito;
    }*/

    public void setBilletera(Billetera billetera) {
        billetera.setUsuario(this);
        this.billetera = billetera;
    }

    public void setPrestamos(List<PrestamoUsuario> prestamos) {
        this.prestamos = prestamos;
    }

    public void agregarPrestamo(PrestamoUsuario prestamoUsuario){
        this.prestamos.add(prestamoUsuario);
    }

   /* public void setNfts(Set<Producto> nfts) {
        this.nfts = nfts;
    }*/


}
