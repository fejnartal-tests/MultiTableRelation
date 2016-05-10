package dev.fnt.codeless.present.rest;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;

import dev.fnt.codeless.persist.entity.Autor;
import dev.fnt.codeless.persist.repo.AutorDao;

@Path("/autor")
public class AutorRest extends BaseRest<Autor,Integer>{
	@Autowired
	private AutorDao repo;

	@Override
	protected PagingAndSortingRepository<Autor, Integer> getRepo() {
		return repo;
	}
}
