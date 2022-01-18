package com.disney.entidades;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class GeneroEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private  String nombre;
    private String imagen;
    //La relacion de genero-pelicula decidi ponerla en pelicula
}
