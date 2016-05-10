package dev.fnt.codeless.persist.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import dev.fnt.codeless.persist.entity.Libro;

@Repository
public interface LibroDao extends PagingAndSortingRepository<Libro, Integer>{
	@Query("SELECT l FROM Libro l WHERE UPPER(editorial) LIKE UPPER('%'||:editorial||'%')")
	public Iterable<Libro> findByEditorial(@Param("editorial") String editorial);
}
