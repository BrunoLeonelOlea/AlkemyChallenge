package com.alkemy.dtos;

import java.time.LocalDate;

import com.alkemy.entidades.Pelicula;

public class PeliculaDTO {
	
	private String imagen;
	private String titulo;
	private LocalDate fechaDeCreacion;
	
	public PeliculaDTO(Pelicula pelicula) {
		this.imagen = pelicula.getImagen();
		this.titulo = pelicula.getTitulo();
		this.fechaDeCreacion = pelicula.getFechaDeCreacion();
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
	
	
}
