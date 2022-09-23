package com.misiontic.tucita.Controllers;

import com.misiontic.tucita.Models.Servicio;
import com.misiontic.tucita.Servicios.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador de usuarios (En trabajo)
 * 
 * @author Yelan
 */

@RestController
public class UserControllers {

    @Autowired
    UsuarioService usuarioService;
    
    @GetMapping("/users/recibidos")
    public Iterable<Servicio> getEnviosByUserId(Long userId) {
        
        //TODO: Retornar todos los envios del usuario logeado;
        return usuarioService.mostrarServiciosByUserId(userId); //envioServ.mostrarServiciosByUserId(idUser);
    }

    
}
