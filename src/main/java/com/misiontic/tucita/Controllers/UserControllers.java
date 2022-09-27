package com.misiontic.tucita.Controllers;

import com.misiontic.tucita.Common.ApiResponse;
import com.misiontic.tucita.Dto.RegisterRequestDto;
import com.misiontic.tucita.Dto.UsuarioDto;
import com.misiontic.tucita.Models.Servicio;
import com.misiontic.tucita.Models.Usuario;
import com.misiontic.tucita.Servicios.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador de usuarios (PARA ADMINS)
 *
 * @author Yelan
 */
@RestController
public class UserControllers {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/users")
    public Iterable<Usuario> getUsers() {

        return usuarioService.mostrarUsuarios();
    }

    @GetMapping("/users/{id}")
    public Usuario getUsersById(@PathVariable("id") Long id) {

        return usuarioService.mostrarUsuarioById(id);
    }

    @PostMapping("/users")
    public ApiResponse createUser(@RequestBody RegisterRequestDto user) {

        return usuarioService.crearUsuario(user);
    }

    @GetMapping("/users/recibidos/{id}")
    public Iterable<Servicio> getEnviosByUserId(@PathVariable("id") Long userId) {

        return usuarioService.mostrarServiciosByUserId(userId);
    }

    @PutMapping("/users")
    public ApiResponse updateUser(@RequestBody Usuario user) {

        return usuarioService.actualizarUsuario(user);
    }

    @DeleteMapping("/users/{id}")
    public ApiResponse deleteUser(@PathVariable("id") Long id) {
        ApiResponse response = new ApiResponse();

        usuarioService.eliminarUsuario(id);
        response.setData("Usuario Eliminado");

        return response;
    }

}
