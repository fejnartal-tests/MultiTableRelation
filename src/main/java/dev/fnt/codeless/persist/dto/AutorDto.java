package dev.fnt.codeless.persist.dto;

import dev.fnt.codeless.persist.entity.Autor;

public class AutorDto extends Autor {
	public Integer getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	};

	public void setNombre() {
		this.nombre = nombre + " - Modificado";
	}
}