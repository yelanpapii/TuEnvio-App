package com.misiontic.tucita.Repository;

import com.misiontic.tucita.Models.Servicio;
import com.misiontic.tucita.Models.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio de envios
 * @author Yelan
 */

@Repository
public interface ServicioRepository extends CrudRepository<Servicio, Long>{
    public List<Servicio> findAllByUsuarioDestinatario(Long id);
}
