package com.misiontic.tucita.Controllers;

import com.misiontic.tucita.Common.ApiResponse;
import com.misiontic.tucita.Dto.LoginRequestDto;
import com.misiontic.tucita.Dto.RegisterRequestDto;
import com.misiontic.tucita.Servicios.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *Controlador inicio de sesion. endpoints: " www.example.com/" (Registro), "www.example.com/login" (login)
 * @author Yelan
 */
@Controller
public class LoginController {
    
    @Autowired
    LoginService login;
    
    @PostMapping("/register")
    public ResponseEntity<ApiResponse> singUp(@RequestBody RegisterRequestDto regist){
        ApiResponse response = login.registAccount(regist);
        
        return ResponseEntity.status(response.getStatus()).body(response);
    }
    
    @PostMapping("/login")
    public ResponseEntity<ApiResponse> logIn(@RequestBody LoginRequestDto log){
        ApiResponse response = login.loginAccount(log);
        
        return ResponseEntity.status(response.getStatus()).body(response);
    }
}
