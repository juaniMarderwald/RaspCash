package Mindhub.RaspCash.Respositories;

import Mindhub.RaspCash.models.Billetera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface BilleteraRepositorio extends JpaRepository<Billetera,Long>{

    }


