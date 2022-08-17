package com.example.demo.dto;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="peliculas")//en caso que la tabla sea diferente
public class Pelicula {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "calificacionEdad")
	private int calificacionEdad;
	
	@OneToMany
    @JoinColumn(name="id")
    private List<Sala> salas;

	public Pelicula() {
		super();
	}
	
	public Pelicula(Long id, String nombre, int calificacionEdad, List<Sala> salas) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.calificacionEdad = calificacionEdad;
		this.salas = salas;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCalificacionEdad() {
		return calificacionEdad;
	}

	public void setCalificacionEdad(int calificacionEdad) {
		this.calificacionEdad = calificacionEdad;
	}

	/**
	 * @return the video
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Sala")
	public List<Sala> getSalas() {
		return salas;
	}

	public void setEmpleados(List<Sala> salas) {
		this.salas = salas;
	}
	
	

}
