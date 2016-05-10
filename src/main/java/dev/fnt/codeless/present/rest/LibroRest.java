package dev.fnt.codeless.present.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;

import dev.fnt.codeless.persist.entity.Libro;
import dev.fnt.codeless.persist.repo.LibroDao;

@Path("/libro")
public class LibroRest extends BaseRest<Libro,Integer>{
	@Autowired
	private LibroDao repo;

	@Override
	protected PagingAndSortingRepository<Libro, Integer> getRepo() {
		return repo;
	}

	@GET
	@Path("/editorial/{editorial}")
	public Iterable<Libro> findByEditorial(@PathParam("editorial") String editorial) {
		return repo.findByEditorial(editorial);
	}
}
