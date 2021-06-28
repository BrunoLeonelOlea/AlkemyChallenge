package com.alkemy.pojos;

import java.time.LocalDate;
import java.util.Set;

import com.alkemy.entidades.Genero;
import com.alkemy.entidades.Personaje;

public class PeliculaRequest {
	
	public long id;
	
	public String imagen;
	
	public String titulo;
	
	public LocalDate fechaDeCreacion;
	
	public int calificacion;
	
//	public Set<Personaje> personajes;
	
	public Set<Genero> generos;
}
