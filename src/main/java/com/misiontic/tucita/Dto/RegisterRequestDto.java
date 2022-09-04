package com.misiontic.tucita.Dto;

import lombok.Getter;
import lombok.Setter;

/**
 *Datos que seran solicitados al usuario al registrarse.
 * @author Yelan
 */

@Getter
@Setter
public class RegisterRequestDto {

    private String nombreUsuario;
    private String email;
    private String apellidoUsuario;
    private String contraseña;
    
}
