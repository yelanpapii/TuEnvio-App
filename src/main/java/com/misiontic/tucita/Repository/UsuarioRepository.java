/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.misiontic.tucita.Repository;

import com.misiontic.tucita.Models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *Repositorio de todos los usuarios de la base de datos
 * @author Yelan
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
    public Usuario findByEmail(String email);
}
