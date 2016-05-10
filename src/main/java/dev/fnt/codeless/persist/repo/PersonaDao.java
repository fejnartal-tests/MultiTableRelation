package dev.fnt.codeless.persist.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import dev.fnt.codeless.persist.entity.Persona;

@Repository
public interface PersonaDao extends PagingAndSortingRepository<Persona, Integer>{}
