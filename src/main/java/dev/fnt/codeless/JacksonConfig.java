package dev.fnt.codeless;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;

public class JacksonConfig extends JacksonJaxbJsonProvider {

    private static ObjectMapper mapper = new ObjectMapper();

    static {
    	mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    	Hibernate4Module hbm = new Hibernate4Module();
    	hbm.enable(Hibernate4Module.Feature.FORCE_LAZY_LOADING);
    	mapper.registerModule(hbm);
    	mapper.setVisibility(mapper.getSerializationConfig().getDefaultVisibilityChecker()
                .withFieldVisibility(Visibility.ANY)
                .withGetterVisibility(Visibility.NONE)
                .withSetterVisibility(Visibility.NONE)
                .withCreatorVisibility(Visibility.NONE));
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
     }

    public JacksonConfig() {
        setMapper(mapper);
    }
}