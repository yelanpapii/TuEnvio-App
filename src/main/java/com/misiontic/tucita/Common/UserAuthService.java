/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.misiontic.tucita.Common;

import com.misiontic.tucita.Models.Usuario;
import com.misiontic.tucita.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


/**
 * Componente para la authentication del usuario
 * (No se implementara por falta de tiempo)
 *  Username = Email
 * @author Yelan
 */
@Service
public class UserAuthService implements UserDetailsService{
    
    @Autowired
    UsuarioRepository repo;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        Usuario inDb = repo.findOneByEmail(username);
        if(inDb == null){
            throw new UsernameNotFoundException("Email de usuario no existe");
        }
        
        return new AppUser((inDb));
    }
}
