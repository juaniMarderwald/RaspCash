package Mindhub.RaspCash.Respositories;

import Mindhub.RaspCash.models.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PrestamoRespositorio extends JpaRepository<Prestamo,Long> {
}
