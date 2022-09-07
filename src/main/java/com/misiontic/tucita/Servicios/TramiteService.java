package com.misiontic.tucita.Servicios;

import com.misiontic.tucita.Common.ApiResponse;
import com.misiontic.tucita.Dto.TramiteDto;
import com.misiontic.tucita.Models.Tramite;
import com.misiontic.tucita.Repository.TramiteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * Servicio de tramites
 *
 * @author Yelan
 */
@Service
@Slf4j
public class TramiteService {

    @Autowired
    TramiteRepository repo;

    public Tramite crearTramite(TramiteDto tramite) {

        Tramite nuevo = new Tramite(tramite.getName(), tramite.getDescription());
        log.info("Nuevo tramite creado");
        return repo.save(nuevo);
    }

    public Iterable<Tramite> mostrarTramites() {

        log.info("Mostrando todos los tramites");
        return repo.findAll();
    }
    
    public Tramite actualizarTramite(Tramite tramite) {
        
        log.info("Tramite actualizado.");
        return repo.save(tramite);
    }

    public Tramite mostrarTramiteById(Long id) {
       
        log.info("Mostrando un tramite.");
        return  repo.findById(id).get();
    }

    public ApiResponse eliminarTramite(Long id) {
        ApiResponse response = new ApiResponse();

        repo.deleteById(id);
        log.info("Tramite eliminado correctamente.");
        response.setData("Tramite eliminado correctamente.");

        return response;
    }
}
