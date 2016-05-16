package dev.fnt.codeless.persist.dto;

import dev.fnt.codeless.persist.entity.Autor;

public class AutorDto extends Autor {
	public Integer getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	};
	public String getTipo() {
		return tipo;
	}

	public String getAutorEditorial() {
		return autorEditorial.editorial;
	}

//	public AutorBlog getAutorBlog() {
//		return autorBlog;
//	}
}