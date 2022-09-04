package com.misiontic.tucita.Dto;

import lombok.Getter;
import lombok.Setter;

/**
 *Datos que seran solicitados al iniciar sesion.
 * @author Yelan
 */
@Getter
@Setter
public class LoginRequestDto {

    private String email;
    private String contraseña;
}
