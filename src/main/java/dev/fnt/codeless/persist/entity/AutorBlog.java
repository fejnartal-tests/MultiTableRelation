package dev.fnt.codeless.persist.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class AutorBlog implements Serializable {
	@EmbeddedId
	public AutorBlogId id;
	public String url;

	public AutorBlog() {}
	public AutorBlog(AutorBlogId id, String url) {
		this.id = id;
		this.url = url;
	}
}