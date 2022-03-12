package Mindhub.RaspCash.servicios.implementacionesServicios;

import Mindhub.RaspCash.servicios.ServicioUsuario;
import Mindhub.RaspCash.dtos.UsuarioDTO;
import Mindhub.RaspCash.models.Usuario;
import Mindhub.RaspCash.respositories.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ImplementacionServicioUsuario implements ServicioUsuario {

	@Autowired
	private PasswordEncoder passwordEncoder;
	   
    @Autowired
    UsuarioRepositorio usuarioRepositorio;

    @Override
    public List<UsuarioDTO> obtenerUsuarios() {
        return usuarioRepositorio.findAll().stream().map(UsuarioDTO::new).collect(Collectors.toList());
    }

	@Override
	public ResponseEntity<Object> registro(String nombre, String apellido, String apodo, String correo, String password) {
		 if (correo.isEmpty() || nombre.isEmpty() || apellido.isEmpty() || password.isEmpty() || apodo.isEmpty()) {
	            return new ResponseEntity<>("Complete los datos solicitados", HttpStatus.FORBIDDEN);
	        }
	        if (usuarioRepositorio.findByEmail(correo) != null) {
	            return new ResponseEntity<>("Correo ya registrado", HttpStatus.FORBIDDEN);
	        }

	        if (password.length() < 8){
	            return new ResponseEntity<>("La contraseña no puede tener menos de 8 caracteres", HttpStatus.FORBIDDEN);
	        }

	        if (!correo.contains("@") && !correo.contains(".")) {
	            return new ResponseEntity<>("Ingrese una dirección de correo valida", HttpStatus.FORBIDDEN);
	        }

	        for(int i = 0; i < nombre.length(); i++){
	            char c = nombre.charAt(i);
	            if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == ' ')) {
	                return new ResponseEntity<>("El nombre no puede tener números, ni caracteres especiales", HttpStatus.FORBIDDEN);
	            }
	        }
	        for(int i = 0; i < apellido.length(); i++){
	            char c = apellido.charAt(i);
	            if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == ' ')) {
	                return new ResponseEntity<>("El apellido no puede tener números, ni caracteres especiales", HttpStatus.FORBIDDEN);
	            }
	        }

			usuarioRepositorio.save(new Usuario(correo, passwordEncoder.encode(password), nombre, apellido, apodo));

			return new ResponseEntity<>("Registro finalizado", HttpStatus.CREATED);
	}
    
    public UsuarioDTO obtenerUsuarioPorId(long id) throws Exception {
    	
    	Usuario usuario = usuarioRepositorio.buscarPorId(id);
    	
    	if(usuario == null) 
    		throw new Exception("El usuario no fue encontrado.");
    		
    	return new UsuarioDTO(usuario);
    };
}
