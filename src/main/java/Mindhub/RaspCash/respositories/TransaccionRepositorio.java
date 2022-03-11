package Mindhub.RaspCash.respositories;

import Mindhub.RaspCash.models.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransaccionRepositorio extends JpaRepository<Transaccion,Long> {

}
