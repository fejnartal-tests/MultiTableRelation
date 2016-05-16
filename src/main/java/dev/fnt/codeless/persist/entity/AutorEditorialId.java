package dev.fnt.codeless.persist.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class AutorEditorialId implements Serializable {
	protected String nombre;
	protected String apellido;

	public AutorEditorialId() {}
	public AutorEditorialId( String nombre, String apellido) {
		this.nombre=nombre;
		this.apellido=apellido;
	}
}
