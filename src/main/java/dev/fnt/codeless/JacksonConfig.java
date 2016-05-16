package dev.fnt.codeless;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;

public class JacksonConfig extends JacksonJaxbJsonProvider {
	private static ObjectMapper mapper = new ObjectMapper();
	static {
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
		.disable(MapperFeature.CAN_OVERRIDE_ACCESS_MODIFIERS)
		.disable(MapperFeature.USE_GETTERS_AS_SETTERS);
		mapper.setConfig(mapper.getSerializationConfig().with(mapper.getSerializationConfig().getDefaultVisibilityChecker()
				.withCreatorVisibility(JsonAutoDetect.Visibility.NONE)
				.withFieldVisibility(JsonAutoDetect.Visibility.NONE)
				.withGetterVisibility(JsonAutoDetect.Visibility.PUBLIC_ONLY)
				.withIsGetterVisibility(JsonAutoDetect.Visibility.NONE)
				.withSetterVisibility(JsonAutoDetect.Visibility.NONE))
			.with(MapperFeature.CAN_OVERRIDE_ACCESS_MODIFIERS,false)
			.with(MapperFeature.USE_GETTERS_AS_SETTERS,false))
		.setConfig(mapper.getDeserializationConfig().with(mapper.getDeserializationConfig().getDefaultVisibilityChecker()
				.withCreatorVisibility(JsonAutoDetect.Visibility.NONE)
				.withFieldVisibility(JsonAutoDetect.Visibility.NONE)
				.withGetterVisibility(JsonAutoDetect.Visibility.NONE)
				.withIsGetterVisibility(JsonAutoDetect.Visibility.NONE)
				.withSetterVisibility(JsonAutoDetect.Visibility.PUBLIC_ONLY))
			.with(MapperFeature.CAN_OVERRIDE_ACCESS_MODIFIERS,false)
			.with(MapperFeature.USE_GETTERS_AS_SETTERS,false));
	}

	public JacksonConfig() {
		setMapper(mapper);
	}
}
