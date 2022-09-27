package com.misiontic.tucita.Validator;

import com.misiontic.tucita.Dto.EnvioRequestDto;
import com.misiontic.tucita.Repository.UsuarioRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Checkeo de errores al crear un envio.
 * TODO: Añadir mas posibles errores al crear un envio
 * @author Yelan
 */
@Component
public class EnvioValidator {
    
    @Autowired
    UsuarioRepository repo;

    public List<Error> createEnvioValidator(EnvioRequestDto envio) {

        List<Error> errors = new ArrayList<>();

        //ERROR 1: SI NO SE ENCUENTRA USUARIO DESTINATARIO
        if (!repo.existsByEmail(envio.getEmailDestinatario())) {
            Error error = new Error("Usuario Destinatario no encontrado");
            errors.add(0, error);
        }
        
        /*
        if(!repo.existsByEmail(envio.getEmail())){
            
            Error error = new Error("Usuario no existe");
            errors.add(1, error);
            
        }
        */
        
        return errors;
    }
}
