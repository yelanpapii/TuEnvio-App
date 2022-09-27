package com.misiontic.tucita.Models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

/**
 *Tabla para saber cuantos envios tiene cada usuario.
 * @author Yelan
 */
@Entity
@Getter
@Setter
public class UsuarioEnvio {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Long id;
    
    @ManyToOne( fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn( name = "servicio_id", referencedColumnName = "id", nullable = false)
    private Servicio servicio;
    
    @ManyToOne( fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn( name = "usuario_id", referencedColumnName =  "id", nullable = false)
    private Usuario usuario;
    
}
