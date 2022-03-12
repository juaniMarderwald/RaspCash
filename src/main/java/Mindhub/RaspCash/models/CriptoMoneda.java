package Mindhub.RaspCash.models;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

import javax.persistence.*;

@Entity
public @Data class CriptoMoneda {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    private String nombre;
    private double cotizacion;
    private String logo;

    public CriptoMoneda() {
    }

    public CriptoMoneda(String nombre, double cotizacion) {
        this.nombre = nombre;
        this.cotizacion = cotizacion;
    }

    public CriptoMoneda(String nombre, double cotizacion, String logo){
        this.nombre=nombre;
        this.cotizacion=cotizacion;
        this.logo=logo;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCotizacion() {
        return cotizacion;
    }

    public void setCotizacion(double cotizacion) {
        this.cotizacion = cotizacion;
    }

    public CriptoMoneda(long id, String nombre, double cotizacion) {
        this.id = id;
        this.nombre = nombre;
        this.cotizacion = cotizacion;

    }
}
