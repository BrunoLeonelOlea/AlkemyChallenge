package com.alkemy.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alkemy.dtos.PeliculaDTO;
import com.alkemy.entidades.Genero;
import com.alkemy.entidades.Pelicula;
import com.alkemy.pojos.PeliculaRequest;
import com.alkemy.repositorios.GeneroRepositorio;
import com.alkemy.repositorios.PeliculaRepositorio;
import com.alkemy.repositorios.PersonajeRepositorio;

@Service
public class PeliculaServicio {

	@Autowired
	private PeliculaRepositorio peliculaRepositorio;

	@Autowired
	private GeneroRepositorio generoRepositorio;

	@Autowired
	private PersonajeRepositorio personajeRepositorio;

	public List<PeliculaDTO> listarPeliculas() throws Exception {
		try {
			List<Pelicula> peliculas = peliculaRepositorio.findAll();
			List<PeliculaDTO> pelisDtos = new ArrayList<>();
			ModelMapper modelMapper = new ModelMapper();
			
			for (Pelicula pelicula : peliculas) {
				pelisDtos.add(modelMapper.map(pelicula, PeliculaDTO.class));
			}
			return pelisDtos;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}

	}

	public Pelicula obtenerPeliculaPorId(long id) throws Exception {
		try {
			return peliculaRepositorio.findById(id);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public Pelicula crearPelicula(PeliculaRequest peliculaRequest) throws Exception {
			try {
				Pelicula pelicula = new Pelicula();
				pelicula.setImagen(peliculaRequest.imagen);
				pelicula.setTitulo(peliculaRequest.titulo);
				pelicula.setFechaDeCreacion(peliculaRequest.fechaDeCreacion);
				pelicula.setCalificacion(peliculaRequest.calificacion);
				pelicula.setGeneros(peliculaRequest.generos
				.stream()
				.map(genero -> {
					Genero genero1 = genero;
					if (genero1.getId() > 0) {
						genero1 = generoRepositorio.findById(genero1.getId());
					}
					genero1.addPeliculas(pelicula);
					return genero1;
				})
				.collect(Collectors.toSet()));
				return peliculaRepositorio.save(pelicula);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public Pelicula editarPelicula(long id, Pelicula Pelicula) throws Exception {
		try {
			Pelicula p1 = peliculaRepositorio.findById(id);
			p1 = peliculaRepositorio.save(Pelicula);
			return p1;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}

	}

	public boolean eliminarPelicula(long id) throws Exception {
		try {
			if (peliculaRepositorio.existsById(id)) {
				peliculaRepositorio.deleteById(id);
				return true;
			} else {
				throw new Exception();
			}

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public Pelicula buscarPeliculaPorTitulo(String titulo) throws Exception {
		try {
			Optional<Pelicula> PeliculaOpcional = peliculaRepositorio.findByTitulo(titulo);
			return PeliculaOpcional.get();

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

//
//	public Pelicula buscarPeliculaPorGenero(long idGenero) throws Exception {
//		try {
//			Optional<Pelicula> PeliculaOpcional = peliculaRepositorio.findByGenero(idGenero);
//			return PeliculaOpcional.get();
//			
//		} catch (Exception e) {
//			throw new Exception(e.getMessage());
//		}
//	}
}
