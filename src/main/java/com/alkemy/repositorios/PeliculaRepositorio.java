package com.alkemy.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.alkemy.entidades.Pelicula;

public interface PeliculaRepositorio extends JpaRepository<Pelicula, Long>{
	
	public Pelicula findById(long id);
	
	@Transactional(readOnly = true)
	public Optional<Pelicula> findByTitulo(String titulo);
	
//	@Transactional(readOnly = true)
//	public Optional<Pelicula> findByGenero(long Idgenero);


}
