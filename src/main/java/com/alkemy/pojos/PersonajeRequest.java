package com.alkemy.pojos;

import java.util.Set;

import com.alkemy.entidades.Pelicula;

public class PersonajeRequest {
	
	public long id;
	
	public String imagen;	
	
	public String nombre;
	
	public int edad;
	
	public int peso;
	
	public String historia;
	
	public Set<Pelicula> peliculas;

}
