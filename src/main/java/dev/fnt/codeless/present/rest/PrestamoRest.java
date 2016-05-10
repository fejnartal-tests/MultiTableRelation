package dev.fnt.codeless.present.rest;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;

import dev.fnt.codeless.persist.entity.Prestamo;
import dev.fnt.codeless.persist.repo.PrestamoDao;

@Path("/prestamo")
public class PrestamoRest extends BaseRest<Prestamo,Integer>{
	@Autowired
	private PrestamoDao repo;

	@Override
	protected PagingAndSortingRepository<Prestamo, Integer> getRepo() {
		return repo;
	}
}
