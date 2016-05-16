package dev.fnt.codeless.persist.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
public class Autor {
	@Id
	@GeneratedValue
	protected Integer id;
	protected String nombre;
	protected String apellido;
	protected String tipo;
	public String getEditorial() {
		return autorEditorial!=null?autorEditorial.editorial:null;
	}
	public String getUrl() {
		return autorBlog!=null?autorBlog.url:null;
	}
	public String getTipo() { return tipo; }
	public void setTipo( String tipo) {
		this.tipo= tipo;
	}
	public Integer getId() { return id; }
	public void setId( Integer id ) {
		this.id=id;
	}
	public String getNombre() { return nombre; }
	public void setNombre( String nombre ) {
		this.nombre = nombre;
	}

	public String getApellido() { return apellido; }
	public void setApellido( String apellido ) {
		this.apellido = apellido;
	}

	@PrePersist
	public void update() {
		switch(tipo) {
		case "BLOG":
			if(autorBlog == null) {
				autorBlog = new AutorBlog(new AutorBlogId(nombre, apellido),"URL NuEVA");
			}
			break;
		case "EDITORIAL":
			if(autorEditorial == null) {
				autorEditorial = new AutorEditorial(new AutorEditorialId(nombre, apellido),"EDITORIAL NuEVA");
			}
			break;
		}
	}

	@ManyToOne(cascade={CascadeType.ALL})
	@NotFound(action=NotFoundAction.IGNORE)
	@ForeignKey(name="none")
	@JoinColumns({
		@JoinColumn(name="nombre",insertable=false,updatable=false, referencedColumnName="nombre"),
		@JoinColumn(name="apellido",insertable=false,updatable=false, referencedColumnName="apellido")
	})
	protected AutorEditorial autorEditorial;

	@ManyToOne(cascade={CascadeType.ALL})
	@NotFound(action=NotFoundAction.IGNORE)
	@ForeignKey(name="none")
	@JoinColumns({
		@JoinColumn(name="nombre",insertable=false,updatable=false, referencedColumnName="nombre"),
		@JoinColumn(name="apellido",insertable=false,updatable=false, referencedColumnName="apellido")
	})
	protected AutorBlog autorBlog;
}