package com.misiontic.tucita.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * Rol del usuario en el sistema
 *
 * @author Yelan
 */
@Entity
@Getter
@Setter
@Table(name = "rol")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    public Rol(Integer id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public Rol(String name) {
        this.name = name;
    }

    public Rol() {
    }

}
