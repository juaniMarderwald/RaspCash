package Mindhub.RaspCash.servicios;

import Mindhub.RaspCash.servicios.implementacionesServicios.EmailSenderServiceImplementation;
import org.springframework.stereotype.Service;

@Service
public interface EmailSenderService {
    public void senSimpleEmailTo(String ReceptorEmail, String  MensajeAenviar, String tema);
}
