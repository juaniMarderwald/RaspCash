package Mindhub.RaspCash.servicios.implementacionesServicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {
    @Autowired
    private JavaMailSender mailSender;
    public void senSimpleEmailTo(String ReceptorEmail,
                                String  MensajeAenviar,
                                String tema){

        SimpleMailMessage message= new SimpleMailMessage();

        message.setFrom("RaspCashCrypto@gmail.com");
        message.setTo(ReceptorEmail);
        message.setText(MensajeAenviar);
        message.setSubject(tema);

        mailSender.send(message);
        System.out.println("Email enviado ...");

    }
}
