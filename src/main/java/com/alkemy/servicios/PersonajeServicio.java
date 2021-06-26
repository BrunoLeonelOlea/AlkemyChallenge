package com.alkemy.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alkemy.dtos.PersonajeDTO;
import com.alkemy.entidades.Personaje;
import com.alkemy.repositorios.PersonajeRepositorio;

@Service
public class PersonajeServicio {

	@Autowired
	PersonajeRepositorio personajeRepositorio;

	public List<PersonajeDTO> listarPersonajes() throws Exception {
		try {
			List<Personaje> personajes = personajeRepositorio.findAll();
			List<PersonajeDTO> dtos = new ArrayList<>();
			ModelMapper modelMapper = new ModelMapper();

			for (Personaje personaje : personajes) {
				dtos.add(modelMapper.map(personaje, PersonajeDTO.class));
			}
			return dtos;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}

	}

	public Personaje obtenerPersonajePorId(long id) throws Exception {
		try {
			Optional<Personaje> personajeOpcional = personajeRepositorio.findById(id);
			return personajeOpcional.get();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public Personaje crearPersonaje(Personaje personaje) throws Exception {
		try {
			Personaje entity =  personajeRepositorio.save(personaje);
			return entity;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public Personaje editarPersonaje(long id, Personaje personaje) throws Exception{
		try {
			Optional<Personaje> personajeOpcional = personajeRepositorio.findById(id);
			Personaje p1 = personajeOpcional.get();
			p1 = personajeRepositorio.save(personaje);
			return p1;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}

	}
	
	public boolean eliminarPersonaje(long id) throws Exception{
		try {
			if(personajeRepositorio.existsById(id)) {
				personajeRepositorio.deleteById(id);
				return true;
			} else {
				throw new Exception();
			}
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public Personaje buscarPersonajePorNombre(String nombre) throws Exception {
		try {
			Optional<Personaje> personajeOpcional = personajeRepositorio.findByNombre(nombre);
			return personajeOpcional.get();
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

}
