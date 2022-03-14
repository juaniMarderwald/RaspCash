package Mindhub.RaspCash.controllers;

import Mindhub.RaspCash.dtos.PrestamoDTO;
import Mindhub.RaspCash.models.*;
import Mindhub.RaspCash.respositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class PrestamoController {

    @RestController
    @RequestMapping("/api")
    public class LoanController {
        @Autowired
        PrestamoRespositorio prestamoRespositorio;
        @Autowired
        UsuarioRepositorio usuarioRepositorio;
        @Autowired
        BilleteraRepositorio billeteraRepositorio;
        @Autowired
        TransaccionRepositorio transaccionRepositorio;
        @Autowired
        PrestamoUsuarioRespositorio prestamoUsuarioRespositorio;

        @RequestMapping(path = "/prestramos", method = RequestMethod.GET)
        public List<PrestamoDTO> obtenerPrestamoUsuarioDTO() {
            return prestamoRespositorio.findAll().stream().map(prestamo>new PrestamoDTO(prestamo)).collect(Collectors.toList());
        }


        @Transactional
        @RequestMapping(value="/loans",method = RequestMethod.POST)
        public <PrestamoUsuarioDTO> ResponseEntity<String> nuevoPrestamo(@RequestBody PrestamoUsuarioDTO prestamoUsuarioDTO, Authentication authentication) {

           Usuario usuario = usuarioRepositorio.findByEmail(authentication.getName());
            Prestamo prestamo = PrestamoRespositorio.findByName(prestamoUsuarioDTO.getNombre());
            Billetera billetera = BilleteraRepositorio.findByNumber(prestamoUsuarioDTO.getDireccion());

          Billetera accountOrigin=BilleteraRepositorio.findByNumber(Billetera.getDireccion());
          Billetera accountDestiny=BilleteraRepositorio.findByNumber(Billetera.getDireccion());

            if (PrestamoUsuarioDTO == null) {
                return new ResponseEntity<>("NO SE ENCUENTRA LOS DATOS", HttpStatus.FORBIDDEN);
            }

            //verifico que los datos no esten vacios
            if (PrestamoUsuarioDTO.getMonto()== 0 ||PrestamoUsuarioDTO().isEmpty() || PrestamoUsuarioDTO.getInteres()==0  {
                return new ResponseEntity<>("LOS DATOS NO SON CORRECTOS", HttpStatus.FORBIDDEN);
            }



            if(Billetera== null){
                return new ResponseEntity<>("LA CUENTA A SOLICITAR NO EXISTE ",HttpStatus.FORBIDDEN);

            }

            if (!Usuario.getBilletera().contains(billetera)){
                return new ResponseEntity<>("NO SE PUDO AUTENTICAR LAS CUENTAS",HttpStatus.FORBIDDEN);

            }
            if (Prestamo==null){
                return new ResponseEntity<>("NO SE PUDO VERIFICAR EL PRESTAMO",HttpStatus.FORBIDDEN);
            }

            if (PrestamoUsuarioDTO.getMonto()>Prestamo.getMontoMaximo() || PrestamoUsuarioDTO.getMonto() <=0){
                return new ResponseEntity<>("EXCEDE EN EL MONTO MAXIMO DISPONIBLE O EL MONTO ES NEGATIVO ",HttpStatus.FORBIDDEN);
            }

            if (!Prestamo.getPayments().contains(PrestamoUsuarioDTO.getInteres())){
                return new ResponseEntity<>("403 ERROR ",HttpStatus.FORBIDDEN);
            }



           PrestamoUsuario prestamoUsuario=new    PrestamoUsuario(prestamoUsuarioDTO.getMonto(),prestamoUsuarioDTO.getInteres(),Usuario,Prestamo);
           Transaccion transaccionCredito=new  Transaccion (TipoDeTransaccion.CREDITO, prestamoUsuarioDTO.getMonto(),Prestamo.getNombre(),Billetera);

            transactionRepository.save(transactionsLoanCredit);
            clientLoansRepository.save(clientLoans);

//descuento de las cuentas

            Double auxOrigin= PrestamoUsuarioDTO.getMonto()- Billetera.;
            Double auxDestiny=PrestamoUsuarioDTO.getMonto()+ Billetera.;

//actualizo los montos

            accountOrigin.setMonto(auxOrigin);
            accountDestiny.setmonto(auxDestiny);

            return new ResponseEntity<>("SE APLICADO EL PRESTAMO",HttpStatus.CREATED);
        }
}
