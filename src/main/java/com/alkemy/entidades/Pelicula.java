package com.alkemy.entidades;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Pelicula {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String imagen;
	
	private String titulo;
	
	private LocalDate fechaDeCreacion;
	
	
	private int calificacion;
	
	@ManyToMany(mappedBy = "peliculas")
	private Set<Personaje> personaje;
	
	@ManyToMany(mappedBy = "peliculas")
	private Set<Genero> generos;
	public Pelicula() {
	}

	public Pelicula(String imagen, String titulo, LocalDate fechaDeCreacion, int calificacion, Set<Personaje> personaje,
			Set<Genero> generos) {
		this.imagen = imagen;
		this.titulo = titulo;
		this.fechaDeCreacion = fechaDeCreacion;
		this.calificacion = calificacion;
		this.personaje = personaje;
		this.generos = generos;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public LocalDate getFechaDeCreacion() {
		return fechaDeCreacion;
	}

	public void setFechaDeCreacion(LocalDate fechaDeCreacion) {
		this.fechaDeCreacion = fechaDeCreacion;
	}

	public int getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}

	public Set<Personaje> getPersonaje() {
		return personaje;
	}

	public void setPersonaje(Set<Personaje> personaje) {
		this.personaje = personaje;
	}

	public Set<Genero> getGeneros() {
		return generos;
	}

	public void setGeneros(Set<Genero> generos) {
		this.generos = generos;
	}
	
	
	
}
