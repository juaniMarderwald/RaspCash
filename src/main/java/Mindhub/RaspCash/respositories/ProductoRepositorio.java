package Mindhub.RaspCash.respositories;

import Mindhub.RaspCash.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepositorio extends JpaRepository<Producto,Long> {
}
