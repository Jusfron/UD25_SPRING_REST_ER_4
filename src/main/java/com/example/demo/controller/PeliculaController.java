package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Pelicula;
import com.example.demo.service.PeliculaServiceImpl;

@RestController
@RequestMapping("/api")
public class PeliculaController {

	@Autowired
	PeliculaServiceImpl peliculaServiceImpl;

	@GetMapping("/peliculas")
	public List<Pelicula> listarPeliculas() {
		return peliculaServiceImpl.listarPeliculas();
	}

	@PostMapping("/peliculas")
	public Pelicula salvarPelicula(@RequestBody Pelicula pelicula) {

		return peliculaServiceImpl.guardarPelicula(pelicula);
	}

	@GetMapping("/peliculas/{id}")
	public Pelicula peliculaXID(@PathVariable(name = "id") Long id) {

		Pelicula pelicula_xid = new Pelicula();

		pelicula_xid = peliculaServiceImpl.peliculaXID(id);

		System.out.println("Pelicula XID: " + pelicula_xid);

		return pelicula_xid;
	}

	@PutMapping("/peliculas/{id}")
	public Pelicula actualizarPelicula(@PathVariable(name = "id") Long id, @RequestBody Pelicula pelicula) {

		Pelicula pelicula_seleccionado = new Pelicula();
		Pelicula pelicula_actualizado = new Pelicula();

		pelicula_seleccionado = peliculaServiceImpl.peliculaXID(id);

		pelicula_seleccionado.setNombre(pelicula.getNombre());
		pelicula_seleccionado.setCalificacionEdad(pelicula.getCalificacionEdad());

		pelicula_actualizado = peliculaServiceImpl.actualizarPelicula(pelicula_seleccionado);

		System.out.println("El pelicula actualizado es: " + pelicula_actualizado);

		return pelicula_actualizado;
	}

	@DeleteMapping("/peliculas/{id}")
	public String eliminarPelicula(@PathVariable(name = "id") Long id) {
	try {
		peliculaServiceImpl.eliminarPelicula(id);
		return "Pelicula borrado";
	} catch (Exception e) {
		return e.getMessage();
	}
	}
}
