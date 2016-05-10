package dev.fnt.codeless.persist.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Libro {
	@Id
	private Integer id;
	private String titulo;
	private int paginas;
	@Column(updatable=false)
	private String editorial;
	private int edicion;
	//private Collection<Categoria> categorias;
	//private Collection<Autor> autores;
}
