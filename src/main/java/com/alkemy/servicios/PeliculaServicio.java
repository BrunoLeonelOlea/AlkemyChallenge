package com.alkemy.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alkemy.repositorios.PeliculaRepositorio;

@Service
public class PeliculaServicio {
	
	@Autowired
	private PeliculaRepositorio peliculaRepositorio;
//	
//	public List<Pelicula> listarPeliculas(){
//		
//	}

}
