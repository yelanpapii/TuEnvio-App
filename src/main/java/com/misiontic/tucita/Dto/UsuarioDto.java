/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.misiontic.tucita.Dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Dto con el que podran ser creado nuevos usuario.
 * @author Yelan
 */
@Getter
@Setter
public class UsuarioDto {
    
    private String nombreUsuario;
    private String email;
    private String apellidoUsuario;
    private String contraseña;
    
}
