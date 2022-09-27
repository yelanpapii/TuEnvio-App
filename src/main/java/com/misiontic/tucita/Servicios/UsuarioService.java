package com.misiontic.tucita.Servicios;

import com.misiontic.tucita.Common.ApiResponse;
import com.misiontic.tucita.Dto.RegisterRequestDto;
import com.misiontic.tucita.Dto.UsuarioDto;
import com.misiontic.tucita.Models.Rol;
import com.misiontic.tucita.Models.Servicio;
import com.misiontic.tucita.Models.Usuario;
import com.misiontic.tucita.Repository.ServicioRepository;
import com.misiontic.tucita.Repository.UsuarioRepository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

/**
 * Servicio de usuarios para admins
 *
 * @author Yelan
 */
@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository repo;

    @Autowired
    ServicioRepository envioRepo;

    @Autowired
    LoginService loginService;

    public List<Usuario> mostrarUsuarios() {

        return repo.findAll();
    }

    public Usuario mostrarUsuarioById(Long id) {

        return repo.findById(id).get();
    }

    public ApiResponse crearUsuario(RegisterRequestDto user) {

        return loginService.registAccount(user);
    }

    public Usuario mostrarUsuarioByEmail(String email) {

        return repo.findOneByEmail(email);
    }

    public Iterable<Servicio> mostrarServiciosByUserId(Long id) {

        Iterable<Servicio> allEnviosList = envioRepo.findAll();
        Usuario user = repo.findById(id).get();

        List<Servicio> enviosByUser = new ArrayList<>();
        for (Servicio envio : allEnviosList) {

            if (envio.getUsuarioDestinatario().getId() == user.getId()) {

                enviosByUser.add(envio);

            }
        }
        return enviosByUser;
    }

    public ApiResponse actualizarUsuario(Usuario user) {
        ApiResponse response = new ApiResponse();

        /*//Si el usuario al actualizar contiene el rol de admin poner el id correspondiente al rol admin
        if(user.getRoles().stream().anyMatch(arr -> arr.getName() == "ROLE_ADMIN")){
            
            user.getRoles().forEach(act -> act.setId(2));
        }*/
        repo.save(user);
        response.setData("Usuario Actualizado");

        return response;
    }

    public void eliminarUsuario(Long id) {

        repo.deleteById(id);
    }

}
