package com.alkemy.entidades;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Genero {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String nombre;

	private String imagen;

	@ManyToMany(mappedBy = "generos", fetch = FetchType.EAGER)
	@JsonIgnore
	private Set<Pelicula> peliculas;

	public Genero() {
	}

	public Genero(String nombre, String imagen, Set<Pelicula> peliculas) {
		this.nombre = nombre;
		this.imagen = imagen;
		this.peliculas = peliculas;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public Set<Pelicula> getPeliculas() {
		return peliculas;
	}

	public void setPeliculas(Set<Pelicula> peliculas) {
		this.peliculas = peliculas;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public void addPeliculas(Pelicula pelicula) {
		this.peliculas.add(pelicula);
	}

}
