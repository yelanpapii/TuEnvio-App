package com.misiontic.tucita.Repository;

import com.misiontic.tucita.Models.UsuarioEnvio;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *Repositorio de cada envio por usuario.
 * @author Yelan
 */
@Repository
public interface UsuarioEnviosRepo extends CrudRepository<UsuarioEnvio, Long> {
    List<UsuarioEnvio> findAllByUsuarioId(Long id);
}
