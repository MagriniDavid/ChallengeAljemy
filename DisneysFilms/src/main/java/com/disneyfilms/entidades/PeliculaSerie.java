package com.disneyfilms.entidades;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Peliculas/Series")
public class PeliculaSerie implements Serializable {

     @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
     @OneToOne
    private Imagen imagen;
    private String titulo;

    private int clasificacion;
    
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDate fechaCreacion;

    private boolean eliminar = Boolean.FALSE;
    @OneToMany
    private Personaje personajes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(int clasificacion) {
        this.clasificacion = clasificacion;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public boolean isEliminar() {
        return eliminar;
    }

    public void setEliminar(boolean eliminar) {
        this.eliminar = eliminar;
    }

    public Personaje getPersonajes() {
        return personajes;
    }

    public void setPersonajes(Personaje personajes) {
        this.personajes = personajes;
    }

    public void setImagen(Imagen imagen) {
        this.imagen = imagen;
    }

    
}