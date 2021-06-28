package com.alkemy.repositorios;

import java.util.List;
import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.alkemy.entidades.Personaje;

public interface PersonajeRepositorio extends JpaRepository<Personaje, Long>{
	
	@Transactional(readOnly = true)
	public Optional<Personaje> findByNombre(String nombre);
	
	@Transactional(readOnly = true)
	public Optional<Personaje> findByEdad(int edad);
//	
//	@Query("from personaje, pelicula where personaje.id = pelicula.id")
//	public Optional<Personaje> findByIdPelicula(long idPelicula);

	
	
}
