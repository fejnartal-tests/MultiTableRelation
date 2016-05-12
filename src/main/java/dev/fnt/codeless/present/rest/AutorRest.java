package dev.fnt.codeless.present.rest;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import dev.fnt.codeless.persist.dto.AutorDto;
import dev.fnt.codeless.persist.entity.Autor;
import dev.fnt.codeless.persist.repo.AutorDao;

@Path("/autor")
public class AutorRest extends BaseRest<Autor,Integer>{
	@Autowired
	private AutorDao repo;

	@GET
	@Path("all/nombre")
	public String mixin() throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
		.setVisibility(mapper.getSerializationConfig().getDefaultVisibilityChecker()
			.withFieldVisibility(Visibility.ANY)
			.withGetterVisibility(Visibility.NONE)
			.withSetterVisibility(Visibility.NONE)
			.withCreatorVisibility(Visibility.NONE));
        mapper.addMixIn(Autor.class, AutorDto.HideId.class);
        return mapper.writer().writeValueAsString(super.findAll());
	}
	

	@GET
	@Path("all/id")
	public String mixin2() throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
		.setVisibility(mapper.getSerializationConfig().getDefaultVisibilityChecker()
			.withFieldVisibility(Visibility.ANY)
			.withGetterVisibility(Visibility.NONE)
			.withSetterVisibility(Visibility.NONE)
			.withCreatorVisibility(Visibility.NONE));
        mapper.addMixIn(Autor.class, AutorDto.HideNombre.class);
        return mapper.writer().writeValueAsString(super.findAll());
	}

	@GET
	@Path("deserialize/id")
	public String mixin3() throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
		.setVisibility(mapper.getDeserializationConfig().getDefaultVisibilityChecker()
			.withFieldVisibility(Visibility.ANY)
			.withGetterVisibility(Visibility.NONE)
			.withSetterVisibility(Visibility.NONE)
			.withCreatorVisibility(Visibility.NONE));
        mapper.addMixIn(Autor.class, AutorDto.HideNombre.class);
        Class<?> clz = Autor.class;
        JavaType type = mapper.getTypeFactory().constructCollectionType(List.class, clz);
        List<Autor> autores = mapper.readValue("[{\"id\":1,\"nombre\":\"Autor1\"},{\"id\":2,\"nombre\":\"Autor2\"},{\"id\":3,\"nombre\":\"Autor3\"},{\"id\":4,\"nombre\":\"Autor4\"}]",
        		type);
        return "Done";
     }

	@Override
	protected PagingAndSortingRepository<Autor, Integer> getRepo() {
		return repo;
	}
}
