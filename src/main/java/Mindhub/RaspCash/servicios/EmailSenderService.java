package Mindhub.RaspCash.servicios;

import org.springframework.stereotype.Service;

@Service
public interface EmailSenderService {
    public void sendSimpleEmailTo(String ReceptorEmail, String  MensajeAenviar, String tema);
}
