package com.misiontic.tucita.Models;


import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;

/**
 * Modelo de usuario que sera almacenado en la base de datos
 * @author Yelan
 */
@Entity
@Getter
@Setter
@Table(name = "usuario", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Usuario {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUSUARIO;
    @Column(name = "nombre_usuario")
    private String nombreUsuario;
    @Column(name = "email")
    private String email;
    @Column(name = "apellido_usuario")
    private String apellidoUsuario;
    private String contraseña;
    
    //RELACION MUCHOS A MUCHOS PARA SABER CUANTOS SOLICITUDES DE SERVICIO TIENE CADA USUARIO
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable( 
            name = "usuario_servicio",
            joinColumns = @JoinColumn(name = "id_usuario", referencedColumnName = "idUsuario"),
            inverseJoinColumns = @JoinColumn(name = "id_servicio", referencedColumnName = "id"))
    private Collection<Servicio> servicios;


    public Usuario() {
    }
    
    public Usuario(String nombreUsuario, String email, String apellidoUsuario, String contraseña, Collection<Servicio> servicio) {
        super();
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.apellidoUsuario = apellidoUsuario;
        this.contraseña = contraseña;
        this.servicios = servicio;
    }

    public Usuario(Integer idUSUARIO, String nombreUsuario, String apellidoUsuario, String email, String pass, Collection<Servicio> servicio) {
        super();
        this.idUSUARIO = idUSUARIO;
        this.nombreUsuario = nombreUsuario;
        this.apellidoUsuario = apellidoUsuario;
        this.email = email;
        this.contraseña = pass;
        this.servicios = servicio;
    }

    
    
}
