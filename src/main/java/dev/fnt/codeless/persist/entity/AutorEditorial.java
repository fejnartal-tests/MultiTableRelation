package dev.fnt.codeless.persist.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class AutorEditorial implements Serializable {
	@EmbeddedId
	public AutorEditorialId id;
	public String editorial;

	public AutorEditorial() {}
	public AutorEditorial(AutorEditorialId id, String editorial) {
		this.id = id;
		this.editorial = editorial;
	}
}