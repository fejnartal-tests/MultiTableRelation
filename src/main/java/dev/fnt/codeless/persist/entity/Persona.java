package dev.fnt.codeless.persist.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Persona {
	@Id
	private Integer id;
	private String nombre;
	private String dni;
	private LocalDate fechaNacimiento;
	private String direccion;
	private String telefono;
	private String pais;
	private String provincia;
	private String codPostal;
}
