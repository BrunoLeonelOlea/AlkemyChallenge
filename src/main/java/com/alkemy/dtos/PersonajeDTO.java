package com.alkemy.dtos;

import com.alkemy.entidades.Personaje;

public class PersonajeDTO {
	
	private String imagen;
	private String nombre;
	
	public PersonajeDTO() {
		
	}
	
	public PersonajeDTO(Personaje personaje){
		this.imagen = personaje.getImagen();
		this.nombre = personaje.getNombre();
	}


	public String getImagen() {
		return imagen;
	}


	public void setImagen(String imagen) {
		this.imagen = imagen;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
