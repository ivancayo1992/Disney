package com.disney.entidades;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
public class PersonajeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private  String imagen;
    private  String nombre;
    private Integer edad;
    private Float peso;
    private String historia;
@ManyToMany(mappedBy = "personajes",cascade = CascadeType.ALL)
    private List<PeliculaEntity> peliculas=new ArrayList<>();
}
