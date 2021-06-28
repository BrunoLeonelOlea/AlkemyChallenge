package com.alkemy.entidades;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Pelicula {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String imagen;

	private String titulo;

	@JsonFormat(pattern = "yyyy-MM-dd", shape = Shape.STRING)
	private LocalDate fechaDeCreacion;

	private int calificacion;

	@ManyToMany(mappedBy = "peliculas", fetch = FetchType.EAGER)
	@JsonIgnore
	private Set<Personaje> personajes = new HashSet<>();

	@ManyToMany( fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinTable(name = "pelicula_generos",
	joinColumns = @JoinColumn(name = "pelicula_id"),
	inverseJoinColumns = @JoinColumn(name = "genero_id"))
	@JsonIgnore
	private Set<Genero> generos;

	public Pelicula() {
	}

	public Pelicula(String imagen, String titulo, LocalDate fechaDeCreacion, int calificacion, Set<Personaje> personaje,
			Set<Genero> generos) {
		this.imagen = imagen;
		this.titulo = titulo;
		this.fechaDeCreacion = fechaDeCreacion;
		this.calificacion = calificacion;
		this.personajes = personaje;
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
		return personajes;
	}

	public void setPersonaje(Set<Personaje> personaje) {
		this.personajes = personaje;
	}
	

	public Set<Genero> getGeneros() {
		return generos;
	}

	public void setGeneros(Set<Genero> generos) {
		this.generos = generos;
	}

	public void addPersonaje(Personaje personaje) {
		this.personajes.add(personaje);
	}

}
