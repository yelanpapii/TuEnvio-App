package com.misiontic.tucita.Controllers;

import com.misiontic.tucita.Common.ApiResponse;
import com.misiontic.tucita.Dto.EnvioRequestDto;
import com.misiontic.tucita.Models.Servicio;
import com.misiontic.tucita.Models.Usuario;
import com.misiontic.tucita.Servicios.ServicioService;
import com.misiontic.tucita.Servicios.UsuarioService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @Autowired
    UsuarioService userServ;

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

    @PutMapping("/envios")
    public Servicio updateEnvio(@RequestBody Servicio envio) {

        return envioServ.actualizarServicio(envio);
    }

    @DeleteMapping("/envios/{id}")
    public ApiResponse deleteEnvio(@PathVariable("id") Long envioid) {

        ApiResponse response = new ApiResponse();

        envioServ.eliminarServicio(envioid);
        response.setData("Envio Eliminado");

        return response;
    }
}
