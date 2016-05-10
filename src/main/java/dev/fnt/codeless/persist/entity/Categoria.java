package dev.fnt.codeless.persist.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Categoria {
	@Id
	private Integer id;
	private String nombre;
}
