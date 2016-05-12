package dev.fnt.codeless.persist.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Libro {
	@Id
	@GeneratedValue
	private Integer id;
	private String titulo;
	private int paginas;
	private String editorial;
	private int edicion;
	//private Collection<Categoria> categorias;
	//private Collection<Autor> autores;
}
