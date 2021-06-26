package com.alkemy.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alkemy.entidades.Genero;

public interface PeliculaRepositorio extends JpaRepository<Genero, Long>{

}
