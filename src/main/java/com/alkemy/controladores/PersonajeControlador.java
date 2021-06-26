package com.alkemy.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alkemy.entidades.Personaje;
import com.alkemy.servicios.PersonajeServicio;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/characters")
public class PersonajeControlador {
	
	@Autowired
	PersonajeServicio personajeServicio;
	
	@GetMapping("")
	public ResponseEntity<?> listarPersonajes() {
		
		try {
			return ResponseEntity.status(HttpStatus.OK).body(personajeServicio.listarPersonajes());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente mas tarde.\"}");
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> obtenerPersonaje(@PathVariable long id) {
		
		try {
			return ResponseEntity.status(HttpStatus.OK).body(personajeServicio.obtenerPersonajePorId(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente mas tarde.\"}");
		}
	}
	
	@PostMapping("")
	public ResponseEntity<?> crearPersonaje(@RequestBody Personaje personaje) {
		
		try {
			return ResponseEntity.status(HttpStatus.OK).body(personajeServicio.crearPersonaje(personaje));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente mas tarde.\"}");
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editarPersonaje(@PathVariable long id,@RequestBody Personaje personaje){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(personajeServicio.editarPersonaje(id, personaje));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente mas tarde.\"}");
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminarPersonaje(@PathVariable long id){
		try {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(personajeServicio.eliminarPersonaje(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente mas tarde.\"}");
		}
	}
	
	@GetMapping("{nombre}")
	public ResponseEntity<?> obtenerPersonajePorNombre(@RequestParam String nombre) {
		
		try {
			return ResponseEntity.status(HttpStatus.OK).body(personajeServicio.buscarPersonajePorNombre(nombre));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente mas tarde.\"}");
		}
	}

}
