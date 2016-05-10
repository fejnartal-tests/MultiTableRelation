package dev.fnt.codeless.persist.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import dev.fnt.codeless.persist.entity.Prestamo;

@Repository
public interface PrestamoDao extends PagingAndSortingRepository<Prestamo, Integer>{}
