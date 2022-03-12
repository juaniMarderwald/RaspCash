package Mindhub.RaspCash;

import Mindhub.RaspCash.models.Usuario;
import Mindhub.RaspCash.respositories.*;
import Mindhub.RaspCash.servicios.implementacionesServicios.EmailSenderServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class RaspCashApplication {
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private EmailSenderServiceImplementation senderService;

	public static void main(String[] args) {
		SpringApplication.run(RaspCashApplication.class, args);
	}


	@EventListener(ApplicationReadyEvent.class)
	public void triggerMail(){                //PARA QUE SEA MAS DINAMICO LO IDEAL SERIA HACER UNA VARIABLE PARA QUE SEA UN EMAIL DIFERENTE
												// O QUE ENGLOBE ESTE SERVICIO ENTONCES QUEDA CONECTADO
												//hablando del receptor del email

 			senderService.senSimpleEmailTo("gelneryus20@gmail.com",
					"Para el registro, usted ha sido registrado con éxito y el mail del usuario",
					"RASPCASH");
	}

	@Bean
	public CommandLineRunner initData(UsuarioRepositorio usuarioRepositorio, BilleteraRepositorio billeteraRepositorio,
									  CarritoRepositorio carritoRepositorio, CriptoMonedaRepositorio criptoMonedaRepositorio,
									  PrestamoRespositorio prestamoRespositorio, PrestamoUsuarioRespositorio prestamoUsuarioRespositorio,
									  ProductoRepositorio productoRepositorio, TransaccionRepositorio transaccionRepositorio){

	return (args) -> {

			String contrasenia1=passwordEncoder.encode("123456");
			String contraseniaAdmin=passwordEncoder.encode("admin");
			Usuario usuario1= new Usuario("jmarderwald87@gmail.com",contrasenia1,"Juan Ignacio","Mardewrwald","Juani");
			Usuario usuario2 = new Usuario("melba@mindhub.com",contrasenia1,"Melba","Morel","Melbita");
			Usuario usuarioAdmin = new Usuario("admin",contraseniaAdmin,"admin","admin","admin");

			usuarioRepositorio.save(usuario1);
			usuarioRepositorio.save(usuario2);
			usuarioRepositorio.save(usuarioAdmin);





		};
	}

}
