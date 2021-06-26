package com.alkemy.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alkemy.entidades.Personaje;

public interface PersonajeRepositorio extends JpaRepository<Personaje, Long>{
	
	public Optional<Personaje> findByNombre(String nombre);
	
	
	
}
