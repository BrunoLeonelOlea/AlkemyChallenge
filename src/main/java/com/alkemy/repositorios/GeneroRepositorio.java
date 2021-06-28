package com.alkemy.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alkemy.entidades.Genero;

public interface GeneroRepositorio extends JpaRepository<Genero, Long>{
	
	public Genero findById(long id);

}
