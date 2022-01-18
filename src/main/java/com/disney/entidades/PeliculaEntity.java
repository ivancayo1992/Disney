package com.disney.entidades;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class PeliculaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String imagen;
    private String titulo;
    @Column(name="fecha_creacion")
    @DateTimeFormat(pattern ="yyyy/MM/dd")
    private LocalDate fechaCreacion;
    private Integer calificacion;

    @ManyToOne(fetch = FetchType.EAGER,cascade =CascadeType.ALL)
    @JoinColumn(name = "genero_id",insertable = false,updatable = false)
    private GeneroEntity genero; //Decidi ponerlo acá la relacion y no en la clase genero,¿No hay problema?
    @Column(name = "genero_id",nullable = false)
    private String generoid;

    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(name="personaje_pelicula",
            joinColumns = @JoinColumn(name="Pelicula_id"),
            inverseJoinColumns = @JoinColumn(name="personaje_id")
    )
    private Set<PersonajeEntity> personajes=new HashSet<>();


}
