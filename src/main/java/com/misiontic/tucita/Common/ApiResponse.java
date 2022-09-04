package com.misiontic.tucita.Common;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

/**
 *Mensaje y estado que retornara la api 
 * @author Yelan
 */

@Getter
@Setter
public class ApiResponse {
    
    private Integer status;
    private Object data;
    private Object error;

    public ApiResponse() {
        this.status = HttpStatus.OK.value();
        this.data = data;
        this.error = error;
    }
    
    
}
