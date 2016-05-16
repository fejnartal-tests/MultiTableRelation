package dev.fnt.codeless.persist.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class AutorBlogId implements Serializable {
	protected String nombre;
	protected String apellido;

	public AutorBlogId() {}
	public AutorBlogId( String nombre, String apellido) {
		this.nombre=nombre;
		this.apellido=apellido;
	}
}
