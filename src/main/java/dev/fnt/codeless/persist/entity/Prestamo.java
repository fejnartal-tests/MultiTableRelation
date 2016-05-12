package dev.fnt.codeless.persist.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Prestamo {
	@Id
	@GeneratedValue
	private Integer id;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private LocalDate fechaDevolucion;
	//private Libro libro;
	//private Persona persona;
}
