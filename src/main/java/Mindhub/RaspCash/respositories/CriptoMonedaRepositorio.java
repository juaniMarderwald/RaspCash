package Mindhub.RaspCash.respositories;

import Mindhub.RaspCash.models.CriptoMoneda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CriptoMonedaRepositorio extends JpaRepository<CriptoMoneda,Long> {
}
