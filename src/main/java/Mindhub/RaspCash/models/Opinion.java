package Mindhub.RaspCash.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Opinion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    private String descripcion;
    private int puntuacion;

    private Usuario usuarioOpinion;

    // Declaro la relacion Muchos a uno, quiere decir que muchas tarjetas pueden pertenecer a un Cliente
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "opinion_id")
    private Opinion opinion;

    public Opinion() {
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public void setUsuarioOpinion(Usuario usuarioOpinion) {
        this.usuarioOpinion = usuarioOpinion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public Usuario getUsuarioOpinion() {
        return usuarioOpinion;
    }
}
