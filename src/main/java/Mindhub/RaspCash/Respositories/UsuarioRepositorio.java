package Mindhub.RaspCash.Respositories;

import Mindhub.RaspCash.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UsuarioRepositorio extends JpaRepository<Usuario,Long> {
}
