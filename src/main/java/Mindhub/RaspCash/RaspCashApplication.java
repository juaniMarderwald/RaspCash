package Mindhub.RaspCash;

import Mindhub.RaspCash.models.Usuario;
import Mindhub.RaspCash.respositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class RaspCashApplication {

	public static void main(String[] args) {
		SpringApplication.run(RaspCashApplication.class, args);
	}

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Bean
	public CommandLineRunner initData(UsuarioRepositorio usuarioRepositorio, BilleteraRepositorio billeteraRepositorio,
									  CarritoRepositorio carritoRepositorio, CriptoMonedaRepositorio criptoMonedaRepositorio,
									  PrestamoRespositorio prestamoRespositorio, PrestamoUsuarioRespositorio prestamoUsuarioRespositorio,
									  ProductoRepositorio productoRepositorio, TransaccionRepositorio transaccionRepositorio){

	return (args) -> {

			Usuario usuario1= new Usuario("jmarderwald87@gmail.com","123456","Juan Ignacio","Mardewrwald","Juani");
			Usuario usuario2 = new Usuario("melba@mindhub.com","123456","Melba","Morel","Melbita");
			usuarioRepositorio.save(usuario1);
			usuarioRepositorio.save(usuario2);





		};
	}

}
