package com.misiontic.tucita.Models;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

/**
 * Entidad: Formato de envio del usuario que sera almacenada en la base de
 * datos
 *
 * @author Yelan
 */
@Entity
@Getter
@Setter
@Table(name = "servicio")
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre_servicio")
    private String nombreServicio;
    @Column(name = "duracion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date duracion;
    private Date fechaDeCreacion;
    //Activa, En Proceso, Cancelada, Hecho
    private String estadoSolicitud;
    @Column(name = "costo_servicio")
    private double costoServicio;

    public Servicio() {
    }

    public Servicio(Long id, String nombreServicio, Date duracion, Date fechaDeCreacion,String EstadoSolicitud, double costoServicio) {
        super();
        this.id = id;
        this.nombreServicio = nombreServicio;
        this.duracion = duracion;
        this.fechaDeCreacion = fechaDeCreacion;
        this.estadoSolicitud = EstadoSolicitud;
        this.costoServicio = costoServicio;
    }

    public Servicio(String nombreServicio, Date duracion, Date fechaDeCreacion,String EstadoSolicitud, double costoServicio) {
        super();
        this.nombreServicio = nombreServicio;
        this.duracion = duracion;
        this.fechaDeCreacion = fechaDeCreacion;
        this.estadoSolicitud = EstadoSolicitud;
        this.costoServicio = costoServicio;
    }

}
