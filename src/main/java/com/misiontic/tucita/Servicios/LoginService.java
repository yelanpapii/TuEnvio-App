package com.misiontic.tucita.Servicios;

import com.misiontic.tucita.Common.ApiResponse;
import com.misiontic.tucita.Dto.LoginRequestDto;
import com.misiontic.tucita.Dto.RegisterRequestDto;
import com.misiontic.tucita.Models.Rol;
import com.misiontic.tucita.Models.Usuario;
import com.misiontic.tucita.Repository.UsuarioRepository;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
        Usuario nuevo = new Usuario(user.getNombreUsuario(),
                user.getApellidoUsuario(),
                user.getEmail(),
                user.getContraseña(),
                Arrays.asList(new Rol("ROLE_USER")));
        
        //Validacion de usuario
        if (user.getContraseña().length() < 4 || user.getEmail().isBlank() || user.getEmail().length() < 4) {
            
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            response.setData("Contraseña o Email muy corto");

            return response;
        }
        
        if(repo.existsByEmail(user.getEmail())){
            
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            response.setData("Este correo ya esta en uso");
            
            return response;
        }

        //Guarda usuario en la base de datos
        repo.save(nuevo);

        response.setData("Usuario Registrado");

        return response;
    }

    public ApiResponse loginAccount(LoginRequestDto user) {

        ApiResponse response = new ApiResponse();

        Usuario usuario = repo.findOneByEmailAndContraseña(user.getEmail(), user.getContraseña());

        if (usuario == null) {
            
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            response.setData("Usuario no encontrado");

            return response;
        }

        response.setData("Usuario Logeado");

        return response;
    }
}
