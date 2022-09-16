package com.misiontic.tucita.Controllers;

import com.misiontic.tucita.Common.ApiResponse;
import com.misiontic.tucita.Dto.EnvioRequestDto;
import com.misiontic.tucita.Models.Servicio;
import com.misiontic.tucita.Servicios.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador de envios. 
 *
 * @author Yelan
 */
@RestController
public class EnvioController {

    @Autowired
    ServicioService envioServ;

    @GetMapping("/envios")
    public Iterable<Servicio> getEnvios() {

        return envioServ.mostrarServicios();
    }

    @GetMapping("/envios/{id}")
    public ResponseEntity<Servicio> getEnvioById(@PathVariable("id") Long envioid) {

        return ResponseEntity.ok(envioServ.mostrarServicioById(envioid));
    }

    @PostMapping("/envios")
    public Servicio createEnvio(@RequestBody EnvioRequestDto envio) {

        return envioServ.crearServicio(envio);
    }
}
