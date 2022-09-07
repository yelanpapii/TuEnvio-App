package com.misiontic.tucita.Dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Dto de tramites del usuario;
 * @author  Yelan
 **/

@Getter
@Setter
public class TramiteDto {
    
    private Long id;
    private String name;
    private String description;

}
