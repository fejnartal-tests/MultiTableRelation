package dev.fnt.codeless.present.rest;

import java.io.Serializable;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

@Component
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public abstract class BaseRest<T,ID extends Serializable> {
	protected abstract PagingAndSortingRepository<T,ID> getRepo();

	@GET
	@Path("all")
	public Iterable<T> findAll() {
		return getRepo().findAll();
	}

	@GET
	@Path("{id}")
	public T findOne(@PathParam("id") ID id) {
		return getRepo().findOne(id);
	}

	@GET
	@Path("count")
	public Long count() {
		return getRepo().count();
	}

	@POST
	@Path("save")
	public void save(T entityObject) {
		getRepo().save(entityObject);
	}
}