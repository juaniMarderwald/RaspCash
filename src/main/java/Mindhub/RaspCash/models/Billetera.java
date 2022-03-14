package Mindhub.RaspCash.models;

import Mindhub.RaspCash.utilidades.Utilidades;
import org.hibernate.annotations.GenericGenerator;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Billetera {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    private String direccion;
    private double montoBTC;
    private double montoPesos;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @OneToMany(mappedBy = "billetera", fetch = FetchType.EAGER)
    Set<Transaccion> transacciones=new HashSet<>();

    public Usuario getUsuario() {
        return usuario;
    }

    public Billetera() {
    }

    public Billetera(String direccion, double montoBTC, double montoPesos) {
        this.direccion=direccion;
        this.montoBTC=montoBTC;
        this.montoPesos=montoPesos;
    }

    public Billetera(String direccion, double montoBTC, double montoPesos, Usuario usuario) {
        this.direccion=direccion;
        this.montoBTC=montoBTC;
        this.montoPesos=montoPesos;
        this.usuario=usuario;
        usuario.setBilletera(this);
    }


    public void agregarTransaccion(Transaccion transaccion){
        //Agregar toda la logica de los montos, de si es credito o debito, y de que tipo de Cripto es la transaccion
        this.transacciones.add(transaccion);
    }

    public long getId() {
        return id;
    }

    public String getDireccion() {
        return direccion;
    }


    public Set<Transaccion> getTransacciones() {
        return transacciones;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public double getMontoBTC() {
        return montoBTC;
    }

    public double getMontoPesos() {
        return montoPesos;
    }
}
