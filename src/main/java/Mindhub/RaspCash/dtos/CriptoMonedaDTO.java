package Mindhub.RaspCash.dtos;

import Mindhub.RaspCash.models.CriptoMoneda;

public class CriptoMonedaDTO {

    private long id;
    private String nombre, logo;
    private double cotizacion;

    public CriptoMonedaDTO(CriptoMoneda criptoMoneda) {
        this.id=criptoMoneda.getId();
        this.nombre= criptoMoneda.getNombre();
        this.logo= criptoMoneda.getLogo();
        this.cotizacion= criptoMoneda.getCotizacion();
    }

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getLogo() {
        return logo;
    }

    public double getCotizacion() {
        return cotizacion;
    }
}