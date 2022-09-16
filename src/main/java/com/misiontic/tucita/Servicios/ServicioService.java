package com.misiontic.tucita.Servicios;

import com.misiontic.tucita.Common.ApiResponse;
import com.misiontic.tucita.Dto.EnvioRequestDto;
import com.misiontic.tucita.Models.Servicio;
import com.misiontic.tucita.Models.Usuario;
import com.misiontic.tucita.Repository.ServicioRepository;
import com.misiontic.tucita.Repository.UsuarioRepository;
import com.misiontic.tucita.Validator.EnvioValidator;
import java.util.Calendar;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Servicio de envios
 *
 * @author Yelan
 */
@Service
public class ServicioService {

    Calendar cale = Calendar.getInstance();
    @Autowired
    ServicioRepository repoEnvio;

    @Autowired
    UsuarioRepository repoUser;

    @Autowired
    EnvioValidator validator;

    public Iterable<Servicio> mostrarServicios() {

        return repoEnvio.findAll();

    }

    public Servicio mostrarServicioById(Long id) {

        return repoEnvio.findById(id).get();

    }

    public Servicio crearServicio(EnvioRequestDto envio) {

        List<Error> errors = validator.createEnvioValidator(envio);

        //validacion de errores en el envio
        if (errors.size() > 0) {
            throw new Error("Usuario destinatario no existe");
        }

        //Trae al usuario destinatario mediante su email
        Usuario current = repoUser.findOneByEmail(envio.getEmailDestinatario());

        //CREACION DE NUEVO ENVIO
        Servicio nuevoEnvio = new Servicio();

        nuevoEnvio.setNombreSender(envio.getNombre());
        nuevoEnvio.setApellidosSender(envio.getApellidos());
        nuevoEnvio.setEmailSender(envio.getEmail());
        nuevoEnvio.setTelefonoSender(envio.getTelefono());
        nuevoEnvio.setNombreServicio(envio.getNombreEnvio());
        nuevoEnvio.setFechaDeCreacion(cale.getTime());
        nuevoEnvio.setDireccionEnvio(envio.getDireccionEnvio());
        nuevoEnvio.setLargo(envio.getLargo());
        nuevoEnvio.setAncho(envio.getAncho());
        nuevoEnvio.setAltura(envio.getAltura());
        nuevoEnvio.setPeso(envio.getPeso());
        nuevoEnvio.setUsuarioDestinatario(current);

        repoEnvio.save(nuevoEnvio);

        return nuevoEnvio;

    }

}
