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

import com.alkemy.entidades.Pelicula;
import com.alkemy.pojos.PeliculaRequest;
import com.alkemy.servicios.PeliculaServicio;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/movies")
public class PeliculaControlador {
	
	@Autowired
	private PeliculaServicio peliculaServicio;
	
	@GetMapping("")
	public ResponseEntity<?> listarPeliculas() {

		try {
			return ResponseEntity.status(HttpStatus.OK).body(peliculaServicio.listarPeliculas());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("{\"error\":\"" + e.getMessage() + "\"}");
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> obtenerPeliculaPorId(@PathVariable long id) {

		try {
			return ResponseEntity.status(HttpStatus.OK).body(peliculaServicio.obtenerPeliculaPorId(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("{\"error\":\"" + e.getMessage() + "\"}");
		}
	}
	
	@PostMapping("")
	public ResponseEntity<?> crearPelicula(@RequestBody PeliculaRequest peliculaRequest) {

		try {
			return ResponseEntity.status(HttpStatus.OK).body(peliculaServicio.crearPelicula(peliculaRequest));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("{\"error\":\"" + e.getMessage() + "\"}");
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editarPelicula(@PathVariable long id, @RequestBody Pelicula pelicula) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(peliculaServicio.editarPelicula(id, pelicula));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("{\"error\":\"" + e.getMessage() + "\"}");
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminarPelicula(@PathVariable long id) {
		try {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(peliculaServicio.eliminarPelicula(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("{\"error\":\"" + e.getMessage() + "\"}");
		}
	}

	@RequestMapping(value = "", params = "titulo")
	public ResponseEntity<?> obtenerPeliculaPorTitulo(@RequestParam String titulo) {

		try {
			return ResponseEntity.status(HttpStatus.OK).body(peliculaServicio.buscarPeliculaPorTitulo(titulo));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("{\"error\":\"" + e.getMessage() + "\"}");
		}
	}
	
	

}
