package dev.fnt.codeless.persist.dto;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class AbstractDto<DtoClass> {
	private static ObjectMapper mapper = new ObjectMapper();
	static {
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
		.setVisibility(mapper.getDeserializationConfig().getDefaultVisibilityChecker()
			.withFieldVisibility(Visibility.ANY)
			.withGetterVisibility(Visibility.NONE)
			.withSetterVisibility(Visibility.NONE)
			.withCreatorVisibility(Visibility.NONE));
	}

	private ObjectMapper om;
	protected AbstractDto() { this(mapper); }
	protected AbstractDto( ObjectMapper om ) { this.om = om; }

	protected <SOURCE_OBJECT,TARGET_CLASS> TARGET_CLASS convertFromTo( SOURCE_OBJECT source, Class<TARGET_CLASS> targetClass ) {
		try {
			return om.readerFor(targetClass)
				.readValue( om.writerFor(source.getClass())
					.writeValueAsBytes(source));
		} catch ( IOException e ) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
}