package com.misiontic.tucita.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.misiontic.tucita.Common.EnvioEstado;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Entidad: Formato de envio del usuario que sera almacenada en la base de datos
 *
 * @author Yelan
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@ToString
@Table(name = "servicio")
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombreSender;
    private String apellidosSender;
    private String emailSender;
    private String telefonoSender;
    @Column(name = "nombre_servicio")
    private String nombreServicio;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fechaDeCreacion;
    private String direccionEnvio;
    private double largo;
    private double ancho;
    private double altura;
    private double peso;
    //Activa, En Proceso, Cancelada, Hecho
    private String estadoSolicitud = EnvioEstado.ENVIO_ESTADO.ACTIVA;
    //Id de usuario destinatario
    @JsonIgnoreProperties({"contraseña", "nombreUsuario", "apellidoUsuario", "roles"})
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private Usuario usuarioDestinatario;

    public Servicio() {
    }

    public Servicio(String nombreSender, String apellidosSender, String emailSender, String telefonoSender, String nombreServicio, Date fechaDeCreacion, String direccionEnvio, double largo, double ancho, double altura, double peso, Usuario usuario_id) {
        super();
        this.nombreSender = nombreSender;
        this.apellidosSender = apellidosSender;
        this.emailSender = emailSender;
        this.telefonoSender = telefonoSender;
        this.nombreServicio = nombreServicio;
        this.fechaDeCreacion = fechaDeCreacion;
        this.direccionEnvio = direccionEnvio;
        this.largo = largo;
        this.ancho = ancho;
        this.altura = altura;
        this.peso = peso;
        this.usuarioDestinatario = usuario_id;
    }

    public Servicio(String nombreSender, String apellidosSender, String emailSender, String telefonoSender, String nombreServicio, Date fechaDeCreacion, String direccionEnvio, double largo, double ancho, double altura, double peso) {
        super();
        this.nombreSender = nombreSender;
        this.apellidosSender = apellidosSender;
        this.emailSender = emailSender;
        this.telefonoSender = telefonoSender;
        this.nombreServicio = nombreServicio;
        this.fechaDeCreacion = fechaDeCreacion;
        this.direccionEnvio = direccionEnvio;
        this.largo = largo;
        this.ancho = ancho;
        this.altura = altura;
        this.peso = peso;
    }
    
    

}
