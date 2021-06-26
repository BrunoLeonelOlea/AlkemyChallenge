package com.alkemy.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alkemy.entidades.Genero;

@Repository
public interface GeneroRepositorio extends JpaRepository<Genero, Long>{

}
