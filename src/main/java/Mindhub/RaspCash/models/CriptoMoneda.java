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



    public CriptoMoneda(long id, String nombre, double cotizacion) {
        this.id = id;
        this.nombre = nombre;
        this.cotizacion = cotizacion;

    }
}
