package com.misiontic.tucita.Repository;

import com.misiontic.tucita.Models.Servicio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio de envios
 * @author Yefferson
 */

@Repository
public interface ServicioRepository extends CrudRepository<Servicio, Long>{
    
}
