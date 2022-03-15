package Mindhub.RaspCash;

import Mindhub.RaspCash.models.*;
import Mindhub.RaspCash.respositories.*;
import Mindhub.RaspCash.servicios.ServicioPrestamo;
import Mindhub.RaspCash.servicios.implementacionesServicios.EmailSenderServiceImplementation;
import Mindhub.RaspCash.utilidades.Utilidades;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

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

 		/*	senderService.senSimpleEmailTo("gelneryus20@gmail.com",
					"Para el registro, usted ha sido registrado con éxito y el mail del usuario",
					"RASPCASH");*/
	}

	@Bean
	public CommandLineRunner initData(UsuarioRepositorio usuarioRepositorio, BilleteraRepositorio billeteraRepositorio,
									  CarritoRepositorio carritoRepositorio, CriptoMonedaRepositorio criptoMonedaRepositorio,
									  PrestamoRespositorio prestamoRespositorio, PrestamoUsuarioRespositorio prestamoUsuarioRespositorio,
									  ProductoRepositorio productoRepositorio, TransaccionRepositorio transaccionRepositorio){

	return (args) -> {

			Utilidades utilidades=new Utilidades();

			String contrasenia1=passwordEncoder.encode("123456");
			String contraseniaAdmin=passwordEncoder.encode("admin");
			Usuario usuarioAdmin = new Usuario("admin",contraseniaAdmin,"admin","admin","admin");
			Usuario usuario1= new Usuario("jmarderwald87@gmail.com",contrasenia1,"Juan Ignacio","Mardewrwald","Juani");
			Usuario usuario2 = new Usuario("melba@mindhub.com",contrasenia1,"Melba","Morel","Melbita");
			Usuario usuario3=new Usuario("ckerps@gmail.com",contrasenia1,"Cristian","Kerps","El Cris");
			usuarioRepositorio.save(usuario1);
			usuarioRepositorio.save(usuario2);
			usuarioRepositorio.save(usuarioAdmin);
			usuarioRepositorio.save(usuario3);

			Billetera billetera1=new Billetera(utilidades.obtenerDireccionBilletera(), 0.5,10000);
			Billetera billetera2=new Billetera(utilidades.obtenerDireccionBilletera(), 0.2,15000);
			Billetera billetera3=new Billetera(utilidades.obtenerDireccionBilletera(), 0,0);
			Billetera billetera4=new Billetera(utilidades.obtenerDireccionBilletera(), 2,20000);

			usuario1.setBilletera(billetera1);
			usuario2.setBilletera(billetera2);
			usuarioAdmin.setBilletera(billetera3);
			usuario3.setBilletera(billetera4);
			billetera1.setUsuario(usuario1);
			billetera2.setUsuario(usuario2);
			billetera3.setUsuario(usuarioAdmin);
			billetera4.setUsuario(usuario3);

			billeteraRepositorio.save(billetera1);
			billeteraRepositorio.save(billetera2);
			billeteraRepositorio.save(billetera3);
			billeteraRepositorio.save(billetera4);

			System.out.println(billetera1.getUsuario().getNombre());
			System.out.println(billetera2.getUsuario().getNombre());
			System.out.println(billetera3.getUsuario().getNombre());

			usuarioRepositorio.save(usuario1);
			usuarioRepositorio.save(usuario2);
			usuarioRepositorio.save(usuarioAdmin);
			usuarioRepositorio.save(usuario3);

		//Creacion de algunas criptomonedas de prueba

			/*CriptoMoneda criptoBTC= new CriptoMoneda(NombreCriptomoneda.BITCOIN,SimboloCriptomoneda.BTC,4255459);
			CriptoMoneda criptoETH= new CriptoMoneda(NombreCriptomoneda.ETHEREUM,SimboloCriptomoneda.ETH,282029);
			CriptoMoneda criptoUSDT = new CriptoMoneda(NombreCriptomoneda.THETER,SimboloCriptomoneda.USDT,108);
			CriptoMoneda criptoBNB= new CriptoMoneda(NombreCriptomoneda.BNB,SimboloCriptomoneda.BNB,41046);
			CriptoMoneda criptoUSDC= new CriptoMoneda(NombreCriptomoneda.USD_COIN,SimboloCriptomoneda.USDC, 108);
			CriptoMoneda criptoXRP = new CriptoMoneda(NombreCriptomoneda.RIPPLE,SimboloCriptomoneda.XRP,86);
			CriptoMoneda criptoTerra=new CriptoMoneda(NombreCriptomoneda.LUNA,SimboloCriptomoneda.TERRA,9715);
			CriptoMoneda criptoADA= new CriptoMoneda(NombreCriptomoneda.CARDANO,SimboloCriptomoneda.ADA,86);
			CriptoMoneda criptoSOL = new CriptoMoneda(NombreCriptomoneda.SOLANA,SimboloCriptomoneda.SOL,8924);
			CriptoMoneda criptoAVAX = new CriptoMoneda(NombreCriptomoneda.AVALANCHE,SimboloCriptomoneda.AVAX,7830);
			criptoMonedaRepositorio.save(criptoBTC);
			criptoMonedaRepositorio.save(criptoETH);
			criptoMonedaRepositorio.save(criptoBNB);
			criptoMonedaRepositorio.save(criptoUSDT);
			criptoMonedaRepositorio.save(criptoUSDC);
			criptoMonedaRepositorio.save(criptoXRP);
			criptoMonedaRepositorio.save(criptoTerra);
			criptoMonedaRepositorio.save(criptoADA);
			criptoMonedaRepositorio.save(criptoSOL);
			criptoMonedaRepositorio.save(criptoAVAX);
			*/

		//Creacion de dos prestamos de prueba

		List<Integer> cuotasTradicional= new ArrayList<>();
		List<Integer> cuotasPersonal= new ArrayList<>();

		cuotasTradicional.add(6);
		cuotasTradicional.add(12);
		cuotasTradicional.add(18);

		cuotasPersonal.add(6);
		cuotasPersonal.add(12);

		Prestamo prestamoTradicional = new Prestamo("Tradicional Bitcoin",0.11,0.3,1,cuotasTradicional);
		Prestamo prestamoTrader=new Prestamo("Trader Bitcoin",0.22,0.6,1.5,cuotasPersonal);

		prestamoRespositorio.save(prestamoTradicional);
		prestamoRespositorio.save(prestamoTrader);

		/*
		PrestamoUsuario prestamoUsuario1=new ClientLoan(400000,60, client1,loanHipotecario);
		ClientLoan clientLoan2=new ClientLoan(50000,12,client1,loanAutomotriz);
		*/

		/*PrestamoUsuario prestamoUsuario1 = new PrestamoUsuario(prestamoTradicional.getMonto(),6,usuario1,prestamoTradicional);
		usuario1.agregarPrestamo(prestamoUsuario1);
		prestamoTradicional.agregarPrestamoUsuario(prestamoUsuario1);

		prestamoUsuarioRespositorio.save(prestamoUsuario1);*/
		/*
		https://i.ibb.co/S6Qd689/funda-notebook.jpg
https://i.ibb.co/NmrcyQ1/libreta2.jpg
https://i.ibb.co/RSv6DSn/mochila-2.jpg
https://i.ibb.co/HnPHnk7/otra-taza1.jpg
https://i.ibb.co/CsXSYK1/remera.jpg
https://i.ibb.co/WG4Gwwf/taza1.jpg
		*/
		    //public Producto(String nombre, int stock,String imagen,double valor,String descripcion,TipoProducto tipo){

			Producto productoFundaNotebook = new Producto("Funda Notebook",100,"https://i.ibb.co/S6Qd689/funda-notebook.jpg",5000,"Funca para notebook ideal para llevar tu notebook a todos lados, practica y comoda",TipoProducto.MERCHANDISING);
			Producto productoLibreta=new Producto("Libreta NFT",1500,"https://i.ibb.co/NmrcyQ1/libreta2.jpg",1500,"Libreta práctica y canchera, para anotar tus ideas mas frescas",TipoProducto.MERCHANDISING);
			Producto productoMochila=new Producto("Mochila NFT",5000,"https://i.ibb.co/RSv6DSn/mochila-2.jpg",10500,"Mochila NFT, diseño unico y exclusivo, amplia para ir con tus cosas a todos lados",TipoProducto.MERCHANDISING);
			Producto productoTaza2=new Producto("Taza NFT - Modelo 2",12000,"https://i.ibb.co/HnPHnk7/otra-taza1.jpg",2350,"Taza termica e irrompible con diseño unico y exclusivo",TipoProducto.MERCHANDISING);
			Producto productoRemera=new Producto("Remera NFT",1000,"https://i.ibb.co/CsXSYK1/remera.jpg",4999,"Destacá entre tus Criptoamigos con esta remera unica en su especie",TipoProducto.MERCHANDISING);
			Producto productoTaza1=new Producto("Taza NFT - Modelo 1",1200,"https://i.ibb.co/WG4Gwwf/taza1.jpg",2350,"Taza termica e irrompible con diseño unico y exclusivo", TipoProducto.MERCHANDISING);

			productoRepositorio.save(productoFundaNotebook);
			productoRepositorio.save(productoLibreta);
			productoRepositorio.save(productoMochila);
			productoRepositorio.save(productoTaza2);
			productoRepositorio.save(productoRemera);
			productoRepositorio.save(productoTaza1);

	};
	}

}
