package dev.fnt.codeless.persist.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


public class AutorDto {
	@JsonIgnoreProperties({"nombre"})
	public static class HideNombre {}

	@JsonIgnoreProperties({"id"})
	public static class HideId {}
}