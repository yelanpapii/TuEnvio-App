package com.misiontic.tucita.Repository;

import com.misiontic.tucita.Models.Tramite;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio de tramites que se comunica con la base datos
 * @author Yelan
 */
@Repository
public interface TramiteRepository extends CrudRepository<Tramite, Long>  {
    
}
