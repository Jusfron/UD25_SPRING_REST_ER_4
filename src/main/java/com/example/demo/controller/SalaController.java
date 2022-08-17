package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.Sala;
import com.example.demo.service.SalaServiceImpl;

@RestController
@RequestMapping("/api")
public class SalaController {
	
	@Autowired
	SalaServiceImpl salaServiceImpl;
	
	@GetMapping("/salas")
	public List<Sala> listarSalas() {
		return salaServiceImpl.listarSalas();
	}
	
	@PostMapping("/salas")
	public Sala salvarSala(@RequestBody Sala sala) {
		return salaServiceImpl.guardarSala(sala);
	}

	@GetMapping("/salas/{id}")
	public Sala salaXID(@PathVariable(name="id") Long id) {
		
		Sala sala_xid= new Sala();
		
		sala_xid=salaServiceImpl.salaXID(id);
		
		System.out.println("Sala XID: "+sala_xid);
		
		return sala_xid;
	}
	
	@PutMapping("/salas/{id}")
	public Sala actualizarSala(@PathVariable(name="id")Long id,@RequestBody Sala sala) {
		
		Sala sala_seleccionado= new Sala();
		Sala sala_actualizado= new Sala();
		
		sala_seleccionado= salaServiceImpl.salaXID(id);
		
		sala_seleccionado.setNombre(sala.getNombre());
		
		sala_actualizado = salaServiceImpl.actualizarSala(sala_seleccionado);
		
		System.out.println("El sala actualizado es: "+ sala_actualizado);
		
		return sala_actualizado;
	}
	
	@DeleteMapping("/salas/{id}")
	public String eliminarSala(@PathVariable(name = "id") Long id) {
		try {
			salaServiceImpl.eliminarSala(id);
			return "Sala eliminada";
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
}
