package com.misiontic.tucita.Controllers;

import com.misiontic.tucita.Common.ApiResponse;
import com.misiontic.tucita.Dto.TramiteDto;
import com.misiontic.tucita.Models.Tramite;
import com.misiontic.tucita.Servicios.TramiteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador de tramites que se usara en el frontend.
 * @author Yelan
 */
@RestController
public class TramiteController {

    @Autowired
    TramiteService tramite;

    @GetMapping("/tramites")
    private Iterable<Tramite> getTramites() {

        return tramite.mostrarTramites();
    }

    @GetMapping("/tramites/{id}")
    private Tramite getTramiteById(@PathVariable("id") Long tramiteId) {
        
        return tramite.mostrarTramiteById(tramiteId);
    }

    @PostMapping("/tramites")
    private Tramite createTramite(@RequestBody TramiteDto tramit) {

        return tramite.crearTramite(tramit);
    }

    @PutMapping("/tramites")
    private Tramite updateTramite(@RequestBody Tramite newtramit) {

        return tramite.actualizarTramite(newtramit);
    }

    @DeleteMapping("/tramites/{id}")
    private ApiResponse deleteTramite(@PathVariable("id") Long tramiteId) {

        return tramite.eliminarTramite(tramiteId);
    }
}
