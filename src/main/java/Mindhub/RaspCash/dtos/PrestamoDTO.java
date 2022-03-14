package Mindhub.RaspCash.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PrestamoDTO {
    private long id ;

    private String nombre;
    private double interes;
    private double montoMaximo;

    public PrestamoDTO() {
    }
}
