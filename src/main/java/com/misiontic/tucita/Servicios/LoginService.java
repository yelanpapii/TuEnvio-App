package com.misiontic.tucita.Servicios;

import com.misiontic.tucita.Common.ApiResponse;
import com.misiontic.tucita.Dto.LoginRequestDto;
import com.misiontic.tucita.Dto.RegisterRequestDto;
import com.misiontic.tucita.Models.Usuario;
import com.misiontic.tucita.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

/**
 *
 * @author Yelan solicita: registroDto, LoginDto return: guarda el usuario o
 * inicia sesion.
 */
@Service
public class LoginService {

    @Autowired
    UsuarioRepository repo;

    public ApiResponse registAccount(RegisterRequestDto user) {
        ApiResponse response = new ApiResponse();

        //Validacion de usuario
        if (user.getContraseña().length() < 4 || user.getEmail().isBlank() || user.getEmail().length() < 4) {

            response.setData("Contraseña o Email muy corto");

            return response;
        }
        //Crea nuevo modelo del usuario
        Usuario nuevo = new Usuario();
        nuevo.setNombreUsuario(user.getNombreUsuario());
        nuevo.setApellidoUsuario(user.getApellidoUsuario());
        nuevo.setEmail(user.getEmail());
        nuevo.setContraseña(user.getContraseña());

        //Guarda usuario en la base de datos
        repo.save(nuevo);

        response.setData("Usuario Registrado");

        return response;
    }

    public ApiResponse loginAccount(LoginRequestDto user) {

        ApiResponse response = new ApiResponse();

        Usuario usuario = repo.findByEmail(user.getEmail());

        if (usuario == null) {

            response.setData("Usuario no encontrado");

            return response;
        }

        response.setData("Usuario Logeado");

        return response;
    }
}
