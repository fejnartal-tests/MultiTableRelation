package dev.fnt.codeless.persist.dto;

import com.fasterxml.jackson.databind.ObjectMapper;

public class SimpleDto<DTO extends ENTITY, ENTITY> extends AbstractDto<DTO> {
	private Class<DTO> dtoClass;
	public SimpleDto( Class<DTO> dtoClass ) { this.dtoClass = dtoClass; }
	public SimpleDto( Class<DTO> dtoClass, ObjectMapper om ) {
		super(om);
		this.dtoClass = dtoClass;
	}

	public DTO fromParent( ENTITY parentObject ) {
		return convertFromTo( parentObject, dtoClass );
	}

	public ENTITY toParent( DTO dtoObject ) {
		return (ENTITY) convertFromTo( dtoObject, dtoClass.getSuperclass());
	}
}