package dev.fnt.codeless.present.rest;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;

import dev.fnt.codeless.persist.entity.Categoria;
import dev.fnt.codeless.persist.repo.CategoriaDao;

@Path("/categoria")
public class CategoriaRest extends BaseRest<Categoria,Integer>{
	@Autowired
	private CategoriaDao repo;

	@Override
	protected PagingAndSortingRepository<Categoria, Integer> getRepo() {
		return repo;
	}
}
