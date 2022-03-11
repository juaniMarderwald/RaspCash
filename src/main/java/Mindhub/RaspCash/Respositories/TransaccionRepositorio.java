package Mindhub.RaspCash.Respositories;

import Mindhub.RaspCash.models.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransaccionRepositorio extends JpaRepository<Transaccion,Long> {
}
