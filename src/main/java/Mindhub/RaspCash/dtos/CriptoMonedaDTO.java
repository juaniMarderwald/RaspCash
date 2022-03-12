package Mindhub.RaspCash.dtos;

import Mindhub.RaspCash.models.CriptoMoneda;
import lombok.Data;

public @Data class CriptoMonedaDTO {

    private long id;
    private String nombre, logo;
    private double cotizacion;

    public CriptoMonedaDTO(CriptoMoneda criptoMoneda) {
        this.id=criptoMoneda.getId();
        this.nombre= criptoMoneda.getNombre();
        this.logo= criptoMoneda.getLogo();
        this.cotizacion= criptoMoneda.getCotizacion();
    }
}
