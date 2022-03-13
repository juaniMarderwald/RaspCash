package Mindhub.RaspCash.dtos;

import Mindhub.RaspCash.models.CriptoMoneda;
import Mindhub.RaspCash.models.NombreCriptomoneda;
import lombok.Data;

public @Data class CriptoMonedaDTO {

    private long id;
    private String logo;
    private NombreCriptomoneda nombre;
    private double cotizacion;

    public CriptoMonedaDTO(CriptoMoneda criptoMoneda) {
        this.id=criptoMoneda.getId();
        this.nombre= criptoMoneda.getNombre();
        this.logo= criptoMoneda.getLogo();
        this.cotizacion= criptoMoneda.getCotizacion();
    }
}
