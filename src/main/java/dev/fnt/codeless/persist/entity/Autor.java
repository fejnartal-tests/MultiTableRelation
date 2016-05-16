package dev.fnt.codeless.persist.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Autor {
	@Id
	@GeneratedValue
	protected Integer id;
	protected String nombre;
	//public Collection<Libro> libros;
}