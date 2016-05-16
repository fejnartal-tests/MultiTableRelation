package dev.fnt.codeless.present.rest;

import java.io.IOException;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.fasterxml.jackson.core.JsonProcessingException;

import dev.fnt.codeless.persist.dto.AutorDto;
import dev.fnt.codeless.persist.dto.SimpleDto;
import dev.fnt.codeless.persist.entity.Autor;
import dev.fnt.codeless.persist.repo.AutorDao;

@Path("/autor")
public class AutorRest extends BaseRest<Autor,Integer>{
	@Autowired
	private AutorDao repo;

	@GET
	@Path("dto")
	public Iterable<AutorDto> all() throws JsonProcessingException, IOException {
		SimpleDto<AutorDto,Autor> dto = new SimpleDto<>(AutorDto.class);
			return StreamSupport.stream(super.findAll().spliterator(),true)
				.map(autor->dto.fromParent(autor))
				.collect(Collectors.toList());
	}

	@POST
	@Path("dto")
	public Iterable<AutorDto> save(Iterable<AutorDto> autores) {
		return autores;
	}
	
	@Override
	protected PagingAndSortingRepository<Autor, Integer> getRepo() {
		return repo;
	}
}
