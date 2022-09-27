package com.misiontic.tucita.Common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Implementacion de authentication basica
 * (No se implementara por falta de tiempo)
 * @author Yelan 
 */
@Configuration
public class SecurityConfiguration {

    AuthenticationManager authenticationManager;

    @Autowired
    UserAuthService authService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        AuthenticationManagerBuilder authManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authManagerBuilder.userDetailsService(authService);
        authenticationManager = authManagerBuilder.build();

        http.csrf().disable();
        
        http.authorizeRequests(auth ->{
                auth.antMatchers("/envios/my").authenticated();
        }).authorizeRequests().anyRequest().permitAll().and().authenticationManager(authenticationManager)
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.httpBasic(Customizer.withDefaults());
        
        return http.build();
 
    }
    
    @Bean
    BCryptPasswordEncoder passEncoder(){
        
        return new BCryptPasswordEncoder();
    }

}

