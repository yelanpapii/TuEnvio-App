package com.misiontic.tucita.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 * Tramite que podra realizar el usuario
 * @author Yelan
 */
@Entity
@Getter
@Setter
public class Tramite {
    
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    

    public Tramite(Long id, String name, String desc) {
        super();
        this.id = id;
        this.name = name;
        this.description = desc;
    }

    public Tramite(String name, String desc) {
        super();
        this.name = name;
        this.description = desc;
    }

    public Tramite() {
    }
    
    
}
