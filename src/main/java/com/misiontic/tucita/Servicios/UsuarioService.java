package com.misiontic.tucita.Servicios;

import com.misiontic.tucita.Dto.UsuarioDto;
import com.misiontic.tucita.Models.Servicio;
import com.misiontic.tucita.Models.Usuario;
import com.misiontic.tucita.Repository.ServicioRepository;
import com.misiontic.tucita.Repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Servicio de usuarios para admins
 * @author Yelan
 */
@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository repo;
    
    @Autowired
    ServicioRepository envioRepo;
    
    public List<Usuario> mostrarUsuarios(){
        
        return repo.findAll();
    }
    
    public Usuario mostrarUsuarioById(Long id){
        
        return repo.findById(id).get();
    }
    
    public Usuario crearUsuario(UsuarioDto user){
        
        Usuario nuevoUser = new Usuario();

        nuevoUser.setNombreUsuario(user.getNombreUsuario());
        nuevoUser.setApellidoUsuario(user.getApellidoUsuario());
        nuevoUser.setEmail(user.getEmail());
        nuevoUser.setContraseña(user.getContraseña());
        nuevoUser.setRoles(user.getRoles());

        repo.save(nuevoUser);

        return nuevoUser;
    }
    public Usuario mostrarUsuarioByEmail(String email){
        
        return repo.findOneByEmail(email);
    }
    
    public Iterable<Servicio> mostrarServiciosByUserId(Long id){
       
        return envioRepo.findAllByUsuarioDestinatario(id);
    }
    
}
