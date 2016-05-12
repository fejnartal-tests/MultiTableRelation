package dev.fnt.codeless.persist.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Autor {
	@Id
	@GeneratedValue
	private Integer id;
	private String nombre;
	//public Collection<Libro> libros;
}