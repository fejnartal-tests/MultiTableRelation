package dev.fnt.codeless.present.rest;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;

import dev.fnt.codeless.persist.entity.Persona;
import dev.fnt.codeless.persist.repo.PersonaDao;

@Path("/persona")
public class PersonaRest extends BaseRest<Persona,Integer>{
	@Autowired
	private PersonaDao repo;

	@Override
	protected PagingAndSortingRepository<Persona, Integer> getRepo() {
		return repo;
	}
}
